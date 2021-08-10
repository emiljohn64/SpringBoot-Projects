package io.emil.study.serviceImpl;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.emil.study.entity.Employee;
import io.emil.study.repository.EmployeeRepository;
import io.emil.study.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveData(Employee data) throws Exception {
		if(employeeRepository.getByEmail(data.getEmail())!=null) {
		
			throw new Exception("Email is already present in database");
		};
		if(data.getName() == null) {
			throw new Exception("Name Is Required");
		}
		else if (data.getEmail() == null) {
			throw new Exception("Email Is Required");
		}
		else if (data.getPassword() == null)
		{
			throw new Exception("password Is Required");
		}

		else {
			try {
				return employeeRepository.save(data);
			} catch (Exception e) 
			{
				throw new Exception(e.getMessage());
			}	
		}
	}

	@Override
	public List<Employee> getData() throws Exception {
		try {
			return (List<Employee>) employeeRepository.findAll();
		} catch (Exception e) 
		{
			throw new Exception(e.getMessage());
		}	
	}

	@Override
	public Employee updateData(Employee data) throws Exception {
		
		if(data.getId() == null) {
			throw new Exception(" Name Is Required");
		}
		else if (data.getEmail() == null) {
			throw new Exception("Email Is Required");
		}
		else if (data.getPassword() == null)
		{
			throw new Exception("password Is Required");
		}

		else {
			try {
				return employeeRepository.save(data);
			} catch (Exception e) 
			{
				throw new Exception(e.getMessage());
			}	
		}
	}

	@Override
	public Optional<Employee> deleteEmployee(Long id) throws Exception {
		Optional<Employee> employee;
		if(employeeRepository.findById(id) == null) {
			throw new Exception(" Id is not found");
		}

		else {
			try {	employee=employeeRepository.findById(id);
					employeeRepository.deleteById(id);
					return employee;
			} catch (Exception e) 
			{
				throw new Exception(e.getMessage());
			}	
		}
	}

	@Override
	public Employee getLogin(Employee data) throws Exception {
		Employee emp;
		if(data.getEmail()==null) {
			throw new Exception("Email Is Required");
		}
		else if(data.getEmail()==null) {
			throw new Exception("Password Is Required");
		}
		else {
			emp=employeeRepository.getByEmail(data.getEmail());
			if(emp==null) {
				throw new Exception("User not found");
			}
			else if(!emp.getPassword().equals(data.getPassword())){
				throw new Exception("Wrong password");
			}
			else
			{
				return emp;
			}
		}
		
	}

	@Override
	public String generateRandomString() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefjhijklmnopqrstuvwxyz0123456789!@#$%^*()><=}{][";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    int length = 32;
	    for(int i = 0; i < length; i++) {
	      int index = random.nextInt(alphabet.length());
	      char randomChar = alphabet.charAt(index);
	      sb.append(randomChar);
	    }

	    return sb.toString();
	}

}
