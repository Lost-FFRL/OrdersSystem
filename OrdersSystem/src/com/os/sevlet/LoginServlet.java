package com.os.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.os.action.UserAction;

@WebServlet(urlPatterns = "/Service/Login", asyncSupported = true)
public class LoginServlet extends BaseServlet
{
    
    /**
     * 序列化
     */
    private static final long serialVersionUID = 4976441135005116644L;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        super.doPost(req, resp);
        write(resp,UserAction.requstMsg(req));
    }
    
}
