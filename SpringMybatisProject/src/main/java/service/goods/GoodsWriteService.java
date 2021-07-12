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
	// dto가 가지고 있는 값은 repository를 통해 디비에 저장한다.
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsInsrt(GoodsCommand goodsCommand,
			HttpSession session) {
		/// goodsCommand가 가지고 있는 값을 디비에 저장하기 위해서는 
		/// DTO에 저장한다.
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
		AuthInfoDTO authInfo = 
				(AuthInfoDTO)session.getAttribute("authInfo");
		String employeeId = authInfo.getGrade();
		dto.setEmployeeId(employeeId);
		// 디비에 파일명만 저장하기 위해 OriginalFilename을 가져와서 확장자를 추출 
		String prodImage= "";
		for(MultipartFile mf : goodsCommand.getProdImage1()) {
			String original = mf.getOriginalFilename();
			String originalExt = 
					original.substring(original.lastIndexOf("."));
			String store = 
					UUID.randomUUID().toString().replace("-","")
					+originalExt;
			prodImage += store + ",";
			String realPath = 
					session.getServletContext()
					       .getRealPath("WEB-INF/view/goods/upload");
			File file = new File(realPath + "/" + store);
			try {mf.transferTo(file);} 
			catch (Exception e) {e.printStackTrace();} 
		}
		dto.setProdImage(prodImage);
		///////////////////////
		
		goodsRepository.goodsInsert(dto);	
	}
}
