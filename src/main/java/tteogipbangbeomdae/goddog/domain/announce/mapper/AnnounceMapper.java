package tteogipbangbeomdae.goddog.domain.announce.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import tteogipbangbeomdae.goddog.domain.announce.dto.Announce;

/**
 * AnnounceMapper
 * 필요한 질문과 답변을 가져오는 거라 list로 불러오기
 * @author 신혜원
 */

@Mapper
public interface AnnounceMapper {
	
	// FAQ 질문과 답변 조회
	public List<Announce> questionAnswer();
	
}







