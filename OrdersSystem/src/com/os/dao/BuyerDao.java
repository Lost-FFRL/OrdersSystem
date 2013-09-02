package com.os.dao;

import java.util.List;

import com.os.bean.Buyer;

public interface BuyerDao
{
    /**
     * 新增
     * @return
     */
    boolean add(List<Buyer> buyers);
    
    /**
     * 更新
     * @param obj
     */
    boolean update(Buyer buyer);
    
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
    List<Buyer> query(Buyer buyer);
    
    /**
     * 检测是否存在
     * @param user
     * @return
     */
    boolean isExists(Buyer buyer);
}
