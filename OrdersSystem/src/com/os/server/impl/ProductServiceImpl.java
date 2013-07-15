package com.os.server.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.Product;
import com.os.dao.ProductDao;
import com.os.dao.impl.ProductDaoImpl;
import com.os.server.ProductService;

public class ProductServiceImpl implements ProductService
{
    private final Logger LOG = Logger.getLogger(ProductServiceImpl.class);
    
    private ProductDao proDao;
    
    public ProductServiceImpl()
    {
        proDao = new ProductDaoImpl();
    }
    
    @Override
    public boolean add(List<Product> products)
    {
        return proDao.add(products);
    }
    
    @Override
    public boolean update(Product product)
    {
        return proDao.update(product);
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        return proDao.delete(ids);
    }
    
    @Override
    public boolean delete(String ids)
    {
        return proDao.delete(ids);
    }
    
    @Override
    public List<Product> query(Product product)
    {
        return proDao.query(product);
    }
    
    @Override
    public boolean isExists(Product product)
    {
        return proDao.isExists(product);
    }
    
}
