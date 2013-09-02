package com.os.dao;

import java.util.List;

import com.os.bean.Orders;

public interface OrdersDao
{
    /**
     * 新增
     * @return
     */
    boolean add(List<Orders> ordersList);
    
    /**
     * 更新
     * @param obj
     */
    boolean update(Orders orders);
    
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
     * 查询
     * @param obj
     * @return
     */
    List<Orders> query(Orders orders);
    
    /**
     * 检测是否存在
     * @param user
     * @return
     */
    boolean isExists(Orders orders);
}
