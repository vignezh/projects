package com.vig.shop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vig.shop.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory session;

	@Override
	public void save(Product product) {
		session.getCurrentSession().save(product);	
	}

	@Override
	public void update(Product product) {
		session.getCurrentSession().update(product);
	}

	@Override
	public void delete(String productId) {
		session.getCurrentSession().delete(getProduct(productId));
	}

	@Override
	public Product getProduct(String productId) {
		return (Product)session.getCurrentSession().get(Product.class, productId);
	}

	@Override
	public List getAllproduct() {
		return session.getCurrentSession().createQuery("from prod").list();
	}

	/*public void save(Product product) {
		session.getCurrentSession().save(product);
	}

	public void update(Product product) {
		session.getCurrentSession().update(product);
	}

	public void delete(String productId) {
		session.getCurrentSession().delete(getProduct(productId));

	}

	public Product getProduct(String productId) {
		return (Product) session.getCurrentSession().get(Product.class, productId);

	}

	public List getAllproduct() {
		return session.getCurrentSession().createQuery("from Product").list();
	}*/

}
