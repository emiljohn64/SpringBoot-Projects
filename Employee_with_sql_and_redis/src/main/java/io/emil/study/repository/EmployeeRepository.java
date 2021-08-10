package io.emil.study.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.emil.study.entity.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	public Employee getByEmail(String email);
}
