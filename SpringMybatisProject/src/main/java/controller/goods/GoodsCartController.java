package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.goods.GoodsCartAddService;
import service.goods.GoodsCartListService;
import service.goods.GoodsCartQtyDownService;

@Controller
@RequestMapping("cart")
public class GoodsCartController {
	@Autowired
	GoodsCartAddService goodsCartAddService;
	@Autowired
	GoodsCartListService goodsCartListService;
	@RequestMapping("goodsCartList")
	public String goodsCartList(HttpSession session, Model model) {
		goodsCartListService.cartList(session, model);
		return "goods/goodsCart";
	}
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@RequestMapping(value="goodsCartQtyDown" , method = RequestMethod.GET)
	public String goodsCartQtyDown(
			@RequestParam(value="prodNum") String prodNum,
			@RequestParam(value = "prodPrice") int prodPrice,
			HttpSession session) {
		goodsCartQtyDownService.goodsQtyDown(prodNum, prodPrice, session);
		return "redirect:goodsCartList";
	}
	@RequestMapping(value = "goodsCartAdd", method = RequestMethod.GET)
	public String goodsCartQtyAdd(
			@RequestParam(value="cartQty") int cartQty,
			@RequestParam(value="prodNum") String prodNum,
			@RequestParam(value="prodPrice") int prodPrice,
			Model model,HttpSession session) {
		goodsCartAddService.cartAdd(cartQty, prodNum,prodPrice,session,model);
		return "redirect:goodsCartList";
	}
	@RequestMapping(value = "goodsCartAdd" ,method = RequestMethod.POST)
	public String goodsCartAdd(
			@RequestParam(value="cartQty") int cartQty,
			@RequestParam(value="prodNum") String prodNum,
			@RequestParam(value="prodPrice") int prodPrice,
			Model model,HttpSession session) {
		goodsCartAddService.cartAdd(cartQty, prodNum,prodPrice,session,model);
		return "goods/cartAdd";
	}
}
