package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsOrderCommand;
import service.goods.DoPaymentService;
import service.goods.GoodsBuyService;
import service.goods.GoodsCartAddService;
import service.goods.GoodsCartListService;
import service.goods.GoodsCartQtyDownService;
import service.goods.GoodsOrderService;
import service.goods.OrderProcessListService;

@Controller
@RequestMapping("cart")
public class GoodsCartController {
	@Autowired
	GoodsCartAddService goodsCartAddService;
	@Autowired
	GoodsCartListService goodsCartListService;
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@Autowired
	GoodsBuyService goodsBuyService;
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	OrderProcessListService orderProcessListService;
	@Autowired
	DoPaymentService doPaymentService;
	@RequestMapping(value="doPayment",  method = RequestMethod.POST)
	public String doPayment(
			@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value = "paymentApprPrice") String paymentApprPrice,
			@RequestParam(value = "paymentNumber") String paymentNumber,
			HttpSession session,Model model) {
		doPaymentService.payment(purchaseNum,paymentApprPrice,
				paymentNumber, session, model);
		return "goods/buyfinished";
	}
	
	
	@RequestMapping("OrderProcessList")
	public String purchaseCon(HttpSession session, Model model) {
		orderProcessListService.orderList(session, model);
		return "goods/purchaseCon";
	}
	@RequestMapping("goodsOrder")
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand,
			HttpSession session) {
		// GoodsOrderCommand가 가지고 있는 값을 구매 테이블에 전달 
		String purchaseNum = 
				goodsOrderService.goodsOrder(goodsOrderCommand, session);
		return "redirect:paymentOk?purchNo="+purchaseNum 
						+"&payPrice="+goodsOrderCommand.getPurchaseTotPrice();
	}
	@RequestMapping("paymentOk")
	public String paymentOk(
			@ModelAttribute(value="purchNo") String purchNo,
			@ModelAttribute(value="payPrice") String payPrice) {
		return "goods/payment";
	}
	@RequestMapping(value = "goodsBuy" , method = RequestMethod.POST)
	public String goodsBuy(
			@RequestParam(value="prodCk") String [] prodNums,
			HttpSession session, Model model) {
		goodsBuyService.goodsBuy(prodNums, session, model);
		return "goods/order";
	}
	@RequestMapping(value="goodsCartQtyDown" , method = RequestMethod.GET)
	public String goodsCartQtyDown(
			@RequestParam(value="prodNum") String prodNum,
			@RequestParam(value = "prodPrice") int prodPrice,
			HttpSession session) {
		goodsCartQtyDownService.goodsQtyDown(prodNum, prodPrice, session);
		return "redirect:goodsCartList";
	}
	@RequestMapping("goodsCartList")
	public String goodsCartList(HttpSession session, Model model) {
		goodsCartListService.cartList(session, model);
		return "goods/goodsCart";
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
