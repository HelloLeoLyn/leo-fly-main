package com.leo.fly.ailibaba.product;

import com.alibaba.product.param.AlibabaProductProductBizGroupInfo;
import com.alibaba.product.param.AlibabaProductProductInfo;

import java.util.Date;

public class ProductGetResult {

    private AlibabaProductProductInfo productInfo;

    /**
     * @return 商品详细信息
     */
    public AlibabaProductProductInfo getProductInfo() {
        return productInfo;
    }

    /**
     * 设置商品详细信息     *
          
     * 此参数必填
     */
    public void setProductInfo(AlibabaProductProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    private AlibabaProductProductBizGroupInfo[] bizGroupInfos;

    /**
     * @return 产品业务的支持信息,support为false说明不支持.
     */
    public AlibabaProductProductBizGroupInfo[] getBizGroupInfos() {
        return bizGroupInfos;
    }

    /**
     * 设置产品业务的支持信息,support为false说明不支持.     *
          
     * 此参数必填
     */
    public void setBizGroupInfos(AlibabaProductProductBizGroupInfo[] bizGroupInfos) {
        this.bizGroupInfos = bizGroupInfos;
    }

    private Date createTime;

    /**
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间     *
          
     * 此参数必填
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date lastUpdateTime;

    /**
     * @return 最后修改时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后修改时间     *
          
     * 此参数必填
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    private Date lastRepostTime;

    /**
     * @return 最近重发时间，国际站无此信息
     */
    public Date getLastRepostTime() {
        return lastRepostTime;
    }

    /**
     * 设置最近重发时间，国际站无此信息     *
          
     * 此参数必填
     */
    public void setLastRepostTime(Date lastRepostTime) {
        this.lastRepostTime = lastRepostTime;
    }

    private Date approvedTime;

    /**
     * @return 审核通过时间，国际站无此信息
     */
    public Date getApprovedTime() {
        return approvedTime;
    }

    /**
     * 设置审核通过时间，国际站无此信息     *
          
     * 此参数必填
     */
    public void setApprovedTime(Date approvedTime) {
        this.approvedTime = approvedTime;
    }

    private Date expireTime;

    /**
     * @return 过期时间，国际站无此信息
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 设置过期时间，国际站无此信息     *
          
     * 此参数必填
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    private String errMsg;

    /**
     * @return 返回错误信息
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 设置返回错误信息     *
          
     * 此参数必填
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
