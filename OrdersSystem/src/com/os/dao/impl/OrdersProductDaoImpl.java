package com.os.dao.impl;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.OrdersProduct;
import com.os.bean.Product;
import com.os.dao.OrdersProductDao;
import com.os.util.SqlUtils;
import com.os.util.Utils;

public class OrdersProductDaoImpl extends BaseDaoAbstract implements OrdersProductDao
{
    private static final Logger LOG = Logger.getLogger(OrdersProductDaoImpl.class);
    
    private String opTable = "os_orders_product";
    
    @Override
    public boolean add(List<OrdersProduct> ordersProducts)
    {
        if (null == ordersProducts || 0 == ordersProducts.size())
        {
            LOG.info("OrdersProduct add param is null");
            return false;
        }
        excSql = new StringBuffer();
        List<String> batchSql = new LinkedList<String>();
        for (OrdersProduct op : ordersProducts)
        {
            if (null != op)
            {
                excSql.append("inset into " + opTable)
                    .append(" (ordersId,ordersNum,proNum,name,`desc`,shelfLife, outputDate, expiredDate, price,discount,discountPrice," +
                            "count,remark,status,updateDate)")
                    .append(" values(")
                    .append(SqlUtils.addSql(op.getOrdersId()))
                    .append(SqlUtils.addSql(op.getOrdersNum()));
                Product product = op.getProduct();
                if (null != op)
                {
                    excSql.append(SqlUtils.addSql(product.getNumber()))
                        .append(SqlUtils.addSql(product.getName()))
                        .append(SqlUtils.addSql(product.getDesc()))
                        .append(SqlUtils.addSql(product.getShelfLife()))
                        .append(SqlUtils.addSql(product.getOutputDate()))
                        .append(SqlUtils.addSql(product.getPrice()))
                        .append(SqlUtils.addSql(product.getDiscount()))
                        .append(SqlUtils.addSql(product.getDiscountPrice()))
                        .append(SqlUtils.addSql(product.getCount()))
                        .append(SqlUtils.addSql(product.getRemark()))
                        .append(SqlUtils.addSql(product.getStatus()));
                }
                excSql.append("CURRENT_DATE);");
                batchSql.add(excSql.toString());
                excSql.delete(0, excSql.length());
            }
        }
        return exeBatchSql(batchSql);
    }
    
    @Override
    public boolean update(OrdersProduct op)
    {
        if (null == op)
        {
            LOG.info("OrdersProduct update param is null");
            return false;
        }
        excSql = new StringBuffer();
        Product product = op.getProduct();
        excSql.append("update " + opTable + "set ")
            .append(SqlUtils.updateSql("ordersNum", op.getOrdersNum()));
        if (null != product)
        {
            excSql.append(SqlUtils.updateSql("proNum", product.getNumber()))
                .append(SqlUtils.updateSql("name", product.getName()))
                .append(SqlUtils.updateSql("`desc`", product.getDesc()))
                .append(SqlUtils.updateSql("shelfLife", product.getShelfLife()))
                .append(SqlUtils.updateSql("outputDate", product.getOutputDate()))
                .append(SqlUtils.updateSql("price", product.getPrice()))
                .append(SqlUtils.updateSql("discount", product.getDiscount()))
                .append(SqlUtils.updateSql("discountPrice", product.getDiscountPrice()))
                .append(SqlUtils.updateSql("remark", product.getRemark()))
                .append(SqlUtils.updateSql("status", product.getStatus()))
                .append(SqlUtils.updateSql("count", product.getCount()));
        }
        excSql.append(" updateDate = CURRENT_DATE where id = " + product.getId());
        return exeSql(excSql.toString());
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        if (null == ids || 0 == ids.size())
        {
            LOG.info("OrdersProduct delete param is null");
            return false;
        }
        excSql = new StringBuffer();
        int size = ids.size();
        for (int i = 0; i < size; i++)
        {
            if (Utils.isNotNull(ids.get(i)))
            {
                if (i > 0)
                {
                    excSql.append("," + ids.get(i));
                }
                else
                {
                    excSql.append(ids.get(i));
                }
            }
        }
        return delete(excSql.toString());
    }
    
    @Override
    public boolean delete(String ids)
    {
        if (Utils.isNull(ids))
        {
            LOG.info("OrdersProduct delete param is null");
            return false;
        }
        return delete(opTable, "id in " + ids);
    }
    
    /**
     * 删除订单
     * @param ids
     * @return
     */
    public boolean delByOrdersId(String ids)
    {
        if (Utils.isNull(ids))
        {
            LOG.info("OrdersProduct delete param is null");
            return false;
        }
        return delete(opTable, "ordersId in " + ids);
    }
    
    @Override
    public List<OrdersProduct> query(OrdersProduct op)
    {
        if (null == op)
        {
            return null;
        }
        excSql = new StringBuffer();
        excSql.append("select id,ordersId,ordersNum,proNum,proId,name,`desc`,shelfLife,outputDate,price,discount," +
                "discountPrice,count,status,createDate,,updateDate,remark ")
            .append(" from " + opTable + " where 1=1 ")
            .append(SqlUtils.querySql("and", "ordersId", "=", op.getOrdersId()))
            .append(SqlUtils.querySql("and", "ordersNum", "=", op.getOrdersNum()));
        Product product = op.getProduct();
        if (null != product)
        {
            excSql.append(SqlUtils.querySql("and", "proNum", "=", product.getNumber()))
                .append(SqlUtils.querySql("and", "`desc`", "like", product.getName()));
        }
        excSql.append(SqlUtils.querySql("and", "status", "!=", "0"));
        List<OrdersProduct> opList = null;
        OrdersProduct opBean = null;
        Product productBean = null;
        try
        {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(excSql.toString());
            if (null != rs)
            {
                opList = new LinkedList<OrdersProduct>();
                while (rs.next())
                {
                    opBean = new OrdersProduct();
                    productBean = new Product();
                    productBean.setId(rs.getInt("proId"));
                    productBean.setNumber(rs.getString("proNum"));
                    productBean.setName(rs.getString("name"));
                    productBean.setDesc(rs.getString("desc"));
                    productBean.setShelfLife(rs.getString("shelfLife"));
                    productBean.setOutputDate(rs.getString("outputDate"));
                    productBean.setExpiredDate(rs.getString("expiredDate"));
                    productBean.setPrice(rs.getFloat("price"));
                    productBean.setDiscount(rs.getFloat("discount"));
                    productBean.setDiscountPrice(rs.getFloat("discountPrice"));
                    productBean.setStatus(rs.getInt("status"));
                    productBean.setCreateDate(rs.getString("createDate"));
                    productBean.setUpdateDate(rs.getString("updateDate"));
                    productBean.setRemark(rs.getString("remark"));
                    opBean.setProduct(productBean);
                    opBean.setTotalCount(rs.getFloat("count"));
                    opBean.setOrdersId(rs.getInt("ordersId"));
                    opBean.setOrdersNum(rs.getString("ordersNum"));
                    opBean.setId(rs.getInt("id"));
                    opList.add(opBean);
                }
            }
        }
        catch (SQLException e)
        {
            LOG.equals("Product query param:" + op.toString() + "Exception=" + e);
        }
        finally
        {
            clearConnection();
        }
        return opList;
    }
    
    @Override
    public boolean isExists(OrdersProduct op)
    {
        return false;
    }
    
}
