package com.os.util;

import java.util.HashMap;
import java.util.Map;

public class SysCache
{
    private static Map<String, String> config = new HashMap<String, String>();
    
    public static Object getConfig(String key){
        if (Utils.isNotNull(key) && null != config){
            return config.get(key);
        }
        return null;
    }
    
    public static void setConfig(String key,Object value){
        if (null != config){
            config.get(key);
        }
    }
}
