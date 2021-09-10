package service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.repository.MemberRepository;
@Service
public class MemberDeleteService {
	@Autowired
	MemberRepository memberRepository;
	public void memDel(String memId) {
		memberRepository.memDel(memId);
	}
}
