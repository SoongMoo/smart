package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.MemberDTO;
import repository.MemberRepository;

public class MemberPwConfirmService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MemberRepository memberRepository; 
	public String memPw(String memPw,HttpSession session,Model model) {
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		MemberDTO dto = memberRepository.memInfo(authInfo.getUserId());
		if(bcryptPasswordEncoder.matches(memPw,dto.getMemPw())) {
			return "member/pwChangeOk";
		}else {
			model.addAttribute("pwFail1", "비밀번호가 틀립니다");
			return "member/pwChang";
		}
	}
}
