package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

public class FileDownLoad {
	public void fileDownLoad(String path, String store, String original, HttpServletRequest request,
			HttpServletResponse response) {
		String RealPath = request.getServletContext().getRealPath(path);
		String originalFileName = "";
		try {
			originalFileName = URLEncoder.encode(original, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setContentType("application/octet-stream; charset=utf-8");
		// originalFileName으로 파일을 받기 위해 이름 설정
		response.setHeader("Content-Disposition", "attachment;filename=\"" + originalFileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		// 다운로드하기 위한 저장된 파일명을 적어준다.
		
		File file = new File(RealPath + "/" + store);
		// 파일이 웹브라우저에서 다운로드 되도록하기 위한 객체
		ServletOutputStream out1 = null;
		// 파일을 웹브라우저에 전송
		FileInputStream fis = null;
		try {
			out1 = response.getOutputStream();
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out1); // 전송
			response.flushBuffer();
			out1.flush();
			out1.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {fis.close();} catch (Exception e) {}
			}
		}
	}
}
