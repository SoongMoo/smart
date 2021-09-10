package service.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.AuthInfoDTO;
import service.repository.GoodsRepository;
@Service
public class GoodsCartRemoveService {
	@Autowired
	GoodsRepository goodsRepository;
	public void cartRemove(String prodNums, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		String [] prodNumMap = prodNums.split(",");
		/// 100164,100166
		// delete from cart 
		// where prodNum in (100164,100166)
		List<String> cs = new ArrayList<String>();
		for(String prodNum : prodNumMap) {
			cs.add(prodNum);
		}
		Map<String, Object> condition =	new HashMap<String, Object>();
		condition.put("prodNums", cs);
		condition.put("memId", memId);
		goodsRepository.cartRemove(condition);
	}
}
