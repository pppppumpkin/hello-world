package com.qunar.fresh.exercise1byteacher;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyingsong on 16-5-13.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private List<File> filePathList = new ArrayList<File>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        filePathList.add(file.toFile());
        return FileVisitResult.CONTINUE;
    }

    public List<File> getFilePathList() {
        return filePathList;
    }
}
