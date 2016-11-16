package com.panlei.employee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.panlei.employee.dao.DepartmentDao;
import com.panlei.employee.domain.Department;
import com.panlei.employee.domain.Employee;
import com.panlei.employee.util.HibernateUtil;
/*
 * ���Ź���DAO���ʵ����
 */
public class DepartmentDaoImpl implements DepartmentDao {
	private HibernateUtil hibernateUtil;
	private Session session;
	
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	//ͳ���ܵ���Ŀ
	public int findCount() {
		String hql = "select count(*) from Department";
		session = hibernateUtil.getSession();
		Query query = session.createQuery(hql);
		int count = ((Long) query.setCacheable(true).uniqueResult()).intValue();
		if(count > 0 ) {
			//System.out.println(count);
			return count;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	//��ѯÿҳ��ʾ������
	public List<Department> findByPage(int begin, int pageSize) {
		String hql = "from Department";
		Query query = session.createQuery(hql);
		//������λ�ð󶨲�ѯ����
		System.out.println(begin);
		System.out.println(pageSize);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Department> list = query.list(); 
		return list;
	}
}
