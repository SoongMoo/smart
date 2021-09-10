package service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.repository.NoticeRepository;
@Service
public class NoticeDeleteService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeDel(String noticeNo) {
		noticeRepository.noticeDel(noticeNo);
	}
}