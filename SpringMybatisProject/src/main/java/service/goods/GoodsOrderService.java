package service.goods;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.AuthInfoDTO;
import Model.CartDTO;
import Model.PurchaseDTO;
import command.GoodsOrderCommand;
import service.repository.GoodsRepository;
@Service
public class GoodsOrderService {
	@Autowired
	GoodsRepository goodsRepository;
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand,
			HttpSession session) {
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseAddr(goodsOrderCommand.getPurchaseAddr());
		dto.setPurchaseMethod(goodsOrderCommand.getPurchaseMethod());
		dto.setPurchaseRequest(goodsOrderCommand.getPurchaseRequest());
		dto.setPurchaseTotPrice(goodsOrderCommand.getPurchaseTotPrice());
		dto.setReceiverName(goodsOrderCommand.getReceiveName());
		dto.setReceiverPhone(goodsOrderCommand.getPurchasePhone());
		
		// 구매번호 
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purchaseNum = df.format(new Date());
		dto.setPurchaseNum(purchaseNum);
		
		
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		goodsRepository.purchaseInsert(dto);
		
		String [] prodNums = goodsOrderCommand.getProdNums().split(",");
		for(String prodNum : prodNums) {
			// 구매리스트에는 구매번호가 있어야 한다.
			CartDTO d = new CartDTO();
			d.setPurchaseNum(purchaseNum);
			d.setMemId(authInfo.getUserId());
			d.setProdNum(prodNum);
			int i = goodsRepository.purchaseListInsert(d);
			if( i == 1) {
				goodsRepository.cartDelete(d);
			}
			
		}
		
		return purchaseNum;
	}
}
