package service.library;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.LibraryDTO;
import repository.LibraryRepository;

public class LibraryDeleteService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libDel(String noticeNo, HttpSession session) {
		LibraryDTO dto = libraryRepository.libraryInfo(noticeNo);
		String [] fileNames = dto.getNoticeFile().split(",");
		String realPath = session.getServletContext()
				                 .getRealPath("WEB-INF/view/library/upload");
		for(String fileName: fileNames) {
			File f = new File(realPath +"/" +fileName);
			if(f.exists()) f.delete();
		}
		libraryRepository.libDel(noticeNo);
	}
}
