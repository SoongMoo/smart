package service.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Model.MemberDTO;
import command.MemberCommand;
import controller.MailService;
import service.repository.MemberRepository;
@Service
public class MemberJoinService {
	@Autowired
	MailService mailService;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public void memJoin(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(memberCommand.getDetailAdd());
		dto.setMemAccount(memberCommand.getMemAccount());
		dto.setMemAddress(memberCommand.getMemAddress());
		dto.setMemBirth(memberCommand.getMemBirth());
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemEmailCk(memberCommand.getMemEmailCk());
		dto.setMemGender(memberCommand.getMemGender());
		dto.setMemId(memberCommand.getMemId());
		dto.setMemName(memberCommand.getMemName());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemPw(bcryptPasswordEncoder.encode(memberCommand.getMemPw()));
		dto.setPostNumber(memberCommand.getPostNumber());
		memberRepository.memJoin(dto);
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = dateForm.format(new Date());
		String subject = "가입환영인사";
		String content ="<html><body>"
				+ " 안녕하세요. " + dto.getMemId() + "님 가입을 축하드립니다."
				+ " 아래 링크를 눌러야 가입이 완료됩니다. <br />"
				+ " <a href='http://192.168.0.90:8080/SpringMybatisProject/register/memberMail?"
				+ "num="+num
				+ "&reciver="+dto.getMemEmail()+"'>가입을 완료하시려면 클릭하세요</a>"
				+ "</body></html>";
		try {
			mailService.sendMail(dto.getMemEmail(), content, subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
