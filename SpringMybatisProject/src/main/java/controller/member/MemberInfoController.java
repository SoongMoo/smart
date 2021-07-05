package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberDeleteService;
import service.member.MemberListService;
import service.member.MemberUpdateService;

@Controller
@RequestMapping("member")
public class MemberInfoController {
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberUpdateService memberUpdateService;
	
	@Autowired
	MemberDeleteService memberDeleteService;
	@RequestMapping("memDel")
	public String memDel(
			@RequestParam(value = "memId") String memId) {
		memberDeleteService.memDel(memId);
		return "redirect:/";
	}
	@RequestMapping(value="memModifyOk", method = RequestMethod.POST)
	public String memUpdate(MemberCommand memberCommand) {
		memberUpdateService.memUpdate(memberCommand);
		return "redirect:memInfo/"+memberCommand.getMemId();
	}
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