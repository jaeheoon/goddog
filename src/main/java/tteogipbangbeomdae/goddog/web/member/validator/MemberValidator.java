package tteogipbangbeomdae.goddog.web.member.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import tteogipbangbeomdae.goddog.domain.member.dto.Member;

/**
 * 
 * 멤버관련 서버측 유효성검사 클래스
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 13.
 * @version 1.0
 */
@Component
public class MemberValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member) target;
		// 폼 필드 검증
		if (!StringUtils.hasText(member.getMemberId())) {
			errors.rejectValue("memberId", "required",null);
			
		} else {
			if (member.getMemberId().length() < 6 || member.getMemberId().length() > 12) {
				errors.rejectValue("memberId", "range", new Object[]{6, 12}, null);
			}
		}
		
		if (!StringUtils.hasText(member.getPasswd())) {
			errors.rejectValue("passwd", "required");
		} else {
			if (member.getPasswd().length() < 4 || member.getPasswd().length() > 16) {
				errors.rejectValue("passwd", "range", new Object[]{4, 16}, null);
			}
		}
		
		if (!StringUtils.hasText(member.getName())) {
		     errors.rejectValue("name", "required");
		}
		if (!StringUtils.hasText(member.getName())) {
		     errors.rejectValue("phoneNum", "required");
		}
		if (!StringUtils.hasText(member.getEmailF())) {
			errors.rejectValue("emailF", "required");
		}
		if (!StringUtils.hasText(member.getEmailB())) {
			errors.rejectValue("emailB", "required");
		}
		if (!StringUtils.hasText(member.getYear())) {
			errors.rejectValue("year", "required");
		}
		if (!StringUtils.hasText(member.getMonth())) {
			errors.rejectValue("month", "required");
		}
		if (!StringUtils.hasText(member.getDay())) {
			errors.rejectValue("day", "required");
		}
		if (!StringUtils.hasText(member.getAdress())) {
			errors.rejectValue("adress", "required");
		}
		if (!StringUtils.hasText(member.getDetailAdress())) {
			errors.rejectValue("detailAdress", "required");
		}
	}
}

