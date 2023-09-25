package tteogipbangbeomdae.goddog;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import tteogipbangbeomdae.goddog.domain.shelter.service.ShelterService;

@SpringBootTest
@Slf4j
public class ShelterServiceTest {
	
	@Autowired
	private ShelterService shelterService;
	
	@Test
	@Disabled
	public void clickShelterTest() {
		int careNo = 1;
		Shelter reserveShelter = shelterService.clickShelter(careNo);
		log.info("예약할 보호소 정보 : {}", reserveShelter);
	}
	
	@Test
	@Disabled
	public void findAllShelter() {
		List<Shelter> shelterlist = shelterService.findAllShelter();
		for (Shelter shelter : shelterlist) {
			log.info("가져온 쉘터 정보 : {}", shelter);
		}
	}
}







