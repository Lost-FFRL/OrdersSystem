package com.os.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.os.action.UserAction;

/**
 * 用户操作
 * 
 * @author FFRL
 */
@WebServlet(urlPatterns = "/Service/User", asyncSupported = true)
public class UserServlet extends BaseServlet
{
    /**
     * 序列化
     */
    private static final long serialVersionUID = -3894037422909170249L;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        super.doPost(req, resp);
        write(resp, UserAction.requstMsg(req));
    }
    
}
