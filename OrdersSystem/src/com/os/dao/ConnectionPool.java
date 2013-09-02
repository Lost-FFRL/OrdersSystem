package com.os.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

public class ConnectionPool
{
    private static Logger logger = Logger.getLogger(ConnectionPool.class);
    
    private String address = "127.0.0.1";
    
    private String port = "3306";
    
    private String user = "FFRL";
    
    private String password = "woaiguo";
    
    private String dbName = "MySQL";
    
    private String driver = "com.mysql.jdbc.Driver";
    
    private String url = "jdbc:mysql://" + address + ":" + port + "/" + dbName;
    
    /**
     * 容量
     */
    private int capacity = 10;
    
    /**
     * 最大连接数
     */
    private int maxCapacity = 50;
    
    /**
     * 最小连接数
     */
    private int minCapacity = 3;
    
    /**
     * 增量
     */
    private int increment = capacity / 2;
    
    /**
     * 正在使用的连接量
     */
    private int useCount = 0;
    
    private LinkedList<Connection> freeConn = null;
    
    private LinkedList<Connection> busyConn = null;
    
    public static ConnectionPool connectionPool = null;
    
    private ConnectionPool()
    {
        init();
    }
    
    /**
     * 获取对象
     * 
     * @return
     */
    public static synchronized ConnectionPool getInstance()
    {
        if (null == connectionPool)
        {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }
    
    /**
     * 获取数据库连接
     * 
     * @return
     */
    public synchronized Connection getConnection()
    {
        Connection conn = null;
        if (useCount >= (capacity / 2 + 1))
        {
            addConnection();
        }
        else if (useCount == capacity)
        {
            logger.info("Connection Pool is not free Connection !");
            return conn;
        }
        if (freeConn.size() == 0)
        {
            logger.info("Free Connection is zero!");
            return conn;
        }
        useCount++;
        conn = freeConn.remove();
        busyConn.add(conn);
        return conn;
    }
    
    /**
     * 释放连接
     * 
     * @param conn
     */
    public synchronized void freeConnection(Connection conn)
    {
        if (null != conn)
        {
            freeConn.add(conn);
            busyConn.remove(conn);
            useCount--;
        }
    }
    
    /**
     * 清除所有连接
     */
    public void clearConnection()
    {
        if (null != freeConn)
        {
            try
            {
                for (Connection conn : freeConn)
                {
                    if (null != conn)
                    {
                        conn.close();
                        conn = null;
                    }
                }
                for (Connection conn : busyConn)
                {
                    if (null != conn)
                    {
                        conn.close();
                        conn = null;
                    }
                }
            }
            catch (SQLException e)
            {
                logger.error("Clear Connection Error: " + e);
            }
            finally
            {
                freeConn.clear();
            }
        }
    }
    
    private void init()
    {
        freeConn = new LinkedList<Connection>();
        busyConn = new LinkedList<Connection>();
        try
        {
            Class.forName(this.driver);
            for (int i = 0; i < capacity; i++)
            {
                freeConn.add(DriverManager.getConnection(url, this.user, this.password));
            }
        }
        catch (SQLException e)
        {
            logger.error("init Connection ERROR: " + e);
        }
        catch (ClassNotFoundException e)
        {
            logger.error("init Connection ERROR: " + e);
        }
    }
    
    /**
     * 增加连接数
     */
    private void addConnection()
    {
        try
        {
            int size = capacity + increment;
            size = (size >= maxCapacity ? maxCapacity : size);
            for (int i = capacity; i <= size; i++)
            {
                freeConn.add(DriverManager.getConnection(url, this.user, this.password));
            }
        }
        catch (SQLException e)
        {
            logger.error("add Connection ERROR: " + e);
        }
    }
}
