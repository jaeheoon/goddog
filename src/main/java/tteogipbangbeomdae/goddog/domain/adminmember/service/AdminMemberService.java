package tteogipbangbeomdae.goddog.domain.adminmember.service;

import tteogipbangbeomdae.goddog.domain.adminmember.dto.AdminMember;

/**
 * 
 * 센터관리회원 관련 비즈니스 로직 처리 및 트랜잭션 관리
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 13.
 * @version 버전
 */
public interface AdminMemberService {
	
	/**
	 * 
	 * @param id 입력받은 id
	 * @param passwd 입력받은 passwd
	 * @return
	 */
	public AdminMember isAdminMember(String id, String passwd);

}
