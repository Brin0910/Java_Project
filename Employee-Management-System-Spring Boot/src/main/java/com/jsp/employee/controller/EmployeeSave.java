package com.jsp.employee.controller;

import com.jsp.employee.Dto.Employee;
import com.jsp.employee.Service.EmployeeService;

public class EmployeeSave {

	public static void main(String[] args) {
		Employee employee = new Employee();
		
		employee.setName("xyz");
		employee.setEmail("xyz@mail.com");
		employee.setContact(884324321);
		
		EmployeeService employeeService=new EmployeeService();
		Employee e=employeeService.saveEmployee(employee);

	}

}
