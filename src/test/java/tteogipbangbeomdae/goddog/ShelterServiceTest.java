package tteogipbangbeomdae.goddog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;
import tteogipbangbeomdae.goddog.domain.member.service.MemberService;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import tteogipbangbeomdae.goddog.domain.shelter.service.ShelterService;

@SpringBootTest
@Slf4j
public class ShelterServiceTest {
	
	@Autowired
	private ShelterService shelterService;
	
	@Test
	public void clickShelterTest() {
		int careNo = 1;
		Shelter reserveShelter = shelterService.clickShelter(careNo);
		log.info("예약할 보호소 정보 : {}", reserveShelter);
	}
}







