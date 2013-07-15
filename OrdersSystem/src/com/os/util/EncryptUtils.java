package com.os.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtils
{
    private static final Logger LOG = Logger.getLogger(EncryptUtils.class);
    
    
    public static String decodeBASE64(String value)
    {
        String decodeVal = null;
        try
        {
            byte[] bytes = new BASE64Decoder().decodeBuffer(value);
            decodeVal = new String(bytes);
        }
        catch (IOException e)
        {
            LOG.error("DecodeBASE64 param = " + value);
            LOG.error("DecodeBASE64 Exception : " + e);
        }
        return decodeVal;
    }
    
    public static String encryptBASE64(String value)
    {
        return new BASE64Encoder().encode(value.getBytes());
    }
}
