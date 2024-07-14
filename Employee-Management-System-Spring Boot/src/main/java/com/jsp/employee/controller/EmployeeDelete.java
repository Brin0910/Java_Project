package com.jsp.employee.controller;

import com.jsp.employee.Dto.Employee;
import com.jsp.employee.Service.EmployeeService;

public class EmployeeDelete {

	public static void main(String[] args) {
		Employee employee = new Employee();

		EmployeeService employeeService = new EmployeeService();
		employeeService.deleteEmployee(6);

	}

}
