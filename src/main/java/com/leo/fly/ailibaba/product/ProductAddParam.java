package com.leo.fly.ailibaba.product;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import com.alibaba.product.param.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ProductAddParam extends AbstractAPIRequest<ProductAddResult> {
    @NotBlank
    /**
     * 商品类型，在线批发商品(wholesale)或者询盘商品(sourcing)，1688网站缺省为wholesale
     */
    private String productType;

    /**
     * 是
     * 类目ID，由相应类目API获取
     * 1031912
     */
    private Long categoryID;

    /**
     * 否
     * 商品属性和属性值。若webSite=1688，此字段必填
     */
    private List<AlibabaProductProductAttribute> attributes;

    /**
     * 否
     * 分组ID，确定商品所属分组。1688可传入多个分组ID，国际站同一个商品只能属于一个分组，因此默认只取第一个
     * [105630024]
     */
    private List<Long> groupID;


    /**
     * 是
     * 商品标题，最多128个字符。标题内容将被系统切分作为关键字，因此API将不再单独提供关键字字段。
     * 可爱长颈鹿公仔睡觉抱枕小鹿玩偶布娃娃毛绒玩具
     */
    private String subject;

    /**
     * 否
     * 商品详情描述，可包含图片中心的图片URL
     * 可爱长颈鹿公仔睡觉抱枕小鹿玩偶布娃娃毛绒玩具
     */
    private String description;

    /**
     * 是
     * 语种，参见FAQ 语种枚举值，1688网站默认传入CHINESE
     * CHINESE
     */
    private String language;


    /**
     * 否
     * 信息有效期，按天计算，国际站可不填
     */
    private Integer periodOfValidity;

    /**
     * 否
     * 业务类型。1：商品，2：加工，3：代理，4：合作，5：商务服务；不传入默认按照商品发布；国际站按默认商品。
     * 1
     */
    private Integer bizType;

    /**
     * 否
     * 是否图片私密信息，国际站此字段无效
     * false
     */
    private Boolean pictureAuth;

    /**
     * 是
     * 商品主图
     */
    private AlibabaProductProductImageInfo image;

    /**
     * 否
     * SKU信息，这里可传入多组信息
     */
    private AlibabaProductProductSKUInfo[] skuInfos;

    /**
     * 否 商品销售信息
     */
    private AlibabaProductProductSaleInfo saleInfo;

    /**
     * 商品物流信息
     */
    private AlibabaProductProductShippingInfo shippingInfo;

    /**
     * 否
     * 商品国际贸易信息，1688无需处理此字段
     */
    private AlibabaProductProductInternationalTradeInfo internationalTradeInfo;

    /**
     * 否
     * 商品扩展信息
     */
    private AlibabaProductProductExtendInfo[] extendInfos;

//    /**
//     *  否
//     *     加工定制信息，传此参数表示是加工定制类型产品
//     */
//    private Alibabaproductproduct processing;

    /**
     * 是
     * 站点信息，指定调用的API是属于国际站（alibaba）还是1688网站（1688）1688
     */
    private String webSite;


    public ProductAddParam() {
        super();
        oceanApiId = new APIId("com.alibaba.product", "alibaba.product.add", 1);
    }

}
