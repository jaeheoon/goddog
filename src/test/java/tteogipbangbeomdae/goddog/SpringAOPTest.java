package tteogipbangbeomdae.goddog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;
import tteogipbangbeomdae.goddog.domain.member.service.MemberService;

@SpringBootTest
@Slf4j
public class SpringAOPTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void getMemberTest() {
//		Member member = memberService.getMember("bangry");
//		log.info("조회된 회원정보 : {}", member);
	}
	
}
