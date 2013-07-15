package com.os.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class InitService implements Constants
{
    private static Logger logger = Logger.getLogger(InitService.class);
    
    public void init()
    {
        
    }
    
    public static void readConfig()
    {
        File file = null;
        Properties properties = null;
        FileReader fr  = null;
        try
        {
            file = new File(CONFIG_FILE_PATH + "/" + DataBase.FILE_NAME);
            properties = new Properties();
            fr = new FileReader(file);
            properties.load(fr);
            for (Map.Entry<Object, Object> entry: properties.entrySet())
            {
                SysCache.setConfig((String)entry.getKey(), entry.getValue());
            }
        }
        catch (FileNotFoundException e)
        {
            logger.error("ReadConfig error : " + e);
        }
        catch (IOException e)
        {
            logger.error("ReadConfig error : " + e);
        }
    }

}
