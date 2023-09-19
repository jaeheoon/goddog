package tteogipbangbeomdae.goddog.reservation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.reservation.mapper.ReservationMapper;
import tteogipbangbeomdae.goddog.domain.web.dto.PageParams;

@SpringBootTest
@Slf4j
public class ReservationMapperTest {
	
	@Autowired
	private ReservationMapper reservationMapper;
	
	@Test
	@Disabled
	@DisplayName("회원아이디에 해당하는 봉사내역들 불러오기")
	public void getAllReservationByIdTest() {
		//given

		String memberId = "bangry";
		int count = reservationMapper.getCountById(memberId);
		PageParams pageParams1 = PageParams.builder()
				  .elementSize(5)
				  .pageSize(5)
				  .requestPage(1)
				  .rowCount(count)
				  .build();
		//when
		List<Reservation> reservations = reservationMapper.getAllReservationById(pageParams1,memberId);
		//then
		log.info("들어온 봉사내역들 {}",reservations);
		assertThat(reservations).isNotNull();
	}
	
	@Test
	@DisplayName("봉사 내역 등록")
	public void createReservationTest() {
		Reservation reservation = Reservation.builder()
											.memberId("bangry")
											.careNo(1)
											.regtime("09:00~13:00")
											.regdate("2023-09-16")
											.people(4)
											.build();
		reservationMapper.createReservation(reservation);
	}
	
	@Test
	@Disabled
	@DisplayName("보호소별 예약 인원")
	public void getReservationCountTest() {
		log.info("인원 수 : " + reservationMapper.getReservationCount(3));
	}
	
	@Test
	@Disabled
	@DisplayName("봉사 예약 결과 불러오기")
	public void getReservationTest() {
		Reservation reservation = Reservation.builder()
				.memberId("bangry")
				.regdate("2023-09-27")
				.regtime("9:00 ~ 13:00")
				.careNo(3)
				.build();
		System.out.println(reservationMapper.getReservation(reservation));
	}
	
	@Test
	@Disabled
	@DisplayName("해당하는 보호소의 봉사현황갯수")
	public void getCountByCareNoTest() {
		//given
		int careNo = 1;
		//when
		int count = reservationMapper.getCountAllByCareNo(careNo);
		//then
		log.info("찾아온 행 갯수 : {} ",count);
	}
	
	@Test
	@Disabled
	@DisplayName("해당하는 보호소의 봉사현황 리스트 불러오기")
	public void getReservationByCareNoTest() {
		//given
		PageParams pageParams = PageParams.builder()
										  .elementSize(5)
										  .requestPage(1)
										  .build();
		int careNo = 1;
		//when
		List<Reservation> list = reservationMapper.getReservationByCareNo(pageParams,careNo);
		//then
		for (Reservation reservation : list) {
			log.info("불러들인 봉사현황 리스트 내용 : {}",reservation.toString());
		}
	}
	
	@Test
	@Disabled
	@DisplayName("봉사예약상태를 승인으로 변경")
	public void updateAgreeReservationTest() {
		//given
		int reservationNo = 148;
		//when
		boolean result = reservationMapper.updateAgreeReservation(reservationNo);
		//then
		log.info("업데이트 결과 : {}", result);
		assertThat(result).isTrue();
	}
	
	@Test
	@Disabled
	@DisplayName("봉사예약상태를 거절로 변경")
	public void updateCancelReservationTest() {
		//given
		int reservationNo = 148;
		//when
		boolean result = reservationMapper.updateCancelReservation(reservationNo);
		//then
		log.info("업데이트 결과 : {}", result);
		assertThat(result).isTrue();
	}
	
	@Test
	@Disabled
	@DisplayName("봉사예약상세정보 불러오기")
	public void getReservationDetailTest() {
		//given
		int reservationNo = 257;
		//when
		Reservation result = reservationMapper.getReservationDetail(reservationNo);
		//then
		log.info("불러온 상세정보 : {}", result);
	}
	
	@Test
	@Disabled
	@DisplayName("회원이름으로 후원내역갯수 찾아오기")
	public void getCountByIdTest() {
		//given
		String memberId = "bangry";
		//when
		int count = reservationMapper.getCountById(memberId);
		//then
		log.info("들어온 갯수 : {}",count);
	}
	
	
}
