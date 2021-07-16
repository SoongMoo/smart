package service.goods;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.OrderListDTO;
import repository.GoodsRepository;

public class OrderProcessListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void orderList(HttpSession session,Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		List<OrderListDTO> list = goodsRepository.baseOrderList(memId);
		model.addAttribute("list", list);
		
	}
}
