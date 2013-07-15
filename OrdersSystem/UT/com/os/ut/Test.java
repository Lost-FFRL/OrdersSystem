package com.os.ut;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.os.bean.User;
import com.os.util.Utils;

public class Test
{
    public static void main(String[] args)
        throws JsonGenerationException, JsonMappingException, IOException
    {
        // System.out.println(EncryptUtils.encryptBASE64("AAAdggdf"));
        // System.out.println("****");
        // System.out.println(EncryptUtils.decodeBASE64("QUFBZGdnZGY="));
        
        // List<User> userList = new ArrayList<User>();
        // for (int i = 0; i < 5; i++)
        // {
        // User user = new User();
        // user.setAccount("name" + i);
        // user.setPassword("pwd" + i);
        // userList.add(user);
        // }
        //
        // ser.setAccount("user");
        // usUser user = new User();
        // uer.setPassword("pwd");
        // ObjectMapper oMapper = new ObjectMapper();
        // System.out.println(oMapper.writeValueAsString(user));
        Test.jTest();
    }
    
    static void jsonTest()
    {
        ObjectMapper om = null;
        try
        {
            Map<String,String> map = new HashMap<String, String>();
            map.put("returns", String.valueOf(1));
            map.put("type", String.valueOf(1));
            map.put("desc", "success");
            om = new ObjectMapper();
            System.out.println(om.writeValueAsString(map));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            
        }
    }
    
    static void jTest (){
        List<User> userList = new ArrayList<User>();
         for (int i = 0; i < 5; i++)
         {
             User user = new User();
             user.setAccount("name" + i);
             user.setPassword("pwd" + i);
             userList.add(user);
         }
         System.out.println(Utils.getRespJson(0, 0, "test", userList));
    }
}
