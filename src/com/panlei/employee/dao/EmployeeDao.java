package com.panlei.employee.dao;

import com.panlei.employee.domain.Employee;

/**
 * Ա�������DAO�Ľӿ�
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);
	
}
