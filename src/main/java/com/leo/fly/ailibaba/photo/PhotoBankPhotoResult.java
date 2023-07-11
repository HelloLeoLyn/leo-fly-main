package com.leo.fly.ailibaba.photo;

import lombok.Data;

@Data
public class PhotoBankPhotoResult {
    private Long albumID;
    private String errCode;
    private String errMsg;
    private PhotoBankImage image;
}
