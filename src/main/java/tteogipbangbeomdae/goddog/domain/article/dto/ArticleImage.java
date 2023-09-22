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
	
	private int imgNo;
	private String img;
	private int reviewNo;
	private String memberId;
	private int noticeNo;
}
