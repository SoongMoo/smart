package controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import command.LogInCommand;

@Controller
public class MainController {
	@RequestMapping("main")
	public String aaa(
			@ModelAttribute LogInCommand logInCommand) {
		return "main/main";
	}
}