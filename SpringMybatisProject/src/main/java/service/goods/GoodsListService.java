package service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.GoodsDTO;
import repository.GoodsRepository;

public class GoodsListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsList(Model model) {
		List<GoodsDTO> list = goodsRepository.goodsList();
		model.addAttribute("lists", list);
	}
}