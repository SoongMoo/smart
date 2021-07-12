package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsCommand;
import service.goods.GoodsDetailService;
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
	@Autowired
	GoodsDetailService goodsDetailService;
	@RequestMapping("prodDetail")
	public String prodDetail(
			@RequestParam(value = "prodNum") String prodNum,
			Model model) {
		goodsDetailService.goodsDetail(prodNum, model);
		return "goods/goodsDetail";
	}
	@RequestMapping("goodsJoin") /// IOC
	public String goodsJoin(GoodsCommand goodsCommand,
			Errors errors,HttpSession session) {
		new GoodsCommandValidate().validate(goodsCommand, errors);
		if(errors.hasErrors()) {
			return "goods/goodsJoin";
		}
		goodsWriteService.goodsInsrt(goodsCommand, session);
		return "redirect:goodsList";
	}
	
	@RequestMapping("goodsRegist") /// IOC
	public String goodsRegist(Model model) {
		goodsNumberService.goodsNum(model);
		return "goods/goodsJoin";
	}
	@Autowired
	GoodsListService goodsListService;
	@RequestMapping("goodsList")
	public String list(Model model) {
		goodsListService.goodsList(model);
		return "goods/goodsList";
	}
}