package controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import Model.MemberDTO;
import service.member.MemberAndroidService;

@RequestMapping("android")
@RestController
public class MemberAndroidController {
	@Autowired
	MemberAndroidService memberAndroidService;
	@RequestMapping(value="memList", produces="application/json;charset=utf-8")
	public @ResponseBody String json() {
		Gson gson = new Gson();
		List<MemberDTO> list = memberAndroidService.memList1();
		return gson.toJson(list);
	}
}