package tteogipbangbeomdae.goddog.domain.shelter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;
import tteogipbangbeomdae.goddog.domain.shelter.mapper.ShelterMapper;

/** @author  떡잎방범대 문승욱
 * @since   2023. 9. 21.
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class ShelterServiceImpl implements ShelterService{
	
	private final ShelterMapper shelterMapper;

	//	보호소별 번호 조회
	@Override
	public Shelter clickShelter(int careNo) {
		return shelterMapper.selectShelter(careNo);
	}
	//	보호소 전체 목록 
	@Override
	public List<Shelter> findAllShelter() {
		return shelterMapper.getShelterList();
	}

}
