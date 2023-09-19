package tteogipbangbeomdae.goddog.domain.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;

/**
 * ArticleMapper
 * @author 신혜원, 최은비
 */
@Mapper
public interface ArticleMapper {
	// 신규 게시글 등록
	public void create(Article article);
	
	// 전체 게시글 목록 반환
	public List<Article> findAll(@Param("pageParams") PageParams pageParams, @Param("noticeNo") int noticeNo);
	
	// 페이징 계산에 필요한 게시글 전체 갯수 반환
	public int getCount(int noticeNo);
	
	// 페이징 계산(검색 값 포함)에 필요한 게시글 전체 갯수 반환
	
	
	// 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환 
	
	
	// 댓글 쓰기 기능
	public void createComment(Article article);
	
	// 글 수정 기능
	public boolean updateArticle();
	
	// 글 상세보기 시 선택된 글의 hitCount 증가 기능
	public boolean updateHitCount();

	// 게시글 상세보기
	public List<Article> readArticle(int groupNo);
	
}
