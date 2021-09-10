package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.AuthInfoDTO;
import Model.CartDTO;
import service.repository.GoodsRepository;
@Service
public class GoodsCartQtyDownService {
	@Autowired
	GoodsRepository goodsRepository; 
	public void goodsQtyDown(String prodNum, int prodPrice,
			HttpSession session) {
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		CartDTO dto = new CartDTO();
		dto.setProdNum(prodNum);
		dto.setCartPrice(prodPrice);
		dto.setMemId(memId);
		
		goodsRepository.goodsQtyDown(dto);
	}
}
