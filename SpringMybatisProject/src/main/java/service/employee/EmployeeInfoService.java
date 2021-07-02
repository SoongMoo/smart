package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeInfoService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empInfo(String empId, Model model) {
		EmployeeDTO dto = employeeRepository.empInfo(empId);
		model.addAttribute("emp", dto);
	}
}