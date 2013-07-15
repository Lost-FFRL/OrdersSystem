package com.os.dao.impl;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.os.bean.Product;
import com.os.dao.ProductDao;
import com.os.util.SqlUtils;
import com.os.util.Utils;

public class ProductDaoImpl extends BaseDaoAbstract implements ProductDao
{
    private static final Logger LOG = Logger.getLogger(ProductDaoImpl.class);
    
    private String productTable = "os_product";
    
    @Override
    public boolean add(List<Product> products)
    {
        if (null == products || 0 == products.size())
        {
            LOG.info("Product add param is null");
            return false;
        }
        excSql = new StringBuffer();
        List<String> batchSql = new LinkedList<String>();
        for (Product product : products)
        {
            if (null != product)
            {
                excSql.append("inset into " + productTable)
                    .append(" (proNum,name,`desc`,shelfLife, outputDate, expiredDate, price,discount,discountPrice," +
                            "remark,status,updateDate)")
                    .append(" values(")
                    .append(SqlUtils.addSql(product.getNumber()))
                    .append(SqlUtils.addSql(product.getName()))
                    .append(SqlUtils.addSql(product.getDesc()))
                    .append(SqlUtils.addSql(product.getShelfLife()))
                    .append(SqlUtils.addSql(product.getOutputDate()))
                    .append(SqlUtils.addSql(product.getExpiredDate()))
                    .append(SqlUtils.addSql(product.getPrice()))
                    .append(SqlUtils.addSql(product.getDiscount()))
                    .append(SqlUtils.addSql(product.getDiscountPrice()))
                    .append(SqlUtils.addSql(product.getRemark()))
                    .append(SqlUtils.addSql(product.getStatus()))
                    .append("CURRENT_DATE)");
                batchSql.add(excSql.toString());
                excSql.delete(0, excSql.length());
            }
        }
        return exeBatchSql(batchSql);
    }
    
    @Override
    public boolean update(Product product)
    {
        if (null == product)
        {
            LOG.info("Product update param is null");
            return false;
        }
        excSql = new StringBuffer();
        excSql.append(" update " + productTable + " set ")
            .append(SqlUtils.updateSql("proNum", product.getNumber()))
            .append(SqlUtils.updateSql("name", product.getName()))
            .append(SqlUtils.updateSql("`desc`", product.getDesc()))
            .append(SqlUtils.updateSql("shelfLife", product.getShelfLife()))
            .append(SqlUtils.updateSql("outputDate", product.getOutputDate()))
            .append(SqlUtils.updateSql("expiredDate", product.getExpiredDate()))
            .append(SqlUtils.updateSql("price", product.getPrice()))
            .append(SqlUtils.updateSql("discount", product.getDiscount()))
            .append(SqlUtils.updateSql("discountPrice", product.getDiscountPrice()))
            .append(SqlUtils.updateSql("remark", product.getRemark()))
            .append(SqlUtils.updateSql("status", product.getStatus()))
            .append(" updateDate = CURRENT_DATE where id = " + product.getId());
        
        return exeSql(excSql.toString());
    }
    
    @Override
    public boolean delete(List<String> ids)
    {
        if (null == ids || 0 == ids.size())
        {
            LOG.info("Product delete param is null");
            return false;
        }
        excSql = new StringBuffer();
        int size = ids.size();
        for (int i = 0; i < size; i++)
        {
            if (Utils.isNotNull(ids.get(i)))
            {
                if (i > 0)
                {
                    excSql.append("," + ids.get(i));
                }
                else
                {
                    excSql.append(ids.get(i));
                }
            }
        }
        return delete(excSql.toString());
    }
    
    @Override
    public boolean delete(String ids)
    {
        if (Utils.isNull(ids))
        {
            LOG.info("PayType delete param is null");
            return false;
        }
        return delete(productTable, " id in " + ids);
    }
    
    @Override
    public List<Product> query(Product product)
    {
        if (null == product)
        {
            return null;
        }
        excSql = new StringBuffer();
        excSql.append("select id,proNum,name,`desc`,shelfLife,outputDate,expiredDate,price," +
        		"discount,discountPrice,status,createDate,,updateDate,remark ")
            .append(" from " + productTable + " where 1=1 ")
            .append(SqlUtils.querySql("and", "num", "like", product.getNumber()))
            .append(SqlUtils.querySql("and", "name", "like", product.getName()))
            .append(SqlUtils.querySql("and", "`desc`", "like", product.getDesc()))
            .append(SqlUtils.querySql("and", "status", "!=", "0"));
        List<Product> productList = null;
        Product productBean = null;
        try
        {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(excSql.toString());
            if (null != rs)
            {
                productList = new LinkedList<Product>();
                while (rs.next())
                {
                    productBean = new Product();
                    productBean.setId(rs.getInt("id"));
                    productBean.setNumber(rs.getString("proNum"));
                    productBean.setName(rs.getString("name"));
                    productBean.setDesc(rs.getString("desc"));
                    productBean.setShelfLife(rs.getString("shelfLife"));
                    productBean.setOutputDate(rs.getString("outputDate"));
                    productBean.setExpiredDate(rs.getString("expiredDate"));
                    productBean.setPrice(rs.getFloat("price"));
                    productBean.setDiscount(rs.getFloat("discount"));
                    productBean.setDiscountPrice(rs.getFloat("discountPrice"));
                    productBean.setStatus(rs.getInt("status"));
                    productBean.setCreateDate(rs.getString("createDate"));
                    productBean.setUpdateDate(rs.getString("updateDate"));
                    productBean.setRemark(rs.getString("remark"));
                    productList.add(productBean);
                }
            }
        }
        catch (SQLException e)
        {
            LOG.error("Product query param = " + product.toString());
            LOG.error( "Exception : " + e);
        }
        finally
        {
            clearConnection();
        }
        return productList;
    }
    
    @Override
    public boolean isExists(Product product)
    {
        if (null != product)
        {
            excSql = new StringBuffer();
            excSql.append("select id from " + productTable + " where 1 = 1")
                .append(SqlUtils.querySql("and", "name", "=", product.getName()))
                .append(SqlUtils.querySql("and", "proNum", "=", product.getNumber()))
                .append(SqlUtils.querySql("and", "status", "!=", "0"));
            return checkIsExists(excSql.toString());
        }
        else
        {
            LOG.error("Product IsExis param is null!");
            return false;
        }
    }
    
}
