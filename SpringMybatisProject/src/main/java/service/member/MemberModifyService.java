package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.MemberDTO;
import command.MemberCommand;
import repository.MemberRepository;

public class MemberModifyService {
	@Autowired
	MemberRepository memberRepository; 
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder; 
	public void memUpdate(HttpSession session,
			MemberCommand memberCommand,Errors errors) {
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId(); 
		if(bcryptPasswordEncoder.matches(
				memberCommand.getMemPw(), authInfo.getUserPw())) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setDetailAdd(memberCommand.getDetailAdd());
			memberDTO.setMemAccount(memberCommand.getMemAccount());
			memberDTO.setMemAddress(memberCommand.getMemAddress());
			memberDTO.setMemEmail(memberCommand.getMemEmail());
			memberDTO.setMemEmailCk(memberCommand.getMemEmailCk());
			memberDTO.setMemPhone(memberCommand.getMemPhone());
			memberDTO.setPostNumber(memberCommand.getPostNumber());
			memberDTO.setMemId(memId);
			memberRepository.memUpdate(memberDTO);
		}else {
			errors.rejectValue("memPw", "notPw");
		}
	}
}
