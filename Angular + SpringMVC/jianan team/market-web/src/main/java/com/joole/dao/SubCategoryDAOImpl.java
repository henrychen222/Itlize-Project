package com.joole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joole.domain.SubCategory;

@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SubCategory getSubCategoty(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		SubCategory subCategoty = (SubCategory) session.get(SubCategory.class, id);
		tx.commit();
		return subCategoty;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SubCategory getSubCategotyBySubcategoryName(String subCategoryName) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		String hql = "from SubCategory sc where sc.subCategoryName = :scn";
		Query query = session.createQuery(hql);
		query.setParameter("scn", subCategoryName);
		List<SubCategory> subCategories = query.list();
		tx.commit();
		return subCategories.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubCategory> getSubCategoriesByCategoryName(String categoryName) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from SubCategory sc where sc.category.categoryName = :cn";
		Query query = session.createQuery(hql);
		query.setParameter("cn", categoryName);
		List<SubCategory> subCategories = query.list();
		tx.commit();
		
		return subCategories;
	}

}
