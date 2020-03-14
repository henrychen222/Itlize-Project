package com.springrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springrest.model.Employee;

@Repository
public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session ses = null;

	@Override
	@Transactional
	public boolean addEntity(Employee employee) throws Exception {
		ses = sessionFactory.openSession();
		ses.save(employee);
		ses.close();
		return false;
	}

	@Override
	@Transactional
	public Employee getEntityById(long id) throws Exception {
		ses = sessionFactory.openSession();
		Employee employee = (Employee) ses.load(Employee.class,
				new Long(id));
		ses.beginTransaction();
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Employee> getEntityList() throws Exception {
		ses = sessionFactory.openSession();
		List<Employee> employeeList = ses.createCriteria(Employee.class).list();
		ses.close();
		return employeeList;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteEntity(long id) throws Exception {
		ses = sessionFactory.openSession();
		Object o = ses.load(Employee.class, id);
		ses.beginTransaction();
		ses.delete(o);
		ses.flush();
		return false;
	}

}
