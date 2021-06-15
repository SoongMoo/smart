package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class LoginPage {
	public void login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		LoginDAO dao = new LoginDAO();
		AuthInfo authInfo = dao.login(userId);
		if(authInfo == null) {
			session.removeAttribute("pwFail");
			session.setAttribute("userFail", "아이디가 존재하지 않습니다.");
		}else {
			session.removeAttribute("userFail");
			if(userPw.equals(authInfo.getUserPw())) {
				session.removeAttribute("pwFail");
				/// 웹브라우저를 닫기 전까지 사용할 수 있도록 session에 저장
				session.setAttribute("authInfo", authInfo);		
			}else {
				session.setAttribute("pwFail", "비밀번호가 틀렸습니다.");
			}
		}
	}
}