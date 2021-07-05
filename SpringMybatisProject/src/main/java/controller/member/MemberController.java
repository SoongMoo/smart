package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberJoinService;

@Controller
@RequestMapping("register")
public class MemberController {
	@RequestMapping("agree")
	public String agree() {
		return "member/agree";
	}
	@RequestMapping(value="memRegist", method = RequestMethod.POST)
	public String  memRegist(
			@RequestParam(value="agree", defaultValue = "false")
			Boolean agree,Model model) {
		if(!agree) { 
			model.addAttribute("err", "동의에 체크해주세요.");
			return "member/agree";
		}
		return "member/memberForm";
	}
	@Autowired
	MemberJoinService memberJoinService;
	@RequestMapping(value="memJoin",method = RequestMethod.POST )
	public String memJoin(MemberCommand memberCommand) {
		memberJoinService.memJoin(memberCommand);
		return "redirect:/";
	}
	
}
