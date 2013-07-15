package com.os.server.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.OrdersProduct;
import com.os.dao.OrdersProductDao;
import com.os.dao.impl.OrdersProductDaoImpl;
import com.os.server.OrdersProductService;

public class OrdersProductServiceImpl implements OrdersProductService
{
    private final Logger LOG = Logger.getLogger(OrdersProductServiceImpl.class);
    
    private OrdersProductDao opDao;
    
    public OrdersProductServiceImpl()
    {
        opDao = new OrdersProductDaoImpl();
    }
    
    @Override
    public boolean add(List<OrdersProduct> ordersProducts)
    {
        // TODO Auto-generated method stub
        return opDao.add(ordersProducts);
    }
    
    @Override
    public boolean update(OrdersProduct ordersProduct)
    {
        // TODO Auto-generated method stub
        return opDao.update(ordersProduct);
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        // TODO Auto-generated method stub
        return opDao.delete(ids);
    }
    
    @Override
    public boolean delete(String ids)
    {
        // TODO Auto-generated method stub
        return opDao.delete(ids);
    }
    
    @Override
    public boolean delByOrdersId(String ids)
    {
        // TODO Auto-generated method stub
        return opDao.delByOrdersId(ids);
    }
    
    @Override
    public List<OrdersProduct> query(OrdersProduct ordersProduct)
    {
        // TODO Auto-generated method stub
        return opDao.query(ordersProduct);
    }
    
    @Override
    public boolean isExists(OrdersProduct ordersProduct)
    {
        // TODO Auto-generated method stub
        return opDao.isExists(ordersProduct);
    }
    
}
