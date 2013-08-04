package com.os.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.os.dao.BaseDao;
import com.os.util.Utils;

public abstract class BaseDaoAbstract implements BaseDao
{
    private static final Logger LOG = Logger.getLogger(BaseDaoAbstract.class);
    
    protected Connection conn;
    
    protected Statement statement;
    
    protected ResultSet rs;
    
    protected StringBuffer excSql;
    
    /**
     * 执行SQL返回是否成功
     * 
     * @param sql
     * @return
     */
    protected boolean exeSql(String sql)
    {
        boolean result = false;
        if (Utils.isNull(sql))
        {
            LOG.info("exeSql param is null");
            return result;
        }
        try
        {
            if(LOG.isDebugEnabled())
            {
                LOG.debug("exeSql param = " + sql);
            }
            conn = ds.getConnection();
            statement = conn.createStatement();
            int count = statement.executeUpdate(sql);
            if (count > 0 ){
                result = true;
            }
        }
        catch (SQLException e)
        {
            LOG.error("exeSql param=" + sql);
            LOG.error("exeSql Exception:" + e);
        }
        finally
        {
            clearConnection();
        }
        return result;
    }
    
    protected boolean exeBatchSql(List<String> sqls)
    {
        if (null == sqls || sqls.size() <= 0)
        {
            LOG.info("exeBatchSql Param is null");
            return false;
        }
        boolean result = true;
        try
        {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            for (String sql : sqls)
            {
                if (Utils.isNotNull(sql))
                {
                    LOG.debug("Execute addBatch SQL = " + sql);
                    statement.addBatch(sql);
                }
            }
            int[] resultInt = statement.executeBatch();
            if (null != resultInt)
            {
                for (int i : resultInt)
                {
                    if (Statement.EXECUTE_FAILED == i)
                    {
                        result = false;
                        break;
                    }
                }
            }
            else 
            {
                LOG.info("exeBatchSql return null !");
                result = false;
            }
            if (result)
            {
                conn.commit();
            }
            else
            {
                conn.rollback();
            }
            conn.setAutoCommit(true);
        }
        catch (SQLException e)
        {
            LOG.error("exeBatchSql param=" + sqls);
            LOG.error("exeBatchSql Exception:" + e);
        }
        finally
        {
            clearConnection();
        }
        return result;
    }
    
    /**
     * 删除数据
     * 
     * @param table
     * @param condition
     * @return
     */
    protected boolean delete(String table, String condition)
    {
        if (Utils.isNull(condition) || Utils.isNull(table))
        {
            LOG.info("Object delete param is null. param table=" + table + ",condition=" + condition);
            return false;
        }
        return exeSql("delete from " + table + " where " + condition);
    }
    
    /**
     * 删除数据，改记录status为0
     * 
     * @return
     */
    protected boolean delUpdateByIds(String table, String ids)
    {
        if (Utils.isNull(table) || Utils.isNull(ids))
        {
            LOG.info("Object delUpdateByIds param is null. param table=" + table + ",ids=" + ids);
            return false;
        }
        return exeSql("update " + table + " set status=0 where id in (" + ids + ")");
    }
    
    /**
     * 检测是否存在。
     * @return
     */
    protected boolean checkIsExists(String sql)
    {
        if (Utils.isNotNull(sql))
        {
            LOG.debug("checkIsExists execute SQL = " + sql);
            try
            {
                conn = ds.getConnection();
                statement = conn.createStatement();
                rs = statement.executeQuery(sql);
                if (rs.next())
                {
                    return true;
                }
            }
            catch (SQLException e)
            {
                LOG.error("CheckIsExists param = " + sql);
                LOG.error("Expection : " + e);
            }
            finally
            {
                clearConnection();
            }
        }
        else 
        {
            LOG.info("CheckIsExists param is null !");
        }
        return false; 
    }
    
    /**
     * 获取总量
     * @return
     */
    protected int getCount(String table,String condition)
    {
        if (Utils.isNotNull(table))
        {
            StringBuffer sb = new StringBuffer();
            sb.append("SELECT COUNT(ID) AS NUM FROM ")
                .append(table)
                .append(" WHERE 1=1 ")
                .append(condition);
            LOG.debug("getCount execute SQL = " + sb);
            try
            {
                conn = ds.getConnection();
                statement = conn.createStatement();
                rs = statement.executeQuery(sb.toString());
                if (null != rs && rs.next())
                {
                    return rs.getInt("num");
                }
            }
            catch (SQLException e)
            {
                LOG.error("CheckIsExists param = " + sb);
                LOG.error("Expection : " + e);
            }
            finally
            {
                clearConnection();
            }
        }
        else 
        {
            LOG.info("CheckIsExists param is null !");
        }
        return 0; 
    }
    
    protected int count(String sql){
        return 0;
    };
    
    /**
     * 关闭连接
     */
    @Override
    public void clearConnection()
    {
        if (null != rs)
        {
            try
            {
                rs.close();
            }
            catch (SQLException e)
            {
                LOG.error("ResultSet close" + e);
            }
        }
        if (null != statement)
        {
            try
            {
                statement.close();
            }
            catch (SQLException e)
            {
                LOG.error("Statement" + e);
            }
        }
        if (null != conn)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                LOG.error(e);
            }
        }
        rs = null;
        statement = null;
        conn = null;
    }
    
    
    
}
