package tteogipbangbeomdae.goddog.web.dog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
import tteogipbangbeomdae.goddog.domain.openapi.service.OpenApiService;
import tteogipbangbeomdae.goddog.domain.web.dto.PageParams;
import tteogipbangbeomdae.goddog.domain.web.dto.Pagination;

/**
 * /dog관련 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 14.
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/dog")
public class DogController {
	
	private final OpenApiService openApiService;
	
	//보여지는 글 갯수(게시판 제목)
	private final int ELEMENT_SIZE = 9;
	
	//페이징처리 목록 갯수(1, 2, 3, 4, 5)
	private final int PAGE_SIZE = 5;
	
	@GetMapping("")
	public String showDog(@RequestParam(defaultValue = "1") String requestPage, Model model) {
		List<Dog> dog = openApiService.getDogList(requestPage);
		
		int rowCount = dog.get(0).getTotalCount().intValue();	//전체 강아지 마리수
		
		PageParams pageParams = PageParams.builder()
				.pageSize(PAGE_SIZE)
				.elementSize(ELEMENT_SIZE)
				.requestPage(Integer.parseInt(requestPage))
				.rowCount(rowCount)
				.build();
		
		int count = 0;
		Dog[][] dogList = new Dog[3][3];
		for (int i = 0; i < dog.size()/3; i++) {
			for (int j = 0; j < dog.size()/3; j++) {
				dogList[i][j] = dog.get(count++);
			}
		}
		
		Pagination pagination = new Pagination(pageParams);
		
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("list", dogList);
		model.addAttribute("pagination", pagination);
		return "dog/dog_list";
	}
	
	@GetMapping("/profile")
	public String showDogProfile(@RequestParam(defaultValue = "1") String requestPage, @RequestParam(value = "desertionNo") String desertionNo, Model model) {
		List<Dog> dogs = openApiService.getDogList(requestPage);
		Dog dog = new Dog();
		for (int i = 0; i < dogs.size(); i++) {
			if (dogs.get(i).getDesertionNo().equals(desertionNo)) {
				dog.setDesertionNo(desertionNo);
				dog.setKindCd(dogs.get(i).getKindCd());
				dog.setColorCd(dogs.get(i).getColorCd());
				dog.setAge(dogs.get(i).getAge());
				dog.setSexCd(dogs.get(i).getSexCd());
				dog.setWeight(dogs.get(i).getWeight());
				dog.setNeuterYn(dogs.get(i).getNeuterYn());
				dog.setPopfile(dogs.get(i).getPopfile());
			}
		}
		
		model.addAttribute("dog", dog);
		return "dog/dog_profile";
	}
}