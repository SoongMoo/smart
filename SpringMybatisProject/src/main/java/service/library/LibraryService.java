package service.library;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Model.AuthInfoDTO;
import Model.LibraryDTO;
import command.LibraryCommand;
import service.repository.LibraryRepository;
@Service
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
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		if(libraryCommand.getNoticeFile()[0].getOriginalFilename()!= "") {
			for(MultipartFile mf : libraryCommand.getNoticeFile()) {
				String original = mf.getOriginalFilename();
				String originalExt =
						original.substring(original.lastIndexOf("."));
				String store = //xnbsvklbsvfwssvsvfws.hwp
						UUID.randomUUID().toString().replace("-","")
						+ originalExt;
				String fileSize = Long.toString(mf.getSize());	
				originalTotal += original + ",";
				storeTotal += store + ",";
				fileSizeTotal += fileSize + ",";
				String path = "WEB-INF/view/library/upload";
				String realPath =
						session.getServletContext().getRealPath(path);
				File file = new File(realPath + "/" + store);
				try {mf.transferTo(file);}catch(Exception e) {}
				dto.setNoticeOrgFile(originalTotal);
				dto.setNoticeFile(storeTotal);
				dto.setNoticeFileSize(fileSizeTotal);
			}
		}
		
		libraryRepository.libWrite(dto);
	}
}
