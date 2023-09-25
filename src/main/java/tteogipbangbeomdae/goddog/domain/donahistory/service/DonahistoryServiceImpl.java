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
 * @author  떡잎방범대 조영호(회원정보관련담당),문승욱(생성담당)
 * @since  	2023. 09. 18.
 * @version 버전
 */
@Service
@RequiredArgsConstructor
public class DonahistoryServiceImpl implements DonahistroyService {

	private final DonahistoryMapper donahistoryMapper;
	
	/**
	 * 페이징 처리를 위해 현제 접속중인 회원의 후원내역 리스트 가져오기
	 */
	@Override
	public List<Donahistory> getAllDonaHistory(PageParams pageParams,String memberId) {
		List<Donahistory> allList = null;
		
		allList = donahistoryMapper.findAllById(pageParams,memberId);
		
		return allList;
	}
	
	/**
	 * 페이징처리를 위한 현제접속중인 회원의 후원내역 갯수 가져오기
	 */
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
