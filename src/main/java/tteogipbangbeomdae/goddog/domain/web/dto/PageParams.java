package tteogipbangbeomdae.goddog.domain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 페이지 계산에 필요한 정보들 포장
 * @author 홍재헌
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageParams {
	private int elementSize;    /** 페이지에 보여지는 목록(게시판 제목) 갯수 */
	private int pageSize;       /** 페이지에 보여지는 페이지(1, 2, 3, 4, 5) 갯수 */
	private int requestPage;    /** 사용자 요청 페이지 */
	private String searchValue;     /** 사용자 검색값 */
	private String searchType; /** 사용자 검색타입 */
	private int rowCount;       /** 검색된 행의 수 */
}
