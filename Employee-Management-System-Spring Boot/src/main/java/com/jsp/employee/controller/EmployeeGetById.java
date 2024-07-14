package com.jsp.employee.controller;

import com.jsp.employee.Dto.Employee;
import com.jsp.employee.Service.EmployeeService;

public class EmployeeGetById {

	public static void main(String[] args) {
		Employee employee = new Employee();
		EmployeeService employeeService = new EmployeeService();
		employeeService.getById(2);

		System.out.println(employee.getName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getContact());
	}

}
