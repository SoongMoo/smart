package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import repository.GoodsRepository;

public class GoodsNumberService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsNum(Model model) {
		String goodsNum = goodsRepository.goodsNum();
		model.addAttribute("goodsNum", goodsNum);
	}
}
