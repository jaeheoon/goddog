package tteogipbangbeomdae.goddog.donahistory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.donahistory.dto.Donahistory;
import tteogipbangbeomdae.goddog.domain.donahistory.mapper.DonahistoryMapper;
/**
 * 
 * DonahistoryMapper가 정상 작동 하는지 테스트하는 클래스
 *
 * @author  떡잎방범대 조영호
 * @since   2023-09-12
 * @version 1.0
 */
@SpringBootTest
@Slf4j
public class DonahistoryMapperTest {
	
	@Autowired
	private DonahistoryMapper donahistoryMapper;
	
	@Test
	@Disabled
	@DisplayName("회원이름으로 후원내역찾아오기")
	public void findbyIdTest() {
		//given
		String memberId = "bangry";
		//when
//		List<Donahistory> list = donahistoryMapper.findAllById(memberId);
		//then
//		log.info("들어온 도네이션 히스토리 {}",list);
//		assertThat(list).isNotNull();
	}
	
	@Test
//	@Disabled
	@DisplayName("회원이름으로 후원내역갯수 찾아오기")
	public void getCountByIdTest() {
		//given
		String memberId = "bangry";
		//when
		int count = donahistoryMapper.getCountById(memberId);
		//then
		log.info("들어온 갯수 : {}",count);
	}
	
	@Test
	@Disabled
	void createTest() {
		 Donahistory createDonahistory = Donahistory
				 .builder()
				 .donation(10000)
				 .memberId("bangry")
				 .build();
		 donahistoryMapper.create(createDonahistory);
			log.info("후원 내역 등록 완료 : {}", createDonahistory);
			
	}

}
