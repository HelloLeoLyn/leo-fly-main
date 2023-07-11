package com.leo.fly.ailibaba.photo;

import lombok.Data;

@Data
public class PhotoBankAlbumResult {
    /**
     * 获取相册
     */
    private Object albumInfos;
    private String errorMsg;
    private String errorCode;
    private Long albumID;
    /**
     * 删除图片/删除相册
     */
    private Boolean isSuccess;
    private String reason;
    private Long imageId;
    private String url;
    private Long[] productIds;

    /**
     * 上传图片
     */
    private Object image;

    private Object result;

    /** 获取图片列表**/
    private Object photoInfos;
    private Integer count;
    private Integer currentPage;
    private Integer pageSize;
}
