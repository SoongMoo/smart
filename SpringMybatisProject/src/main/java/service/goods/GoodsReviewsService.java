package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.GoodsReviewsDTO;
import repository.GoodsRepository;

public class GoodsReviewsService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsReviews(String prodNum, Model model) {
		GoodsReviewsDTO dto = goodsRepository.goodsReviews(prodNum);
		model.addAttribute("goodsReviews", dto);
	}
}
