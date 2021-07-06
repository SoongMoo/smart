package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;

public class MemberPwConfirmService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public String memPw(String memPw,HttpSession session,Model model) {
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		if(bcryptPasswordEncoder.matches(memPw, authInfo.getUserPw())) {
			return "member/pwChangeOk";
		}else {
			model.addAttribute("pwFail1", "비밀번호가 틀립니다");
			return "member/pwChang";
		}
	}
}
