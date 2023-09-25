package tteogipbangbeomdae.goddog.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 회원가입시 입력된 정보를 담을 객체
 *
 * @author  떡잎방범대 조영호
 * @since   날짜
 * @version 버전
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {
	
	/**
	 * 회원 아이디
	 */
	@NotBlank(message = "아이디는 필수 입력 항목입니다.")
	@Pattern(regexp = "^[a-zA-Z][0-9a-zA-Z]{5,12}$", message = "아이디는 5~12자의 영문 대소문자, 숫자, 특수문자로 이루어져야 합니다.")
	private String memberId;
	
	/**
	 * 회원 비밀번호
	 */
	@NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*]{4,16}$", message = "비밀번호는 4~16자의 영문 대소문자, 숫자, 특수문자로 이루어져야 합니다.")
	private String passwd;
	
	/**
	 * 회원 이름
	 */
	@NotBlank(message = "이름은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[가-힣a-zA-Z]{2,10}$", message = "이름은 2~10자의 영문 대소문자, 숫자, 한글로 이루어져야 합니다.")
	private String name;
	
	/**
	 * 회원 전화번호
	 */
	@NotBlank(message = "전화번호는 필수 입력 항목입니다.")
	@Pattern(regexp = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}", message = "전화번호 형식은 000-0000-0000입니다.")
	private String phoneNum;
	
	/**
	 * 회원 이메일 아이디부분
	 */
	@NotBlank(message = "이메일은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[a-zA-Z][0-9a-zA-Z]{2,}$")
	private String emailF;

	/**
	 * 회원 이메일 도메인부분
	 */
	@NotBlank(message = "이메일은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+")
	private String emailB;
	
	/**
	 * 가입한 날짜
	 */
	private String regdate;
	
	/**
	 * 생년월일중 년
	 */
	@NotBlank(message = "년은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[0-9]{4}")
	private String year;
	
	/**
	 * 생년월일중 월
	 */
	@NotBlank(message = "월은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[0-9]{1,}")
	private String month;
	
	/**
	 * 생년월일중 일
	 */
	@NotBlank(message = "일은 필수 입력 항목입니다.")
	@Pattern(regexp = "^[0-9]{1,}")
	private String day;
	
	/**
	 * 주소 도로명, 지번
	 */
	@NotBlank(message = "주소는 필수 입력 항목입니다.")
	private String adress;
	
	/**
	 * 사용자가 입력한 상세주소
	 */
	@NotBlank(message = "상세주소는 필수 입력 항목입니다.")
	private String detailAdress;
	
	/**
	 * 일반회원 lev1, 보호소lev2
	 */
	private int lev;
	
//	폼필드에서 들어온 각 값들을 하나의 값으로 초기화해주기 위한 필드값과 메소드
	
	/**
	 * 위에 입력된 나누어진 email을 하나의 문장으로 만들어담을 속성 ex)jhonedoe@gmail.com
	 */
	private String fullEmail;
	
	/**
	 * 각각 생년월일을 더해 하나의 날짜형식으로 담을 속성 ex)1993-07-05
	 */
	private String fullBirthday;
	
	/**
	 * 지번,도로명과 사용자가 입혁한 상세주소를 더해줘 담을 속성 ex)서울 특별시 숙선옹주로 54 떡잎마을 1동 2호
	 */
	private String fullAdress;
	
	/**
	 * 이메일을 하나의 문장으로 합함.
	 * @return 완성된 이메일 반환
	 */
	public String combineFullEmail() {
		fullEmail = emailF+"@"+emailB;
		return fullEmail;
	}
	
	/**
	 * 생년월일을 하나의 문장으로 합함.
	 * @return 완성된 생년월일
	 */
	public String combineFullBirthday() {
		fullBirthday = year + "-" + month + "-" + day;
		return fullBirthday;
	}
	
	/**
	 * 주소를 하나의 문장으로 합함.
	 * @return 완성된 주소
	 */
	public String combineFullAdress() {
		fullAdress = adress+" "+detailAdress;
		return fullAdress;
	}
	
}





