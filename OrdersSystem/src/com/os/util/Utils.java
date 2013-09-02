package com.os.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.os.bean.JsonResult;

/**
 * 工具类
 * 
 * @author FFRL
 * 
 */
public class Utils
{
    /**
     * 日志记录
     */
    private static Logger logger = Logger.getLogger(Utils.class);
    
    public static boolean isNotNull(String str)
    {
        if (null == str || "".equals(str))
        {
            return false;
        }
        return true;
    }
    
    public static boolean isNull(String str)
    {
        return !isNotNull(str);
    }
    
    /**
     * 字符串替换<br>
     * Example: <br> 
     *  source = "{0},{1},{2}" <br>
     *  value = new String[]{"first","two","three"} <br>
     *  return = "first,two,three"<br>
     * @param source 
     * @param value new String[]{3,4,5}
     * @return "345"
     */
    public static String template(String source, String... value)
    {
        if (value.length == 0)
        {
            logger.info("Param value is null.");
            return source;
        }
        String result = source;
        for (int i = 0, size = value.length; i < size; i++)
        {
            result = result.replaceAll("\\{"+i+"\\}", value[i]);
        }
        return result;
    }
    
    public static String getRespJson(int code, int type, String desc,Object content)
    {
        String result = "";
        try
        {
            ObjectMapper om = new ObjectMapper();
            JsonResult js = new JsonResult();
            js.setCode(String.valueOf(code));
            js.setType(String.valueOf(type));
            js.setContent(content);
            js.setDesc(desc);
            result = om.writeValueAsString(js);
        }
        catch (JsonGenerationException e)
        {
            logger.error(e);
        }
        catch (JsonMappingException e)
        {
            logger.error(e);
        }
        catch (IOException e)
        {
            logger.error(e);
        }
        return result;
    }
    
    /**
     * 响应成功或失败，不返回数据
     * @param code
     * @param type
     * @param desc
     * @return
     */
    public static String getRespJson(int code, int type, String desc)
    {
        String result = "";
        try
        {
            ObjectMapper om = new ObjectMapper();
            JsonResult js = new JsonResult();
            js.setCode(String.valueOf(code));
            js.setType(String.valueOf(type));
            js.setDesc(desc);
            js.setContent("");
            result = om.writeValueAsString(js);
        }
        catch (JsonGenerationException e)
        {
            logger.error(e);
        }
        catch (JsonMappingException e)
        {
            logger.error(e);
        }
        catch (IOException e)
        {
            logger.error(e);
        }
        return result;
    }
}
