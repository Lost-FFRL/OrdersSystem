package com.os.server;

import java.util.List;

import com.os.bean.PayType;

public interface PayTypeService
{
    /**
     * 新增
     * @return
     */
    boolean add(List<PayType> payTypes);
    
    /**
     * 更新
     * @param obj
     */
    boolean update(PayType payTypes);
    
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
    List<PayType> query(PayType payTypes);
    
    /**
     * 检测是否存在
     * @param user
     * @return
     */
    boolean isExists(PayType payTypes);
}
