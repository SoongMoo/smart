package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/testHello")
	public String test() {
		return "hello";
	}
}
