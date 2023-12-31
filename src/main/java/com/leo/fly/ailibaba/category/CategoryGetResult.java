package com.leo.fly.ailibaba.category;

public class CategoryGetResult {

    private String succes;

    /**
     * @return 是否成功
     */
    public String getSucces() {
        return succes;
    }

    /**
     * 设置是否成功     *
          
     * 此参数必填
     */
    public void setSucces(String succes) {
        this.succes = succes;
    }

    private CategoryCategoryInfo[] categoryInfo;

    /**
     * @return 类目列表
     */
    public CategoryCategoryInfo[] getCategoryInfo() {
        return categoryInfo;
    }

    /**
     * 设置类目列表     *
          
     * 此参数必填
     */
    public void setCategoryInfo(CategoryCategoryInfo[] categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    private String errorMsg;

    /**
     * @return 错误信息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设置错误信息     *
          
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

}
