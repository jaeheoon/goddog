package tteogipbangbeomdae.goddog.domain.shelter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import tteogipbangbeomdae.goddog.domain.shelter.mapper.ShelterMapper;

@RequiredArgsConstructor
@Service
public class ShelterServiceImpl implements ShelterService{
	
	private final ShelterMapper shelterMapper;

	@Override
	public Shelter clickShelter(int careNo) {
		return shelterMapper.selectShelter(careNo);
	}

	@Override
	public List<Shelter> findAllShelter() {
		return shelterMapper.getShelterList();
	}
}
