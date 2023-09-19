package tteogipbangbeomdae.goddog.domain.shelter.mapper;

import org.apache.ibatis.annotations.Mapper;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;

@Mapper
public interface ShelterMapper {
	
	public Shelter selectShelter(int careNo);
	

}







