package service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.GoodsDTO;
import service.repository.GoodsRepository;
@Service
public class GoodsDetailService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsDetail(String prodNum, Model model ) {
		GoodsDTO dto1  = goodsRepository.goodsDetail(prodNum);
		// model.addAttribute(속성명,속성값);
		// 속성명을 jsp페이지에서 받는다
		model.addAttribute("test", 10);
		model.addAttribute("goodsCommand",dto1);
		/*
		model.addAttribute("dto",10); 경우
		int dto = 10;
		model.addAttribute("goodsCommand",dto1); 경우
		GoodsDTO goodsCommand = dto1;
		*/
	}
}