package tteogipbangbeomdae.goddog.web.dog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.area.dto.Area;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
import tteogipbangbeomdae.goddog.domain.openapi.service.OpenApiService;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import tteogipbangbeomdae.goddog.domain.shelter.service.ShelterService;
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
	private final ShelterService shelterService;
	
	//보여지는 글 갯수
	private final int ELEMENT_SIZE = 9;
	
	//페이징처리 목록 갯수(1, 2, 3, 4, 5)
	private final int PAGE_SIZE = 5;
	
	/**
	 * 강아지 리스트 데이터 처리 메소드
	 * @author  떡잎방범대 홍재헌
	 * @since   2023. 9. 14.
	 * @version 1.0
	 */
	@GetMapping("")
	public String showDog(@RequestParam(defaultValue = "1") String requestPage, @RequestParam(defaultValue = "") String sido, @RequestParam(defaultValue = "") String shelter, Model model) {
		List<Area> areaList = openApiService.getAreaList();
		List<Shelter> shelterList = shelterService.findAllShelter();
		List<Dog> dogList = openApiService.getDogList(requestPage, sido);
		boolean status = false;
		if (!shelter.equals("")) {
			status = true;
			for (int i = 0; i < shelterList.size(); i++) {
				if (shelter.equals(shelterList.get(i).getName())) {
					dogList = openApiService.getShelterDogList(i + 1, status);
				}
			}
		}
		int rowCount = dogList.get(0).getTotalCount().intValue();	//전체 강아지 마리수
		
		PageParams pageParams = PageParams.builder()
				.pageSize(PAGE_SIZE)
				.elementSize(ELEMENT_SIZE)
				.requestPage(Integer.parseInt(requestPage))
				.rowCount(rowCount)
				.build();
		int count = 0;
		Dog[][] dogArrayList = new Dog[3][3];
		for (int i = 0; i < dogList.size()/3; i++) {
			for (int j = 0; j < dogList.size()/3; j++) {
				dogArrayList[i][j] = dogList.get(count++);
			}
		}
		
		Pagination pagination = new Pagination(pageParams);
		
		model.addAttribute("status", status);
		model.addAttribute("shelter", shelter);
		model.addAttribute("sidoCode", sido);
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("list", dogArrayList);
		model.addAttribute("shelterList", shelterList);
		model.addAttribute("areaList", areaList);
		model.addAttribute("pagination", pagination);
		return "dog/dog_list";
	}
	
	/**
	 * 강아지 상세 페이지 데이터 넣는 메소드
	 * @author  떡잎방범대 홍재헌
	 * @since   2023. 9. 14.
	 * @version 1.0
	 */
	@GetMapping("/profile")
	public String showDogProfile(@RequestParam(defaultValue = "1") String requestPage, @RequestParam(value = "desertionNo") String desertionNo, Model model) {
		List<Dog> dogs = openApiService.getDogList(requestPage, "");
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