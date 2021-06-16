package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DTO.AuthInfo;

public class MemberPwConfirmPage {
	public String pwConfirm(HttpServletRequest request) {
		String path = null;
		HttpSession session = request.getSession();
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		if(request.getParameter("memPw")
				  .equals(authInfo.getUserPw())) {
			path = "member/pwChangeOk.jsp";
		}else {
			request.setAttribute("pwFail1","비밀번호가 틀렸습니다.");
			path = "member/pwChang.jsp";
		}
		return path;
	}
}
