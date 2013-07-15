package com.os.dao;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public interface BaseDao
{
    public static DataSource ds = new ComboPooledDataSource();
    
    public void clearConnection();
    
}
