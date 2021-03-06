package com.os.dao;

import java.util.List;

import com.os.bean.Product;

public interface ProductDao
{
    /**
     * 新增
     * @return
     */
    boolean add(List<Product> products);
    
    /**
     * 更新
     * @param obj
     */
    boolean update(Product product);
    
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
    List<Product> query(Product product);
    
    /**
     * 检测是否存在
     * @param user
     * @return
     */
    boolean isExists(Product product);
}
