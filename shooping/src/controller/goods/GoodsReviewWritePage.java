package controller.goods;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProductReviewDTO;

public class GoodsReviewWritePage {
	public void reviewUpdate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ProductReviewDTO dto = new ProductReviewDTO();
		dto.setProdNum(request.getParameter("prodNum"));
		
		dto.setPurchaseNum(request.getParameter("purchaseNum"));
		dto.setReviewContent(request.getParameter("reviewContent"));
		System.out.println(request.getParameter("prodNum"));
		System.out.println(request.getParameter("purchaseNum"));
		GoodsDAO dao = new GoodsDAO();
		dao.reviewUpdate(dto);
	}
}
