package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.CartDTO;
import repository.GoodsRepository;

public class GoodsCartAddService {
	@Autowired
	GoodsRepository goodsRepository; 
	public void cartAdd(int cartQty, String prodNum, int prodPrice
			,HttpSession session, Model model) {
		CartDTO dto = new CartDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		dto.setCartQty(cartQty);
		dto.setProdNum(prodNum);
		dto.setCartPrice(prodPrice * cartQty);
		int i = goodsRepository.cartAdd(dto);
		model.addAttribute("num", i);
	}
}
