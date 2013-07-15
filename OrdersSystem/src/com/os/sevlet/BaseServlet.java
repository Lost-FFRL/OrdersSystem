package com.os.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.os.util.Constants;

/**
 * Servlet implementation class BaseServlet
 */
/*
 * urlPatterns 请求url asyncSupported 异步处理请求。true 开启; false 关闭
 * @WebServlet(urlPatterns = "/hello", asyncSupported = true)
 */
public class BaseServlet extends HttpServlet implements Constants
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = -9157641880232022699L;
    
    /**
     * 日子记录
     */
    private static final Logger LOG = Logger.getLogger(BaseServlet.class);
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        
    }
    
    protected void write(HttpServletResponse response, String write)
    {
        PrintWriter pw = null;
        try
        {
            response.setHeader(CONTENT_TYPE_KEY, CONTENT_TYPE);
            pw = response.getWriter();
            pw.write(write);
            pw.flush();
        }
        catch (IOException e)
        {
            LOG.error("Response write param = " + write);
            LOG.error("Response write Excetpion: " + e);
        }
        finally
        {
            if (null != pw)
            {
                pw.close();
                pw = null;
            }
        }
    }
    
}
