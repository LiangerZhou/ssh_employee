package com.panlei.employee.service.impl;

import com.panlei.employee.dao.EmployeeDao;
import com.panlei.employee.domain.Employee;
import com.panlei.employee.service.EmployeeService;

/**
 * Ա�������ʵ����
 */
public class EmployeeServiceImpl implements EmployeeService {
	//ע��DAO��Ķ���
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	//ҵ���ĵ�½����
	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}

}
