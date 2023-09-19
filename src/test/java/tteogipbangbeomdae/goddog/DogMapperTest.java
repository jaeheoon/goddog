package tteogipbangbeomdae.goddog;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
import tteogipbangbeomdae.goddog.domain.openapi.service.OpenApiService;

@SpringBootTest
@Slf4j
public class DogMapperTest {
	
	@Autowired
	private OpenApiService openApiService;
	
//	@Test
//	@Disabled
//	void createTest() {
//		List<Dog> dogs = openApiService.getDogList();
//		for (int i = 0; i < dogs.size(); i++) {
//			log.info("강아지 정보 : " + dogs.get(i));
//		}
//	}
	
}
