package controller.library;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.LibraryCommand;
import service.library.LibraryInfoService;
import service.library.LibraryListService;
import service.library.LibraryService;

@Controller
@RequestMapping("lib")
public class LibraryController {
	@Autowired
	LibraryListService libraryListService;
	@Autowired
	LibraryInfoService libraryInfoService;
	@RequestMapping(value = "libModify", method = RequestMethod.POST)
	public String libModify(LibraryCommand libraryCommand) {
		
		return "redirect:libraryInfo?noticeNo="
				+libraryCommand.getNoticeNo();
	}
	@RequestMapping("libDetail")
	public String libDetail(
			@RequestParam(value="noticeNo") String noticeNo,
			Model model) {
		libraryInfoService.libraryInfo(model, noticeNo);
		return "library/libModify";
	}
	@RequestMapping("libraryInfo")
	public String libraryInfo(
			@RequestParam(value="noticeNo") String noticeNo,
			Model model) {
		libraryInfoService.libraryInfo(model, noticeNo);
		return "library/libInfo";
	}
	@RequestMapping("libBoard")
	public String libList(Model model) {
		libraryListService.libList(model);
		return "library/libList";
	}
	@RequestMapping("libRegist")
	public String libRegist() {
		return "library/libForm";
	}
	@Autowired
	LibraryService libraryService;
	@RequestMapping(value="libwrite", method = RequestMethod.POST)
	public String libwrite(LibraryCommand libraryCommand,
			HttpSession session) {
		libraryService.libWrite(libraryCommand, session);
		return "redirect:libBoard";	
	}
}
