package tteogipbangbeomdae.goddog.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;
import tteogipbangbeomdae.goddog.domain.member.service.MemberService;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void isMemberTest() {
		String id = "bangry", passwd = "1111";
//		Member loginMember = memberService.isMember(id, passwd);
//		log.info("로그인 사용자 정보 : {}", loginMember);
	}
}







