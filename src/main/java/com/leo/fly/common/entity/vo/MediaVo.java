package com.leo.fly.common.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class MediaVo {
    private List<ImageVo> images;
    private VideoVo video;

}
