package controller.goods;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.PurchaseDTO;

public class GoodsOrderPage {
	public void goodsOrder(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();

		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purchaseNum = df.format(day);
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseNum(purchaseNum);
		dto.setPurchaseTotPrice(request.getParameter("purchaseTotPrice"));
		dto.setMemId(memId);
		dto.setPurchaseAddr(request.getParameter("purchaseAddr"));
		dto.setPurchaseMethod(request.getParameter("purchaseMethod"));
		dto.setPurchaseRequest(request.getParameter("purchaseRequest"));
		dto.setReceiverName(request.getParameter("receiveName"));
		System.out.println(request.getParameter("receiveName"));
		dto.setReceiverPhone(request.getParameter("purchasePhone"));
		GoodsDAO dao = new GoodsDAO();
		dao.purchaseInsert(dto);
		String [] prodNums = request.getParameter("prodNums").split(",");
		for(String prodNum : prodNums) {
			dao.purchaseListInsert(purchaseNum,prodNum,memId);
		}
		for(String prodNum : prodNums) {
			dao.cartDel(prodNum,memId);
		}
	}
}
