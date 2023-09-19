package tteogipbangbeomdae.goddog.web.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 오류코드와 오류메시지 저장
 *
 * @author 에너자이조 김기정
 * @since 2023. 9. 5.
 * @version 1.0
 */
@AllArgsConstructor
@Data
public class ErrorResult {
	private String code;
	private String message;
}
