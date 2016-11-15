package com.panlei.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.panlei.employee.dao.EmployeeDao;
import com.panlei.employee.domain.Employee;
import com.panlei.employee.util.HibernateUtil;
/**
 * Ա�������DAO��ʵ��
 */
public class EmployeeDaoImpl implements EmployeeDao {
	
	private HibernateUtil hibernateUtil;
	private Session session;
	
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	//DAO�и����û����������ѯ�û��ķ���
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username=? and password=?";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		//������λ�ð󶨲�ѯ����
		query.setParameter(0, employee.getUsername());
		query.setParameter(1, employee.getPassword());
		List<Employee> lists = query.list(); 
		if(lists.size() > 0) {
			return lists.get(0);
		}
		return null;
	}
	
}
