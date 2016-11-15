package com.panlei.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.panlei.employee.domain.Employee;
import com.panlei.employee.service.EmployeeService;

/**
 * Ա�������Action��
 * ����ģ����������ҳ��Ĳ���
 * Ȼ�����service��
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//�����employee��ֱ�ӱ�ҳ�洫������ֵ��ֵ
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//ע��ҵ�����
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * ��½ִ�еķ���
	 */
	public String login() {
		System.out.println("loginִ����...");
		//����ҵ������
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null) {
			//��½ʧ��
			this.addActionError("�û������������");
			return INPUT;
		} else{
			//��½�ɹ��ͽ��û���Ϣ����session����
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	
}
