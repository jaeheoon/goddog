package tteogipbangbeomdae.goddog.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {
	
	@NotBlank(message = "아이디는 필수 입력 항목입니다.")
	@Pattern(regexp = "^[a-zA-Z][0-9a-zA-Z]{5,12}$", message = "아이디는 5~12자의 영문 대소문자, 숫자, 특수문자로 이루어져야 합니다.")
	private String memberId;
	
	@NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*]{4,16}$", message = "비밀번호는 4~16자의 영문 대소문자, 숫자, 특수문자로 이루어져야 합니다.")
	private String passwd;
	
	@NotBlank(message = "이름은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "이름은 2~10자의 영문 대소문자, 숫자, 한글로 이루어져야 합니다.")
	private String name;
	
	@NotBlank(message = "전화번호는 필수 입력 항목입니다.")
	@Pattern(regexp = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}", message = "전화번호 형식은 000-0000-0000입니다.")
	private String phoneNum;
	
	@NotBlank(message = "이메일은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[a-zA-Z][0-9a-zA-Z]{2,}$")
	private String emailF;

	@NotBlank(message = "이메일은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+")
	private String emailB;
	
	private String regdate;
	
	@NotBlank(message = "년은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[0-9]{4}")
	private String year;
	
	@NotBlank(message = "월은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[0-9]{1,}")
	private String month;
	
	@NotBlank(message = "일은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[0-9]{1,}")
	private String day;
	
	@NotBlank(message = "주소는 필수 입력 항목입니다.")
	private String adress;
	
	@NotBlank(message = "상세주소는 필수 입력 항목입니다.")
	private String detailAdress;
	
	//일반회원 lev1, 관리자 lev0
	private int lev;
	
//	폼필드에서 들어온 각 값들을 하나의 값으로 초기화해주기 위한 필드값과 메소드
	private String fullEmail;
	
	private String fullBirthday;
	
	private String fullAdress;
	
	public String combineFullEmail() {
		fullEmail = emailF+"@"+emailB;
		return fullEmail;
	}
	
	public String combineFullBirthday() {
		fullBirthday = year + "-" + month + "-" + day;
		return fullBirthday;
	}
	
	public String combineFullAdress() {
		fullAdress = adress+" "+detailAdress;
		return fullAdress;
	}
	
}





