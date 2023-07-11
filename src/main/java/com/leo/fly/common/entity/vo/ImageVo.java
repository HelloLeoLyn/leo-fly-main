package com.leo.fly.common.entity.vo;

import lombok.Data;

@Data
public class ImageVo {

    /**
     * Small 50*50
     */
    private String sm;

    /**
     * Middle 300*300
     */
    private String md;

    /***
     * Large 1000*1000
     */
    private String lg;

    private String original;
}
