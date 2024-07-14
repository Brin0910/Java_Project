package com.jsp.employee.Service;

import java.util.List;

import com.jsp.employee.Dao.EmployeeDao;
import com.jsp.employee.Dto.Employee;

public class EmployeeService {

	EmployeeDao employeeDao = new EmployeeDao();

	// TO INSERT DETAILS
	public Employee saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}

	// TO DELETE DETAILS
	public Employee deleteEmployee(int id) {
		return employeeDao.deleteEmployee(id);
	}

	// TO UPDATE DETAILS
	public Employee updateEmployee(Employee employee1, int id) {
		return employeeDao.updateEmployee(employee1, id);
	}

	// TO GET DETAILS BY ID
	public Employee getById(int id) {
		return employeeDao.getById(id);
	}

	// TO GET ALL EMPLOYEE DETAILS
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

}
