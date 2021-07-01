package controller.employee;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.employee.EmployeeNumService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeNumService employeeNumService;
	@RequestMapping(value = "empList", method = RequestMethod.GET)
	public String empList() {
		return "employee/employeeList";
	}
	@RequestMapping(value = "empRegist", method = RequestMethod.GET)
	public String empRegist(Model model) {
		employeeNumService.empNo(model);
		return "employee/employeeForm";
	}
	@RequestMapping(value="empJoin",method = RequestMethod.POST )
	public String empJoin(
			@RequestParam(value="employeeId") String employeeId,
			@RequestParam(value="hireDate") Date hireDate) {
		return "redirect:empList";
	}
}
