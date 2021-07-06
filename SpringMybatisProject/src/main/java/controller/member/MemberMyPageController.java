package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.member.MemberInfoService;

@Controller
@RequestMapping("edit")
public class MemberMyPageController {
	@Autowired
	MemberInfoService memberInfoService;
	@RequestMapping("myPage")
	public String myPage() {
		return "member/memMyPage";
	}
	@RequestMapping("memDetail")
	public String memDetail(HttpSession session,Model model) {
		memberInfoService.memInfo(model, session);
		return "member/memDetail";
	}
	
	
	
	
}