package com.leo.fly.db.product.alibaba.params;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import lombok.Data;

@Data
public class ProductAlibabaNewParam extends AbstractAPIRequest<ProductAlibabaNewResult> {
    private Long catId;
    private String scene;
    private Long offerId;
    private JSONObject bizParam;
}
