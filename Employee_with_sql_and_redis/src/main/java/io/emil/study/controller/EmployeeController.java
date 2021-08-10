package io.emil.study.controller;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.emil.study.response.entity.ErrorResponse;
import io.emil.study.response.entity.ErrorTokenResponse;
import io.emil.study.response.entity.ListResponse;
import io.emil.study.response.entity.Response;
import io.emil.study.response.entity.TokenResponse;
import io.emil.study.dto.EmployeeDto;
import io.emil.study.dto.SessionDto.SessionDtoBuilder;
import io.emil.study.entity.Employee;
import io.emil.study.entity.Session;
import io.emil.study.entity.Session.SessionBuilder;
import io.emil.study.entity.Token;
import io.emil.study.mapping.EmployeeMapping;
import io.emil.study.mapping.SessionMapping;
import io.emil.study.service.EmployeeService;
import io.emil.study.service.SessionService;

@RestController
@RequestMapping("/f1/api")
@EnableScheduling
public class EmployeeController 
{

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SessionService sessionService;
	
	ErrorResponse error=new ErrorResponse();
	Response response=new Response();
	ListResponse response_get=new ListResponse();
	TokenResponse tresponse=new TokenResponse();
	ErrorTokenResponse eresponse=new ErrorTokenResponse();
	@PostMapping("/create")
	public ResponseEntity saveData(@RequestBody @Valid  EmployeeDto employee,HttpServletRequest request)  
	{
		Employee employee1;
	try
	{
			employee1= employeeService.saveData(EmployeeMapping.dTODto(employee));
	}
	catch(Exception e)
	{
		error.setError_message(e.getMessage());
		error.setStatus_code((long) 0);
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	EmployeeDto responseData=EmployeeMapping.doToDto(employee1);
	response.setStatus_code((long)1);
	response.setMessage("Employee added successfully");
	response.setData(responseData);
	return new ResponseEntity(response,HttpStatus.CREATED);
	
	
	}
	
	@GetMapping("/get")
	public ResponseEntity getData(HttpServletRequest request)  
	{
		List<Employee> employee;
	try
	{
			employee= employeeService.getData();
	}
	catch(Exception e)
	{
		error.setError_message(e.getMessage());
		error.setStatus_code((long) 0);
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	List<EmployeeDto> responseData=EmployeeMapping.doToDTOList(employee);
	response_get.setStatus_code((long)1);
	response_get.setMessage("Query Run Successfully");
	response_get.setData(responseData);
	return new ResponseEntity(response_get,HttpStatus.CREATED);
	
	}
	
	@PutMapping("/update")
	public ResponseEntity updateData(@RequestBody @Valid Employee employee,HttpServletRequest request)  
	{
	Employee employee1;
	try
	{
			employee1= employeeService.updateData(employee);
	}
	catch(Exception e)
	{
		error.setError_message(e.getMessage());
		error.setStatus_code((long) 0);
		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	EmployeeDto responseData=EmployeeMapping.doToDto(employee1);
	response.setStatus_code((long)1);
	response.setMessage("Updated Successfully");
	response.setData(responseData);
	return new ResponseEntity(response,HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteTopic(@PathVariable  Long id) {
		Optional<Employee> employee;
		try
		{
			employee=employeeService.deleteEmployee(id);
		}
		catch(Exception e)
		{
			error.setError_message(e.getMessage());
			error.setStatus_code((long) 0);
			return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
		}
		response.setStatus_code((long)1);
		response.setMessage("Deleted Successfully");
		response.setData(employee);
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity getLogin(@RequestBody Employee employee,HttpServletRequest request)  
	{
		
		Employee employee1;
	try
	{
			employee1= employeeService.getLogin(employee);
	}
	catch(Exception e)
	{
		error.setError_message(e.getMessage());
		error.setStatus_code((long) 0);
		return new ResponseEntity(error,HttpStatus.NOT_ACCEPTABLE);
	}
	EmployeeDto responseData=EmployeeMapping.doToDto(employee1);
	Session session;
	try
	{
		session=sessionService.checkActiveSession(employee1.getId());
	}
	catch(Exception e)
	{
		error.setError_message(e.toString());
		error.setStatus_code((long) 0);
		return new ResponseEntity(error,HttpStatus.NOT_ACCEPTABLE);
	}
	if(session==null) {
		response.setStatus_code((long)1);
		response.setMessage("Login Successfull : Token Generated");
		response.setData(responseData);
		String a=employeeService.generateRandomString();
		response.setAccess_token(a);
		LocalDateTime b=LocalDateTime.now();
		response.setLogin_time(b);
		LocalDateTime c=response.getLogin_time().plusHours(2);
		response.setToken_expiry(c);
		SessionBuilder sessionBuilder=new SessionBuilder();
		sessionBuilder.setEid(employee1.getId());
		sessionBuilder.setToken(a);
		sessionBuilder.setLogin_time(b);
		sessionBuilder.setToken_expiry(c);
		try {
			sessionService.saveData(sessionBuilder.build());
		}
		catch(Exception e)
		{
			error.setError_message(e.getMessage());
			error.setStatus_code((long) 0);
			return new ResponseEntity(error,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	else if(session.getToken_expiry().isAfter(LocalDateTime.now())){
		response.setStatus_code((long)1);
		response.setMessage("Login Successfull with existing token");
		response.setData(responseData);
		String a=session.getToken();
		response.setAccess_token(a);
		LocalDateTime b=LocalDateTime.now();
		response.setLogin_time(b);
		LocalDateTime c=session.getToken_expiry();
		response.setToken_expiry(c);
		SessionBuilder sessionBuilder=new SessionBuilder();
		sessionBuilder.setEid(employee1.getId());
		sessionBuilder.setToken(a);
		sessionBuilder.setLogin_time(b);
		sessionBuilder.setToken_expiry(c);
	}
	else {
		response.setStatus_code((long)1);
		response.setMessage("Login Successfull : New Token Generated");
		response.setData(responseData);
		String a=employeeService.generateRandomString();
		response.setAccess_token(a);
		LocalDateTime b=LocalDateTime.now();
		response.setLogin_time(b);
		LocalDateTime c=response.getLogin_time().plusHours(2);
		response.setToken_expiry(c);
		SessionBuilder sessionBuilder=new SessionBuilder();
		sessionBuilder.setEid(employee1.getId());
		sessionBuilder.setToken(a);
		sessionBuilder.setLogin_time(b);
		sessionBuilder.setToken_expiry(c);
		try {
			sessionService.saveData(sessionBuilder.build());
			sessionService.deleteSession(session.getSession_id());
		}
		catch(Exception e)
		{
			error.setError_message(e.getMessage());
			error.setStatus_code((long) 0);
			return new ResponseEntity(error,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	return new ResponseEntity(response,HttpStatus.OK);
	
	}
	
	@GetMapping("/validateToken")
	public ResponseEntity validateToken(@RequestBody Token token) {
		Session session;
		
		try {session=sessionService.checkActiveToken(token);
			if(session!=null) {
				tresponse.setValid("Yes");
			}
			else {
			tresponse.setValid("No");
			}
		}
		catch(Exception e) {
			eresponse.setError(e.getMessage());
			return new ResponseEntity(eresponse,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(tresponse,HttpStatus.OK);
	}
	
}
