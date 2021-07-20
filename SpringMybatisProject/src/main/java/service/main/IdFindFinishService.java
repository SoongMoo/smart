package service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.MemberDTO;
import command.MemberCommand;
import repository.MemberRepository;

public class IdFindFinishService {
	@Autowired
	MemberRepository memberRepository;
	public void idFind(MemberCommand memberCommand, 
			Model model) {
		MemberDTO dto = new MemberDTO();
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemName(memberCommand.getMemName());
		String memId = memberRepository.idFind(dto);
		model.addAttribute("memId", memId);
	}
}
