package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeUpdateValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "phNumber", "required");
		ValidationUtils.rejectIfEmpty(errors, "officeNumber", "required");
		ValidationUtils.rejectIfEmpty(errors, "email", "required");
		ValidationUtils.rejectIfEmpty(errors, "empAddress", "required");
		ValidationUtils.rejectIfEmpty(errors, "empPw", "required");
	}

}
