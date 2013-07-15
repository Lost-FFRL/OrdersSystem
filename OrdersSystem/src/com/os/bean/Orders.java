package com.os.bean;

import java.util.List;

public class Orders
{
    /**
     * 数据唯一标识
     */
    private int id;
    
    /**
     * 订单名称
     */
    private String name;
    
    /**
     * 描述
     */
    private String desc;
    
    /**
     * 订单编号
     */
    private String ordersNum;
    
    /**
     * 下单时间
     */
    private String startDate;
    
    /**
     * 订单结束时间
     */
    private String endDate;
    
    /**
     * 总价
     */
    private float totalPrice;
    
    /**
     * 商品总量
     */
    private float totalProduct;
    
    /**
     * 买家姓名
     */
    private String buyerName;
    
    /**
     * 买家地址
     */
    private String buyerAddress;
    
    /**
     * 买家联系方式
     */
    private String buyerPhone;
    
    /**
     * 买家留言
     */
    private String buyerMsg;
    
    /**
     * 支付方式
     */
    private String payTypeName;
    
    /**
     * 支付方式
     */
    private int payTypeId;
    
    
    /**
     * 快递名
     */
    private String expressName;
    
    /**
     * 快递id
     */
    private int expressId;
    
    /**
     * 总运费
     */
    private float totalExpPrice;
    
    /**
     * 运单号
     */
    private String expressNum;
    
    /**
     * 订单状态 <br>
     * 0.数据被删除<br>
     * 1.待定<br>
     * 2.新单  <br>
     * 3.已发货 <br>
     * 4.已签收 <br>
     * 5.拒签 <br>
     * 6.已确认收款<br> 
     * 7.拒签返货中  <br>
     * 8.拒签货已退回 <br>
     * 9.已退款<br>
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
    
    /**
     * 订单商品
     */
    private List<OrdersProduct> ordersProduct;

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

    public String getOrdersNum()
    {
        return ordersNum;
    }

    public void setOrdersNum(String ordersNum)
    {
        this.ordersNum = ordersNum;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public float getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public float getTotalProduct()
    {
        return totalProduct;
    }

    public void setTotalProduct(float totalProduct)
    {
        this.totalProduct = totalProduct;
    }

    public String getBuyerName()
    {
        return buyerName;
    }

    public void setBuyerName(String buyerName)
    {
        this.buyerName = buyerName;
    }

    public String getBuyerAddress()
    {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress)
    {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerPhone()
    {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone)
    {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerMsg()
    {
        return buyerMsg;
    }

    public void setBuyerMsg(String buyerMsg)
    {
        this.buyerMsg = buyerMsg;
    }

    public int getStatus()
    {
        return status;
    }

    public String getPayTypeName()
    {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName)
    {
        this.payTypeName = payTypeName;
    }

    public int getPayTypeId()
    {
        return payTypeId;
    }

    public void setPayTypeId(int payTypeId)
    {
        this.payTypeId = payTypeId;
    }

    public String getExpressName()
    {
        return expressName;
    }

    public void setExpressName(String expressName)
    {
        this.expressName = expressName;
    }

    public int getExpressId()
    {
        return expressId;
    }

    public void setExpressId(int expressId)
    {
        this.expressId = expressId;
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

    public List<OrdersProduct> getOrdersProduct()
    {
        return ordersProduct;
    }

    public void setOrdersProduct(List<OrdersProduct> ordersProduct)
    {
        this.ordersProduct = ordersProduct;
    }

    public String getExpressNum()
    {
        return expressNum;
    }

    public void setExpressNum(String expressNum)
    {
        this.expressNum = expressNum;
    }

    public float getTotalExpPrice()
    {
        return totalExpPrice;
    }

    public void setTotalExpPrice(float totalExpPrice)
    {
        this.totalExpPrice = totalExpPrice;
    }
}
