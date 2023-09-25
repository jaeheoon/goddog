package tteogipbangbeomdae.goddog.domain.openapi.service;

import java.util.List;

import tteogipbangbeomdae.goddog.domain.area.dto.Area;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
import tteogipbangbeomdae.goddog.domain.dog.dto.DogKind;

/**
 * OpenAPI 관련 비즈니스 인터페이스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 12.
 * @version 1.0
 */
public interface OpenApiService {
	
	/** OpenAPI 이용하여 강아지 리스트 불러오는 메소드 */
	public List<Dog> getDogList(String page, String sido);
	
	/** OpenAPI 이용하여 강아지 리스트 불러오는 메소드 */
	public List<Dog> getDogIndexList();
	
	/** OpenAPI 이용하여 시, 도 리스트 불러오는 메소드 */
	public List<Area> getAreaList();
	
	/** OpenAPI 이용하여 품종 리스트 불러오는 메소드 */
	public List<DogKind> getDogKindList();
	
	/** OpenAPI 이용하여 보호소 강아지 리스트 불러오는 메소드 */
	public List<Dog> getShelterDogList(int shelterNo, String pageNo, boolean status);
	
}
