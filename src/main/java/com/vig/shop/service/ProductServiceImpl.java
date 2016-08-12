package com.vig.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vig.shop.dao.ProductDAO;
import com.vig.shop.dao.ProductDAOImpl;
import com.vig.shop.model.Product;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired(required=true)
	private ProductDAO productDao;
	
	public void save(Product product){
		productDao.save(product);
	}
	
	public void update(Product product){
		productDao.update(product);
	}
	
	
	public void delete( String productId){
		productDao.delete(productId);
		}
	
	
	public Product getproduct(String productId) {
		return productDao.getProduct(productId);
	}
	
	public List getAllproduct() {
		return productDao.getAllproduct();
	}

	
	}
