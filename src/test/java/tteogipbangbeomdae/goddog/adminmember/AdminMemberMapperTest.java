package tteogipbangbeomdae.goddog.adminmember;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.adminmember.dto.AdminMember;
import tteogipbangbeomdae.goddog.domain.adminmember.mapper.AdminMemberMapper;
import tteogipbangbeomdae.goddog.domain.donahistory.dto.Donahistory;
/**
 * 
 * AdminMemberMapper가 정상 작동 하는지 테스트하는 클래스
 *
 * @author  떡잎방범대 조영호
 * @since   2023-09-14
 * @version 1.0
 */
@SpringBootTest
@Slf4j
public class AdminMemberMapperTest {
	
	@Autowired
	private AdminMemberMapper adminMemberMapper;
	
	@Test
//	@Disabled
	@DisplayName("회원이름, 비밀번호로 로그인체크 후 로그인하기")
	public void findbyIdTest() {
		//given
		String memberId = "gooddog";
		String passwd = "1111";
		//when
		AdminMember adminMember = adminMemberMapper.findAdminIdAndPasswd(memberId,passwd);
		//then
		log.info("들어온 도네이션 히스토리 {}",adminMember);
		assertThat(adminMember).isNotNull();
	}

}
