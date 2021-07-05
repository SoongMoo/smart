package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import service.member.MemberListService;

@Controller
@RequestMapping("member")
public class MemberInfoController {
	@Autowired
	MemberListService memberListService;
	@RequestMapping("memList")
	public String memList(Model model) {
		memberListService.memList(model,null);
		return "member/memberList";
	}
	@RequestMapping("memInfo/{memId}")
	public String memInfo(
			@PathVariable(value = "memId") String memId,
			Model model) {
		memberListService.memList(model,memId);
		return "member/memberInfo";
	}
	@RequestMapping("memMod/{memId}")
	public String memMod(@PathVariable(value = "memId") String memId,
			Model model) {
		memberListService.memList(model,memId);
		return "member/memberModify";
	}
}