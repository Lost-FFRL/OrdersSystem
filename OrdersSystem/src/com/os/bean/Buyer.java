package com.os.bean;

/**
 * 买家
 * @author 张培军
 *
 */
public class Buyer
{
    /**
     * 数据唯一标识
     */
    private int id;
    
    /**
     * 编号
     */
    private String number;
    
    /**
     * 称呼
     */
    private String name;
    
    /**
     * 描述
     */
    private String desc;

    /**
     * 性别
     * 1.女
     * 2.男
     * 3.未知
     */
    private int sex;

    /**
     * 联系电话
     */
    private String phone;
    
    /**
     * 手机号码1
     */
    private String mobile;
    
    /**
     * 邮编
     */
    private int position;
    
    /**
     * 地址
     */
    private String address;
    
    
    /**
     * 数据状态
     * 0.数据删除<br>
     * 1.可见<br>
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
     * 信誉
     */
    private int reputation;
    
    public int getReputation()
    {
        return reputation;
    }

    public void setReputation(int reputation)
    {
        this.reputation = reputation;
    }

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

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
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

    public int getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public int getPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
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
