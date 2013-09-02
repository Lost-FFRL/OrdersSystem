package com.os.bean;

/**
 * 支付方式
 * @author 张培军
 *
 */
public class PayType
{
    /**
     * 数据唯一标识
     */
    private int id;
    
    /**
     * 编号
     */
    private String number;
    
    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    /**
     * 名称
     */
    private String name;
    
    /**
     * 描述
     */
    private String desc;
    
    /**
     * 状态<br>
     * 0.数据删除<br>
     * 1.可用
     * 2.不可用
     */
    private int status;
    
    /**
     * 数据创建时间
     */
    private String createDate;
    
    /**
     * 数据更新时间
     */
    private String updateDate;
    
    /**
     * 备注
     */
    private String remark;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public String getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(String updateDate)
    {
        this.updateDate = updateDate;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
