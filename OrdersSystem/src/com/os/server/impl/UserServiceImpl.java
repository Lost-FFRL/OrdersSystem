package com.os.server.impl;

import java.util.List;

import com.os.bean.Page;
import com.os.bean.User;
import com.os.dao.UserDao;
import com.os.dao.impl.UserDaoImpl;
import com.os.server.UserService;

public class UserServiceImpl implements UserService
{
    // private final Logger LOG = Logger.getLogger(UserServiceImpl.class);
    
    private UserDao userDao;;
    
    public UserServiceImpl()
    {
        userDao = new UserDaoImpl();
    }
    
    @Override
    public boolean add(List<User> users)
    {
        return userDao.add(users);
    }
    
    @Override
    public boolean add(User user)
    {
        return userDao.add(user);
    }
    
    @Override
    public boolean update(User user)
    {
        return userDao.update(user);
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        return userDao.delete(ids);
    }
    
    @Override
    public boolean delete(String ids)
    {
        return userDao.delete(ids);
    }
    
    @Override
    public boolean delUpdateByIds(String ids)
    {
        return userDao.delUpdateByIds(ids);
    }
    
    /**
     * 获取总量
     */
    public int getCount(User user)
    {
        return userDao.getCount(user);
    }
    
    @Override
    public List<User> query(User user, Page page)
    {
        return userDao.query(user, page);
    }
    
    @Override
    public boolean isExists(User user)
    {
        return userDao.isExists(user);
    }
    
    /**
     * 检查用户名密码是否正确
     * 
     * @param account
     * @param pwd
     * @return
     */
    public boolean checkUser(String account, String pwd)
    {
        return userDao.checkUser(account, pwd);
    }
    
}
