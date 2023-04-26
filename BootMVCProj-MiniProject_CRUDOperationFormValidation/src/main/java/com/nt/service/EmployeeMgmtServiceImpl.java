package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepository;


@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	

	public Iterable<Employee> getAllEmployees() {
		
		return empRepo.findAll();
		
	}
	@Override
	public String registerEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return "employee is saved with id value "+empRepo.save(emp).getEmpno();
	}
	@Override
	public Employee getEmployeeByNo(int eno) {
		
		
		      Employee emp= empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
		
		return emp;
	}
	@Override
	public String updateEmployee(Employee emp) {
		
		
		return "Employee is update with id value "+empRepo.save(emp).getEmpno();
	}
	@Override
	public String deleteEmployeeById(int eno) {
		empRepo.deleteById(eno);
		
		
		return eno+"Employee id Employee is Deleted";
	}
	
@Override
public boolean isDesgInRejectetList(String desg) {

	
	if(desg.equalsIgnoreCase("TeamLeader")){
		
		return true;
	}
	else
	   return false;
			
			
	
	
	
	
}
	
	
	
}
