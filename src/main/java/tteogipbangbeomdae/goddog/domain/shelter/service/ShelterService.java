package tteogipbangbeomdae.goddog.domain.shelter.service;

import java.util.List;

import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;


public interface ShelterService {
	
	public List<Shelter> findAllShelter();	
	
	public Shelter clickShelter(int careNo);

	

}
