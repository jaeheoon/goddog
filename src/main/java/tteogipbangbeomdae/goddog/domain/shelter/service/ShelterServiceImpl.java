package tteogipbangbeomdae.goddog.domain.shelter.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
