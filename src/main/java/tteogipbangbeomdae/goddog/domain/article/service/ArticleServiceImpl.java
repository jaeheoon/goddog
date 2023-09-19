package tteogipbangbeomdae.goddog.domain.article.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.board.mapper.ArticleMapper;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;

/**
 * ArticleServiceImpl
 * @author 신혜원
 *
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{
	
	private final ArticleMapper articleMapper;
	
	// Insert
	
	// 게시글 등록
	@Override
	@Transactional
	public void createArticle(Article article) {
		articleMapper.create(article);
	}
	
	// 댓글 등록
	@Override
	public void createNewComment(Article article) {
		articleMapper.createComment(article);
	}
	
	
	//Select
	@Override
	public List<Article> getAllPagingArticle(PageParams pageParams, int noticeNo) {
		return articleMapper.findAll(pageParams, noticeNo);
	}
	
	@Override
	public int getAllcount(int noticeNo) {
		return articleMapper.getCount(noticeNo);
	}

	// 게시글 상세보기
	@Override
	public List<Article> datailArticle(int groupNo) {
		return articleMapper.readArticle(groupNo);
	}


}
