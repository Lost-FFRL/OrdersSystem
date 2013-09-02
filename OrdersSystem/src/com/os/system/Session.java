package com.os.system;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.os.util.Utils;

public class Session implements HttpSessionBindingListener
{
    /**
     * 用户Id
     */
    private String userId;
    
    /**
     * 登录标识，默认false
     */
    private boolean isLoginFlag;
    
    /**
     * 存放属性缓存
     */
    private ConcurrentHashMap<String, Object> userMap = new ConcurrentHashMap<String, Object>();
    
    public boolean isLogin()
    {
        return isLoginFlag;
    }
    
    public void setLoginFlag(boolean isLoginFlag)
    {
        this.isLoginFlag = isLoginFlag;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public Object getAttribute(String key)
    {
        if (null != userMap && Utils.isNotNull(key))
        {
            return userMap.get(key);
        }
        return null;
    }
    
    public void setAttribute(String key, Object obj)
    {
        if (null != userMap && Utils.isNotNull(key))
        {
            userMap.put(key, obj);
        }
    }

    @Override
    public void valueBound(HttpSessionBindingEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }
    
}
