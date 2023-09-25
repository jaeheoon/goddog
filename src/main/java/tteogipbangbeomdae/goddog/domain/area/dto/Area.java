package tteogipbangbeomdae.goddog.domain.area.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * OpenApi 이용하여 지역 정보 불러와서 저장하는 클래스
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
public class Area {
	
	private String orgCd;			//시도코드
	private String orgdownNm;		//시도명
	
}
