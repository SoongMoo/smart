package service.notice;

import org.springframework.beans.factory.annotation.Autowired;

import repository.NoticeRepository;

public class NoticeDeleteService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeDel(String noticeNo) {
		noticeRepository.noticeDel(noticeNo);
	}
}