package service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.NoticeDTO;
import service.repository.NoticeRepository;
@Service
public class NoticeDetailService {
	@Autowired
	NoticeRepository noticeRepository;
	public void noticeDetail(String noticeNo, Model model) {
		noticeRepository.noticeReadUpdate(noticeNo);
		NoticeDTO dto = noticeRepository.noticeDetail(noticeNo);
		model.addAttribute("dto", dto);
	}
}
