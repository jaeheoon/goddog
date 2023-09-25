package tteogipbangbeomdae.goddog.web.introduce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * /introduce관련 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 9. 10.
 * @version 1.0
 */
@Controller
@RequestMapping("/introduce")
public class IntroduceController {
	
	/**
	 * 기업소개 페이지 뷰로 이동
	 * @param model
	 * @return 기업소개 페이지 뷰이름
	 */
	@GetMapping("")
	public String showIntroduce(Model model) {
		return "introduce/introduce";
	}
	
	/**
	 * 팀소개 페이지 뷰로 이동
	 * @param model
	 * @return 팀소개 페이지 뷰이름
	 */
	@GetMapping("/team")
	public String showTeam(Model model) {
		return "introduce/team";
	}
}
