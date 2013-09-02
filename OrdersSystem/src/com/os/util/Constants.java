package com.os.util;

public interface Constants
{
    String CONFIG_NAME = "service.xml";
    
    String DATA_BASE = "";
    
    String CONFIG_FILE_PATH = "./conf";
    
    /**
     * 空字符串，无实际意义
     */
    String STRING_EMPTY = "";
    
    /**
     * http请求头域： Content-Type
     */
    final String CONTENT_TYPE_KEY = "Content-Type";
    
    /**
     * http请求头域： Content-Type值
     */
    final String CONTENT_TYPE = "application/x-www-form-urlencoded; charset=utf-8";
    
    interface DataBase
    {
        String FILE_NAME = "dbConfig.properties";
        
        String USER = "user";
        
        String PASSWORD = "password";
        
        String NAME = "name";
        
        String DRIVER = "driver";
        
        String ADDRESS = "address";
        
        String PORT = "port";
    }
    
    /**
     * 请求命令码
     * 
     * @author FFRL
     * 
     */
    interface Code
    {
        int SUECCESS = 0;
        
        /**
         * 调用接口失败
         */
        int FAIL_1 = -1;
        
        /**
         * 不支持请求
         */
        int FAIL_2 = -2;
        
        /**
         * 成功
         */
        String DESC_SUCCESS = "Success";
        
         /**
          * 失败
          */
        String DESC_FAIL = "Fail";
        
        /**
         * 不支持请求
         */
        String DESC_NO_SUPPORT = "Not support !";
    }
    
}
