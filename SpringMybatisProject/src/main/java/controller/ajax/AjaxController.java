package controller.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {
	@RequestMapping("ajaxTest")
	public String ajaxTest() {
		return "ajax/ajaxTest";
	}
	@RequestMapping("ajaxTest1")
	public String ajaxTest1(
			@ModelAttribute(value="n") String n) {
		return "ajax/divList";
	}
	@RequestMapping("ajaxTest2")
	public String ajaxTest2() {
		return "ajax/ajaxTest1";
	}
}
