package com.os.bean;

public class JsonResult
{
    /**
     * 返回结果
     */
    private String code;
    
    /**
     * 请求类型
     */
    private String type;
    
    /**
     * 返回内容
     */
    private Object content;
    
    /**
     * 描述
     */
    private String desc;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Object getContent()
    {
        return content;
    }

    public void setContent(Object content)
    {
        this.content = content;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
