package io.emil.study.mapping;

import java.util.List;
import java.util.stream.Collectors;

import io.emil.study.dto.EmployeeDto;
import io.emil.study.entity.Employee;


public class EmployeeMapping {

	public static Employee dTODto(EmployeeDto data)
	{
		Employee modelData = new Employee.EmployeeBuilder()
				.setId(data.getId())
				.setName(data.getName())
				.setEmail(data.getEmail())
				.setPassword(data.getPassword())
				.build();
				return modelData;
	}

	public static EmployeeDto doToDto(Employee data) 
	{
		EmployeeDto modelData = new EmployeeDto.EmployeeDtoBuilder()
				.setId(data.getId())
				.setName(data.getName())
				.setEmail(data.getEmail())
				.setPassword(data.getPassword())
				.build();
				return modelData;
	}

	public static List<EmployeeDto> doToDTOList(List<Employee> data)
	{
		return data.stream().map(EmployeeMapping::doToDto).collect(Collectors.toList());	
		}
}
