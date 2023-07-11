package com.leo.fly.common.file;

import lombok.Data;

@Data
public class FileCreateParam {
    private String fileName;
    private String filePath;
    private String fileType;
    private String fileDirectory;
    private String content;
}
