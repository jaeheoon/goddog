package tteogipbangbeomdae.goddog.reservation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.reservation.service.ReservationService;

@SpringBootTest
@Slf4j
public class ReservationServiceTest {
	
	@Autowired
	private ReservationService reservationService;
	
	@Test
//	@Disabled
	@DisplayName("봉사 내역 불러오기")
	public void isReservationTest() {
		Reservation reservation = Reservation.builder()
											.memberId("bangry")
											.regdate("2023-09-15")
											.regtime("09:00 ~ 13:00")
											.people(5)
											.careNo(3)
											.build();
		reservationService.isReservation(reservation);
	}
	
	@Test
	@Disabled
	public void getReservationCountTest() {
		reservationService.getReservationCount(3);
	}
}
