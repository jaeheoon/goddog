package tteogipbangbeomdae.goddog.domain.file.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 이미지 파일을 담기위한 객체
 *
 * @author  떡잎방범대 최은비
 * @since   2023. 09. 18.
 * @version 1.0
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ArticleForm {
	
	private String title; //제목
	private String content; //내용
	private List<MultipartFile> uploadFiles; //업로드된 파일들
}