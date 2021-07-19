package controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.NoticeCommand;
import service.notice.NoticeDeleteService;
import service.notice.NoticeDetailService;
import service.notice.NoticeListService;
import service.notice.NoticeModifyService;
import service.notice.NoticeWriteService;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	NoticeWriteService noticeWriteService;
	@Autowired
	NoticeListService noticeListService;
	@Autowired
	NoticeDetailService noticeDetailService;
	@Autowired
	NoticeModifyService noticeModifyService;
	@Autowired
	NoticeDeleteService noticeDeleteService;
	@RequestMapping("noticeDel")
	public String noticeDel(
			@RequestParam(value = "noticeNo") String noticeNo) {
		noticeDeleteService.noticeDel(noticeNo);
		return "redirect:noticeList";
	}
	@RequestMapping(value="noticeModify",method = RequestMethod.POST)
	public String noticeModify(
			NoticeCommand noticeCommand) {
		noticeModifyService.noticeModify(noticeCommand);
		return "redirect:noticeList";
	}
	@RequestMapping("noticeUpdate")
	public String noticeUpdate(
			@RequestParam(value="noticeNo")String noticeNo,
			Model model) {
		noticeDetailService.noticeDetail(noticeNo, model);
		return "notice/noticeModify";
	}
	@RequestMapping("noticeDetail")
	public String noticeDetail(
			@RequestParam(value="noticeNo")String noticeNo,
			Model model) {
		noticeDetailService.noticeDetail(noticeNo, model);
		return "notice/noticeView";
	}
	@RequestMapping("noticeList")
	public String noticeList(Model model) {
		noticeListService.noticeList(model);
		return "notice/noticeList";
	}
	@RequestMapping("noticeForm")
	public String noticeForm() {
		return "notice/noticeForm";
	}
	@RequestMapping("noticeWrite")
	public String noticeWrite(NoticeCommand noticeCommand,
			HttpSession session) {
		noticeWriteService.noticeWrite(session, noticeCommand);
		return "redirect:noticeList";
	}
}
