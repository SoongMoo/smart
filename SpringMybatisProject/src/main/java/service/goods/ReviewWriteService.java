package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.ReviewDTO;
import command.ReviewCommand;
import repository.GoodsRepository;

public class ReviewWriteService {
	@Autowired
	GoodsRepository goodsRepository;
	public void reviewWrite(ReviewCommand reviewCommand,
			HttpSession session) {
		ReviewDTO dto = new ReviewDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		dto.setProdNum(reviewCommand.getProdNum());
		dto.setPurchaseNum(reviewCommand.getPurchaseNum());
		dto.setReviewContent(reviewCommand.getReviewContent());
		goodsRepository.reviewWrite(dto);
	}
}
	