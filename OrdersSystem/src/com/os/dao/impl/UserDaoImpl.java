package com.os.dao.impl;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.User;
import com.os.dao.UserDao;
import com.os.util.SqlUtils;
import com.os.util.Utils;

public class UserDaoImpl extends BaseDaoAbstract implements UserDao
{
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);
    
    private String userTable = "os_user";
    
    @Override
    public boolean add(List<User> users)
    {
        if (null == users || 0 == users.size())
        {
            LOG.info("User add param is null");
            return false;
        }
        excSql = new StringBuffer();
        List<String> batchSql = new LinkedList<String>();
        for (User user : users)
        {
            if (null != user)
            {
                excSql.append("insert into " + userTable)
                    .append(" (num,name,account,password,`desc`,sex,phone,mobile,address,remark,status)")
                    .append(" values(")
                    .append(SqlUtils.addSql(user.getNumber()))
                    .append(SqlUtils.addSql(user.getName()))
                    .append(SqlUtils.addSql(user.getAccount()))
                    .append(SqlUtils.addSql(user.getPassword()))
                    .append(SqlUtils.addSql(user.getDesc()))
                    .append(SqlUtils.addSql(user.getSex()))
                    .append(SqlUtils.addSql(user.getPhone()))
                    .append(SqlUtils.addSql(user.getMobile()))
                    .append(SqlUtils.addSql(user.getAddress()))
                    .append(SqlUtils.addSql(user.getRemark()))
                    .append("1)");
                batchSql.add(excSql.toString());
                excSql.delete(0, excSql.length());
            }
        }
        return exeBatchSql(batchSql);
    }
    
    public boolean add(User user)
    {
        if (null != user)
        {
            excSql.append("insert into " + userTable)
                .append(" (num,name,account,password,`desc`,sex,phone,mobile,address,remark,status)")
                .append(" values(")
                .append(SqlUtils.addSql(user.getNumber()))
                .append(SqlUtils.addSql(user.getName()))
                .append(SqlUtils.addSql(user.getAccount()))
                .append(SqlUtils.addSql(user.getPassword()))
                .append(SqlUtils.addSql(user.getDesc()))
                .append(SqlUtils.addSql(user.getSex()))
                .append(SqlUtils.addSql(user.getPhone()))
                .append(SqlUtils.addSql(user.getMobile()))
                .append(SqlUtils.addSql(user.getAddress()))
                .append(SqlUtils.addSql(user.getRemark()))
                .append("1)");
            return exeSql(excSql.toString());
        }
        else
        {
            LOG.info("User add param is null");
            return false;
        }
    }
    
    @Override
    public boolean update(User user)
    {
        if (null == user)
        {
            LOG.info("User update param is null");
            return false;
        }
        excSql = new StringBuffer();
        excSql.append(" update " + userTable + " set ")
            .append(SqlUtils.updateSql("num", user.getNumber()))
            .append(SqlUtils.updateSql("name", user.getName()))
            .append(SqlUtils.updateSql("account", user.getAccount()))
            .append(SqlUtils.updateSql("password", user.getPassword()))
            .append(SqlUtils.updateSql("`desc`", user.getDesc()))
            .append(SqlUtils.updateSql("sex", user.getSex()))
            .append(SqlUtils.updateSql("phone", user.getPhone()))
            .append(SqlUtils.updateSql("mobile", user.getMobile()))
            .append(SqlUtils.updateSql("address", user.getAddress()))
            .append(SqlUtils.updateSql("remark", user.getRemark()))
            .append(SqlUtils.updateSql("status", user.getStatus()))
            .append("updateDate = CURRENT_TIMESTAMP where id = " + user.getId());
        return exeSql(excSql.toString());
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        if (null == ids || 0 == ids.size())
        {
            LOG.info("User delete param is null");
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
    public boolean delUpdateByIds(String ids)
    {
        return delUpdateByIds(userTable,ids);
    }
    
    @Override
    public boolean delete(String ids)
    {
        if (Utils.isNull(ids))
        {
            LOG.info("User delete param is null");
            return false;
        }
        return delete(userTable, " id in (" + ids + ")");
    }
    
    @Override
    public List<User> query(User user)
    {
        if (null == user)
        {
            LOG.info("User query param is null !");
            return null;
        }
        excSql = new StringBuffer();
        excSql.append("select id,num,name,`desc`,sex,phone,mobile,account,address,authority,remark ")
            .append(" from " + userTable + " where 1=1 ")
            .append(SqlUtils.querySql("and", "num", "like", user.getNumber()))
            .append(SqlUtils.querySql("and", "name", "like", user.getName()))
            .append(SqlUtils.querySql("and", "mobile", "like", user.getMobile()))
            .append(SqlUtils.querySql("and", "account", "=", user.getAccount()))
            .append(SqlUtils.querySql("and", "phone", "like", user.getPhone()));
        LOG.debug("Execute SQL = " + excSql.toString());
        List<User> userList = null;
        User userBean = null;
        try
        {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(excSql.toString());
            if (null != rs)
            {
                userList = new LinkedList<User>();
                while (rs.next())
                {
                    userBean = new User();
                    userBean.setId(rs.getInt("id"));
                    userBean.setNumber(rs.getString("num"));
                    userBean.setName(rs.getString("name"));
                    userBean.setDesc(rs.getString("desc"));
                    userBean.setSex(rs.getInt("sex"));
                    userBean.setPhone(rs.getString("phone"));
                    userBean.setMobile(rs.getString("mobile"));
                    userBean.setAccount(rs.getString("account"));
                    userBean.setAddress(rs.getString("address"));
                    userBean.setAuthority(rs.getInt("authority"));
                    userBean.setRemark(rs.getString("remark"));
                    userList.add(userBean);
                }
            }
        }
        catch (SQLException e)
        {
            LOG.error("User query param = " + user.toString());
            LOG.error("Exception : " + e);
        }
        finally
        {
            clearConnection();
        }
        return userList;
    }
    
    @Override
    public boolean isExists(User user)
    {
        if (null != user)
        {
            excSql = new StringBuffer();
            excSql.append("select id from ")
                .append(userTable)
                .append(" where 1 = 1")
                .append(SqlUtils.querySql("and", "name", "=", user.getName()))
                .append(SqlUtils.querySql("and", "account", "=", user.getAccount()))
                .append(SqlUtils.querySql("and", "status", "!=", "0"));
            return checkIsExists(excSql.toString());
        }
        else
        {
            LOG.error("User IsExis param is null!");
            return false;
        }
    }
    
    @Override
    public boolean checkUser(String account, String pwd)
    {
        if (Utils.isNotNull(account) && Utils.isNotNull(pwd))
        {
            excSql = new StringBuffer();
            excSql.append("select id from ")
                .append(userTable)
                .append(" where ")
                .append(SqlUtils.querySql("", "account", "=", account))
                .append(SqlUtils.querySql("and", "password", "=", pwd))
                .append(SqlUtils.querySql("and", "status", "=", "1"));
            return checkIsExists(excSql.toString());
        }
        else
        {
            LOG.error("User checkUser param is null!");
            return false;
        }
    }
}
