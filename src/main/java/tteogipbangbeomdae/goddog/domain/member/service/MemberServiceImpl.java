package tteogipbangbeomdae.goddog.domain.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;
import tteogipbangbeomdae.goddog.domain.member.mapper.MemberMapper;

/**
 * 
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 13.
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberMapper memberMapper;
	
	/**
	 * 회원 생성
	 */
	@Override
	@Transactional
	public void register(Member member) {
		memberMapper.create(member);
	}
	
	/**
	 * 아이디 & 패스워드로 회원찾기
	 */
	@Override
	public Member isMember(String id, String passwd) {
		return memberMapper.findByIdAndPasswd(id, passwd);
	}
	
	/**
	 * 아이디로만 회원찾기
	 */
	@Override
	public Member getMember(String id) {
		return memberMapper.findById(id);
	}


}
