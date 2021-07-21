package service.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import command.LogInCommand;
import repository.LogInRepository;

public class LoginService {
	@Autowired
	LogInRepository logInRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void logIn1(LogInCommand logInCommand, Errors errors,
			HttpSession session, HttpServletResponse response) {
		String userId = logInCommand.getUserId();
		AuthInfoDTO authInfo = logInRepository.logIn(userId);
		if(authInfo == null) {
			errors.rejectValue("userId", "notId");
		}else {
			if(bcryptPasswordEncoder.matches(
					logInCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo);
				if(logInCommand.getAutoLogin() != null) {
					Cookie cookie = 
							new Cookie("autoLogin", authInfo.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				if(logInCommand.getIdStore() != null) {
					Cookie cookie = 
							new Cookie("idStore", authInfo.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}else {
					Cookie cookie = 
							new Cookie("idStore", "");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}else {
				errors.rejectValue("userPw", "notPw");
			}
		}
	}
	public AuthInfoDTO logIn(String userId, String userPw) {
		AuthInfoDTO authInfo = logInRepository.logIn(userId); 
		return authInfo;
	}
	
}