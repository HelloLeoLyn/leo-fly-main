// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaSearchCbuGeneralResult.java

package com.alibaba.search.param;


// Referenced classes of package com.alibaba.search.param:
//            AlibabaSearchProductSearchResultInfo

public class AlibabaSearchCbuGeneralResult
{

    private AlibabaSearchProductSearchResultInfo resultList[];
    private Integer totalRecords;
    private Integer pageIndex;
    private Integer sizePerPage;

    public AlibabaSearchCbuGeneralResult()
    {
    }

    public AlibabaSearchProductSearchResultInfo[] getResultList()
    {
        return resultList;
    }

    public void setResultList(AlibabaSearchProductSearchResultInfo resultList[])
    {
        this.resultList = resultList;
    }

    public Integer getTotalRecords()
    {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords)
    {
        this.totalRecords = totalRecords;
    }

    public Integer getPageIndex()
    {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public Integer getSizePerPage()
    {
        return sizePerPage;
    }

    public void setSizePerPage(Integer sizePerPage)
    {
        this.sizePerPage = sizePerPage;
    }
}
