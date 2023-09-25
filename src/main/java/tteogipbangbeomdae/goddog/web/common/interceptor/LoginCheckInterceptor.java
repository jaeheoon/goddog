package tteogipbangbeomdae.goddog.web.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * 로그인 체크 Interceptor 구현
 *
 * @author 떡잎방범대 조영호
 * @since 2023. 9. 4.
 * @version 1.0
 */
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		log.info("=> [로그인 체크 인터셉터 실행] : {}", requestURI);

		HttpSession session = request.getSession();
		// 로그인 하지 않은 요청인 경우
		if (session.getAttribute("loginMember") == null) {
			log.info("=> 로그인 하지 않은 사용자 요청으로 로그인 화면으로 리다이렉트");
			// 쿼리스트링이 존재하는 경우
			String queryString = request.getQueryString();
			log.info("들어온 쿼리스트링 [{}]",queryString);
			String redirectURI = queryString == null ? requestURI : requestURI + "?" + queryString;
			log.info("완성된URI [{}]",redirectURI);
			//세션에 redirectURI 설정
			session.setAttribute("redirectURI", redirectURI);
			// 로그인 화면으로 리다이렉트
			response.sendRedirect("/member/login");
			return false;
		}
		return true;
	}
}

