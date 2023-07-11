package com.leo.fly.ailibaba.product;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

import java.util.Date;

public class ProductListGetParam extends AbstractAPIRequest<ProductListGetResult> {

    public ProductListGetParam() {
        super();
        oceanApiId = new APIId("com.alibaba.product", "alibaba.product.list.get", 1);
    }

    private String[] signs;

    /**
     * @return 业务标
     */
    public String[] getSigns() {
        return signs;
    }

    /**
     * 设置业务标     *
     * 参数示例：<pre>['isMicroSupply']</pre>     
     * 此参数必填
     */
    public void setSigns(String[] signs) {
        this.signs = signs;
    }

    private Integer pageNo;

    /**
     * @return 分页参数，起始为1
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置分页参数，起始为1     *
     * 参数示例：<pre>1</pre>     
     * 此参数必填
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    private Integer pageSize;

    /**
     * @return 分页参数，每页大小，目前最大值为20，超过20时以20为准
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置分页参数，每页大小，目前最大值为20，超过20时以20为准     *
     * 参数示例：<pre>20</pre>     
     * 此参数必填
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private String[] statusList;

    /**
     * @return 商品状态，published:上架状态，expired：过期(包含手动过期与自动过期)，TBD：to be delete，deleted：删除，new：新发，modified：修改，member expired：会员撤销
     */
    public String[] getStatusList() {
        return statusList;
    }

    /**
     * 设置商品状态，published:上架状态，expired：过期(包含手动过期与自动过期)，TBD：to be delete，deleted：删除，new：新发，modified：修改，member expired：会员撤销     *
     * 参数示例：<pre>['published']</pre>     
     * 此参数必填
     */
    public void setStatusList(String[] statusList) {
        this.statusList = statusList;
    }

    private Long categoryId;

    /**
     * @return 类目ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类目ID     *
     * 参数示例：<pre>1031728</pre>     
     * 此参数必填
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    private Date startModifyTime;

    /**
     * @return 产品修改开始时间
     */
    public Date getStartModifyTime() {
        return startModifyTime;
    }

    /**
     * 设置产品修改开始时间     *
     * 参数示例：<pre>20180717174002000+0800</pre>     
     * 此参数必填
     */
    public void setStartModifyTime(Date startModifyTime) {
        this.startModifyTime = startModifyTime;
    }

    private Date endModifyTime;

    /**
     * @return 产品修改结束时间
     */
    public Date getEndModifyTime() {
        return endModifyTime;
    }

    /**
     * 设置产品修改结束时间     *
     * 参数示例：<pre>20180717174002000+0800</pre>     
     * 此参数必填
     */
    public void setEndModifyTime(Date endModifyTime) {
        this.endModifyTime = endModifyTime;
    }

    private String subjectKey;

    /**
     * @return 关键词
     */
    public String getSubjectKey() {
        return subjectKey;
    }

    /**
     * 设置关键词     *
     * 参数示例：<pre>北极</pre>     
     * 此参数必填
     */
    public void setSubjectKey(String subjectKey) {
        this.subjectKey = subjectKey;
    }

    private String cargoNumber;

    /**
     * @return 货号
     */
    public String getCargoNumber() {
        return cargoNumber;
    }

    /**
     * 设置货号     *
     * 参数示例：<pre>LYQ-8816</pre>     
     * 此参数必填
     */
    public void setCargoNumber(String cargoNumber) {
        this.cargoNumber = cargoNumber;
    }

    private long[] productIds;

    /**
     * @return 产品ID列表
     */
    public long[] getProductIds() {
        return productIds;
    }

    /**
     * 设置产品ID列表     *
     * 参数示例：<pre>[12323213,12312323]</pre>     
     * 此参数必填
     */
    public void setProductIds(long[] productIds) {
        this.productIds = productIds;
    }

    private Integer beginStar;

    /**
     * @return 星级范围起始值0-5，不能高于endStar
     */
    public Integer getBeginStar() {
        return beginStar;
    }

    /**
     * 设置星级范围起始值0-5，不能高于endStar     *
     * 参数示例：<pre>0</pre>     
     * 此参数必填
     */
    public void setBeginStar(Integer beginStar) {
        this.beginStar = beginStar;
    }

    private Integer endStar;

    /**
     * @return 星级范围起始值0-5，不能低于beginStar
     */
    public Integer getEndStar() {
        return endStar;
    }

    /**
     * 设置星级范围起始值0-5，不能低于beginStar     *
     * 参数示例：<pre>5</pre>     
     * 此参数必填
     */
    public void setEndStar(Integer endStar) {
        this.endStar = endStar;
    }

    private String groupIds;

    /**
     * @return 查询自定义分组ID，目前只支持查询一个
     */
    public String getGroupIds() {
        return groupIds;
    }

    /**
     * 设置查询自定义分组ID，目前只支持查询一个     *
     * 参数示例：<pre>100416219</pre>     
     * 此参数必填
     */
    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }

    private Date startPublishTime;

    /**
     * @return 发布时间起始值
     */
    public Date getStartPublishTime() {
        return startPublishTime;
    }

    /**
     * 设置发布时间起始值     *
     * 参数示例：<pre>20180717174002000+0800</pre>     
     * 此参数必填
     */
    public void setStartPublishTime(Date startPublishTime) {
        this.startPublishTime = startPublishTime;
    }

    private Date endPublishTime;

    /**
     * @return 发布时间结束值
     */
    public Date getEndPublishTime() {
        return endPublishTime;
    }

    /**
     * 设置发布时间结束值     *
     * 参数示例：<pre>20180717174002000+0800</pre>     
     * 此参数必填
     */
    public void setEndPublishTime(Date endPublishTime) {
        this.endPublishTime = endPublishTime;
    }

    private Date startExpiredTime;

    /**
     * @return 过期时间起始值
     */
    public Date getStartExpiredTime() {
        return startExpiredTime;
    }

    /**
     * 设置过期时间起始值     *
     * 参数示例：<pre>20180717174002000+0800</pre>     
     * 此参数必填
     */
    public void setStartExpiredTime(Date startExpiredTime) {
        this.startExpiredTime = startExpiredTime;
    }

    private Date endExpiredTime;

    /**
     * @return 过期时间结束值
     */
    public Date getEndExpiredTime() {
        return endExpiredTime;
    }

    /**
     * 设置过期时间结束值     *
     * 参数示例：<pre>20180717174002000+0800</pre>     
     * 此参数必填
     */
    public void setEndExpiredTime(Date endExpiredTime) {
        this.endExpiredTime = endExpiredTime;
    }

    private Double priceStart;

    /**
     * @return 价格范围起始值
     */
    public Double getPriceStart() {
        return priceStart;
    }

    /**
     * 设置价格范围起始值     *
     * 参数示例：<pre>1.0</pre>     
     * 此参数必填
     */
    public void setPriceStart(Double priceStart) {
        this.priceStart = priceStart;
    }

    private Double priceEnd;

    /**
     * @return 价格范围结束值
     */
    public Double getPriceEnd() {
        return priceEnd;
    }

    /**
     * 设置价格范围结束值     *
     * 参数示例：<pre>1000.0</pre>     
     * 此参数必填
     */
    public void setPriceEnd(Double priceEnd) {
        this.priceEnd = priceEnd;
    }

    private String orderByCondition;

    /**
     * @return 排序条件：CREATE_DATE,POST_DATE,MODIFY_DATE,APPROVED_DATE,EXPIRE_DATE,STATUS,ID,GROUP_ID,PRICE,SALE_QUANTITY
     */
    public String getOrderByCondition() {
        return orderByCondition;
    }

    /**
     * 设置排序条件：CREATE_DATE,POST_DATE,MODIFY_DATE,APPROVED_DATE,EXPIRE_DATE,STATUS,ID,GROUP_ID,PRICE,SALE_QUANTITY     *
     * 参数示例：<pre>PRICE</pre>     
     * 此参数必填
     */
    public void setOrderByCondition(String orderByCondition) {
        this.orderByCondition = orderByCondition;
    }

    private String orderByType;

    /**
     * @return 升序 ASC 还是降序 DESC
     */
    public String getOrderByType() {
        return orderByType;
    }

    /**
     * 设置升序 ASC 还是降序 DESC     *
     * 参数示例：<pre>DESC</pre>     
     * 此参数必填
     */
    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    private Boolean supportOnlineTrade;

    /**
     * @return 支持在线交易
     */
    public Boolean getSupportOnlineTrade() {
        return supportOnlineTrade;
    }

    /**
     * 设置支持在线交易     *
     * 参数示例：<pre>true</pre>     
     * 此参数必填
     */
    public void setSupportOnlineTrade(Boolean supportOnlineTrade) {
        this.supportOnlineTrade = supportOnlineTrade;
    }

    private Boolean privateOffer;

    /**
     * @return 私密商品
     */
    public Boolean getPrivateOffer() {
        return privateOffer;
    }

    /**
     * 设置私密商品     *
     * 参数示例：<pre>false</pre>     
     * 此参数必填
     */
    public void setPrivateOffer(Boolean privateOffer) {
        this.privateOffer = privateOffer;
    }

    private Boolean needDetail;

    /**
     * @return 是否需要详情
     */
    public Boolean getNeedDetail() {
        return needDetail;
    }

    /**
     * 设置是否需要详情     *
     * 参数示例：<pre>true</pre>     
     * 此参数必填
     */
    public void setNeedDetail(Boolean needDetail) {
        this.needDetail = needDetail;
    }

    private Boolean needFreight;

    /**
     * @return 是否需要运费
     */
    public Boolean getNeedFreight() {
        return needFreight;
    }

    /**
     * 设置是否需要运费     *
     * 参数示例：<pre>true</pre>     
     * 此参数必填
     */
    public void setNeedFreight(Boolean needFreight) {
        this.needFreight = needFreight;
    }

    private Boolean needUserCategoryInfo;

    /**
     * @return 是否需要自定义类目
     */
    public Boolean getNeedUserCategoryInfo() {
        return needUserCategoryInfo;
    }

    /**
     * 设置是否需要自定义类目     *
     * 参数示例：<pre>true</pre>     
     * 此参数必填
     */
    public void setNeedUserCategoryInfo(Boolean needUserCategoryInfo) {
        this.needUserCategoryInfo = needUserCategoryInfo;
    }

}
