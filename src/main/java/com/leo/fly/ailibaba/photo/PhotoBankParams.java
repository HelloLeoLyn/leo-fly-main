package com.leo.fly.ailibaba.photo;

import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import com.leo.fly.db.image.entity.Image;
import lombok.Data;

import java.util.List;

@Data
public class PhotoBankParams extends AbstractAPIRequest<PhotoBankPhotoResult> {

    /**
     * 相册ID，1688必须传此参数，国际站可不传
     */
    private Long albumID;

    /**
     * 图片名称。最长30个中文字符
     */
    private String name;

    /**
     * 图片描述。最长2000个中文字符
     */
    private String description;
    /**
     * 是否打上默认水印，国际站无需处理此字段
     */
    private Boolean drawTxt;

    /**
     * 图片的二进制数据，向服务端提交文件即可 (二进制文件数组 PHP 的话，用 base64_encode 转换 ，JAVA 是 通过 IOUtils.toByteArray 转换)
     */
    private byte[] imageBytes;


    /**
     * webSite 站点信息，指定调用的API是属于国际站（alibaba）还是1688网站（1688）
     */
    private String webSite;

    /**
     * 授权可见
     */
    private String authority;

    /**
     * 密码
     */
    private String password;

    /**
     * 图片集合
     */
    private List<Image> images;
}
