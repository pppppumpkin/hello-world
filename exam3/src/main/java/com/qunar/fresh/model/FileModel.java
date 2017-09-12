package com.qunar.fresh.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Map;

/**
 * Created by liyingsong on 16-6-17.
 */
public class FileModel {

    /**
     * 文件名
     */
    @NotEmpty
    private String filename;

    /**
     * 文件内容
     */
    @NotEmpty
    private Map<String, String> content;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Map<String, String> getContent() {
        return content;
    }

    public void setContent(Map<String, String> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : content.entrySet()) {
            builder.append(entry.getValue()+";");
        }
        return builder.toString();
    }
}
