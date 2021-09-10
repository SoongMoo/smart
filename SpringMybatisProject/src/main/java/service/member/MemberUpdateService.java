package service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.MemberDTO;
import command.MemberCommand;
import service.repository.MemberRepository;
@Service
public class MemberUpdateService {
	@Autowired
	MemberRepository memberRepository; 
	public void memUpdate(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(memberCommand.getDetailAdd());
		dto.setMemAccount(memberCommand.getMemAccount());
		dto.setMemAddress(memberCommand.getMemAddress());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemEmailCk(memberCommand.getMemEmailCk());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setPostNumber(memberCommand.getPostNumber());
		dto.setMemId(memberCommand.getMemId());
		memberRepository.memUpdate(dto);
	}
}
