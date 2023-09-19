package tteogipbangbeomdae.goddog.domain.dog.mapper;

import org.apache.ibatis.annotations.Mapper;

import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;

/**
 * Dog xml 파일 인터페이스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 10.
 * @version 1.0
 */
@Mapper
public interface DogMapper {
	
	public void create(Dog dog);

}







