package com.panlei.employee.service;

import com.panlei.employee.domain.Department;
import com.panlei.employee.domain.PageBean;

/**
 * ����ҵ���Ľӿ�
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

}
