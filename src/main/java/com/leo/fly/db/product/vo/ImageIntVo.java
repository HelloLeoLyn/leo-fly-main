package com.leo.fly.db.product.vo;

import lombok.Data;

@Data
public class ImageIntVo {
    /**
     * Small 50*50
     */
    private Integer smId;

    /**
     * Middle 300*300
     */
    private Integer mdId;

    /***
     * Large 1000*1000
     */
    private Integer lgId;

    private Integer originalId;
}
