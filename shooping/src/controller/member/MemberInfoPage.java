package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberInfoPage {
	public void memInfo(HttpServletRequest request) {
		String memId = request.getParameter("memId");
		MemberDAO dao= new MemberDAO();
		MemberDTO dto = dao.memDetail(memId);
		request.setAttribute("dto", dto);
	}
}