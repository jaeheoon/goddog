package tteogipbangbeomdae.goddog.web.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.web.member.exception.MemberException;

/**
 * 세부 컨트롤러에서 발생하는 예외 처리를 위한 공통 구현
 *
 * @author 에너자이조 김기정
 * @since 2023. 9. 5.
 * @version 1.0
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorResult exception4xxHandle(IllegalArgumentException ex) {
		log.error("[Client 요청 오류] : {}", ex);
		return new ErrorResult("CLIENT-ERROR", ex.getMessage());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ErrorResult exception5xxHandle(Exception ex) {
		log.error("[Server 응답 오류] : {}", ex);
		return new ErrorResult("SERVER-ERROR", ex.getMessage());
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResult> userExcptionHandle(MemberException ex) {
		log.error("[User 응답 예외] : {}", ex);
		ErrorResult errorResult = new ErrorResult("USER-EXCEPTION", ex.getMessage());
		return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
	}
}
