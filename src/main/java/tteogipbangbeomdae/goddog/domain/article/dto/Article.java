package tteogipbangbeomdae.goddog.domain.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * Article DTO클래스
 *
 * @author  떡잎방범대 신혜원, 최은비
 * @since   2023. 09. 10.
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Article {
	
	private int reviewNo; //리뷰 고유번호
	private String memberId; //작성자 아이디
	private int noticeNo; //작성된 글의 게시판 번호
	private String reviewTitle; //제목
	private String reviewContents; //내용
	private int count; //조회수
	private String writeDate; //작성일
	private int groupNo; //댓글과 작성된글을 하나의 그룹으로 합쳐주는 번호
	private int levelNo; //그룹내의 작성글과 댓글의 구분 0이 작성글 1은 댓글
	private int orderNo; //그룹내의 순서
	private int commentCount; //작성된 글의 댓글 갯수

}
