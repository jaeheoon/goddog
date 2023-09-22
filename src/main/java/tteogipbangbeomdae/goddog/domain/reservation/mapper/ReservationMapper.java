package tteogipbangbeomdae.goddog.domain.reservation.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.web.dto.PageParams;

/**
 * 
 * 봉사 관련 DB작업을 실행하는 Mapper인터페이스 xml파일에 해당하는 메소드를 맵핑하여 DB작업 수행
 *
 * @author  떡잎방범대 홍재헌
 * @since  	2023. 09. 14.
 * @version 버전
 */
@Mapper
public interface ReservationMapper {
	

	//로그인한 회원 아이디에 해당하는 봉사활동내역 불러오기
	public List<Reservation> getAllReservationById(@Param("pageParams")PageParams pageParams ,@Param("memberId") String memberId);
	
	//로그인한 회원 아이디에 해당하는 봉사활동내역 갯수
	public int getCountById(String memeberId);
	
	//특정 보호소의 봉사예약 현황 리스트 불러오기
	public List<Reservation> getReservationByCareNo(@Param("pageParams")PageParams pageParams, @Param("careNo") int careNo);
	
	//특정 보호소의 봉사예약 현황 총 갯수 가져오기
	public int getCountAllByCareNo(int careNo);
	
	//보호소에서 들어온 봉사예약 승인시 상태 업데이트하기
	public boolean updateAgreeReservation(int reservationNo);
	
	//보호소에서 들어온 봉사예약 거부시 상태 업데이트하기
	public boolean updateCancelReservation(int reservationNo);
	
	//보호소 상세페이지를 위한 봉사예약상세정보 불러오기
	public Reservation getReservationDetail(int reservationNo);

	//로그인한 회원 아이디에 해당하는 봉사활동내역 등록하기
	public void createReservation(Reservation reservation);
	
	//보호소 봉사 예약 인원 불러오기
	public Integer getReservationCount(@Param("careNo") Integer careNo);
	
	//날짜와 아이디로 보호소 예약 불러오기
	public Reservation getReservation(Reservation reservation);
	
	//선택된 정보로 해당 reservationNo의 reservation업데이트
	public void updateReservation(Reservation reservation);
	
	//reservationNo을 받아서 삭제
	public boolean deleteReservation(int reservationNo);
	
	//고유번호에 해당하는 레저베이션 정보 반환
	public Reservation getReservationByNo(int reservationNo);
	
	//해당하는 쉘터와 해당하는 날짜의 봉사인원수 반환
	public int getCountByDate(@Param("careNo") int careNo, @Param("formattedDate") String formattedDate);
	
	//해당쉘터의 최대 봉사인원 제한수 반환
	public int getMaxCountInshelter(int careNo);
	
	//해당쉘터의 휴무일 반환
	public String getCloseday(int careNo);
	
}
