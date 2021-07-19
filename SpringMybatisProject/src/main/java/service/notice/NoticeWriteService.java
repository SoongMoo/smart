package service.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.NoticeDTO;
import command.NoticeCommand;
import repository.NoticeRepository;

public class NoticeWriteService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeWrite(HttpSession session, 
			NoticeCommand noticeCommand) {
		AuthInfoDTO authInfo =
				(AuthInfoDTO)session.getAttribute("authInfo");
		String employeeId =	authInfo.getGrade();
		NoticeDTO dto = new NoticeDTO();
		dto.setNoticeCon(noticeCommand.getNoticeCon());
		dto.setNoticeKind(noticeCommand.getNoticeKind());
		dto.setNoticeSub(noticeCommand.getNoticeSub());
		dto.setEmployeeId(employeeId);
		noticeRepository.noticeWrite(dto);		
	}
}
