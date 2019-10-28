package com.joole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joole.domain.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Category";
		Query query = session.createQuery(hql);
		List<Category> products = query.list();
		tx.commit();
		
		return products;
		
	}

}
