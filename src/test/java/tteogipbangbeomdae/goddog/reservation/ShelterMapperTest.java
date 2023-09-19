package tteogipbangbeomdae.goddog.reservation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.reservation.mapper.ReservationMapper;
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
	
}
