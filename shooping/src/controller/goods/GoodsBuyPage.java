package controller.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.ProductCartDTO;

public class GoodsBuyPage {
	public void goodsBuy(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		String [] prodNums = request.getParameterValues("prodCk");
		List<ProductCartDTO> list = new ArrayList<ProductCartDTO>();
		GoodsDAO dao = new GoodsDAO();
		for(String prodNum : prodNums) {
			ProductCartDTO dto = dao.prodCart(prodNum,memId);
			list.add(dto);
		}
		request.setAttribute("list", list);
	}
}