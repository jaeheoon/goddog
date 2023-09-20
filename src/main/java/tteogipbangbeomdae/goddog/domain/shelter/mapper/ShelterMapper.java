package tteogipbangbeomdae.goddog.domain.shelter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import tteogipbangbeomdae.goddog.domain.shelter.dto.Shelter;

@Mapper
public interface ShelterMapper {
	
	public Shelter selectShelter(int careNo);
	
	public List<Shelter> getShelterList();
}







