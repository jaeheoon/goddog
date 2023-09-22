package tteogipbangbeomdae.goddog.domain.reservation.service;


import java.util.List;

import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.web.dto.PageParams;

/**
 * 봉사예약 관련 비즈니스 인터페이스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 14.
 * @version 1.0
 */
public interface ReservationService {
	
	//로그인한 회원의 봉사내역을 불러오는 메소드 명세
	public List<Reservation> findAllReservationById(PageParams pageParams,String memberId);
	
	//로그인한 회원의 봉사갯수를 불러오는명세
	public int getReserCountById(String memberId);
	
	//페이징 처리를 위한 행 갯수 받아오는 명세
	public int getCount(int careNo);
	
	//페이징 처리된 특정보호소 봉사예약 리스트 불러오기
	public List<Reservation> getReservationList(PageParams pageParams, int careNo);
	
	//봉사예약 상태 승인으로 변경
	public boolean agreeUpdate(int reservationNo);
	
	//봉사예약 상태 거절로 변경
	public boolean cancelUpdate(int reservationNo);
	
	//봉사신청 상세정보 불러오는 명세
	public Reservation getReservation(int reservationNo);
	
	/** 봉사 예약 등록 */
	public Reservation isReservation(Reservation reservation);
	
	/** CareNo로 봉사 예약 총 인원 수 검색 */
	public int getReservationCount(int careNo);
	
	/** 봉사예약정보 삭제 */
	public boolean deleteReservation(int reservationNo);
	
	/** 예약번호로 해당 예약정보 불러오기 */
	public Reservation getReservaionInfo(int reservationNo);
	
	/** 레저베이션 업데이트 */
	public Reservation updateReservationInfo(Reservation reservation);
	
	/** 센터번호와 해당날짜로 봉사신청인원 가져오기 */
	public int getAllpeople(int careNo, String formattedDate);
	
	/** 특정센터의 봉사최대인원 가져오기 */
	public int getMaxCount(int careNo);
	
	/** 특정센터 휴무일 가져오기 */
	public String getClosedayByCareNo(int careNo);
	
	
}