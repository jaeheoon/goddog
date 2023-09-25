package tteogipbangbeomdae.goddog.domain.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.reservation.mapper.ReservationMapper;
import tteogipbangbeomdae.goddog.domain.shelter.mapper.ShelterMapper;
import tteogipbangbeomdae.goddog.domain.web.dto.PageParams;

/**
 * 봉사예약 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * 
 * @author 떡잎방범대 홍재헌(봉사생성담당), 조영호(봉사내역관리담당)
 * @since 2023. 9. 14.
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

	private final ReservationMapper reservationMapper;
	private final ShelterMapper shelterMapper;

	//-------------------------------------------조영호 작업------------------------------------------------
	
	// 회원 아이디로 페이징처리된 봉사목록 찾아오기
	@Override
	public List<Reservation> findAllReservationById(PageParams pageParams, String memberId) {
		List<Reservation> reservationList = reservationMapper.getAllReservationById(pageParams, memberId);
		return reservationList;
	}

	// 페이징처리를 위해 센터번호로 봉사목록 갯수 찾아오기
	@Override
	public int getCount(int careNo) {
		return reservationMapper.getCountAllByCareNo(careNo);
	}

	// 페이징처리된 센터별 봉사목록들 찾아오기
	@Override
	public List<Reservation> getReservationList(PageParams pageParams, int careNo) {
		return reservationMapper.getReservationByCareNo(pageParams, careNo);
	}

	// 봉사예약 승인처리
	@Override
	@Transactional
	public boolean agreeUpdate(int reservationNo) {
		return reservationMapper.updateAgreeReservation(reservationNo);
	}

	// 봉사예약 거절처리
	@Override
	@Transactional
	public boolean cancelUpdate(int reservationNo) {
		return reservationMapper.updateCancelReservation(reservationNo);
	}

	// 봉사예약 상세정보
	@Override
	public Reservation getReservation(int reservationNo) {
		return reservationMapper.getReservationDetail(reservationNo);
	}
	
	// 회원의 총 내역갯수
	@Override
	public int getReserCountById(String memberId) {
		return reservationMapper.getCountById(memberId);
	}
	
	// 보호소의 총 내역갯수
	@Override
	public int getReservationCount(int careNo) {
		if (reservationMapper.getReservationCount(careNo) != null) {
			return reservationMapper.getReservationCount(careNo);
		} else {
			return 0;
		}
	};
	
	// 봉사 내역 삭제
	@Override
	@Transactional
	public boolean deleteReservation(int reservationNo) {
		return reservationMapper.deleteReservation(reservationNo);
	}
	
	// 봉사 내역을 위해 상세정보 가져오기
	@Override
	public Reservation getReservaionInfo(int reservationNo) {
		return reservationMapper.getReservationByNo(reservationNo);
	}
	
	// 새로 작성된 reservation을 기준으로 업데이트 후 변경된 reservation 반환
	@Override
	@Transactional
	public Reservation updateReservationInfo(Reservation reservation) {
		//먼저 들어온 값으로 업데이트
		reservationMapper.updateReservation(reservation);		
		//업데이트된 레저베이션 반환
		return reservationMapper.getReservation(reservation);
	}
	
	// 보호소의 특정날짜에 봉사예약한 총 인원수 반환
	@Override
	public int getAllpeople(int careNo, String formattedDate) {
		
		return reservationMapper.getCountByDate(careNo, formattedDate);
	}
	
	// 보호소의 최대 수용할수 있는 봉사 인원 수 반환
	@Override
	public int getMaxCount(int careNo) {
		return reservationMapper.getMaxCountInshelter(careNo);
	}
	
	// 보호소의 휴무일을 반환
	@Override
	public String getClosedayByCareNo(int careNo) {
		return reservationMapper.getCloseday(careNo);
	}
	
	//----------------------------------------------조영호 작업 끝--------------------------------------------------
	
	/**
	 * @author 홍재헌(생성및 출력을 위한 로직작성), 조영호(업데이트관련만 추가)
	 * @version 2.0 current-update 2023.09.20(조영호 업데이트추가)
	 */
	@Override
	@Transactional
	public Reservation isReservation(Reservation reservation) {
		if (reservationMapper.getReservation(reservation) == null) {
			reservationMapper.createReservation(reservation);
			Reservation resultReservation = reservationMapper.getReservation(reservation);
			Reservation reservation2 = Reservation.builder().memberId(resultReservation.getMemberId())
					.insertDate(resultReservation.getInsertDate()).regdate(resultReservation.getRegdate())
					.regtime(resultReservation.getRegtime()).people(resultReservation.getPeople())
					.careNo(resultReservation.getCareNo())
					.shelterName(shelterMapper.selectShelter(resultReservation.getCareNo()).getName()).build();
			return reservation2;
		} else {
			reservationMapper.updateReservation(reservation);
			Reservation resultReservation = reservationMapper.getReservation(reservation);
			Reservation reservation2 = Reservation.builder().memberId(resultReservation.getMemberId())
					.insertDate(resultReservation.getInsertDate()).regdate(resultReservation.getRegdate())
					.regtime(resultReservation.getRegtime()).people(resultReservation.getPeople())
					.careNo(resultReservation.getCareNo())
					.shelterName(shelterMapper.selectShelter(resultReservation.getCareNo()).getName()).build();
			return reservation2;
		}
	}
	
	

}
