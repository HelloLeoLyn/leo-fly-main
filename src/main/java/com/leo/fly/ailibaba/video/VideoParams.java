package com.leo.fly.ailibaba.video;

import com.alibaba.multimedia.param.AlibabaVideoVideocenterUploadResult;
import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import lombok.Data;

import java.io.InputStream;

@Data
public class VideoParams extends AbstractAPIRequest<AlibabaVideoVideocenterUploadResult> {
    private String fileName;
    private InputStream fileData;
    private String description;
    public VideoParams() {
        this.oceanApiId = new APIId("com.alibaba.multimedia", "alibaba.video.videocenter.upload", 1);
    }
}
