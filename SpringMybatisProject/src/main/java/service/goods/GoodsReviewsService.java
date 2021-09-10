package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.GoodsReviewsDTO;
import Model.WishDTO;
import service.repository.GoodsRepository;
@Service
public class GoodsReviewsService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsReviews(String prodNum, Model model,
			HttpSession session) {
		GoodsReviewsDTO dto = goodsRepository.goodsReviews(prodNum);
		Integer i = 0;
		if(session.getAttribute("authInfo") != null) {
			AuthInfoDTO authInfo = 
					(AuthInfoDTO)session.getAttribute("authInfo");
			WishDTO wish = new WishDTO();
			wish.setMemId(authInfo.getUserId());
			wish.setProdNum(prodNum);
			i = goodsRepository.wishCount(wish);
		}
		model.addAttribute("num", i);
		model.addAttribute("goodsReviews", dto);
	}
}
