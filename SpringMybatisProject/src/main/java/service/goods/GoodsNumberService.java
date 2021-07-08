package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import repository.GoodsRepository;

// service : 데이터를 디비에 전달하거나 디비로 가져 온 값을 model에 저장
public class GoodsNumberService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsNum(Model model) {
		int goodsNum = goodsRepository.goodsNum();
		model.addAttribute("goodsNum", goodsNum);
	}
}