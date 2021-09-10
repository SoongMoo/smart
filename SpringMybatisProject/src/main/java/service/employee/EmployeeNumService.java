package service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import command.EmployeeCommand;
import service.repository.EmployeeRepository;
@Service
public class EmployeeNumService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empNo(Model model, EmployeeCommand employeeCommand) {
		String empNo = employeeRepository.empNo();
		employeeCommand.setEmployeeId(empNo);
		model.addAttribute("employeeCommand", employeeCommand);
		model.addAttribute("empNo", empNo);
	}
}
