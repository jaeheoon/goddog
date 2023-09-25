package tteogipbangbeomdae.goddog.domain.donahistory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tteogipbangbeomdae.goddog.domain.donahistory.dto.Donahistory;
import tteogipbangbeomdae.goddog.domain.web.dto.PageParams;

/**
 * 도네이션 관련 DB작업을 실행하는 Mapper인터페이스 xml파일에 해당하는 메소드를 맵핑하여 DB작업 수행
 *
 * @author  떡잎방범대 조영호(회원정보관련담당),문승욱(생성담당)
 * @since  	2023. 09. 18.
 * @version 1.0
 */
@Mapper
public interface DonahistoryMapper {
	
	//로그인한 회원 아이디에 해당하는 후원내역 리스트
	public List<Donahistory> findAllById(@Param("pageParams")PageParams pageParams ,@Param("memberId") String memberId);
	
	//로그인한 회원 아이디에 해당하는 후원내역 갯수
	public int getCountById(String memeberId);
	
	//생성
	public void create(Donahistory donahistory);
	
}
