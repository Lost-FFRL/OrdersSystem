package com.os.dao.impl;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.PayType;
import com.os.dao.PayTypeDao;
import com.os.util.SqlUtils;
import com.os.util.Utils;

public class PayTypeDaoImpl extends BaseDaoAbstract implements PayTypeDao
{
    private static final Logger LOG = Logger.getLogger(PayTypeDaoImpl.class);
    
    private String payTypeTable = "os_paytype";
    
    @Override
    public boolean add(List<PayType> payTypeList)
    {
        boolean result = false;
        if (null == payTypeList || 0 == payTypeList.size())
        {
            LOG.info("PayType add param is null");
            return result;
        }
        excSql = new StringBuffer();
        List<String> batchSql = new LinkedList<String>();
        for (PayType PayType : payTypeList)
        {
            if (null != PayType)
            {
                excSql.append("inset into " + payTypeTable)
                    .append(" (num,name,`desc`,remark,status)")
                    .append(" values(")
                    .append(SqlUtils.addSql(PayType.getNumber()))
                    .append(SqlUtils.addSql(PayType.getName()))
                    .append(SqlUtils.addSql(PayType.getDesc()))
                    .append(SqlUtils.addSql(PayType.getRemark()))
                    .append("1)");
                batchSql.add(excSql.toString());
                excSql.delete(0, excSql.length());
            }
        }
        return exeBatchSql(batchSql);
    }
    
    @Override
    public boolean update(PayType payType)
    {
        if (null == payType)
        {
            LOG.info("PayType update param is null");
            return false;
        }
        excSql = new StringBuffer();
        excSql.append(" update " + payTypeTable + " set ")
            .append(SqlUtils.updateSql("name", payType.getName()))
            .append(SqlUtils.updateSql("`desc`", payType.getDesc()))
            .append(SqlUtils.updateSql("status", payType.getStatus()))
            .append(SqlUtils.updateSql("remark", payType.getRemark()))
            .append(" updateDate = CURRENT_DATE where id = " + payType.getId());
        return exeSql(excSql.toString());
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        if (null == ids || 0 == ids.size())
        {
            LOG.info("PayType delete param is null");
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
        return delete(payTypeTable, "id in " + ids);
    }
    
    @Override
    public List<PayType> query(PayType payType)
    {
        if (null == payType)
        {
            LOG.info("PayType query param is null !");
            return null;
        }
        excSql = new StringBuffer();
        excSql.append("select id,num,name,`desc`,createDate,status,remark ")
            .append(" from " + payTypeTable + " where 1=1 ")
            .append(SqlUtils.querySql("and", "name", "like", payType.getName()))
            .append(SqlUtils.querySql("and", "num", "like", payType.getNumber()))
            .append(SqlUtils.querySql("and", "`desc`", "like", payType.getDesc()))
            .append(SqlUtils.querySql("and", "status", "!=", "0"));
        LOG.debug("Execute SQL = " + excSql.toString());
        List<PayType> payTypeList = null;
        PayType payTypeBean = null;
        try
        {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(excSql.toString());
            if (null != rs)
            {
                payTypeList = new LinkedList<PayType>();
                while (rs.next())
                {
                    payTypeBean = new PayType();
                    payTypeBean.setId(rs.getInt("id"));
                    payTypeBean.setName(rs.getString("name"));
                    payTypeBean.setNumber(rs.getString("number"));
                    payTypeBean.setDesc(rs.getString("desc"));
                    payTypeBean.setRemark(rs.getString("remark"));
                    payTypeBean.setCreateDate(rs.getString("createDate"));
                    payTypeList.add(payTypeBean);
                }
            }
        }
        catch (SQLException e)
        {
            LOG.error("Buyer query param = " + payType.toString());
            LOG.error("Exception : " + e);
        }
        finally
        {
            clearConnection();
        }
        return payTypeList;
    }
    
    @Override
    public boolean isExists(PayType payType)
    {
        if (null != payType)
        {
            excSql = new StringBuffer();
            excSql.append("select id from " + payTypeTable + " where 1 = 1")
                .append(SqlUtils.querySql("and", "id", "=", payType.getId()))
                .append(SqlUtils.querySql("and", "name", "=", payType.getName()))
                .append(SqlUtils.querySql("and", "status", "!=", "0"));
            return checkIsExists(excSql.toString());
        }
        else
        {
            LOG.error("PayType IsExis param is null!");
            return false;
        }
    }
}
