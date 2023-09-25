package tteogipbangbeomdae.goddog.domain.common.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 페이지 계산에 필요한 정보를 담기 위한 객체
 *
 * @author  떡잎방범대 신혜원, 최은비
 * @since   2023. 09. 10.
 * @version 1.0
 */
@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageParams {
	
	private int elementSize;    /** 페이지에 보여지는 목록 갯수 */
	private int pageSize;       /** 페이지에 보여지는 페이지 갯수 */
	private int requestPage;    /** 사용자 요청 페이지 */
	private String searchValue;     /** 사용자 검색값 */
	private String searchType; /** 사용자 검색타입 */
	private int rowCount;       /** 테이블 목록 갯수 */
}
