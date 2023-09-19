package tteogipbangbeomdae.goddog.domain.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tteogipbangbeomdae.goddog.domain.member.dto.Member;
import tteogipbangbeomdae.goddog.domain.member.dto.MemberSearchCondition;

@Mapper
public interface MemberMapper {
	
//	public List<Member> findByAll();
	
	public Member findById(String id);
	
	public Member findByIdAndPasswd(@Param("memberId") String id, @Param("passwd") String passwd);
	
//	public List<Member> findByNameLike(String name);
	
	public void create(Member member);
	
//	public void update(Member member);
	
	// 검색 타입별 회원 검색
//	public List<Member> findBySearchType(@Param("type") String type, @Param("value") String value);
	
	// 통합 검색
//	public List<Member> findBySearchAll(String value);
	
	// 통합 검색
//	public List<Member> findBySearchAllOption(MemberSearchCondition searchCondition);

}







