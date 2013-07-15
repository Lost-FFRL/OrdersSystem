package com.os.dao.impl;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.Buyer;
import com.os.dao.BuyerDao;
import com.os.util.SqlUtils;
import com.os.util.Utils;

public class BuyerDaoImpl extends BaseDaoAbstract implements BuyerDao
{
    
    private static final Logger LOG = Logger.getLogger(BuyerDaoImpl.class);
    
    private String buyerTable = "os_buyer";
    
    @Override
    public boolean add(List<Buyer> buyers)
    {
        if (null == buyers || 0 == buyers.size())
        {
            LOG.info("Buyer add param is null");
            return false;
        }
        excSql = new StringBuffer();
        List<String> batchSql = new LinkedList<String>();
        for (Buyer buyer : buyers)
        {
            if (null != buyer)
            {
                excSql.append("inset into " + buyerTable)
                    .append(" (name,sex,`desc`,phone,mobile,address,reputation,remark,status)")
                    .append(" values(")
                    .append(SqlUtils.addSql(buyer.getName()))
                    .append(SqlUtils.addSql(buyer.getSex()))
                    .append(SqlUtils.addSql(buyer.getDesc()))
                    .append(SqlUtils.addSql(buyer.getPhone()))
                    .append(SqlUtils.addSql(buyer.getMobile()))
                    .append(SqlUtils.addSql(buyer.getAddress()))
                    .append(SqlUtils.addSql(buyer.getReputation()))
                    .append(SqlUtils.addSql(buyer.getRemark()))
                    .append("1)");
                batchSql.add(excSql.toString());
                excSql.delete(0, excSql.length());
            }
        }
        return exeBatchSql(batchSql);
    }
    
    @Override
    public boolean update(Buyer buyer)
    {
        if (null == buyer)
        {
            LOG.info("Buyer update param is null");
            return false;
        }
        excSql = new StringBuffer();
        excSql.append(" update " + buyerTable + " set ")
            .append(SqlUtils.updateSql("name", buyer.getName()))
            .append(SqlUtils.updateSql("sex", buyer.getSex()))
            .append(SqlUtils.updateSql("`desc`", buyer.getDesc()))
            .append(SqlUtils.updateSql("phone", buyer.getPhone()))
            .append(SqlUtils.updateSql("mobile", buyer.getMobile()))
            .append(SqlUtils.updateSql("address", buyer.getAddress()))
            .append(SqlUtils.updateSql("reputation", buyer.getReputation()))
            .append(SqlUtils.updateSql("remark", buyer.getRemark()))
            .append(SqlUtils.updateSql("status", buyer.getStatus()))
            .append(" updateDate = CURRENT_DATE where id = " + buyer.getId());
        return exeSql(excSql.toString());
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        if (null == ids || 0 == ids.size())
        {
            LOG.info("Buyer delete param is null");
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
            LOG.info("Buyer delete param is null");
            return false;
        }
        return delete(buyerTable, "id in " + ids);
    }
    
    @Override
    public List<Buyer> query(Buyer buyer)
    {
        if (null == buyer)
        {
            return null;
        }
        excSql = new StringBuffer();
        excSql.append("select id,name,sex,`desc`,phone,mobile,address,reputation,status,createDate,updateDate,remark ")
            .append(" from " + buyerTable + " where 1=1 ")
            .append(SqlUtils.querySql("and", "num", "like", buyer.getNumber()))
            .append(SqlUtils.querySql("and", "name", "like", buyer.getName()))
            .append(SqlUtils.querySql("and", "mobile", "like", buyer.getMobile()))
            .append(SqlUtils.querySql("and", "phone", "like", buyer.getPhone()))
            .append(SqlUtils.querySql("and", "status", "!=", "0"));
        List<Buyer> buyerList = null;
        Buyer buyerBean = null;
        try
        {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(excSql.toString());
            if (null != rs)
            {
                buyerList = new LinkedList<Buyer>();
                while (rs.next())
                {
                    buyerBean = new Buyer();
                    buyerBean.setId(rs.getInt(1));
                    buyerBean.setName(rs.getString(2));
                    buyerBean.setSex(rs.getInt(3));
                    buyerBean.setDesc(rs.getString(4));
                    buyerBean.setPhone(rs.getString(5));
                    buyerBean.setMobile(rs.getString(6));
                    buyerBean.setAddress(rs.getString(7));
                    buyerBean.setReputation(rs.getInt(8));
                    buyerBean.setStatus(rs.getInt(9));
                    buyerBean.setCreateDate(rs.getString(10));
                    buyerBean.setUpdateDate(rs.getString(11));
                    buyerBean.setRemark(rs.getString(12));
                    buyerList.add(buyerBean);
                }
            }
        }
        catch (SQLException e)
        {
            LOG.error("User query param = " + buyer.toString());
            LOG.error("Exception : " + e);
        }
        finally
        {
            clearConnection();
        }
        return buyerList;
    }
    
    @Override
    public boolean isExists(Buyer buyer)
    {
        if (null != buyer)
        {
            excSql = new StringBuffer();
            excSql.append("select id from " + buyerTable + " where 1 = 1")
                .append(SqlUtils.querySql("and", "name", "=", buyer.getName()))
                .append(SqlUtils.querySql("and", "status", "!=", "0"));
            return checkIsExists(excSql.toString());
        }
        else
        {
            LOG.error("User IsExis param is null!");
            return false;
        }
    }
    
}
