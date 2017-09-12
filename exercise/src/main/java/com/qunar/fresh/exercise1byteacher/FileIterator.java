package com.qunar.fresh.exercise1byteacher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liyingsong on 16-5-13.
 */
public class FileIterator implements Iterator<File>{
    private List<File> fileList = new ArrayList<File>();
    private int currentIndex = 0;

    public FileIterator(String dir) throws IOException {
        fileList = searchAllFiles(dir);
    }

    private List<File> searchAllFiles(String dir) throws IOException {
        Path path = Paths.get(dir);
        MyFileVisitor fileVisitor = new MyFileVisitor();
        Files.walkFileTree(path, fileVisitor);
        return fileVisitor.getFilePathList();
    }

    @Override
    public boolean hasNext() {
        return currentIndex < fileList.size();
    }

    @Override
    public File next() {
        return fileList.get(currentIndex++);
    }

    @Override
    public void remove() {

    }
}
