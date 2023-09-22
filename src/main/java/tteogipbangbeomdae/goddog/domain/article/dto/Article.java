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
	
	private int reviewNo;
	private String memberId;
	private int noticeNo;
	private String reviewTitle;
	private String reviewContents;
	private int count;
	private String writeDate;
	private int groupNo;
	private int levelNo;
	private int orderNo;

}
