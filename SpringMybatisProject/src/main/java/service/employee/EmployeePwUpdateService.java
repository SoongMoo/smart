package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import service.repository.EmployeeRepository;
@Service
public class EmployeePwUpdateService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public int empPwUpdate(String empPw, Model model, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		EmployeeDTO dto = employeeRepository.empDetail(authInfo.getUserId());
		if(!bcryptPasswordEncoder.matches(empPw, dto.getEmpPw())) {
			model.addAttribute("errPw", "비밀번호가 틀렸습니다.");
			return 1;
		}
		return 0;
	}
}
