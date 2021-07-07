package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberInfoService;
import service.member.MemberModifyService;
import service.member.MemberOutService;
import service.member.MemberPwConfirmService;
import service.member.MemberPwUpdateService;
import validator.MemberPasswordValidator;

@Controller
@RequestMapping("edit")
public class MemberMyPageController {
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberPwConfirmService memberPwConfirmService;
	@Autowired
	MemberPwUpdateService memberPwUpdateService;
	@Autowired
	MemberOutService memberOutService;
	@RequestMapping("memOut")
	public String memOut(){
		return "member/outPw";
	}
	@RequestMapping("memOutOk")
	public String memOutOk(
			@RequestParam(value="memPw") String memPw,
			HttpSession session, Model model){
		String path = memberOutService.memDelete(memPw, session, model);
		return path;
	}
	@RequestMapping("changePw")
	public String changePw(MemberCommand memberCommand,
			Errors errors,HttpSession session) {
		new MemberPasswordValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/pwChangeOk";
		}
		memberPwUpdateService.memPwUpdate(memberCommand,errors,
				session);
		if(errors.hasErrors()) {
			return "member/pwChangeOk";
		}
		return "redirect:/";
	}
	@RequestMapping("pwChangeOk")
	public String pwChangeOk(
			@RequestParam(value = "memPw") String memPw,
			HttpSession session,Model model,
			@ModelAttribute MemberCommand memberCommand) {
		String path = memberPwConfirmService.memPw(memPw,session,model);
		return path ;
	}
	@RequestMapping("memPwChange")
	public String memPwChange() {
		return "member/pwChang";
	}
	@RequestMapping(value="memSujungOk", method = RequestMethod.POST)
	public String memUpdate(MemberCommand memberCommand,
			Errors errors, HttpSession session) {
		memberModifyService.memUpdate(session,memberCommand,errors);
		if(errors.hasErrors()) {
			return "member/memSujung";
		}
		return "redirect:memDetail";
	}
	
	@RequestMapping("myPage")
	public String myPage() {
		return "member/memMyPage";
	}
	@RequestMapping("memDetail")
	public String aaaaa(HttpSession session,Model model) {
		memberInfoService.memInfo(model, session);
		return "member/memDetail";
	}
	@RequestMapping("memSujung")
	public String memSujung(HttpSession session,Model model,
			@ModelAttribute MemberCommand memberCommand) {
		memberInfoService.memInfo(model, session);
		return "member/memSujung";
	}
}