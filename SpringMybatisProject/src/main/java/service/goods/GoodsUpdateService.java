package service.goods;

import org.springframework.beans.factory.annotation.Autowired;

import Model.GoodsDTO;
import command.GoodsCommand;
import repository.GoodsRepository;

public class GoodsUpdateService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsUpdate(GoodsCommand goodsCommand) {
		GoodsDTO dto = new GoodsDTO();
		dto.setProdNum(goodsCommand.getProdNum());
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setProdSupplyer(goodsCommand.getProdSupplyer());
		dto.setRecommend(goodsCommand.getRecommend());
		goodsRepository.goodsUpdate(dto);
	}
}
