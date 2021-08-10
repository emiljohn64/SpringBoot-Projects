package io.emil.study.service;


import java.util.List;
import java.util.Optional;

import io.emil.study.entity.Employee;

public interface EmployeeService {

	public Employee saveData(Employee data) throws Exception;
	public List<Employee> getData() throws Exception;
	public Employee updateData(Employee employee) throws Exception;
	public Optional<Employee> deleteEmployee(Long id) throws Exception;
	public Employee getLogin(Employee data)throws Exception;
	public String generateRandomString();

}