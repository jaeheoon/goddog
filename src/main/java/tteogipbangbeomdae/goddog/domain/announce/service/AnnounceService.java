package tteogipbangbeomdae.goddog.domain.announce.service;

import java.util.List;

import tteogipbangbeomdae.goddog.domain.announce.dto.Announce;

/**
 * AnnounceService
 * @author 떡잎방범대 신혜원
 */
public interface AnnounceService {

	public List<Announce> getAnnoList();
}