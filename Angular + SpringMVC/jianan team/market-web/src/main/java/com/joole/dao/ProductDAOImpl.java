package com.joole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joole.domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub

		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		List<Product> products = session.createQuery("from Product").list();
		tx.commit();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsBySubcategory(String subCategory) {
		// TODO Auto-generated method stub

		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Product p where p.subCategory.subCategoryName = :sc ";
		Query query = session.createQuery(hql);
		query.setParameter("sc", subCategory);
		List<Product> products = query.list();
		tx.commit();
		return products;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getProduct(int pid) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Product where productId = :pid";
		Query query = session.createQuery(hql);
		query.setParameter("pid", pid);
		List<Product> products = query.list();
		tx.commit();
		return products;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getProductsByComparison(List<Integer> productList) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Product where productId in :pl";
		Query query = session.createQuery(hql);
		query.setParameterList("pl", productList);
		List<Product> products = query.list();
		tx.commit();
		return products;
	}

	@Override
	public List<Product> getProductsByAdvancedSearch() {
		// TODO Auto-generated method stub
		return null;
	}

}
