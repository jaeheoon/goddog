package tteogipbangbeomdae.goddog.domain.donahistory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.donahistory.dto.Donahistory;
import tteogipbangbeomdae.goddog.domain.donahistory.mapper.DonahistoryMapper;
import tteogipbangbeomdae.goddog.domain.web.dto.PageParams;

/**
 * 
 * 후원내역 관련 비즈니스 로직 처리 및 트랜잭션 관리 명세 구현체
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 12.
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class DonahistoryServiceImpl implements DonahistroyService {

	private final DonahistoryMapper donahistoryMapper;
	
	@Override
	public List<Donahistory> getAllDonaHistory(PageParams pageParams,String memberId) {
		List<Donahistory> allList = null;
		
		allList = donahistoryMapper.findAllById(pageParams,memberId);
		
		return allList;
	}

	@Override
	public int getDonaCountById(String memberId) {
		return donahistoryMapper.getCountById(memberId);
	}
	
	//신규 후원 작성
	@Override
	@Transactional
	public void createDonaHistory(Donahistory donahistory) {
		
		donahistoryMapper.create(donahistory);
	}

}
