package tteogipbangbeomdae.goddog.domain.dog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * OpenApi로 강아지 품종 정보 불러와서 저장하는 클래스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 21.
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DogKind {
	
	private String kindCd;		//품종번호
	private String knm;			//품종이름
	
}
