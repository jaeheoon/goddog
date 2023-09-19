package tteogipbangbeomdae.goddog.domain.dog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Dog {
	private String desertionNo;		//번호
	private String happenDt;		//접수일
	private String happenPlace;		//발견장소
	private String orgNm;			//시군구
	private String kindCd;			//품종
	private String colorCd;			//색상
	private String age;				//나이
	private String weight;			//체중
	private String popfile;			//Image
	private String processState;	//보호중
	private String sexCd;			//성별
	private String neuterYn;		//중성화여부
	private String specialMark;		//특징
	private String careAddr;		//보호장소
	private String noticeNo;		//공고번호
	private String noticeComment;	//특이사항
	private String noticeSdt;		//공고시작일
	private String noticeEdt;		//공고종료일
	private Long totalCount;		//전체결과수
	
}
