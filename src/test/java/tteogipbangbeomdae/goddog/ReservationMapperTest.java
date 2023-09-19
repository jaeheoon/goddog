package tteogipbangbeomdae.goddog;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.reservation.mapper.ReservationMapper;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;

@SpringBootTest
@Slf4j
public class ReservationMapperTest {
	
	@Autowired
	private ReservationMapper reservationMapper;
	
	@Test
	@Disabled
	public void createReservationTest() {
		int careNo = 1; 
		String regdate ="2023. 01. 25"; 
		String regtime ="13:00 ~ 18:00";
		int people = 3; 
		String memberId= "bangry";
		
//		boolean result = reservationMapper.createReservation(regtime, regdate, people, memberId, careNo);
		
//		log.info("봉사활동 예약 생성 : {}", result);
	}
	
}