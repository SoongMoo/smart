package controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import command.LogInCommand;
import service.goods.GoodsListService;

@Controller
public class MainController {
	@Autowired
	GoodsListService goodsListService;
	@RequestMapping("main")
	public String aaa(
			@ModelAttribute LogInCommand logInCommand,
			Model model) {
		goodsListService.goodsList(model);
		return "main/main";
	}
}