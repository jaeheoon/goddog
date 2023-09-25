package tteogipbangbeomdae.goddog.domain.adminmember.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tteogipbangbeomdae.goddog.domain.adminmember.dto.AdminMember;

/**
 * 
 * 관리자계정을 위한 mapper
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 14
 * @version 1.0
 */
@Mapper
public interface AdminMemberMapper {
	
	/**
	 * 입력된 id,passwd로 회원 찾기
	 * 
	 * @param id 로그인시도중인 id
	 * @param passwd 로그인 시도중인 passwd
	 * @return 찾아온 회원
	 */
	public AdminMember findAdminIdAndPasswd(@Param("memberId") String id, @Param("passwd") String passwd);

}