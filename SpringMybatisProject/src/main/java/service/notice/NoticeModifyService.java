package service.notice;

import org.springframework.beans.factory.annotation.Autowired;

import Model.NoticeDTO;
import command.NoticeCommand;
import repository.NoticeRepository;

public class NoticeModifyService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeModify(NoticeCommand noticeCommand) {
		NoticeDTO dto = new NoticeDTO();
		dto.setNoticeNo(noticeCommand.getNoticeNo());
		dto.setNoticeCon(noticeCommand.getNoticeCon());
		dto.setNoticeSub(noticeCommand.getNoticeSub());
		noticeRepository.noticeModify(dto);
	}
}
