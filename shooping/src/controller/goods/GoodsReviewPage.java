package controller.goods;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DTO.AuthInfo;
import model.DTO.ProductReviewDTO;

public class GoodsReviewPage {
	public void review(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		String path = "goods/review";
		String realPath = request.getServletContext().getRealPath(path);
		int size = 1024 * 1024 * 5;
		MultipartRequest multi = null;
		ProductReviewDTO dto =  new ProductReviewDTO();
		try {
			multi = new MultipartRequest(request, realPath, size,
					"utf-8", new DefaultFileRenamePolicy());
			dto.setReviewImg(multi.getFilesystemName("reviewImg"));
			dto.setMemId(memId);
			dto.setProdNum(multi.getParameter("prodNum"));
			dto.setPurchaseNum(multi.getParameter("purchaseNum"));
			dto.setReviewContent(multi.getParameter("reviewContent"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
}
