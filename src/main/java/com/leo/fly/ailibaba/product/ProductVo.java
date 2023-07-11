package com.leo.fly.ailibaba.product;

import lombok.Data;

@Data
public class ProductVo {

    private Long albumID;

    private Integer id;


    /**
     * 商品类型，在线批发商品(wholesale)或者询盘商品(sourcing)，1688网站缺省为wholesale
     */
    private String type;

    /**
     * 类目ID，由相应类目API获取
     */
    private Long categoryID;

    /**
     * 商品属性和属性值。若webSite=1688，此字段必填
     */
    private String attributes;



    /**
     * 商品标题，最多128个字符。标题内容将被系统切分作为关键字，因此API将不再单独提供关键字字段。
     */
    private String subject;

    /**
     * 商品详情描述，可包含图片中心的图片URL
     */
    private String description;

    /**
     * 语种，参见FAQ 语种枚举值，1688网站默认传入CHINESE
     */
    private String language;

    /**
     * 信息有效期，按天计算，国际站可不填
     */
    private Integer periodOfValidity;

    /**
     * 业务类型。1：商品，2：加工，3：代理，4：合作，5：商务服务；不传入默认按照商品发布；国际站按默认商品。
     */
    private Integer bizType;

    /**
     * 是否图片私密信息，国际站此字段无效 false
     */
    private Boolean pictureAuth;

    /**
     * 媒体资料列表，1688使用相对路径，需要增加域名：https://cbu01.alicdn.com/
     */
    private String media;

    /**
     * SKU信息，这里可传入多组信息,规格
     */
    private String skuInfos;

    /**
     * 是否支持网上交易。true：支持 false：不支持，国际站不需关注此字段
     */
    private Boolean supportOnlineTrade;

    /**
     * 是否支持混批，国际站无需关注此字段
     */
    private Boolean mixSholeSale;

    /**
     * 销售方式，按件卖(normal)或者按批卖(batch)，1688站点无需关注此字段
     */
    private String saleType;

    /**
     * 是否价格私密信息，国际站无需关注此字段 false
     */
    private Boolean priceAuth;

    /**
     * 区间价格。按数量范围设定的区间价格
     */
    private String priceRanges;

    /**
     * 可售数量，国际站无需关注此字段
     */
    private String amountOnSale;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 最小起订量，范围是1-99999。
     */
    private Integer minOrderQuantity;

    /**
     * 每批数量，默认为空或者非零值，该属性不为空时sellunit为必填
     */
    private Integer batchNumber;

    /**
     * 建议零售价，国际站无需关注
     */
    private Double retailprice;

    /**
     * 税率相关信息，内容由用户自定，国际站无需关注
     */
    private String tax;

    /**
     * 售卖单位，如果为批量售卖，代表售卖的单位，该属性不为空时batchNumber为必填，例如1"手"=12“件"的"手"，国际站无需关注
     */
    private String sellunit;

    /**
     * 普通报价-FIXED_PRICE("0"),SKU规格报价-SKU_PRICE("1"),SKU区间报价（商品维度）-SKU_PRICE_RANGE_FOR_OFFER("2"),SKU区间报价（SKU维度）-SKU_PRICE_RANGE("3")，国际站无需关注
     */
    private Integer quoteType;

    /**
     * 分销基准价。代销场景均使用该价格。有SKU商品查看skuInfo中的consignPrice
     */
    private Double consignPrice;



    /**
     * 运费模板ID，0表示运费说明，1表示卖家承担运费，其他值表示使用运费模版。此参数可调用运费模板相关API获取
     */
    private Long freightTemplateID;

    /**
     * 单位重量
     */
    private Double unitWeight;

    /**
     * 尺寸，单位是厘米，长宽高范围是1-9999999。1688无需关注此字段
     */
    private String packageSize;

    /**
     * 体积，单位是立方厘米，范围是1-9999999，1688无需关注此字段
     */
    private Integer volume;

    /**
     * 备货期，单位是天，范围是1-60。1688无需处理此字段
     */
    private Integer handlingTime;

    /**
     * 发货地址ID，国际站无需处理此字段
     */
    private Long sendGoodsAddressID;

    /**
     * 商品扩展信息
     */
    private String sendGoodsAddressText;

    /**
     * 站点信息，指定调用的API是属于国际站（alibaba）还是1688网站（1688）
     */
    private String website;

    private Integer autoPartsID;

    private Long platformProductID;

    private String oe;


    /**
     * 分组ID，确定商品所属分组。1688可传入多个分组ID，国际站同一个商品只能属于一个分组，因此默认只取第一个
     */
    private Long groupID;

    private String remark;

    private String name;

    private String error;

    private Integer status;
}
