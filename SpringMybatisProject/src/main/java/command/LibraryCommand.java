package command;

import org.springframework.web.multipart.MultipartFile;

public class LibraryCommand {
	String noticeNo;
	String noticeSub;
	String noticeCon;
	MultipartFile [] noticeFile;	
	
	String fileDel;
	public String getFileDel() {
		return fileDel;
	}
	public void setFileDel(String fileDel) {
		this.fileDel = fileDel;
	}
	
	public MultipartFile[] getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(MultipartFile[] noticeFile) {
		this.noticeFile = noticeFile;
	}
	
	
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeSub() {
		return noticeSub;
	}
	public void setNoticeSub(String noticeSub) {
		this.noticeSub = noticeSub;
	}
	public String getNoticeCon() {
		return noticeCon;
	}
	public void setNoticeCon(String noticeCon) {
		this.noticeCon = noticeCon;
	}
}
