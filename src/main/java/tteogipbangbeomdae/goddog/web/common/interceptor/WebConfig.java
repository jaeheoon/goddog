package tteogipbangbeomdae.goddog.web.common.interceptor;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 인터셉터 등록 자바 설정 클래스 구현
 * 완성된 인터셉터 등록하는 역할 WebMvcConfigurer를 구현해야함.
 *
 * @author 떡잎방범대 조영호
 * @since 2023. 9. 12.
 * @version 1.0
 * @see  com.ezen.springmvc.web.common.interceptor.LoggerInterceptor
 * @see  com.ezen.springmvc.web.common.interceptor.LoginCheckInterceptor
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
//	public static final List<String> loginEssential = Arrays.asList("/**");
	
	public static final List<String> loginEssential = Arrays.asList("/donation/method/{path}","/donation/result/{path}",
																	"/article/volunteer/read","/article/adoption/read",
																	"/article/volunteer/create","/article/adoption/create",
																	"/article/comment","/article/volunteer/correct","/article/adoption/correct",
																	"/volunteer/delete","/adoption/delete","/member/mypage",
																	"/member/mypage/adminpage","/mypage/reser/{path}","/mypage/dona/{path}",
																	"/volunteer/agreement","/volunteer/calender","/volunteer/choice","/volunteer/result/{path}/{path}/{path}",
																	"/volunteer/result","/volunteer/detail/{path}","/volunteer/cancel/{path}",
																	"/reservation/agreeReservations","/reservation/cancelReservations",
																	"/reservation/agreeReservations/{path}","/reservation/cancelReservations/{path}");
	
	public static final List<String> loginNotEssential = Arrays.asList("/", "/**/*.ico", "/**/*.html", "/**/css/**", 
																		"/**/js/**", "/**/assets/**", "/error", "/member",
																		"/member/signup", "/member/login", "/member/logout",
																		"/member/valid/{path}", "/member/valid/{path}/{path}",
																		"/member/rest/{path}" ,"/**/img/**", "/**/video/**" ,
																		"/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js",
																		"/shelter/list","/shelter/detail","/introduce/introduce",
																		"/introduce/team","/article/adoption/board","/article/volunteer/board",
																		"/announce","/announce/announce","/introduce","/dog","/donation",
																		"/shelter","/volunteer","/dog/profile","/member/mypage/adminpage",
																		"/article/volunteer/board/{path}","/article/adoption/board/{path}","/{path}");

	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
		 // 세부 컨트롤러 로그 기록 인터셉터 등록
		 registry.addInterceptor(new LoggerInterceptor())
		 .order(1)
//		  하위 패스에 상관없이 모든 요청에 인터셉터 적용 
//		 .addPathPatterns("/**")
		 .addPathPatterns(loginEssential)
//		 인터셉터에서 제외할 패턴 설정
//		 .excludePathPatterns("/*.ico", "/*.html", "/css/**", "/vendor/**", "/error", "/**/assets/**", "/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"); 
		 .excludePathPatterns(loginNotEssential); 
		 
		 // 세부 컨트롤러 실행 전 로그인 체크 인터셉터 등록
		 registry.addInterceptor(new LoginCheckInterceptor())
		 .order(1)
		 .addPathPatterns(loginEssential)
		 .excludePathPatterns(loginNotEssential);
	}
}





