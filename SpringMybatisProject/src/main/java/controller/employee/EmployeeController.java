package controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeeCommand;
import service.employee.EmployeeNumService;
import validator.EmployeeCommandValidator;

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
		model.addAttribute("employeeCommand", new EmployeeCommand());
		return "employee/employeeForm";
	}
	@RequestMapping(value="empJoin",method = RequestMethod.POST )
	public String empJoin(EmployeeCommand employeeCommand,Errors errors,
			Model model) {
		/// cammand 객체는 html로 부터 넘어온 값을 저장한다.
		/// 그러므로 @RequestParam을 사용 안해도 된다.
		new EmployeeCommandValidator().validate(employeeCommand, errors);
		if(errors.hasErrors()) {
			return "employee/employeeForm";
		}
		return "redirect:empList";
	}
}
