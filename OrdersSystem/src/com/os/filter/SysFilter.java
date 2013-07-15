package com.os.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.os.system.Session;
import com.os.util.Utils;

public class SysFilter implements Filter
{
    
    public static Logger LOG = Logger.getLogger(SysFilter.class);
    
    public List<String> filterList;
    
    public List<String> notfilterList;
    
    @Override
    public void destroy()
    {
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        
        if (req.getRequestURL().toString().endsWith("Login"))
        {
            chain.doFilter(request, response);
        }
        else
        {
            Object reqInfo = req.getSession(true).getAttribute("session");
            if (null == reqInfo)
            {
                resp.sendError(404);
                return;
            }
            else
            {
                Session session = (Session)reqInfo;
                if (session.isLogin())
                {
                    chain.doFilter(request, response);
                }
                else
                {
                    resp.sendError(404);
                    return;
                }
            }
        }
    }
    
    @Override
    public void init(FilterConfig config)
        throws ServletException
    {
        filterList = new ArrayList<String>();
        notfilterList = new ArrayList<String>();
        
        String value = config.getInitParameter("filter");
        String[] valArr;
        if (Utils.isNotNull(value))
        {
            valArr = value.split(",");
            if (null != valArr)
            {
                for (String val : valArr)
                {
                    filterList.add(val);
                }
            }
        }
        
        value = config.getInitParameter("notFilter");
        if (Utils.isNotNull(value))
        {
            valArr = null;
            valArr = value.split(",");
            if (null != valArr)
            {
                for (String val : valArr)
                {
                    notfilterList.add(val);
                }
            }
        }
    }
    
}
