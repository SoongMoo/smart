package service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.AuthInfoDTO;
import Model.GoodsDTO;
import command.GoodsCommand;
import repository.GoodsRepository;

public class GoodsWriteService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsWrite(GoodsCommand goodsCommand,
			HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setProdName(goodsCommand.getProdName());
		dto.setProdNum(goodsCommand.getGoodsNum());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setPrudSupplyer(goodsCommand.getProdSupplyer());
		dto.setRecommend(goodsCommand.getRecommend());
		/// employeeId는 로그인 시 session 저장
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		dto.setEmployeeId(authInfo.getGrade());
		String prodImage = "";
		for(MultipartFile mf : goodsCommand.getProdImage1()) {
			// 확장자를 알기 위해서 
			String original = mf.getOriginalFilename();
			// original에서 확당자만 추출
			String originalExt = 
					original.substring(original.lastIndexOf("."));
			String store =
					UUID.randomUUID().toString().replace("-", "")
					+ originalExt;
			// 디비에 저장할 파일명을 추출하여 prodImage에 저장
			prodImage += store + ",";
			// 파일을 시스템에 저장
			String filePath =
					session.getServletContext().getRealPath(
							"WEB-INF/view/goods/upload");
			File file = new File(filePath + "/" +store);
			// 파일 저장
			try {mf.transferTo(file);
			} catch (Exception e) {	e.printStackTrace(); }
		}
		dto.setProdImage(prodImage);
		System.out.println(dto.getCtgr());
		System.out.println(dto.getEmployeeId());
		goodsRepository.goodsWrite(dto);
	}
}