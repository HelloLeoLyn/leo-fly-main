package com.leo.fly.ailibaba.category;

public class CategoryAttributeValueInfo {

    private Long attrValueID;

    /**
     * @return 属性值id
     */
    public Long getAttrValueID() {
        return attrValueID;
    }

    /**
     * 设置属性值id     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setAttrValueID(Long attrValueID) {
        this.attrValueID = attrValueID;
    }

    private String name;

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setName(String name) {
        this.name = name;
    }

    private String enName;

    /**
     * @return 英文名称
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置英文名称     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    private long[] childAttrs;

    /**
     * @return 该属性值的子属性id
     */
    public long[] getChildAttrs() {
        return childAttrs;
    }

    /**
     * 设置该属性值的子属性id     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setChildAttrs(long[] childAttrs) {
        this.childAttrs = childAttrs;
    }

    private Boolean isSKU;

    /**
     * @return 是否SKU属性值
     */
    public Boolean getIsSKU() {
        return isSKU;
    }

    /**
     * 设置是否SKU属性值     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setIsSKU(Boolean isSKU) {
        this.isSKU = isSKU;
    }

}
