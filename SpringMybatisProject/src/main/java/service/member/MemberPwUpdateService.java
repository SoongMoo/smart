package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.MemberDTO;
import command.MemberCommand;
import repository.MemberRepository;

public class MemberPwUpdateService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MemberRepository memberRepository; 
	public void memPwUpdate(MemberCommand memberCommand,
			Errors errors,HttpSession session) {
		AuthInfoDTO authInfo =
				(AuthInfoDTO)session.getAttribute("authInfo");
		MemberDTO mem = memberRepository.memInfo(authInfo.getUserId());
		if(bcryptPasswordEncoder.matches(memberCommand.getOldPw(), 
				mem.getMemPw())) {
			MemberDTO dto = new MemberDTO();
			System.out.println(memberCommand.getMemPw());
			dto.setMemId(authInfo.getUserId());
			dto.setMemPw(
					bcryptPasswordEncoder.encode(
							memberCommand.getMemPw()));
			memberRepository.memPwUpdate(dto);
		}else {
			errors.rejectValue("oldPw", "notPw");
		}
	}
}
