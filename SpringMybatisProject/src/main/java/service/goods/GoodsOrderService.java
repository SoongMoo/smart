package service.goods;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.PurchaseDTO;
import command.GoodsOrderCommand;
import repository.GoodsRepository;

public class GoodsOrderService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsOrder(GoodsOrderCommand goodsOrderCommand,
			HttpSession session) {
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseAddr(goodsOrderCommand.getPurchaseAddr());
		dto.setPurchaseMethod(goodsOrderCommand.getPurchaseMethod());
		dto.setPurchaseRequest(goodsOrderCommand.getPurchaseRequest());
		dto.setPurchaseTotPrice(goodsOrderCommand.getPurchaseTotPrice());
		dto.setReceiverName(goodsOrderCommand.getReceiveName());
		dto.setReceiverPhone(goodsOrderCommand.getPurchasePhone());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purchaseNum = df.format(new Date());
		dto.setPurchaseNum(purchaseNum);
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		goodsRepository.purchaseInsert(dto);
		
	}
}
