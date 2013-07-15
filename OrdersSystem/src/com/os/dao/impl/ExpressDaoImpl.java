package com.os.dao.impl;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.Express;
import com.os.dao.ExpressDao;
import com.os.util.SqlUtils;
import com.os.util.Utils;

public class ExpressDaoImpl extends BaseDaoAbstract implements ExpressDao
{
    
    private static final Logger LOG = Logger.getLogger(ExpressDaoImpl.class);
    
    private String expressTable = "os_express";
    
    @Override
    public boolean add(List<Express> expressList)
    {
        if (null == expressList || 0 == expressList.size())
        {
            LOG.info("Express add param is null");
            return false;
        }
        excSql = new StringBuffer();
        List<String> batchSql = new LinkedList<String>();
        for (Express Express : expressList)
        {
            if (null != Express)
            {
                excSql.append("inset into " + expressTable)
                    .append(" (name,`desc`,phone,mobile,address,reputation,price,remark,status)")
                    .append(" values(")
                    .append(SqlUtils.addSql(Express.getName()))
                    .append(SqlUtils.addSql(Express.getDesc()))
                    .append(SqlUtils.addSql(Express.getPhone()))
                    .append(SqlUtils.addSql(Express.getMobile()))
                    .append(SqlUtils.addSql(Express.getAddress()))
                    .append(SqlUtils.addSql(Express.getReputation()))
                    .append(SqlUtils.addSql(Express.getPrice()))
                    .append(SqlUtils.addSql(Express.getRemark()))
                    .append("1)");
                batchSql.add(excSql.toString());
                excSql.delete(0, excSql.length());
            }
        }
        return exeBatchSql(batchSql);
    }
    
    @Override
    public boolean update(Express express)
    {
        if (null == express)
        {
            LOG.info("Express update param is null");
            return false;
        }
        excSql = new StringBuffer();
        excSql.append(" update " + expressTable + " set ")
            .append(SqlUtils.updateSql("name", express.getName()))
            .append(SqlUtils.updateSql("`desc`", express.getDesc()))
            .append(SqlUtils.updateSql("phone", express.getPhone()))
            .append(SqlUtils.updateSql("mobile", express.getMobile()))
            .append(SqlUtils.updateSql("address", express.getAddress()))
            .append(SqlUtils.updateSql("reputation", express.getReputation()))
            .append(SqlUtils.updateSql("price", express.getPrice()))
            .append(SqlUtils.updateSql("status", express.getStatus()))
            .append(SqlUtils.updateSql("remark", express.getRemark()))
            .append(" updateDate = CURRENT_DATE where id = " + express.getId());
        return exeSql(excSql.toString());
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        if (null == ids || 0 == ids.size())
        {
            LOG.info("Express delete param is null");
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
            LOG.info("Express delete param is null");
            return false;
        }
        return delete(expressTable, " id in (" + ids + ")");
    }
    
    @Override
    public List<Express> query(Express express)
    {
        if (null == express)
        {
            LOG.info("Express query param is null !");
            return null;
        }
        excSql = new StringBuffer();
        excSql.append("select id,name,`desc`,phone,mobile,address,reputation,price,remark ")
            .append(" from " + expressTable + " where 1=1 ")
            .append(SqlUtils.querySql("and", "name", "like", express.getName()))
            .append(SqlUtils.querySql("and", "mobile", "like", express.getName()))
            .append(SqlUtils.querySql("and", "phone", "like", express.getName()));
        List<Express> expressList = null;
        Express expressBean = null;
        try
        {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(excSql.toString());
            if (null != rs)
            {
                expressList = new LinkedList<Express>();
                while (rs.next())
                {
                    expressBean = new Express();
                    expressBean.setId(rs.getInt("id"));
                    expressBean.setName(rs.getString("name"));
                    expressBean.setDesc(rs.getString("desc"));
                    expressBean.setPhone(rs.getString("phone"));
                    expressBean.setMobile(rs.getString("mobile"));
                    expressBean.setAddress(rs.getString("address"));
                    expressBean.setReputation(rs.getInt("reputation"));
                    expressBean.setPrice(rs.getFloat("price"));
                    expressBean.setRemark(rs.getString("remark"));
                    expressList.add(expressBean);
                }
            }
        }
        catch (SQLException e)
        {
            LOG.error("User query param = " + express.toString());
            LOG.error("Exception : " + e);
        }
        finally
        {
            clearConnection();
        }
        return expressList;
    }
    
    @Override
    public boolean isExists(Express express)
    {
        if (null != express)
        {
            excSql = new StringBuffer();
            excSql.append("select id from " + expressTable + " where 1 = 1")
                .append(SqlUtils.querySql("and", "id", "=", express.getId()))
                .append(SqlUtils.querySql("and", "name", "=", express.getName()))
                .append(SqlUtils.querySql("and", "status", "!=", "0"));
            return checkIsExists(excSql.toString());
        }
        else
        {
            LOG.error("Express IsExis param is null!");
            return false;
        }
    }
    
}
