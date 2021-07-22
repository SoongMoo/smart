package service.library;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import Model.LibraryDTO;
import command.LibraryCommand;
import repository.LibraryRepository;

public class LibraryService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libWrite(LibraryCommand libraryCommand,
			HttpSession session) {
		LibraryDTO dto = new LibraryDTO();
		dto.setNoticeCon(libraryCommand.getNoticeCon());
		dto.setNoticeSub(libraryCommand.getNoticeSub());
		dto.setNoticeKind("자료실");
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		dto.setEmployeeId(authInfo.getGrade());
		System.out.println(dto.getEmployeeId());
		System.out.println(dto.getNoticeCon());
		System.out.println(dto.getNoticeKind());
		System.out.println(dto.getNoticeSub());
		libraryRepository.libWrite(dto);
	}
}
