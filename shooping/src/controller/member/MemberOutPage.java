package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.AuthInfo;

public class MemberOutPage {
	public int memOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		if(request.getParameter("memPw")
				  .equals(authInfo.getUserPw())) {
			MemberDAO dao = new MemberDAO();
			dao.memDel(authInfo.getUserId());
			session.invalidate();
			return 1;
		}else {
			session.setAttribute("pwFail", "비밀번호가 틀렸습니다.");
			return 2;
		}
	}
}
