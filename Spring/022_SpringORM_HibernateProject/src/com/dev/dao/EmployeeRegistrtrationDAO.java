package com.dev.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.db.Employee;
import com.enet.logger.LogUtil;

@Repository
@SuppressWarnings("unchecked")
public class EmployeeRegistrtrationDAO {

	private SessionFactory factory;

	@Autowired
	public void setSessionFactory(@Qualifier("ENetSessionFactory")
	SessionFactory factory) {
		this.factory = factory;
	}

	@Transactional
	public ArrayList<Employee> getAllEmpList(int currentPage) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Employee.class);
		//criteria.addOrder(Order.asc("nmLast"));
		//criteria.addOrder(Order.asc("nmFirst"));
		criteria.addOrder(Order.asc("idEmp"));
		criteria.setFirstResult(currentPage * 15);
		criteria.setMaxResults(15);
		ArrayList<Employee> employees = (ArrayList<Employee>) criteria.list();
		LogUtil.info(employees);
		factory.getCurrentSession().clear();
		if (employees == null || employees.size() == 0) {
			return new ArrayList<Employee>();
		} else {
			return employees;
		}
	}

	@Transactional
	public int getAllEmpCount() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Employee.class);
		criteria.setProjection(Projections.count("idEmp"));
		Long totalEmps = (Long) criteria.list().get(0);
		LogUtil.info(totalEmps);
		factory.getCurrentSession().clear();
		return totalEmps.intValue();

	}

}
