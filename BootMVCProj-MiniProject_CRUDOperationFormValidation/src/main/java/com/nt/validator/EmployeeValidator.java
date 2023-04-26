package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;


@Component
public class EmployeeValidator implements Validator {
	
	
	
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Employee.class);
	}

	
	public void validate(Object target, Errors errors) {
	
		Employee emp=(Employee)target;
		
		if(!errors.hasFieldErrors("sal")) {
			
			if(emp.getSal()==null)
				errors.rejectValue("sal","emp.salary.required");
			else if(emp.getSal()<1000.0||emp.getSal()>200000.0)
				errors.rejectValue("sal","emp.salary.range");
				
			
		}
		
		
		
		
		if(emp.getEname()==null||emp.getEname().isBlank())
			errors.rejectValue("ename","emp.name.required");
		
		else if(emp.getEname().length()<5||emp.getEname().length()>=15)
			errors.rejectValue("ename","emp.name.length");
		
		if(emp.getJob()==null||emp.getJob().isBlank())
			errors.rejectValue("job","emp.job.required");
		
		else if(emp.getJob().length()<5||emp.getJob().length()>=10)
			errors.rejectValue("job","emp.job.length");
		
		
		if(emp.getSal()==null)
			errors.rejectValue("sal","emp.salary.required");
		
		else if(emp.getSal()<1000.0||emp.getSal()>200000.0)
			errors.rejectValue("sal","emp.salary.range");
		
		if(emp.getDeptno()==null)
			errors.rejectValue("deptno","emp.deptno.required");

	}

}
