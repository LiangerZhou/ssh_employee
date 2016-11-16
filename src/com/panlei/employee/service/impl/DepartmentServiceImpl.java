package com.panlei.employee.service.impl;

import java.util.List;

import com.panlei.employee.dao.DepartmentDao;
import com.panlei.employee.domain.Department;
import com.panlei.employee.domain.PageBean;
import com.panlei.employee.service.DepartmentService;
/**
 * ����ҵ����ʵ����
 */
public class DepartmentServiceImpl implements DepartmentService {
	//ע�벿�Ź����DAO
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//��ҳ��ѯ���ŵķ���
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;	//ÿҳ��ʾ3��
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);	//����ȡ��
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage - 1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
}
