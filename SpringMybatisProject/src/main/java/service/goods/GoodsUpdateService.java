package service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Model.GoodsDTO;
import command.GoodsCommand;
import service.repository.GoodsRepository;
@Service
public class GoodsUpdateService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsUpdate(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		/// 컨텐츠 수정		
		dto.setProdNum(goodsCommand.getProdNum());
		dto.setCtgr(goodsCommand.getCtgr());
		dto.setProdCapacity(goodsCommand.getProdCapacity());
		dto.setProdDelFee(goodsCommand.getProdDelFee());
		dto.setProdDetail(goodsCommand.getProdDetail());
		dto.setProdPrice(goodsCommand.getProdPrice());
		dto.setProdSupplyer(goodsCommand.getProdSupplyer());
		dto.setRecommend(goodsCommand.getRecommend());
		//파일 수정
		String [] fileNames = goodsCommand.getFileDel1().split(",");
		/// aaa,bbb,
		GoodsDTO dto1 = // 디비 저장되어 있는 파일명을 가져 오기 위해서 
				goodsRepository.goodsDetail(
						goodsCommand.getProdNum().toString());
		// 이미 저장되어 있는 이미지 파일명을 먼저 저장
		dto.setProdImage(dto1.getProdImage());
		// 파일 추가
		String realPath = session.getServletContext()
				.getRealPath("WEB-INF/view/goods/upload");
		String storeFile = ""; 
		if(!goodsCommand.getProdImage()[0].getOriginalFilename().equals("") ) {
			for(MultipartFile mf : goodsCommand.getProdImage()) {
				String original = mf.getOriginalFilename();
				String fileNameExt = original.substring(
						original.lastIndexOf("."));
				String store = // 랜덤으로 문자열을 받아옴
						UUID.randomUUID().toString().replace("-", "")
						+fileNameExt;
				File file = new File(realPath + "/" + store);
				try {mf.transferTo(file);} 
				catch (Exception e) {e.printStackTrace();} 
				storeFile = storeFile + store + ","; 
			}
		}
		String goodsFileName = dto1.getProdImage();
		if(!fileNames[0].equals("")) {	
			// 디비에 있는 이미지 파일명을 제거
			// 이미지 파일이 변경된 경우 수정된 내용으로 다시 저장	
			for(String s : fileNames) {
				String delfile = s+ ",";
				goodsFileName = goodsFileName.replace(delfile,"");
				File file = new File(realPath + "/" + s);
				if(file.exists()) {file.delete();}
			}
			dto.setProdImage(goodsFileName);
		}
		if(dto.getProdImage() != null) {
			dto.setProdImage(storeFile + dto.getProdImage());
		}else {
			dto.setProdImage(storeFile);
		}
		goodsRepository.goodsUpdate(dto);
	}
}