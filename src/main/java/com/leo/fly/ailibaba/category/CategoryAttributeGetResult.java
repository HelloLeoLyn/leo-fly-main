package com.leo.fly.ailibaba.category;

import java.util.Map;

public class CategoryAttributeGetResult {

    private CategoryAttributeInfo[] attributes;

    /**
     * @return 类目属性信息
     */
    public CategoryAttributeInfo[] getAttributes() {
        return attributes;
    }

    /**
     * 设置类目属性信息     *
          
     * 此参数必填
     */
    public void setAttributes(CategoryAttributeInfo[] attributes) {
        this.attributes = attributes;
    }

    private CategoryPostLevelAttrRel[] levelAttrRelList;

    /**
     * @return (废弃)类目属性级联关系，只有1688业务返回返回该字段
     */
    public CategoryPostLevelAttrRel[] getLevelAttrRelList() {
        return levelAttrRelList;
    }

    /**
     * 设置(废弃)类目属性级联关系，只有1688业务返回返回该字段     *
          
     * 此参数必填
     */
    public void setLevelAttrRelList(CategoryPostLevelAttrRel[] levelAttrRelList) {
        this.levelAttrRelList = levelAttrRelList;
    }

    private Map attributeLevelMapStr;

    /**
     * @return 级联信息字符串，可强转成map
     */
    public Map getAttributeLevelMapStr() {
        return attributeLevelMapStr;
    }

    /**
     * 设置级联信息字符串，可强转成map     *
          
     * 此参数必填
     */
    public void setAttributeLevelMapStr(Map attributeLevelMapStr) {
        this.attributeLevelMapStr = attributeLevelMapStr;
    }

    private String errorMsg;

    /**
     * @return 错误描述
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设置错误描述     *
          
     * 此参数必填
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private String errorCode;

    /**
     * @return 错误码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误码     *
          
     * 此参数必填
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    private Boolean success;

    /**
     * @return 是否成功
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 设置是否成功     *
          
     * 此参数必填
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
