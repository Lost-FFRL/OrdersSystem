package com.os.server;

import java.util.List;

import com.os.bean.OrdersProduct;

public interface OrdersProductService
{
    /**
     * 新增
     * @return
     */
    boolean add(List<OrdersProduct> ordersProducts);
    
    /**
     * 更新
     * @param obj
     */
    boolean update(OrdersProduct ordersProduct);
    
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
     * 删除订单
     * @param ids
     * @return
     */
    boolean delByOrdersId(String ids);
    
    /**
     * 查询
     * @param obj
     * @return
     */
    List<OrdersProduct> query(OrdersProduct ordersProduct);
    
    /**
     * 检测是否存在
     * @param user
     * @return
     */
    boolean isExists(OrdersProduct ordersProduct);
}
