package service.member;

import org.springframework.beans.factory.annotation.Autowired;

import Model.MemberDTO;
import command.MemberCommand;
import repository.MemberRepository;

public class MemberJoinService {
	@Autowired
	MemberRepository memberRepository;
	public void memJoin(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(memberCommand.getDetailAdd());
		dto.setMemAccount(memberCommand.getMemAccount());
		dto.setMemAddress(memberCommand.getMemAddress());
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemEmailCk(memberCommand.getMemEmailCk());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemPw(memberCommand.getMemPw());
		dto.setPostNumber(memberCommand.getPostNumber());
		memberRepository.memJoin(dto);
	}
}
