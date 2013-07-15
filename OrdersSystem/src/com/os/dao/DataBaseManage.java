package com.os.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.os.bean.User;
import com.os.dao.impl.UserDaoImpl;

public class DataBaseManage
{
    private static Logger logger = Logger.getLogger(DataBaseManage.class);
    
    private String address = "127.0.0.1";
    
    private String port = "3306";
    
    private String dataName = "MySQL";
    
    private String driver = "com.mysql.jdbc.Driver";
    
    private String url = "jdbc:mysql://" + address + ":" + port + "/" + dataName;
    
    private String user = "FFRL";
    
    private String password = "woaiguuo";
    
    public static void main(String[] args)
    {
//        String address = "127.0.0.1";
//        String port = "3306";
//        String dataName = "MySQL";
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://" + address + ":" + port + "/" + dataName;
//        String user = "FFRL";
//        String password = "woaiguo";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try
        {
//            Class.forName(driver);
            DataSource ds = new ComboPooledDataSource();
            conn = ds.getConnection();
//            conn = ConnectionPool.getInstance().getConnection();
//            conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
            {
                stm = conn.createStatement();
                rs = stm.executeQuery("select *  from user");
                if (null != rs)
                {
                    while (rs.next())
                    {
                        logger.debug(rs.getString(1));
                        logger.debug(rs.getString(2));
                    }
                }
            }
        }
        catch (Exception e)
        {
            logger.error(e);
        }
        finally
        {
            try
            {
                if (null != rs)
                {
                    rs.close();
                }
            }
            catch (SQLException e)
            {
                logger.error(e);
            }
            if (null != conn)
            {
                ConnectionPool.getInstance().freeConnection(conn);
            }
            rs = null;
            conn = null;
        }
        
//        UserDaoImpl userDao = new UserDaoImpl();
//        User user = new User();
//        user.setAccount("account");
//        System.out.println(userDao.isExists(user));
        
    }
}
