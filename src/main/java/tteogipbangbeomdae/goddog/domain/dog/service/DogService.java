package tteogipbangbeomdae.goddog.domain.dog.service;

import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
/**
 * /dog관련 요청을 처리하는 인터페이스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 10.
 * @version 1.0
 */
public interface DogService {
	
	public void register(Dog dog);
	
}
