package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberCommand;

public class MemberCommandValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	public void validate(Object target, Errors errors) {
		MemberCommand memberCommand = (MemberCommand)target;
		if(memberCommand.getMemPw() != null && memberCommand.getMemPwCon() != null) {
			if(!memberCommand.isMemPwEqualsMemPwCon()) {
				errors.rejectValue("memPwCon", "nomatch");
			}
		}
		ValidationUtils.rejectIfEmpty(errors, "memId", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPwCon", "required");
		ValidationUtils.rejectIfEmpty(errors, "memName", "required");
		ValidationUtils.rejectIfEmpty(errors, "postNumber", "required");
		ValidationUtils.rejectIfEmpty(errors, "memAddress", "required");
		ValidationUtils.rejectIfEmpty(errors, "detailAdd", "required");
		ValidationUtils.rejectIfEmpty(errors, "memPhone", "required");
		ValidationUtils.rejectIfEmpty(errors, "memEmail", "required");
		ValidationUtils.rejectIfEmpty(errors, "memBirth", "required");
		ValidationUtils.rejectIfEmpty(errors, "memGender", "required");
		ValidationUtils.rejectIfEmpty(errors, "memEmailCk", "required");
	}

}
