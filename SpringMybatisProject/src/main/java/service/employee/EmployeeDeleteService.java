package service.employee;

import org.springframework.beans.factory.annotation.Autowired;

import repository.EmployeeRepository;

public class EmployeeDeleteService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empDelete(String empId) {
		employeeRepository.empDelete(empId);
	}
}
