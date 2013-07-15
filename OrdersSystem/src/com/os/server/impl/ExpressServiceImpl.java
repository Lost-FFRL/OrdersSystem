package com.os.server.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.Express;
import com.os.dao.ExpressDao;
import com.os.dao.impl.ExpressDaoImpl;
import com.os.server.ExpressService;

public class ExpressServiceImpl implements ExpressService
{
    private final Logger LOG = Logger.getLogger(ExpressServiceImpl.class);
    
    private ExpressDao expressDao;
    
    public ExpressServiceImpl()
    {
        expressDao = new ExpressDaoImpl();
    }
    
    @Override
    public boolean add(List<Express> express)
    {
        // TODO Auto-generated method stub
        return expressDao.add(express);
    }
    
    @Override
    public boolean update(Express express)
    {
        // TODO Auto-generated method stub
        return expressDao.update(express);
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        // TODO Auto-generated method stub
        return expressDao.delete(ids);
    }
    
    @Override
    public boolean delete(String ids)
    {
        // TODO Auto-generated method stub
        return expressDao.delete(ids);
    }
    
    @Override
    public List<Express> query(Express express)
    {
        // TODO Auto-generated method stub
        return expressDao.query(express);
    }
    
    @Override
    public boolean isExists(Express express)
    {
        // TODO Auto-generated method stub
        return expressDao.isExists(express);
    }
    
}
