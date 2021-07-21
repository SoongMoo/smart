package service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.MemberDTO;
import Model.StartEndPageDTO;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	public void memList(Model model,String memId, Integer page) {
		int limit = 5;
		int limitPage = 10;
		//                      2  - 1
		Long startRow = ((long)page -1 ) * limit +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO sep = new StartEndPageDTO();
		sep.setStartRow(startRow);
		sep.setEndRow(endRow);
		
		MemberDTO dto = new MemberDTO();
		dto.setStartEndPageDTO(sep);
		dto.setMemId(memId);
		
		
		List<MemberDTO> list = memberRepository.memList(dto);
		Integer count = memberRepository.getMemberCount();
		model.addAttribute("lists", list);
		model.addAttribute("count", count);
		
		int maxPage = (int)((double) count / limit + 0.99);
				//        1    /  10  = 0.1 + 0.9
		        //        2    / 10   = 0.2 + 0.9 = 1
		        //        11   / 10 = 1.1 + 0.9 = 2
		int startPage = (int)((double) page / limitPage + 0.99); 
		int endPage = startPage + limitPage - 1;
		if(endPage > maxPage)endPage = maxPage;
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		
		/* 총페이지 수 */
		
		
		
		
		
	}
}
