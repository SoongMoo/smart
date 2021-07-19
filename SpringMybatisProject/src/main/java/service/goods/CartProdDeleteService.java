package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.CartDTO;
import repository.GoodsRepository;

public class CartProdDeleteService {
	@Autowired
	GoodsRepository goodsRepository; 
	public void cartProdDel(String prodNum, HttpSession session) {
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		String memId= authInfo.getUserId();
		CartDTO dto = new CartDTO();
		dto.setProdNum(prodNum);
		dto.setMemId(memId);
		goodsRepository.cartProdDel(dto);
	}
}
