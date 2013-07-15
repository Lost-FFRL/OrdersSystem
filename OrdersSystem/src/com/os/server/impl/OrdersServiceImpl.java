package com.os.server.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.Orders;
import com.os.dao.OrdersDao;
import com.os.dao.OrdersProductDao;
import com.os.dao.impl.OrdersDaoImpl;
import com.os.server.OrdersService;

public class OrdersServiceImpl implements OrdersService
{
    private final Logger LOG = Logger.getLogger(OrdersServiceImpl.class);
    
    private OrdersDao ordersDao;
    
    public OrdersServiceImpl()
    {
        ordersDao = new OrdersDaoImpl();
    }
    
    @Override
    public boolean add(List<Orders> ordersList)
    {
        // TODO Auto-generated method stub
        return ordersDao.add(ordersList);
    }
    
    @Override
    public boolean update(Orders orders)
    {
        // TODO Auto-generated method stub
        return ordersDao.update(orders);
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        // TODO Auto-generated method stub
        return ordersDao.delete(ids);
    }
    
    @Override
    public boolean delete(String ids)
    {
        // TODO Auto-generated method stub
        return ordersDao.delete(ids);
    }
    
    @Override
    public List<Orders> query(Orders orders)
    {
        // TODO Auto-generated method stub
        return ordersDao.query(orders);
    }
    
    @Override
    public boolean isExists(Orders orders)
    {
        // TODO Auto-generated method stub
        return ordersDao.isExists(orders);
    }
    
}
