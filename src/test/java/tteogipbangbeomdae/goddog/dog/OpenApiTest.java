package tteogipbangbeomdae.goddog.dog;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.area.dto.Area;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
import tteogipbangbeomdae.goddog.domain.dog.dto.DogKind;
import tteogipbangbeomdae.goddog.domain.openapi.service.OpenApiService;

@SpringBootTest
@Slf4j
public class OpenApiTest {
	
	@Autowired
	private OpenApiService openApiService;
	
	@Test
	@Disabled
	void listTest() {
		List<Dog> dogs = openApiService.getDogIndexList();
		for (int i = 0; i < dogs.size(); i++) {
			log.info("강아지 정보 : " + dogs.get(i));
		}
	}
	
	void searchTest() {
		
	}
	
	@Test
	@Disabled
	void areaListTest() {
		List<Area> list = openApiService.getAreaList();
		for (Area area : list) {
			log.info("지역 정보 : {}", area);
		}
	}
	
	@Test
	@Disabled
	void DogKindListTest() {
		List<DogKind> list = openApiService.getDogKindList();
		for (DogKind dogKind : list) {
			log.info("품종 정보 : {}", dogKind);
		}
	}
	
	@Test
//	@Disabled
	void shelterDogListTest() {
		List<Dog> list = openApiService.getShelterDogList(1, "1", false);
		for (Dog dog : list) {
			log.info("강아지 사진, 번호 : {}", dog);
		}
	}
}
