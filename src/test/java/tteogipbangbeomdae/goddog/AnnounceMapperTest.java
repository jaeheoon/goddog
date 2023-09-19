package tteogipbangbeomdae.goddog;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.announce.dto.Announce;
import tteogipbangbeomdae.goddog.domain.announce.mapper.AnnounceMapper;

/**
 * AnnounceMapperTest
 * 전체 공지사항 조회하기
 * @author 떡잎방범대 신혜원
 */

@SpringBootTest
@Slf4j
public class AnnounceMapperTest {
	
	@Autowired
	private AnnounceMapper announceMapper;
	
	@Test
	@Disabled
	public void questionAskTest() {
		
		List<Announce> announces = announceMapper.questionAnswer();
		log.info("들어왔남?? : {}", announces);
		assertThat(announces).isNotNull();
		
	}
	
	

}
