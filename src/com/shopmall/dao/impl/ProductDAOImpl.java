
package com.shopmall.dao.impl;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopmall.bean.Category;
import com.shopmall.bean.Product;
import com.shopmall.bean.ProductImage;
import com.shopmall.dao.ProductDAO;
import com.shopmall.util.DBTool;
import com.shopmall.util.DateUtil;
  
public class ProductDAOImpl implements ProductDAO{
	private DBTool dbtool;
	
	public ProductDAOImpl()
	{
		dbtool = new DBTool();
	}
	
    public int getTotal(int cid) {
        int total = 0;
        String sql = "select count(*) from Product where cid = " + cid;
        ResultSet rs = dbtool.executeQuery(sql);
        try {
			while (rs.next())
			{
			     total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}
        return total;
    }
  
    public void add(Product bean) {
 
        String sql = "insert into Product values(null,?,?,?,?,?,?,?)";
        dbtool.getConnection();
        dbtool.executeUpdate(sql,bean.getName(),bean.getSubTitle(),String.valueOf(bean.getOrignalPrice()),
        		String.valueOf(bean.getPromotePrice()),String.valueOf(bean.getStock()),String.valueOf(bean.getCategory().getId()),
        		String.valueOf(DateUtil.d2t(bean.getCreateDate())));
        dbtool.close();
    }
  
    public void update(Product bean) {
 
        String sql = "update Product set name= ?, subTitle=?, orignalPrice=?,promotePrice=?,stock=?, cid = ?, createDate=? where id = ?";
        dbtool.getConnection();
        dbtool.executeUpdate(sql,bean.getName(),bean.getSubTitle(),String.valueOf(bean.getOrignalPrice()),
        		String.valueOf(bean.getPromotePrice()),String.valueOf(bean.getStock()),String.valueOf(bean.getCategory().getId()),
        		String.valueOf(DateUtil.d2t(bean.getCreateDate())),String.valueOf(bean.getId()));
        dbtool.close();
  
    }
  
    public void delete(int id) {
    	String sql = "delete from Product where id = " + id;
    	dbtool.getConnection();
    	dbtool.executeUpdate(sql);
    	dbtool.close();
      
    }
  
    public Product get(int id) {
        Product bean = new Product();
        String sql = "select * from Product where id = " + id;
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql);

            try {
				if (rs.next()) {
 
				    String name = rs.getString("name");
				String subTitle = rs.getString("subTitle");
				float orignalPrice = rs.getFloat("orignalPrice");
				float promotePrice = rs.getFloat("promotePrice");
				int stock = rs.getInt("stock");
				int cid = rs.getInt("cid");
				Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
         
				bean.setName(name);
				bean.setSubTitle(subTitle);
				bean.setOrignalPrice(orignalPrice);
				bean.setPromotePrice(promotePrice);
				bean.setStock(stock);
				Category category = new CategoryDAOImpl().get(cid);
				bean.setCategory(category);
				bean.setCreateDate(createDate);
				bean.setId(id);
				setFirstProductImage(bean);
      }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				dbtool.close();
			}
  
        return bean;
    }
  
    public List<Product> list(int cid) {
        return list(cid,0, Short.MAX_VALUE);
    }
  
    public List<Product> list(int cid, int start, int count) {
        List<Product> beans = new ArrayList<Product>();
        Category category = new CategoryDAOImpl().get(cid);
        String sql = "select * from Product where cid = ? order by id desc limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, cid,start,count);
       
        try {
			while (rs.next()) {
			    Product bean = new Product();
			    int id = rs.getInt(1);
			    String name = rs.getString("name");
			    String subTitle = rs.getString("subTitle");
			    float orignalPrice = rs.getFloat("orignalPrice");
			    float promotePrice = rs.getFloat("promotePrice");
			    int stock = rs.getInt("stock");
			    Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
			    bean.setName(name);
			    bean.setSubTitle(subTitle);
			    bean.setOrignalPrice(orignalPrice);
			    bean.setPromotePrice(promotePrice);
			    bean.setStock(stock);
			    bean.setCreateDate(createDate);
			    bean.setId(id);
			    bean.setCategory(category);
			    setFirstProductImage(bean);
			    beans.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbtool.close();
		}
        return beans;
    }
    public List<Product> list() {
        return list(0,Short.MAX_VALUE);
    }
    public List<Product> list(int start, int count) {
        List<Product> beans = new ArrayList<Product>();
 
        String sql = "select * from Product limit ?,? ";
        dbtool.getConnection();
        ResultSet rs = dbtool.executeQuery(sql, start,count);
            try {
				while (rs.next()) {
				    Product bean = new Product();
				    int id = rs.getInt(1);
				    int cid = rs.getInt("cid");
				    String name = rs.getString("name");
				    String subTitle = rs.getString("subTitle");
				    float orignalPrice = rs.getFloat("orignalPrice");
				    float promotePrice = rs.getFloat("promotePrice");
				    int stock = rs.getInt("stock");
				    Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
 
				    bean.setName(name);
				    bean.setSubTitle(subTitle);
				    bean.setOrignalPrice(orignalPrice);
				    bean.setPromotePrice(promotePrice);
				    bean.setStock(stock);
				    bean.setCreateDate(createDate);
				    bean.setId(id);
 
				    Category category = new CategoryDAOImpl().get(cid);
				    bean.setCategory(category);
				    beans.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				dbtool.close();
			}
        return beans;
    }    
 
    public void fill(List<Category> cs) {
        for (Category c : cs) 
            fill(c);
    }
    public void fill(Category c) {
            List<Product> ps = this.list(c.getId());
            c.setProducts(ps);
    }
 
    public void fillByRow(List<Category> cs) {
        int productNumberEachRow = 8;
        for (Category c : cs) {
            List<Product> products =  c.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i + productNumberEachRow;
                size = size > products.size() ? products.size() : size;
                List<Product> productsOfEachRow = products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }
     
    public void setFirstProductImage(Product p) {
        List<ProductImage> pis= new ProductImageDAOImpl().list(p, ProductImageDAOImpl.type_single);
        if(!pis.isEmpty())
            p.setFirstProductImage(pis.get(0));     
    }
     
    public void setSaleAndReviewNumber(Product p) {
        int saleCount = new CartDAOImpl().getSaleCount(p.getId());
        p.setSaleCount(saleCount);          
 
        int reviewCount = new ReviewDAOImpl().getCount(p.getId());
        p.setReviewCount(reviewCount);
         
    }
 
    public void setSaleAndReviewNumber(List<Product> products) {
        for (Product p : products) {
            setSaleAndReviewNumber(p);
        }
    }
 
    public List<Product> search(String keyword, int start, int count) {
         List<Product> beans = new ArrayList<Product>();
          
         if(null==keyword||0==keyword.trim().length())
             return beans;
            String sql = "select * from Product where name like ? limit ?,? ";
            dbtool.getConnection();
            ResultSet rs = dbtool.executeQuery(sql,keyword,start,count);
            try {
				while (rs.next()) {
				    Product bean = new Product();
				    int id = rs.getInt(1);
				    int cid = rs.getInt("cid");
				    String name = rs.getString("name");
				    String subTitle = rs.getString("subTitle");
				    float orignalPrice = rs.getFloat("orignalPrice");
				    float promotePrice = rs.getFloat("promotePrice");
				    int stock = rs.getInt("stock");
				    Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
					bean.setName(name);
					bean.setSubTitle(subTitle);
					bean.setOrignalPrice(orignalPrice);
					bean.setPromotePrice(promotePrice);
					bean.setStock(stock);
					bean.setCreateDate(createDate);
					bean.setId(id);
 
					Category category = new CategoryDAOImpl().get(cid);
					bean.setCategory(category);
					setFirstProductImage(bean);                
					beans.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				dbtool.close();
			}
            return beans;
    }
}