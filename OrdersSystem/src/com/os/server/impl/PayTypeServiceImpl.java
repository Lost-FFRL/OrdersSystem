package com.os.server.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.PayType;
import com.os.dao.PayTypeDao;
import com.os.dao.impl.PayTypeDaoImpl;
import com.os.server.PayTypeService;

public class PayTypeServiceImpl implements PayTypeService
{
    private final Logger LOG = Logger.getLogger(PayTypeServiceImpl.class);
    
    private PayTypeDao ptDao;
    
    public PayTypeServiceImpl()
    {
        ptDao = new PayTypeDaoImpl();
    }
    
    @Override
    public boolean add(List<PayType> payTypes)
    {
        return ptDao.add(payTypes);
    }
    
    @Override
    public boolean update(PayType payTypes)
    {
        return ptDao.update(payTypes);
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        return ptDao.delete(ids);
    }
    
    @Override
    public boolean delete(String ids)
    {
        return ptDao.delete(ids);
    }
    
    @Override
    public List<PayType> query(PayType payTypes)
    {
        return ptDao.query(payTypes);
    }
    
    @Override
    public boolean isExists(PayType payTypes)
    {
        return ptDao.isExists(payTypes);
    }
    
}
