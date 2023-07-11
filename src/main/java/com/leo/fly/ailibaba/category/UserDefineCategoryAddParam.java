package com.leo.fly.ailibaba.category;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class UserDefineCategoryAddParam extends AbstractAPIRequest<UserDefineCategoryAddResult> {

    public UserDefineCategoryAddParam() {
        super();
        oceanApiId = new APIId("com.alibaba.product", "alibaba.userDefine.category.add", 1);
    }

    private String groupName;

    /**
     * @return 要新增的类目的名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置要新增的类目的名称     *
     * 参数示例：<pre>女装</pre>     
     * 此参数必填
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    private Long parentID;

    /**
     * @return 上一级类目的id。如果要创建的是一级类目，此处值填0
     */
    public Long getParentID() {
        return parentID;
    }

    /**
     * 设置上一级类目的id。如果要创建的是一级类目，此处值填0     *
     * 参数示例：<pre>0</pre>     
     * 此参数必填
     */
    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

}
