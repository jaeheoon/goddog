package tteogipbangbeomdae.goddog.domain.donahistory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 도네이션(후원)관련 C.R.U.D를 위한 bean객체
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 12.
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Donahistory {
	
	//도네이션 번호
	private int donahistoryNo;
	
	//도네이션한 멤버
	private String memberId;
	
	//도네이션한 금액
	private int donation;
	
	//도네이션한 날짜
	private String donationDate;
	
}
