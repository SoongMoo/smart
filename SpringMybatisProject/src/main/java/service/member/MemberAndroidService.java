package service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.MemberDTO;
import service.repository.MemberRepository;
@Service
public class MemberAndroidService {
	@Autowired
	MemberRepository memberRepository;
	public List<MemberDTO> memList1() {
		MemberDTO dto = new MemberDTO();
		List<MemberDTO> list = memberRepository.memList(dto);
		return list;
	}
}
