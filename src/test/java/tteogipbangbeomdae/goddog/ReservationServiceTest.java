package tteogipbangbeomdae.goddog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;
import tteogipbangbeomdae.goddog.domain.member.service.MemberService;
import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.reservation.service.ReservationService;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import tteogipbangbeomdae.goddog.domain.shelter.service.ShelterService;

@SpringBootTest
@Slf4j
public class ReservationServiceTest {
	
	@Autowired
	private ReservationService reservationService;
	
	@Test
	public void isReservationTest() {
		String regtime = "14:00 ~ 18:00";
		String regdate = "2023. 10. 10";
		int people = 3;
		String memberId = "bangry";
		int careNo = 1;
//		boolean myReservation = reservationService.isReservation(regtime, regdate, people, memberId, careNo);
//		log.info("예약 여부 : {}", myReservation);
		
	}
}







