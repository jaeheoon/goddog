package tteogipbangbeomdae.goddog.shelter;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import tteogipbangbeomdae.goddog.domain.shelter.mapper.ShelterMapper;

@SpringBootTest
@Slf4j
public class ShelterMapperTest {
	
	@Autowired
	private ShelterMapper shelterMapper;
	
	@Test
	@Disabled
	@DisplayName("봉사 예약 결과 불러오기")
	public void getReservationTest() {
		System.out.println(shelterMapper.selectShelter(3));
	}
	
	@Test
	@Disabled
	public void getShelterListTest() {
		List<Shelter> list = shelterMapper.getShelterList();
		for (Shelter shelter : list) {
			log.info("쉘터 정보 : {}", shelter);
		}
	}
	@Test
//	@Disabled
	public void selectShelterTest() {
		int careNo = 1;
		Shelter shelter = shelterMapper.selectShelter(careNo);
		log.info("보호소 정보 : {}", shelter.toString());
	}
	
}
