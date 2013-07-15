package com.os.server;

import java.util.List;

import com.os.bean.User;

public interface UserService
{
    /**
     * 新增
     * @return
     */
    boolean add(List<User> users);
    
    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean add(User user);
    
    /**
     * 更新
     * @param obj
     */
    boolean update(User user);
    
    /**
     * 删除
     * @return
     */
    boolean delete(List<String> ids);
    
    /**
     * 删除
     * @param ids
     * @return
     */
    boolean delete(String ids);
    
    /**
     * 修改状态为删除
     * @return
     */
    boolean delUpdateByIds(String ids);
    
    /**
     * 查询
     * @param obj
     * @return
     */
    List<User> query(User user);
    
    /**
     * 检测是否存在
     * @param user
     * @return
     */
    boolean isExists(User user);
    
    /**
     * 检查用户名密码是否正确
     * @param account
     * @param pwd
     * @return
     */
    boolean checkUser(String account, String pwd);
}
