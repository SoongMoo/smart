package service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.MemberDTO;
import Model.StartEndPageDTO;
import controller.PageAction;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void memList(Model model,String memId, Integer page) {
		MemberDTO dto = new MemberDTO();
		int limit = 5;
		int limitPage = 10;
		//                      2  - 1
		Long startRow = ((long)page -1 ) * limit +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO sep = new StartEndPageDTO();
		sep.setStartRow(startRow);
		sep.setEndRow(endRow);
		dto.setStartEndPageDTO(sep);
		dto.setMemId(memId);
		List<MemberDTO> list = memberRepository.memList(dto);
		Integer count = memberRepository.getMemberCount();
		model.addAttribute("lists", list);
		model.addAttribute("count", count);
		PageAction pageAction = new PageAction();
		pageAction.page(count, limit, page, limitPage, model, 
					"memList");
	}
}
