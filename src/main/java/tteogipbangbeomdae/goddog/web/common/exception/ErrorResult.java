package tteogipbangbeomdae.goddog.web.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 오류코드와 오류메시지 저장
 * 발표시엔 사용안하고 개발단계에서만 사용
 *
 * @author 떡잎방범대 조영호
 * @since 2023. 9. 5.
 * @version 1.0
 */
@AllArgsConstructor
@Data
public class ErrorResult {
	private String code;
	private String message;
}
