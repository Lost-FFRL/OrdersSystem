package com.os.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
    
    private UserAction userAction;

	public void init(ServletConfig servletConfig) {
		// 硬编码获取Bean,不太优雅，后续改成动态代理获取
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(servletConfig.getServletContext());
		userAction = (UserAction) wac.getBean(UserAction.class);
	}
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        super.doPost(req, resp);
        write(resp, userAction.requstMsg(req));
    }
    
}
