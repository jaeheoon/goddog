package tteogipbangbeomdae.goddog.domain.shelter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;

@Mapper
public interface ShelterMapper {
	
	/**
	 * 보호소 상세 정보 반환
	 * @param careNo
	 * @return
	 */
	public Shelter selectShelter(int careNo);
	
	/**
	 * 보호소 목록 반환
	 * @return
	 */
	public List<Shelter> getShelterList();
	
}







