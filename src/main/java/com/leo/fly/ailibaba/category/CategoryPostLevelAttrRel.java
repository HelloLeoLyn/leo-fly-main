package com.leo.fly.ailibaba.category;

public class CategoryPostLevelAttrRel {

    private Integer fid;

    /**
     * @return 属性id
     */
    public Integer getFid() {
        return fid;
    }

    /**
     * 设置属性id     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    private int[] subFids;

    /**
     * @return 子关联属性
     */
    public int[] getSubFids() {
        return subFids;
    }

    /**
     * 设置子关联属性     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setSubFids(int[] subFids) {
        this.subFids = subFids;
    }

    private Integer attrType;

    /**
     * @return 0和空都为现货属性层级关系，1为加工属性层级关系，后面其它的可加
     */
    public Integer getAttrType() {
        return attrType;
    }

    /**
     * 设置0和空都为现货属性层级关系，1为加工属性层级关系，后面其它的可加     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setAttrType(Integer attrType) {
        this.attrType = attrType;
    }

}
