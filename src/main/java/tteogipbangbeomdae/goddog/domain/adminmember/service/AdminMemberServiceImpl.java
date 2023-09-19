package tteogipbangbeomdae.goddog.domain.adminmember.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import tteogipbangbeomdae.goddog.domain.adminmember.dto.AdminMember;
import tteogipbangbeomdae.goddog.domain.adminmember.mapper.AdminMemberMapper;

@RequiredArgsConstructor
@Service
public class AdminMemberServiceImpl implements AdminMemberService{
	
	private final AdminMemberMapper adminMemberMapper;
	
	public AdminMember isAdminMember(String id, String passwd) {
		return adminMemberMapper.findAdminIdAndPasswd(id, passwd);
	}

}
