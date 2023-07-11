// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductProductImageInfo.java

package com.alibaba.product.param;


public class AlibabaProductProductImageInfo {

    private String images[];
    private Boolean isWatermark;
    private Boolean isWatermarkFrame;
    private String watermarkPosition;
    private String idList[];

    public AlibabaProductProductImageInfo() {
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String images[]) {
        this.images = images;
    }

    public Boolean getIsWatermark() {
        return isWatermark;
    }

    public void setIsWatermark(Boolean isWatermark) {
        this.isWatermark = isWatermark;
    }

    public Boolean getIsWatermarkFrame() {
        return isWatermarkFrame;
    }

    public void setIsWatermarkFrame(Boolean isWatermarkFrame) {
        this.isWatermarkFrame = isWatermarkFrame;
    }

    public String getWatermarkPosition() {
        return watermarkPosition;
    }

    public void setWatermarkPosition(String watermarkPosition) {
        this.watermarkPosition = watermarkPosition;
    }

    public String[] getIdList() {
        return idList;
    }

    public void setIdList(String[] idList) {
        this.idList = idList;
    }
}
