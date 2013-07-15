package com.os.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
    
    private User userBean;
    
    public static String requstMsg(HttpServletRequest req)
    {
        String result = "";
        int type = Integer.parseInt(req.getParameter("type"));
        UserAction userAction = new UserAction();
        switch (type)
        {
            case 0:
                result = userAction.login(type, req);
                break;
            case 1:
                result = userAction.queryUser(type, req);
                break;
            case 2:

                break;
            default:
                result = Utils.getRespJson(-2, type, Code.DESC_NO_SUPPORT, Constants.STRING_EMPTY);
                break;
        }
        return result;
    }
    
    public String addUser(int type, HttpServletRequest req)
    {
        userBean = new User();
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
        return Utils.getRespJson(code, type, desc, Constants.STRING_EMPTY);
    }
    
    public String queryUser(int type, HttpServletRequest req)
    {
        userBean = new User();
        userBean.setName(req.getParameter("name"));
        userBean.setPhone(req.getParameter("phone"));
        userService = new UserServiceImpl();
        return Utils.getRespJson(Code.SUECCESS, type, Code.DESC_SUCCESS, userService.query(userBean));
    }
    
    public String checkUser(int type, HttpServletRequest req)
    {
        userService = new UserServiceImpl();
        userBean = new User();
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
        return Utils.getRespJson(code, type, desc, Constants.STRING_EMPTY);
    }
    
    public String login(int type, HttpServletRequest req)
    {
        userService = new UserServiceImpl();
        userBean = new User();
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
        return Utils.getRespJson(code, type, desc, Constants.STRING_EMPTY);
    }
}
