package com.os.bean;

/**
 * 商品
 * @author 张培军
 *
 */
public class Product
{
    /**
     * 商品id
     */
    private int id;
    
    /**
     * 商品编号
     */
    private String number;
    
    /**
     * 商品名称
     */
    private String name;
    
    /**
     * 商品描述
     */
    private String desc;
    
    /**
     * 商品保质期
     */
    private String shelfLife;
    
    /**
     * 生产日期
     */
    private String outputDate;
    
    /**
     * 过期时间
     */
    private String expiredDate;
    
    /**
     * 售价
     */
    private float price;
    
    /**
     * 折扣
     */
    private float discount;
    
    /**
     * 折后价
     */
    private float discountPrice;
    
    /**
     * 数据状态
     * 0.数据删除<br>
     * 1.有货<br>
     * 2.缺货
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
    
    private float count;

    public float getCount()
    {
        return count;
    }

    public void setCount(float count)
    {
        this.count = count;
    }

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

    public String getShelfLife()
    {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife)
    {
        this.shelfLife = shelfLife;
    }

    public String getOutputDate()
    {
        return outputDate;
    }

    public void setOutputDate(String outputDate)
    {
        this.outputDate = outputDate;
    }

    public String getExpiredDate()
    {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate)
    {
        this.expiredDate = expiredDate;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public float getDiscount()
    {
        return discount;
    }

    public void setDiscount(float discount)
    {
        this.discount = discount;
    }

    public float getDiscountPrice()
    {
        return discountPrice;
    }

    public void setDiscountPrice(float discountPrice)
    {
        this.discountPrice = discountPrice;
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
