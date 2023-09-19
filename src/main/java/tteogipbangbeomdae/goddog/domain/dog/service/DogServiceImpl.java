package tteogipbangbeomdae.goddog.domain.dog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;
import tteogipbangbeomdae.goddog.domain.dog.mapper.DogMapper;

/**
 * /dog관련 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 10.
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class DogServiceImpl implements DogService{
	
	private final DogMapper dogMapper;
	
	@Override
	@Transactional
//	@Transactional(propagation = Propagation.REQUIRED)
	public void register(Dog dog) {
		dogMapper.create(dog);
	}

}
