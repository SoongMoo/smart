package controller.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employee.EmployeeDetailService;
import service.employee.EmployeeInfoUpdateService;
import service.employee.EmployeePwModifyService;
import service.employee.EmployeePwUpdateService;
import validator.EmployeeUpdateValidator;

@Controller
@RequestMapping("employee")
public class EmployeeMypageController {
	@Autowired
	EmployeeDetailService employeeDetailService;
	@Autowired
	EmployeeInfoUpdateService employeeInfoUpdateService;
	@Autowired
	EmployeePwUpdateService employeePwUpdateService;
	
	@Autowired
	EmployeePwModifyService employeePwModifyService;
	@RequestMapping(value="empPwUpdateOk", method = RequestMethod.POST)
	public String empPwUpdateOk(EmployeeCommand employeeCommand,
			Errors errors, HttpSession session) {
		employeePwModifyService.pwUpdateOk(employeeCommand, errors, session);
		if(errors.hasErrors()) {
			return "employee/empPwUpdate";
		}
		return "redirect:mapage";
	}
	@RequestMapping(value = "empPwUpdate", method = RequestMethod.POST)
	public String empPwUpdate(
			@RequestParam(value="empPw") String empPw, Model model,
			HttpSession session) {
		int i = employeePwUpdateService.empPwUpdate(empPw, model, session);
		if(i == 1) {
			return "employee/empPwForm";
		}else {
			return "employee/empPwUpdate";
		}
	}
	
	@RequestMapping("empPwForm")
	public String empPwForm() {
		return "employee/empPwForm";
	}
	
	@RequestMapping(value = "empUpdateOk" ,method = RequestMethod.POST)
	public String empUpdateOk(EmployeeCommand employeeCommand,
			Errors errors,HttpSession session) {
		new EmployeeUpdateValidator().validate(employeeCommand, errors);
		employeeInfoUpdateService.empUpdate(employeeCommand, errors, session);
		if(errors.hasErrors()) {
			return "employee/empUpdate";
		}
		return "redirect:empInfo";
	}
	@RequestMapping("empUpdate")
	public String empUpdate(HttpSession session,Model model) {
		employeeDetailService.empInfo(session,model);
		return "employee/empUpdate";
	}
	@RequestMapping("empInfo")
	public String empInfo(HttpSession session,Model model) {
		employeeDetailService.empInfo(session,model);
		return "employee/empDetail";
	}
	@RequestMapping("mapage")
	public String mapage() {
		return "employee/empMypage";
	}
}
