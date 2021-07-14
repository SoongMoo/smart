package controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.goods.GoodsDetailService;

@Controller
@RequestMapping("prod")
public class GoodsViewController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@RequestMapping("goodsView")
	public String goodsView(
			@RequestParam(value="prodNum") String prodNum,
			Model model) {
		goodsDetailService.goodsDetail(prodNum, model);
		return "goods/goodsView";
	}
}
