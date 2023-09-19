package tteogipbangbeomdae.goddog.domain.adminmember.service;

import tteogipbangbeomdae.goddog.domain.adminmember.dto.AdminMember;

/**
 * 센터관리회원 관련 비즈니스 로직 처리 및 트랜잭션 관리
 */
public interface AdminMemberService {
	
//	public void register(Member member);
	public AdminMember isAdminMember(String id, String passwd);
//	public List<Member> getMemberList();
//	public AdminMember getAdminMember(String id);
//	public void editMember(Member member);

}
