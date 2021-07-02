package controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employee.EmployeeInfoService;
import service.employee.EmployeeJoinService;
import service.employee.EmployeeListService;
import service.employee.EmployeeNumService;
import validator.EmployeeCommandValidator;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeNumService employeeNumService;
	@Autowired
	EmployeeJoinService employeeJoinService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeInfoService employeeInfoService;
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value = "empId") String empId,
			Model model) {
		employeeInfoService.empInfo(empId, model);
		return "employee/employeeInfo";
	}
	@RequestMapping(value = "empList", method = RequestMethod.GET)
	public String empList(Model model) {
		employeeListService.empList(model);
		return "employee/employeeList";
	}
	@RequestMapping(value = "empRegist", method = RequestMethod.GET)
	public String empRegist(Model model , 
			EmployeeCommand employeeCommand) {
		employeeNumService.empNo(model, employeeCommand);
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
		employeeJoinService.empInsert(employeeCommand);
		return "redirect:empList";
	}
}
