package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import command.EmployeeCommand;
import repository.EmployeeRepository;

public class EmployeeInfoUpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder ;
	public void empUpdate(EmployeeCommand employeeCommand,Errors errors,
			HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo"); 
		EmployeeDTO dto = employeeRepository.empDetail(authInfo.getUserId());
		if(bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(), dto.getEmpPw())) {
			dto = new EmployeeDTO();
			dto.setEmail(employeeCommand.getEmail());
			dto.setEmpAddress(employeeCommand.getEmpAddress());
			dto.setEmpName(employeeCommand.getEmpName());
			dto.setOfficeNumber(employeeCommand.getOfficeNumber());
			dto.setPhNumber(employeeCommand.getPhNumber());
			dto.setEmpUserId(authInfo.getUserId());
			employeeRepository.empModify(dto);
		}else {
			errors.rejectValue("empPw", "notPw");
		}
	}
}
