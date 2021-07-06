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
@RequestMapping("login")
public class LogInController {
	@RequestMapping(method = RequestMethod.GET)
	public String main() {
		return "redirect:/";
	}
	@Autowired
	LoginService loginService; 
	@RequestMapping(method = RequestMethod.POST)
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
	@RequestMapping("logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
