package com.os.server.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.Buyer;
import com.os.dao.BuyerDao;
import com.os.dao.impl.BuyerDaoImpl;
import com.os.server.BuyerService;

public class BuyerServiceImpl implements BuyerService
{
    private static final Logger LOG = Logger.getLogger(BuyerServiceImpl.class);
    
    private BuyerDao buyerDao;
    
    public BuyerServiceImpl()
    {
        buyerDao = new BuyerDaoImpl();
    }
    
    @Override
    public boolean add(List<Buyer> buyers)
    {
        // TODO Auto-generated method stub
        return buyerDao.add(buyers);
    }
    
    @Override
    public boolean update(Buyer buyer)
    {
        // TODO Auto-generated method stub
        return buyerDao.update(buyer);
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        // TODO Auto-generated method stub
        return buyerDao.delete(ids);
    }
    
    @Override
    public boolean delete(String ids)
    {
        // TODO Auto-generated method stub
        return buyerDao.delete(ids);
    }
    
    @Override
    public List<Buyer> query(Buyer buyer)
    {
        // TODO Auto-generated method stub
        return buyerDao.query(buyer);
    }
    
    @Override
    public boolean isExists(Buyer buyer)
    {
        // TODO Auto-generated method stub
        return buyerDao.isExists(buyer);
    }
    
}
