package com.panlei.employee.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.panlei.employee.domain.Department;

/**
 * ���Ź����Action��
 * ����ģ����������ҳ��Ĳ���
 * Ȼ�����service��
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//ģ������ʹ�õĶ���
	private Department department = new Department();
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

}
