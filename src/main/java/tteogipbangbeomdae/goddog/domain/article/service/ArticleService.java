package tteogipbangbeomdae.goddog.domain.article.service;

import java.util.List;

import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;

/**
 * ArticleService 
 * @author 신혜원, 최은비
 *
 */
public interface ArticleService {
	
	// Insert--------------------------
	
	// 게시판 등록
	public void createArticle(Article article);
	
	// 댓글 등록
	public void createNewComment(Article article);
	
	// Select---------------------------
	public List<Article> getAllPagingArticle(PageParams pageParams, int noticeNo);
	public int getAllcount(int noticeNo);
	
	// 게시글 상세보기
	public List<Article> datailArticle(int groupNo);
	
}
