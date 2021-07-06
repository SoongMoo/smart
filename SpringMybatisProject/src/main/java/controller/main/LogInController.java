package controller.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.LogInCommand;
import service.main.LoginService;
import validator.LogInCommandValidator;

@Controller
public class LogInController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String main() {
		return "redirect:/";
	}
	@Autowired
	LoginService loginService; 
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(LogInCommand logInCommand, Errors errors,
			HttpSession session) {
		new LogInCommandValidator().validate(logInCommand, errors);
		if(errors.hasErrors()) {
			return "main/main";
		}
		loginService.logIn1(logInCommand, errors, session); 
		if(errors.hasErrors()) {
			return "main/main";
		}
		return "redirect:/";		
	}
}
