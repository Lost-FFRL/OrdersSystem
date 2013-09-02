package com.os.server;


import java.util.List;

import com.os.bean.Express;

public interface ExpressService
{
    /**
     * 新增
     * @return
     */
    boolean add(List<Express> express);
    
    /**
     * 更新
     * @param obj
     */
    boolean update(Express express);
    
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
    List<Express> query(Express express);
    
    /**
     * 检测是否存在
     * @param user
     * @return
     */
    boolean isExists(Express express);
}
