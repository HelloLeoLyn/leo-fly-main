package com.leo.fly.ailibaba.category;

public class CategoryCategoryInfoFeatureInfo {

    private String key;

    /**
     * @return 名称
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置名称     *
     * 参数示例：<pre>name</pre>     
     * 此参数必填
     */
    public void setKey(String key) {
        this.key = key;
    }

    private String value;

    /**
     * @return 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值     *
     * 参数示例：<pre>jiagong</pre>     
     * 此参数必填
     */
    public void setValue(String value) {
        this.value = value;
    }

    private Integer status;

    /**
     * @return 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态     *
     * 参数示例：<pre>0</pre>     
     * 此参数必填
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    private Boolean hierarchy;

    /**
     * @return 是否继承到子元素上
     */
    public Boolean getHierarchy() {
        return hierarchy;
    }

    /**
     * 设置是否继承到子元素上     *
     * 参数示例：<pre>true</pre>     
     * 此参数必填
     */
    public void setHierarchy(Boolean hierarchy) {
        this.hierarchy = hierarchy;
    }

}
