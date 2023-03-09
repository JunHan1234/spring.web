package com.my.spring.web.ch04.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.my.spring.web.ch04.domain.Employee;
import com.my.spring.web.ch04.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired private EmployeeService employeeService;
	
	//client에서 요청한 주소를 handler 가 잡아서 해당 ID값을 찾아 model에 부여한다.
	@GetMapping("ch04/employee/{employeeId}")
	public String getEmployee(@PathVariable int employeeId, Model model) {
		Employee employee = employeeService.getEmployee(employeeId);
		model.addAttribute("employee", employee);
		
		return "ch04/employee";
	}
}
