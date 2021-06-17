package controller.goods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DTO.AuthInfo;
import model.DTO.ProductDTO;

public class GoodsJoinPage {
	public void goodsJoin(HttpServletRequest request) {
		String filePath = "goods/upload";
		String realPath = request.getServletContext()
								 .getRealPath("goods/upload");
		System.out.println(realPath);
		int fileSize = 1024*1024*5;
		MultipartRequest multi;
		HttpSession session = request.getSession();
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		String emp_no = authInfo.getGrade();
		String storeFileName1;
		String storeFileName2;
		String storeFileName3;
		String images="";
		try {
			multi =	new MultipartRequest(request, realPath, fileSize, 
							"utf-8",new DefaultFileRenamePolicy());
			storeFileName1 = multi.getFilesystemName("prodImage1");
			storeFileName2 = multi.getFilesystemName("prodImage2");
			storeFileName3 = multi.getFilesystemName("prodImage3");
			images = storeFileName1+","+storeFileName2+","+storeFileName3;
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProductDTO dto = new ProductDTO();
		dto.setEmployeeId(emp_no);
		dto.setProdCapacity(request.getParameter("prodCapacity"));
		dto.setProdDelFee(request.getParameter("prodDelFee"));
		dto.setProdDetail(request.getParameter("prodDetail"));
		dto.setProdImage(images);
		dto.setProdName(request.getParameter("prodName"));
		dto.setProdNum(request.getParameter("prodNum"));
		dto.setProdPrice(
				Integer.parseInt(request.getParameter("prodPrice")));
		dto.setProdSupplyer(request.getParameter("prodSupplyer"));
		dto.setRecommend(request.getParameter("recommend"));
		dto.setCtgr(request.getParameter("ctgr"));
	}
}
