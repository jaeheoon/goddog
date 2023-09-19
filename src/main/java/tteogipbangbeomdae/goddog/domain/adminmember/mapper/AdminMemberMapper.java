package tteogipbangbeomdae.goddog.domain.adminmember.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tteogipbangbeomdae.goddog.domain.adminmember.dto.AdminMember;

@Mapper
public interface AdminMemberMapper {

	//public AdminMember findAdminId(String id);

	public AdminMember findAdminIdAndPasswd(@Param("memberId") String id, @Param("passwd") String passwd);

}