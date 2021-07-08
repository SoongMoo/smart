package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.GoodsCommand;
import service.goods.GoodsListService;
import service.goods.GoodsNumberService;
import service.goods.GoodsWriteService;
import validator.GoodsCommandValidate;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsNumberService goodsNumberService;
	@Autowired
	GoodsWriteService goodsWriteService;
	@RequestMapping(value="goodsJoin", method = RequestMethod.POST)
	public String join(GoodsCommand goodsCommand,Errors errors,
			HttpSession session) {
		new GoodsCommandValidate().validate(goodsCommand, errors);
		if(errors.hasErrors()) {
			return "goods/goodsJoin";
		}
		goodsWriteService.goodsWrite(goodsCommand,session);
		return "redirect:goodsList";
	}
	@Autowired
	GoodsListService goodsListService;
	@RequestMapping("goodsList")
	public String list(Model model) {
		goodsListService.goodsList(model);
		return "goods/goodsList";
	}
	@RequestMapping("goodsRegist")
	public String regist(Model model) {
		/// Model : 자바에서 만들러진 값을 jsp에 전달하기 위해서 사용
		goodsNumberService.goodsNum(model);
		return "goods/goodsJoin";
	}
}