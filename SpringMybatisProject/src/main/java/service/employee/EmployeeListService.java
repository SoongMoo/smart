package service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeListService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empList(Model model) {
		List<EmployeeDTO> list = employeeRepository.empList();
		System.out.println(list.size());
		model.addAttribute("empList", list);
	}
}


