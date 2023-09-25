package tteogipbangbeomdae.goddog.domain.shelter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 보호소관련 정보를 담기 위한 객체
 *
 * @author  떡잎방범대 문승욱, 홍재헌
 * @since   날짜
 * @version 버전
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Shelter{

	private int careNo; //보호소 고유번호
	private String name; //보호소 이름
	private String adress; //보호소 주소
	private String tel; //보호소 전화번호
	private String closeday; //보호소 닫는날
	private int mans; //보호소 가능한 최대봉사인원수
	private String open; //시작시간
	private String close; //끝나는 시간
	private String volunteerAm; //봉사 예약 오전반 시간
	private String volunteerPm; //봉사 예약 오후반 시간
	private String mapUrl; //해당 보호소 위치 URL
	private String introduction; //소개문구
	private String etc; //한줄소개
	
	private int careImgNo; //보호소 이미지별 고유번호
	
	private String careImg; //보호소 소개이미지
	private String careImg1; //보호소 전경1
	private String careImg2; //보호소 전경2
	private String careImg3; //보호소 전경3
	private String careImg4; //보호소 전경4
	
	
}
