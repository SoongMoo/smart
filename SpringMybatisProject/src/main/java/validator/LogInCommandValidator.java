package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LogInCommandValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return false;
	}
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "userId", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPw", "required");	
	}

}
