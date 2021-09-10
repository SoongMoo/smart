package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.ReviewDTO;
import command.ReviewCommand;
import service.repository.GoodsRepository;
@Service
public class GoodsReviewUpdateService {
	@Autowired
	GoodsRepository goodsRepository;
	
	public void reviewUpdate(ReviewCommand reviewCommand) {
		ReviewDTO dto = new ReviewDTO();
		dto.setProdNum(reviewCommand.getProdNum());
		dto.setPurchaseNum(reviewCommand.getPurchaseNum());
		dto.setReviewContent(reviewCommand.getReviewContent());
		goodsRepository.reviewUpdate(dto);
	}
	
	
	public void reviewInfo(String purchaseNum, String prodNum,
			HttpSession session, Model  model) {
		ReviewDTO dto = new ReviewDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		dto.setMemId(memId);
		dto.setProdNum(prodNum);
		dto.setPurchaseNum(purchaseNum);
		dto = goodsRepository.reviewInfo(dto);
		model.addAttribute("dto", dto);
	}
}
