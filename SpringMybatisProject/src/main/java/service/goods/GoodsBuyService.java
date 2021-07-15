package service.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.CartDTO;
import Model.ProductCartDTO;
import repository.GoodsRepository;

public class GoodsBuyService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsBuy(String [] prodNums, HttpSession session,
			Model model) {
		AuthInfoDTO authInfo =
				(AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		List<ProductCartDTO> list = new ArrayList<ProductCartDTO>();
		for(String prodNum : prodNums) {
			/// cart리스트에서 사용했던 정보를 구매페이지에서도 사용하면되어서
			/// cart리스트에서 사용했던 코드를 그대로 적용
			CartDTO dto = new CartDTO();
			dto.setMemId(memId);
			dto.setProdNum(prodNum);
			ProductCartDTO productCartDTO =	goodsRepository.cartList(dto);
			list.add(productCartDTO);
		}
		model.addAttribute("lists", list);
	}
}