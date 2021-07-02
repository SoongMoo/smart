package service.main;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import repository.LogInRepository;

public class LoginService {
	@Autowired
	LogInRepository logInRepository;
	public AuthInfoDTO logIn(String userId, String userPw) {
		AuthInfoDTO authInfo = logInRepository.logIn(userId); 
		return authInfo;
	}
}