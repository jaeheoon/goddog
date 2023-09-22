package tteogipbangbeomdae.goddog.web.shelter.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
import tteogipbangbeomdae.goddog.domain.openapi.service.OpenApiService;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import tteogipbangbeomdae.goddog.domain.shelter.service.ShelterService;

/**
 * /shelter관련 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 9. 10.
 * @author  떡잎방범대 문승욱
 * @since   2023. 9. 20.
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 22.
 * @version 1.0
 */
@Controller
@RequestMapping("/shelter")
@RequiredArgsConstructor
public class ShelterController {
	
	private final ShelterService shelterService;
	private final OpenApiService openApiService;
	
	@GetMapping
	public String showShelterList(Model model) {
		List<Shelter> list = shelterService.findAllShelter();
		model.addAttribute("list", list);
		return "shelter/shelter_list";
	}
	
	@GetMapping("/detail/{careNo}")
	public String showDetail(@PathVariable("careNo") int careNo, Model model) {
		Shelter shelter = shelterService.clickShelter(careNo);
		List<Dog> dogList = openApiService.getShelterDogList(careNo, false);
		model.addAttribute("shelter", shelter);
		model.addAttribute("dogList", dogList);
		return "shelter/shelter_detail";
	}
	
}



