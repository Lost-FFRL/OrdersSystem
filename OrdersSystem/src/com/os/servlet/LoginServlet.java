package com.os.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.os.action.UserAction;

@WebServlet(urlPatterns = "/Service/Login", asyncSupported = true)
public class LoginServlet extends BaseServlet {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 4976441135005116644L;

	private UserAction userAction;

	public void init(ServletConfig servletConfig) {
		// 硬编码获取Bean,不太优雅，后续改成动态代理获取
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(servletConfig.getServletContext());
		// userAction = (UserAction)wac.getBean("userAction");
		userAction = (UserAction) wac.getBean(UserAction.class);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		write(resp, userAction.requstMsg(req));
	}

	public void setUserAction(UserAction userAction) {
		this.userAction = userAction;
	}

}
