package tteogipbangbeomdae.goddog.domain.announce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.announce.dto.Announce;
import tteogipbangbeomdae.goddog.domain.announce.mapper.AnnounceMapper;

/**
 * AnnounceServiceImpl
 * @author 떡잎방범대 신혜원
 */
@RequiredArgsConstructor
@Service
public class AnnounceServiceImpl implements AnnounceService{
	private final AnnounceMapper announceMapper;

	@Override
	public List<Announce> getAnnoList() {
		return announceMapper.questionAnswer();
	}
}