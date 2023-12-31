package com.leo.fly.db.goods.params;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.List;

@Data
public class GoodsTemplateParams {
    private List<String> images;
    private JSONArray models;
    private String website;
    private String target2;
    private String detailCoverUrl;
    private Object productDetail;
    private List<String> codes;
    private String packingBoxUrl;
    private String packingSizeUrl;

}
