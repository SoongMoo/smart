package service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.MemberDTO;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void memList(Model model,String memId) {
		List<MemberDTO> list = memberRepository.memList(memId);
		model.addAttribute("lists", list);
	}
}
