package tteogipbangbeomdae.goddog.domain.shelter.mapper;

import org.apache.ibatis.annotations.Mapper;

import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import java.util.List;

/** @author  떡잎방범대 문승욱
 * @since   2023. 9. 21.
 * @version 1.0
 */
@Mapper
public interface ShelterMapper {
	
	
	//	보호소 상세 정보 반환
	public Shelter selectShelter(int careNo);
	
	
	//	 보호소 목록 반환
	public List<Shelter> getShelterList();
	
}







