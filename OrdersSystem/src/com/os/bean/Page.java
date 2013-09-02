package com.os.bean;

public class Page
{
    /**
     * 总页数
     */
    private int totalPage;
    
    /**
     * 当前页数
     */
    private int curPage;
    
    /**
     * 每页数量
     */
    private int pageSize;
    
    /**
     * 总数
     */
    private int total;
    
    /**
     * 分页查询结果
     */
    private Object result;
    
    public Page()
    {
        // 设置默认值
        curPage = 1;
        pageSize = 10;
    }
    
    public int getTotalPage()
    {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }
    
    public int getCurPage()
    {
        return curPage;
    }
    
    public void setCurPage(int curPage)
    {
        this.curPage = curPage;
    }
    
    public int getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public Object getResult()
    {
        return result;
    }
    
    public void setResult(Object result)
    {
        this.result = result;
    }
}
