package io.emil.study.dto;


import io.swagger.annotations.ApiModelProperty;

public class EmployeeDto
{
	@ApiModelProperty(hidden=true)
	private Long Id;
	
	private String name;
	private String email;
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
	
	public EmployeeDto(Long id, String name, String email, String password) {
		Id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public EmployeeDto() {
	}
	
	public EmployeeDto(EmployeeDtoBuilder builder)
	{
		Id = builder.Id;
		name = builder.name;
		email = builder.email;
		password = builder.password;
	}
	
	public static class EmployeeDtoBuilder{
		
		private Long Id;
		private String name;
		private String email;
		private String password;
		
		public EmployeeDtoBuilder setId(Long id) {
			Id = id;
			return this;
		}
		public EmployeeDtoBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public EmployeeDtoBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		public EmployeeDtoBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public EmployeeDto build() {
			
			return new EmployeeDto(this);
		}
		
	}

}
