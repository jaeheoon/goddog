package tteogipbangbeomdae.goddog.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 로그인시 입력한 값을 객체로 담기 위해 만들어진 객체
 * 
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 11.
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
@ToString
@Builder
public class LoginForm {
	/**
	 * 로그인폼에 입력된 아이디
	 */
	@NotBlank(message = "아이디를 입력하여 주세요.")
	@Size(min = 6, max = 12, message = "아이디는 6~12자 사이여야 합니다.")
	private String loginId;
	
	/**
	 * 로그인폼에 입력된 패스워드
	 */
	@NotBlank(message = "비밀번호를 입력하여 주세요")
	@Size(min = 4, max = 16, message = "비밀번호는 4~16자 사이여야 합니다.")
	private String passwd;
	
	/**
	 * 로그인폼에 입력된 로그인 타입('보호소 로그인 체크여부')
	 */
	private Boolean loginType;
	
}





