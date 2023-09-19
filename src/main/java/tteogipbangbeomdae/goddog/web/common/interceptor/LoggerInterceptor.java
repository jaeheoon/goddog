package tteogipbangbeomdae.goddog.web.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 로그 기록 인터셉터 구현
 * 스프링은 스프링컨테이너에 빈을 등록하는게 xml, 어노테이션, java파일(인터셉터의 경우)
 * WebConfig.java로 빈을 등록함.
 * 
 * @author 에너자이조 김기정
 * @since 2023. 9. 4.
 * @version 1.0
 */
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestURI = request.getRequestURI();

		// @Controller가 아니라 /resources/static와 같은 정적 리소스 요청의 경우, ResourceHttpRequestHandler가 핸들러 정보로 전달된다.
		if (handler instanceof ParameterizableViewController) {
			// @Controller , @RequestMapping을 활용한 핸들러 매핑 시 핸들러 정보로 HandlerMethod 전달된다.
			// 호출할 세부 컨트롤러 메서드의 모든 정보가 포함되어 있다.
			ParameterizableViewController handlerMethod = (ParameterizableViewController) handler;
			// log.info("세부 컨트롤러 정보 : {}", handlerMethod.toString());
		}
		log.info("[로그 인터셉터 실행] : HTTP 요청(세부 컨트롤러 호출 전) => {}, {}", requestURI, handler);
		//if문으로 true,false변경가능하게 로직구현가능 true는 세부컨트롤러 실행
		return true; // false 진행 X
	}
	
	//정상처리됐을때만 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info("[로그 인터셉터 실행] : HTTP 요청(세부 컨트롤러 호출 후) => {}", modelAndView);
	}
	
	//예외발생하던 말던 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)	throws Exception {
		String requestURI = request.getRequestURI();
		log.info("[로그 인터셉터 실행] : HTT 응답(뷰 렌더링 이후) => {}", requestURI);
		if (exception != null) {
			log.error("세부 컨트롤러 호출 후 오류 발생 : {}", exception);
		}
	}
}
