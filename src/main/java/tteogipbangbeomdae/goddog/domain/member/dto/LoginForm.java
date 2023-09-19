package tteogipbangbeomdae.goddog.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
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
public class LoginForm {
	@NotBlank(message = "아이디를 입력하여 주세요.")
	@Size(min = 6, max = 12, message = "아이디는 6~12자 사이여야 합니다.")
	private String loginId;
	
	@NotBlank(message = "비밀번호를 입력하여 주세요")
	@Size(min = 4, max = 16, message = "비밀번호는 4~16자 사이여야 합니다.")
	private String passwd;
	
	private Boolean loginType;
	
}





