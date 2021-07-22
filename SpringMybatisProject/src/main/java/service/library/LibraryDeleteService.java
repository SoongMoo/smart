package service.library;

import org.springframework.beans.factory.annotation.Autowired;

import repository.LibraryRepository;

public class LibraryDeleteService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libDel(String noticeNo) {
		libraryRepository.libDel(noticeNo);
	}
}
