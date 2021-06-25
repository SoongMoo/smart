package controller.goods;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DAO.LoginDAO;
import model.DTO.AuthInfo;
import model.DTO.ProductDTO;

public class GoodsListPage {
	public void goodsList(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		List<ProductDTO> list = dao.goodsList();
		request.setAttribute("lists", list);
		Cookie [] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().startsWith("id")) {
					request.setAttribute("isId",cookie.getValue());
				}
				if(cookie.getName().startsWith("au")) {
					HttpSession session = request.getSession();
					LoginDAO ldao = new LoginDAO();
					String userId = cookie.getValue();
					AuthInfo authInfo =  ldao.login(userId);
					session.setAttribute("authInfo", authInfo);		
				}
			}
		}
	}
}
