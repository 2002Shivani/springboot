package com.productinventory.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.productinventory.enitiy.ProductEntity;

@Repository
public class Product_Dao {

	@Autowired
	SessionFactory factory;
	Session session = null;
	Transaction tr = null;
	String msg = null;

	public String insertProduct(ProductEntity product) {
		try {
			session = factory.openSession();
			tr = session.beginTransaction();
			session.persist(product);
			tr.commit();
			msg = "Data Inserted";
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return msg;
	}

	public String updateProduct(ProductEntity product, int productId) {
		try {
		session = factory.openSession();
		tr = session.beginTransaction();
		ProductEntity productUpdate = session.get(ProductEntity.class, productId);
		productUpdate.setPrice(product.getPrice());
		productUpdate.setQuantity(product.getQuantity());
		session.merge(productUpdate);
		tr.commit();
		msg = "Price and Quantity Updated";
		}catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		
		
		return msg;
	}

	public String deleteProduct(int productId) {
		try {
		session = factory.openSession();
		tr = session.beginTransaction();
		ProductEntity product = session.get(ProductEntity.class, productId);
		session.remove(product);
		tr.commit();
		msg = "Data Deleted";
		}catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return msg;
	}

	public ProductEntity getSingleProduct(int productId) {
		ProductEntity product=null;
		try {
		session = factory.openSession();
		tr = session.beginTransaction();
		product = session.get(ProductEntity.class, productId);
		tr.commit();
		}catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return product;
	}

	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> record = null;
		try {
		session = factory.openSession();
		tr = session.beginTransaction();
		String hqlquery = "from ProductEntity";
		Query<ProductEntity> query = session.createQuery(hqlquery, ProductEntity.class);
		record = query.getResultList();
		tr.commit();
		}catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return record;
	}
}
