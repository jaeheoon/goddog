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
	
	public List<Dog> getDogList(String page, String sido);
	
	public List<Dog> getDogIndexList();
	
	public List<Area> getAreaList();
	
	public List<DogKind> getDogKindList();
	
}
