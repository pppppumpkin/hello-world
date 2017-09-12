package com.qunar.fresh.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.qunar.fresh.model.FileModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by liyingsong on 16-6-17.
 */
public class MyConverter {
    private static Logger logger = LoggerFactory.getLogger(MyConverter.class);

    public static FileModel inputStreamToFileModel(InputStream inputStream, String fileName) throws IOException {
        FileModel fileModel = new FileModel();
        fileModel.setFilename(fileName);
        Map<String, String> content = Maps.newLinkedHashMap();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while((line = reader.readLine()) != null) {
            content.put(Splitter.on('=').splitToList(line).get(0), line);
        }
        fileModel.setContent(content);
        return fileModel;
    }
}
