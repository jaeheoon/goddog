package tteogipbangbeomdae.goddog.domain.member.service;

import tteogipbangbeomdae.goddog.domain.member.dto.Member;

/**
 * 
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 13.
 * @version 1.0
 */
public interface MemberService {
	
	/**
	 * 입력받은 회원정보로 가입.
	 * @param member 입력반은정보로 만들어진 멤버객체
	 */
	public void register(Member member);
	
	/**
	 * 입력받은 회원 아이디와 비밀번호로 회원찾기
	 * @param id 아이디
	 * @param passwd 비밀번호
	 * @return 찾아온 회원
	 */
	public Member isMember(String id, String passwd);
	
	/**
	 * 입력받은 회원아이디로 해당하는 회원 찾아오기
	 * @param id 아이디
	 * @return 찾아온 회원
	 */
	public Member getMember(String id);

}
