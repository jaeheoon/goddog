package tteogipbangbeomdae.goddog.domain.adminmember.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 센터관리자를 담기위한 객체
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 14.
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class AdminMember {
	
	//관리자 계정의 아이디
	private String memberId;
	
	//관리자 계정의 비밀번호
	private String passwd;
	
	//관리하는 보호소 이름
	private String shelterName;
	
	//관리하는 보호소의 번호
	private int careNo;
	
	//일반회원과의 차이 (보호소관리자 2)
	private String lev;
	
}
