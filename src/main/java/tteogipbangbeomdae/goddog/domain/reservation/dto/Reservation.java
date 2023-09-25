package tteogipbangbeomdae.goddog.domain.reservation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 
 * 봉사예약 신청과 봉사 체크여부를 담기 위한 bean객체
 *
 * @author  떡잎방범대 홍재헌, 조영호
 * @since   2023. 09. 14.
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Reservation{

   //신청 회원 정보 관련 속성
   private int reservationNo;
   private String memberId;
   private String memberName;
   private int people;
   private String insertDate;
   private String regdate;
   private String regtime;
   private String status;
   private String memberPhoneNum;
   

   //신청 보호소 정보 관련 속성
   private int careNo;
   private String shelterName;
   private String telNum;
   
   
}
