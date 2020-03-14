package com.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.dao.EmployeeRegistrtrationDAO;
import com.dev.db.Employee;
import com.dev.valueobject.EmployeeVO;

@Service("employeeRegServiceImpl")
public class EmployeeRegistrtrationServiceImpl implements EmployeeRegistrtrationService {

	@Autowired
	EmployeeRegistrtrationDAO empDAO;

	public EmployeeVO getAllEmpList(Employee form1) {
		
		EmployeeVO empVO=new EmployeeVO();
		
		if(form1 !=null && form1.getCurrent_page() == 0){
			empVO.setEmpTotCount(empDAO.getAllEmpCount());
		}
		
		empVO.setEmpList(empDAO.getAllEmpList(form1.getCurrent_page()));
		
		return empVO;
	}

}
