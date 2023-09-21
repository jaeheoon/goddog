package tteogipbangbeomdae.goddog.web.home.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
import tteogipbangbeomdae.goddog.domain.openapi.service.OpenApiService;

/**
 * 홈페이지 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 21.
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
	
	private final OpenApiService openApiService;
	
	@GetMapping("")
	public String home(Model model) {
		List<Dog> dogList = openApiService.getDogIndexList();
		int count = 0;
		Dog[][] dogArrayList = new Dog[2][3];
		for (int i = 0; i < dogList.size()/3; i++) {
			for (int j = 0; j < dogList.size()/2; j++) {
				dogArrayList[i][j] = dogList.get(count++);
			}
		}
		model.addAttribute("list", dogArrayList);
		return "index";
	}
}