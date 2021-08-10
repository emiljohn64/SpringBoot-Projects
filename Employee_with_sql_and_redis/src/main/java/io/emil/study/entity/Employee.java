package io.emil.study.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String password;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Employee(Long id, @NotNull String name, @NotNull String email, @NotNull String password) {
		Id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Employee() {
		
	}
	
	
	public Employee(EmployeeBuilder builder)
	{
		Id = builder.Id;
		name = builder.name;
		email = builder.email;
		password = builder.password;
	}
	public static class EmployeeBuilder{
		
		private Long Id;
		private String name;
		private String email;
		private String password;
		
		public EmployeeBuilder setId(Long id) {
			Id = id;
			return this;
		}
		public EmployeeBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public EmployeeBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		public EmployeeBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public Employee build() {
			
			return new Employee(this);
		}
		
	}
}
