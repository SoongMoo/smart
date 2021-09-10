package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import command.EmployeeCommand;
import service.repository.EmployeeRepository;
@Service
public class EmployeePwModifyService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void pwUpdateOk(EmployeeCommand employeeCommand,
			Errors errors, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		EmployeeDTO dto = employeeRepository.empDetail(authInfo.getUserId());
		if(!bcryptPasswordEncoder.matches(employeeCommand.getOldPw(), 
				dto.getEmpPw())) {
			errors.rejectValue("oldPw", "notPw");
		}else {
			if(employeeCommand.isEmpPwEqualsEmpPwCon()) {
				dto.setEmpPw(
						bcryptPasswordEncoder.encode(employeeCommand.getEmpPw()));
				dto.setEmpUserId(authInfo.getUserId());
				employeeRepository.pwUpdate(dto);
			}else {
				errors.rejectValue("empPwCon", "nomatch");
			}
		}
	}
}
