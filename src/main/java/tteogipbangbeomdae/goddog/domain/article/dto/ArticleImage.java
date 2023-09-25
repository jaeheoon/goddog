package tteogipbangbeomdae.goddog.domain.article.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * ArticleImage DTO 구현
 *
 * @author  떡잎방범대 최은비
 * @since   2023. 09. 18.
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ArticleImage {
	
	private int imgNo; //이미지 고유 번호
	private String img; //이미지 이름
	private int reviewNo; //연관된 리뷰 번호
	private String memberId; //올린이
	private int noticeNo; //게시판번호
}
