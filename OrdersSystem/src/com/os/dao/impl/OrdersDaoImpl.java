package com.os.dao.impl;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.Orders;
import com.os.dao.OrdersDao;
import com.os.util.SqlUtils;
import com.os.util.Utils;

public class OrdersDaoImpl extends BaseDaoAbstract implements OrdersDao
{
    private static final Logger LOG = Logger.getLogger(OrdersDaoImpl.class);
    
    private String ordersTable = "os_orders";
    
    @Override
    public boolean add(List<Orders> ordersList)
    {
        if (null == ordersList || 0 == ordersList.size())
        {
            LOG.info("Buyer add param is null");
            return false;
        }
        List<String> batchSql = new LinkedList<String>();
        excSql = new StringBuffer();
        for (Orders orders : ordersList)
        {
            if (null != orders)
            {
                excSql.append("inset into " + ordersTable)
                    .append(" (ordersNum,name,`desc`,startDate,endDate,totalPrice,totalProduct," +
                        "buyerName,buyerAddress,buyerPhone,buyerMsg,payType,payId,expressName,expressId," +
                        "expressNum,status,remark,updateDate)")
                    .append(" values(")
                    .append(SqlUtils.addSql(orders.getOrdersNum()))
                    .append(SqlUtils.addSql(orders.getName()))
                    .append(SqlUtils.addSql(orders.getDesc()))
                    .append(SqlUtils.addSql(orders.getStartDate()))
                    .append(SqlUtils.addSql(orders.getEndDate()))
                    .append(SqlUtils.addSql(orders.getTotalPrice()))
                    .append(SqlUtils.addSql(orders.getTotalProduct()))
                    .append(SqlUtils.addSql(orders.getBuyerName()))
                    .append(SqlUtils.addSql(orders.getBuyerAddress()))
                    .append(SqlUtils.addSql(orders.getBuyerPhone()))
                    .append(SqlUtils.addSql(orders.getBuyerMsg()))
                    .append(SqlUtils.addSql(orders.getPayTypeName()))
                    .append(SqlUtils.addSql(orders.getPayTypeId()))
                    .append(SqlUtils.addSql(orders.getExpressName()))
                    .append(SqlUtils.addSql(orders.getExpressId()))
                    .append(SqlUtils.addSql(orders.getExpressNum()))
                    .append(SqlUtils.addSql(orders.getStatus()))
                    .append(SqlUtils.addSql(orders.getRemark()))
                    .append(" CURRENT_DATE)");
                batchSql.add(excSql.toString());
                excSql.delete(0, excSql.length());
            }
        }
        return exeBatchSql(batchSql);
    }
    
    @Override
    public boolean update(Orders orders)
    {
        if (null == orders)
        {
            LOG.info("Orders update param is null");
            return false;
        }
        excSql = new StringBuffer();
        excSql.append(" update " + ordersTable + " set ")
            .append(SqlUtils.updateSql("ordersNum", orders.getOrdersNum()))
            .append(SqlUtils.updateSql("name", orders.getName()))
            .append(SqlUtils.updateSql("`desc`", orders.getDesc()))
            .append(SqlUtils.updateSql("startDate", orders.getStartDate()))
            .append(SqlUtils.updateSql("endDate", orders.getEndDate()))
            .append(SqlUtils.updateSql("totalPrice", orders.getTotalPrice()))
            .append(SqlUtils.updateSql("totalProduct", orders.getTotalProduct()))
            .append(SqlUtils.updateSql("buyerName", orders.getBuyerName()))
            .append(SqlUtils.updateSql("buyerAddress", orders.getBuyerAddress()))
            .append(SqlUtils.updateSql("buyerPhone", orders.getBuyerPhone()))
            .append(SqlUtils.updateSql("buyerMsg", orders.getBuyerMsg()))
            .append(SqlUtils.updateSql("payType", orders.getPayTypeName()))
            .append(SqlUtils.updateSql("payId", orders.getPayTypeId()))
            .append(SqlUtils.updateSql("expressName", orders.getExpressName()))
            .append(SqlUtils.updateSql("expressId", orders.getExpressId()))
            .append(SqlUtils.updateSql("expressNum", orders.getExpressNum()))
            .append(SqlUtils.updateSql("remark", orders.getRemark()))
            .append(SqlUtils.updateSql("status", orders.getStatus()))
            .append(" updateDate = CURRENT_DATE where id = " + orders.getId());
        return exeSql(excSql.toString());
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        if (null == ids || 0 == ids.size())
        {
            LOG.info("Orders delete param is null");
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
            LOG.info("Orders delete param is null");
            return false;
        }
        return delete(ordersTable, "id in " + ids);
    }
    
    @Override
    public List<Orders> query(Orders orders)
    {
        if (null == orders)
        {
            LOG.info("Orders query param is null !");
            return null;
        }
        excSql = new StringBuffer();
        excSql.append("select id,ordersNum,name,`desc`,startDate,endDate,totalPrice,totalProduct," +
                "buyerName,buyerAddress,buyerPhone,buyerMsg,payType,payId,expressName,expressId," +
                "expressNum,status,createDate,updateDate,remark ")
            .append(" from " + ordersTable + " where 1=1 ")
            .append(SqlUtils.querySql("and", "ordersNum", "=", orders.getOrdersNum()))
            .append(SqlUtils.querySql("and", "name", "like", orders.getName()))
            .append(SqlUtils.querySql("and", "`desc`", "like", orders.getDesc()))
            .append(SqlUtils.querySql("and", "status", "!=", "0"));
        List<Orders> ordersList = null;
        Orders ordersBean = null;
        try
        {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(excSql.toString());
            if (null != rs)
            {
                ordersList = new LinkedList<Orders>();
                while (rs.next())
                {
                    ordersBean = new Orders();
                    ordersBean.setId(rs.getInt("id"));
                    ordersBean.setOrdersNum(rs.getString("ordersNum"));
                    ordersBean.setName(rs.getString("name"));
                    ordersBean.setDesc(rs.getString("desc"));
                    ordersBean.setStartDate(rs.getString("startDate"));
                    ordersBean.setEndDate(rs.getString("endDate"));
                    ordersBean.setTotalPrice(rs.getFloat("totalPrice"));
                    ordersBean.setTotalProduct(rs.getFloat("totalProduct"));
                    ordersBean.setBuyerName(rs.getString("buyerName"));
                    ordersBean.setBuyerAddress(rs.getString("buyerAddress"));
                    ordersBean.setBuyerPhone(rs.getString("buyerPhone"));
                    ordersBean.setBuyerMsg(rs.getString("buyerMsg"));
                    ordersBean.setExpressNum(rs.getString("expressNum"));
                    ordersBean.setStatus(rs.getInt("status"));
                    ordersBean.setCreateDate(rs.getString("createDate"));
                    ordersBean.setUpdateDate(rs.getString("updateDate"));
                    ordersBean.setRemark(rs.getString("remark"));
                    ordersBean.setPayTypeId(rs.getInt("payId"));
                    ordersBean.setPayTypeName(rs.getString("payType"));
                    ordersBean.setExpressName(rs.getString("expressName"));
                    ordersBean.setExpressId(rs.getInt("expressId"));
                    ordersList.add(ordersBean);
                }
            }
        }
        catch (SQLException e)
        {
            LOG.error("Orders query param = " + orders.toString());
            LOG.error("Exception : " + e);
        }
        finally
        {
            clearConnection();
        }
        return ordersList;
    }
    
    @Override
    public boolean isExists(Orders orders)
    {
        if (null != orders)
        {
            excSql = new StringBuffer();
            excSql.append("select id from " + ordersTable + " where 1 = 1")
                .append(SqlUtils.querySql("and", "ordersNum", "=", orders.getOrdersNum()))
                .append(SqlUtils.querySql("and", "name", "=", orders.getName()))
                .append(SqlUtils.querySql("and", "status", "!=", "0"));
            return checkIsExists(excSql.toString());
        }
        else
        {
            LOG.info("Orders IsExis param is null!");
            return false;
        }
    }
    
}
