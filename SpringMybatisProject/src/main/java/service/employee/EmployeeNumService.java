package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import repository.EmployeeRepository;

public class EmployeeNumService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empNo(Model model) {
		String empNo = employeeRepository.empNo();
		model.addAttribute("empNo", empNo);
	}
}
