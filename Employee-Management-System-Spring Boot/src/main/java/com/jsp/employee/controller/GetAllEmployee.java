package com.jsp.employee.controller;

import java.util.List;

import com.jsp.employee.Dto.Employee;
import com.jsp.employee.Service.EmployeeService;

public class GetAllEmployee {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = employeeService.getAllEmployee();

		for (Employee employee : employees) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getEmail());
			System.out.println(employee.getContact());
			System.out.println();
		}

	}

}
