package tteogipbangbeomdae.goddog.domain.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tteogipbangbeomdae.goddog.domain.member.dto.Member;

/**
 * 
 * 회원관리를 위한 맵퍼
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09.13
 * @version 1.0
 */
@Mapper
public interface MemberMapper {
	
	/**
	 * 받은 회원아이디로 실제 db에 저장된 회원정보 가져오기
	 * @param id 입력받은 아이디
	 * @return 찾아온 멤버
	 */
	public Member findById(String id);
	
	/**
	 * 받은 회원 아이디와 비밀번호로 회원정보 가져오기
	 * @param id 입력받은 아이디
	 * @param passwd 입력받은 비밀번호
	 * @return 찾아온 멤버
	 */
	public Member findByIdAndPasswd(@Param("memberId") String id, @Param("passwd") String passwd);
	
	/**
	 * 받은 정보를 토대로 회원을 DB에 저장
	 * @param member 입력받은 정보를 토대로 만들어진 멤버객체
	 */
	public void create(Member member);
	
}







