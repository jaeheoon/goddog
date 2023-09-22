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
	
	private String uploadFileName;
	private String storeFileName;
}
