package service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.MemberDTO;
import repository.MemberRepository;

public class MemberEmailCkService {
	@Autowired
	MemberRepository memberRepository; 
	public int emailCk(String email, String ckOk) {
		MemberDTO dto = new MemberDTO();
		dto.setMemEmail(email);
		dto.setCkOk(ckOk);
		return memberRepository.updateCkOk(dto);
	}
}
