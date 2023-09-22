package tteogipbangbeomdae.goddog.domain.shelter.service;

/** @author  떡잎방범대 문승욱
 * @since   2023. 9. 21.
 * @version 1.0
*/

import java.util.List;

import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;


public interface ShelterService {
	
	public List<Shelter> findAllShelter();	
	
	public Shelter clickShelter(int careNo);

	

}
