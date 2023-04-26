package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationController {

	@Autowired
	private IEmployeeMgmtService empService;
	
	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping("/")
	public String showHome() {

		return "home";

	}

	@GetMapping("/report")
	public String showEmpReport(Map<String, Object> map) {

		Iterable<Employee> itEmps = empService.getAllEmployees();
		map.put("empsList", itEmps);
		return "show_employee_report";

	}

	@GetMapping("/emp_add")
	public String showFormForsaveEmployee(@ModelAttribute("emp") Employee emp) {

		System.out.println(emp);
		return "register_employee";

	}
	/*	@PostMapping("/emp_add")
		public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
			
			String msg=empService.registerEmployee(emp);
			Iterable<Employee> itEmps=empService.getAllEmployees();
			
			map.put("resultMsg",msg);
			map.put("empsList", itEmps);
			
			return "show_employee_report";
			
		}*/

	/*	@PostMapping("/emp_add")
		public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
			
			String msg=empService.registerEmployee(emp);
			//Iterable<Employee> itEmps=empService.getAllEmployees();
			
			map.put("resultMsg",msg);
			//map.put("empsList", itEmps);
			
			//return "show_employee_report";
			return "redirect:report";
			
			
		}*/
	
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes atts,BindingResult errors) {

		  if(emp.getVflag().equalsIgnoreCase("no")) {
			  
		    System.out.println("server side form validation......");
		
		
		
		  if(empValidator.supports(Employee.class)) {
			  
			    empValidator.validate(emp,errors);
			    
			    
			    if(empService.isDesgInRejectetList(emp.getJob())) {
			    	
			    	errors.rejectValue("job","emp.desg.reject");
			    }



			    if(errors.hasErrors())
			    	 return "register_employee";
			  
		  }
		
		  }
		
		String msg=empService.registerEmployee(emp);
		//Iterable<Employee> itEmps=empService.getAllEmployees();
		
	atts.addFlashAttribute("resultMsg",msg);
		
		return "redirect:report";
		
		
	}

	/*	@PostMapping("/emp_add")
		public String saveEmployee(@ModelAttribute("emp") Employee emp, HttpSession ses) {
	
			String msg = empService.registerEmployee(emp);
			// Iterable<Employee> itEmps=empService.getAllEmployees();
	
			// atts.addFlashAttribute("resultMsg",msg);
	
			ses.setAttribute("resultMsg", msg);
			return "redirect:report";
	
		}*/

	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		Employee emp1 = empService.getEmployeeByNo(no);
		BeanUtils.copyProperties(emp1, emp);

		return "update_employee";

	}
	@PostMapping("/emp_edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs,BindingResult errors) {
		
		  if(empValidator.supports(Employee.class)) {
			  
			    empValidator.validate(emp,errors);
			    
			    
			    if(empService.isDesgInRejectetList(emp.getJob())) {
			    	
			    	errors.rejectValue("job","emp.desg.reject");
			    }
			    
			    
			    
			    if(errors.hasErrors()) {
			    	
			    	return "update_employee";
			    }
			  
		  }
		
		
		String msg=empService.updateEmployee(emp);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
		
		
	}
	@GetMapping("/emp_delete")
	public String editEmployee(@RequestParam int no,RedirectAttributes attrs) {
		
		String msg=empService.deleteEmployeeById(no);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
		
		
	}	
	
	

}
