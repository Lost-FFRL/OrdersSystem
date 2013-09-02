package com.os.util;

public class SqlUtils
{
    /**
     * 拼接查询sql
     * 
     * @param relation
     * @param name
     * @param condition
     * @param value
     * @return
     */
    public static String querySql(String relation, String name, String condition, Object value)
    {
        String val = "";
        if (null == value)
        {
            return val;
        }
        if (Utils.isNotNull(name) 
            && Utils.isNotNull(String.valueOf(value)))
        {
            if ("like".equalsIgnoreCase(condition))
            {
                val = " " + relation + " " + name + " LIKE '%" + value + "%'";
            }
            else
            {
                val = " " + relation + " " + name + " " + condition + " '" + value + "'";
            }
        }
        return val;
    }
    
    /**
     * 创建增加sql
     * 
     * @param value
     * @return
     */
    public static String addSql(Object value)
    {
        if (null == value)
        {
            return "'',";
        }
        else
        {
            return "'" + String.valueOf(value) + "',";
        }
    }
    
    
    /**
     * 创建更新sql
     * @return
     */
    public static String updateSql(String key, Object value)
    {
        if (Utils.isNotNull(key) && null != value)
        {
            return key + "='" + value + "',";
        }
        return "";
    }
    
}
