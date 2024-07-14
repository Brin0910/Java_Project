package com.jsp.employee.controller;

import com.jsp.employee.Dto.Employee;
import com.jsp.employee.Service.EmployeeService;

public class EmployeeUpdate {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("Nashra");
		employee.setEmail("nashra@gmail.com");
		employee.setContact(773885);

		EmployeeService employeeService = new EmployeeService();
		employeeService.updateEmployee(employee, 1);

	}

}
