package com.qunar.fresh.exercise1byteacher;

import java.io.*;
import java.util.Iterator;

/**
 * Created by liyingsong on 16-5-15.
 */
public class CharacterIterator implements Iterator<String>{
    private File mFile;
    private FileInputStream mFileInputStream;
    private Reader mReader;
    private int mCurCharacter;
    private boolean mLock;

    public CharacterIterator(File file) {
        mFile = file;
        init();
    }

    private void init() {
        try {
            mFileInputStream = new FileInputStream(mFile);
            mReader = new BufferedReader(new InputStreamReader(mFileInputStream));
        } catch (FileNotFoundException e) {
            // TODO: 2016/4/24 Log
        }
    }

    @Override
    public boolean hasNext() {
        if (mFileInputStream != null) {
            try {
                if (mLock) {
                    return true;
                } else {
                    mCurCharacter = mReader.read();
                    mLock = !mLock;
                }
            } catch (IOException e) {
                // TODO: 2016/4/24 Log
            }
        }
        return mCurCharacter != -1;
    }

    @Override
    public String next() {
        boolean isWindowsBreakLine = false;
        char character = (char) mCurCharacter;
        if (character == '\r') {
            try {
                mReader.mark(10);   // Magic Number.Not Recommend
                if (mReader.read() == '\n') {
                    isWindowsBreakLine = true;
                } else {
                    mReader.reset();
                }
            } catch (IOException e) {
                // TODO: 2016/4/25 LOG
            }
        }
        mLock = !mLock;
        return judgeCharacterType(character, isWindowsBreakLine);
    }

    @Override
    public void remove() {

    }

    private String judgeCharacterType(char character, boolean isWindowsBreakLine) {
        if (isChinese(character)) {
            return "汉字";
        } else if (character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z') {
            return "字母" + String.valueOf(character).toUpperCase();
        } else if (character >= '0' && character <= '9') {
            return "数字" + character;
        } else if (character == ' ') {
            return "空格";
        } else if (System.lineSeparator().equals(String.valueOf(character)) || isWindowsBreakLine) {
            return "行数";
        }
        return null;
    }

    private boolean isChinese(char character) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(character);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION;
    }
}
