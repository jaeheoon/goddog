package tteogipbangbeomdae.goddog.domain.shelter.service;


import java.util.List;

import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;


/** @author  떡잎방범대 문승욱
 * @since   2023. 9. 21.
 * @version 1.0
 */
public interface ShelterService {
	
	//	보호소 전체 목록
	public List<Shelter> findAllShelter();	
	
	//	보호소 번호 조회
	public Shelter clickShelter(int careNo);

	

}
