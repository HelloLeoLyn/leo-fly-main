package com.leo.fly.ailibaba.category;

public class CategoryAttributeInfo {

    private Long attrID;

    /**
     * @return 属性id
     */
    public Long getAttrID() {
        return attrID;
    }

    /**
     * 设置属性id     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setAttrID(Long attrID) {
        this.attrID = attrID;
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

    private Boolean required;

    /**
     * @return 是否必填属性
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     * 设置是否必填属性     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }

    private String[] units;

    /**
     * @return 该属性的单位
     */
    public String[] getUnits() {
        return units;
    }

    /**
     * 设置该属性的单位     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setUnits(String[] units) {
        this.units = units;
    }

    private Boolean isSKUAttribute;

    /**
     * @return 该属性能否当成SKU属性
     */
    public Boolean getIsSKUAttribute() {
        return isSKUAttribute;
    }

    /**
     * 设置该属性能否当成SKU属性     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setIsSKUAttribute(Boolean isSKUAttribute) {
        this.isSKUAttribute = isSKUAttribute;
    }

    private CategoryAttributeValueInfo[] attrValues;

    /**
     * @return 属性可选的属性值
     */
    public CategoryAttributeValueInfo[] getAttrValues() {
        return attrValues;
    }

    /**
     * 设置属性可选的属性值     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setAttrValues(CategoryAttributeValueInfo[] attrValues) {
        this.attrValues = attrValues;
    }

    private String inputType;

    /**
     * @return 输入类型。
    下拉框:1,
    多选框:2
    单选框:3,
    文本输入框:0,
    数字输入框:-1,
    下拉框列表:4,
    日期：5
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * 设置输入类型。
    下拉框:1,
    多选框:2
    单选框:3,
    文本输入框:0,
    数字输入框:-1,
    下拉框列表:4,
    日期：5     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    private Boolean isSupportCustomizeValue;

    /**
     * @return 用成SKU属性时，是否支持自定义属性值名称，1688不返回该信息
     */
    public Boolean getIsSupportCustomizeValue() {
        return isSupportCustomizeValue;
    }

    /**
     * 设置用成SKU属性时，是否支持自定义属性值名称，1688不返回该信息     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setIsSupportCustomizeValue(Boolean isSupportCustomizeValue) {
        this.isSupportCustomizeValue = isSupportCustomizeValue;
    }

    private Boolean isSupportCustomizeImage;

    /**
     * @return 用成SKU属性时，是否支持自定义图片展示，1688不返回该信息
     */
    public Boolean getIsSupportCustomizeImage() {
        return isSupportCustomizeImage;
    }

    /**
     * 设置用成SKU属性时，是否支持自定义图片展示，1688不返回该信息     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setIsSupportCustomizeImage(Boolean isSupportCustomizeImage) {
        this.isSupportCustomizeImage = isSupportCustomizeImage;
    }

    private String enName;

    /**
     * @return 英文名称，1688无此属性
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置英文名称，1688无此属性     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    private String parentAttrID;

    /**
     * @return 父属性ID，如果此值为空或零，则表示此属性为一级属性
     */
    public String getParentAttrID() {
        return parentAttrID;
    }

    /**
     * 设置父属性ID，如果此值为空或零，则表示此属性为一级属性     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setParentAttrID(String parentAttrID) {
        this.parentAttrID = parentAttrID;
    }

    private String parentAttrValueID;

    /**
     * @return 父属性值ID，如果此值为空或零，则表示此属性为一级属性
     */
    public String getParentAttrValueID() {
        return parentAttrValueID;
    }

    /**
     * 设置父属性值ID，如果此值为空或零，则表示此属性为一级属性     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setParentAttrValueID(String parentAttrValueID) {
        this.parentAttrValueID = parentAttrValueID;
    }

    private String aspect;

    /**
     * @return 产品属性:0,
    交易属性:3,
    spu匹配属性:5
     */
    public String getAspect() {
        return aspect;
    }

    /**
     * 设置产品属性:0,
    交易属性:3,
    spu匹配属性:5     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    private String fieldType;

    /**
     * @return 类型，int：数字；string:字符串；enum：枚举
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * 设置类型，int：数字；string:字符串；enum：枚举     *
     * 参数示例：<pre>enum</pre>     
     * 此参数必填
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    private Boolean isSpecPicAttr;

    /**
     * @return 是否图片属性
     */
    public Boolean getIsSpecPicAttr() {
        return isSpecPicAttr;
    }

    /**
     * 设置是否图片属性     *
     * 参数示例：<pre>false</pre>     
     * 此参数必填
     */
    public void setIsSpecPicAttr(Boolean isSpecPicAttr) {
        this.isSpecPicAttr = isSpecPicAttr;
    }

    private Boolean firstLevel;

    /**
     * @return 是否为一级属性
     */
    public Boolean getFirstLevel() {
        return firstLevel;
    }

    /**
     * 设置是否为一级属性     *
     * 参数示例：<pre>true</pre>     
     * 此参数必填
     */
    public void setFirstLevel(Boolean firstLevel) {
        this.firstLevel = firstLevel;
    }

    private String attrType;

    /**
     * @return 专业化类目，属性类型
     */
    public String getAttrType() {
        return attrType;
    }

    /**
     * 设置专业化类目，属性类型     *
     * 参数示例：<pre>0：规格属性，1：规格扩展属性，2：产品属性</pre>     
     * 此参数必填
     */
    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }


    private String defaultValue;

}
