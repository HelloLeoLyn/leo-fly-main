package com.leo.fly.ailibaba.category;



public class ChildCategoryInfo {

    private Long id;

    /**
     * @return 子类目ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置子类目ID     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    /**
     * @return 子类目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置子类目名称     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setName(String name) {
        this.name = name;
    }

    private String categoryType;

    /**
     * @return 类目的类型：1表示cbu类目，2表示gallop类目
     */
    public String getCategoryType() {
        return categoryType;
    }

    /**
     * 设置类目的类型：1表示cbu类目，2表示gallop类目     *
     * 参数示例：<pre>1</pre>     
     * 此参数必填
     */
    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

}
