package tteogipbangbeomdae.goddog.domain.adminmember.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import tteogipbangbeomdae.goddog.domain.adminmember.dto.AdminMember;
import tteogipbangbeomdae.goddog.domain.adminmember.mapper.AdminMemberMapper;

/**
 * 
 * 센터관리회원 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 14
 * @version 버전
 */
@RequiredArgsConstructor
@Service
public class AdminMemberServiceImpl implements AdminMemberService{
	
	private final AdminMemberMapper adminMemberMapper;
	
	/**
	 * 관리자의 아이디와 비밀번호를 기준으로 실제 존재하는지 찾아오는 메소드
	 */
	public AdminMember isAdminMember(String id, String passwd) {
		return adminMemberMapper.findAdminIdAndPasswd(id, passwd);
	}

}
