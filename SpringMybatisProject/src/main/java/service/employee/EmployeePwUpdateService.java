package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

public class EmployeePwUpdateService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void empPwUpdate(String empPw, Errors errors) {
		
	}
}
