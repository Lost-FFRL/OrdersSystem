package com.os.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.os.bean.Page;
import com.os.bean.User;
import com.os.server.UserService;
import com.os.server.impl.UserServiceImpl;
import com.os.system.Session;
import com.os.util.Constants;
import com.os.util.Constants.Code;
import com.os.util.Utils;

public class UserAction extends BaseAction
{
    private UserService userService;
    
//    private User userBean;
    
    public String requstMsg(HttpServletRequest req)
    {
        String result = "";
        int type = Integer.parseInt(req.getParameter("type"));
        switch (type)
        {
            case 0:
                result = login(type, req);
                break;
            case 1:
                result = queryUser(type, req);
                break;
            case 2:
                result = delUser(type, req);
                break;
            default:
                result = Utils.getRespJson(-2, type, Code.DESC_NO_SUPPORT, Constants.STRING_EMPTY);
                break;
        }
        return result;
    }
    
    public String addUser(int type, HttpServletRequest req)
    {
        User userBean = new User();
        userBean.setNumber(req.getParameter("num"));
        userBean.setName(req.getParameter("name"));
        userBean.setDesc(req.getParameter("desc"));
        userBean.setSex(Integer.parseInt(req.getParameter("sex")));
        userBean.setPhone(req.getParameter("phone"));
        userBean.setMobile(req.getParameter("mobile"));
        userBean.setAccount(req.getParameter("account"));
        userBean.setPassword(req.getParameter("pwd"));
        userBean.setAddress(req.getParameter("address"));
        userBean.setAuthority(Integer.parseInt(req.getParameter("authority")));
        userBean.setRemark(req.getParameter("remark"));
        userService = new UserServiceImpl();
        int code = 0;
        String desc = "";
        if (userService.add(userBean))
        {
            code = Code.SUECCESS;
            desc = Code.DESC_SUCCESS;
        }
        else
        {
            code = Code.FAIL_1;
            desc = Code.DESC_FAIL;
        }
        return Utils.getRespJson(code, type, desc);
    }
    
    public String delUser(int type, HttpServletRequest req){
        userService = new UserServiceImpl();
        String ids = req.getParameter("ids");
        int code = 0;
        String desc = "";
        if (userService.delUpdateByIds(ids))
        {
            code = Code.SUECCESS;
            desc = Code.DESC_SUCCESS;
        }
        else
        {
            code = Code.FAIL_1;
            desc = Code.DESC_FAIL;
        }
        return Utils.getRespJson(code, type, desc);
    }
    
    public String queryUser(int type, HttpServletRequest req)
    {
        Page page = null;
        User userBean = new User();
        userBean.setName(req.getParameter("name"));
        userBean.setPhone(req.getParameter("phone"));
        int count = userService.getCount(userBean);
        if (count > 0){
            page = new Page();
            page.setTotal(count);
            int pageSize =Integer.parseInt(null == req.getParameter("pageSize") ? "10" : req.getParameter("pageSize"));
            int curPage = Integer.parseInt(null == req.getParameter("curPage") ? "1" : req.getParameter("curPage"));
            page.setPageSize(pageSize <= 0 ? 10 : pageSize);
            page.setCurPage(curPage <= 0 ? 1 : curPage);
            List<User> reuslt = userService.query(userBean,page); 
            page.setResult(reuslt);
            int totalPage = count% pageSize == 0 ? count / pageSize : count / pageSize +1;
            page.setTotalPage(totalPage);
        }
        return Utils.getRespJson(Code.SUECCESS, type, Code.DESC_SUCCESS, page);
    }
    
    public String checkUser(int type, HttpServletRequest req)
    {
    	User userBean = new User();
        userBean.setAccount(req.getParameter("user"));
        userBean.setPassword(req.getParameter("pwd"));
        int code = 0;
        String desc = "";
        if (userService.isExists(userBean))
        {
            code = Code.SUECCESS;
            desc = Code.DESC_SUCCESS;
        }
        else
        {
            code = Code.FAIL_1;
            desc = Code.DESC_FAIL;
        }
        return Utils.getRespJson(code, type, desc);
    }
    
    public String login(int type, HttpServletRequest req)
    {
    	User userBean = new User();
        userBean.setAccount(req.getParameter("user"));
        userBean.setPassword(req.getParameter("pwd"));
        int code = 0;
        String desc = "";
        if (userService.isExists(userBean))
        {
            code = Code.SUECCESS;
            desc = Code.DESC_SUCCESS;
            Session session = new Session();
            session.setLoginFlag(true);
            session.setUserId(req.getParameter("user"));
            req.getSession(true).setAttribute("session", session);
        }
        else
        {
            code = Code.FAIL_1;
            desc = Code.DESC_FAIL;
        }
        return Utils.getRespJson(code, type, desc);
    }

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
}
