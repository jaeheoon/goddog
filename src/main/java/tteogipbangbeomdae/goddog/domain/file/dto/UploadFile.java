package tteogipbangbeomdae.goddog.domain.file.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UploadFile {
	
	private String uploadFileName; //업로드된 실제파일이름
	private String storeFileName; //저장된 파일이름
}
