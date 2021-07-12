package controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeMypageController {
	@RequestMapping("mapage")
	public String mapage() {
		return null;
	}
}
