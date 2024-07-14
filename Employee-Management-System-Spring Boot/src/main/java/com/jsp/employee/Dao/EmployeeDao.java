package com.jsp.employee.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.employee.Dto.Employee;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nashra");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

// TO INSERT DETAILS
	public Employee saveEmployee(Employee employee) {

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}

//TO DELETE BY ID
	public Employee deleteEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		return employee;
	}

//To UPDATE DETAILS
	public Employee updateEmployee(Employee employee1, int id) {

		entityTransaction.begin();
		Employee employee = entityManager.find(Employee.class, id);
		if (employee != null) {
			employee.setName(employee1.getName());
			employee.setEmail(employee1.getEmail());
			employee.setContact(employee1.getContact());
			;
		}
		entityTransaction.commit();

		return employee;
	}

//TO GET DETAILS BY ID
	public Employee getById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

//TO GET ALL EMPLOYEE DETAILS
	public List<Employee> getAllEmployee() {
		String sql = "SELECT e FROM Employee e";
		Query query = entityManager.createQuery(sql);
		List<Employee> employee = query.getResultList();
		return employee;
	}
}
