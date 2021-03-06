package service.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.WishDTO;
import service.repository.GoodsRepository;
@Service
public class GoodsWishService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsWishAdd(String prodNum, 
			HttpSession session, Model model) {
		System.out.println("svnsbvsbvsbvSbv");
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		System.out.println("nvsdvsvs : " + memId);
		WishDTO dto = new WishDTO();
		dto.setMemId(memId);
		dto.setProdNum(prodNum);
		int i = goodsRepository.wishAdd(dto);
		model.addAttribute("num", i);
	}
}
