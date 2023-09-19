package tteogipbangbeomdae.goddog.domain.member.service;

import java.util.List;

import tteogipbangbeomdae.goddog.domain.member.dto.Member;


/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리
 */
public interface MemberService {
	
	public void register(Member member);
	public Member isMember(String id, String passwd);
//	public List<Member> getMemberList();
	public Member getMember(String id);
//	public void editMember(Member member);

}
