package tteogipbangbeomdae.goddog.domain.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.ParameterScriptAssert;

import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.article.dto.ArticleImage;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;

/**
 * ArticleMapper
 *
 * @author  떡잎방범대 신혜원, 최은비
 * @since   2023. 9. 10.
 * @version 1.0
 */
@Mapper
public interface ArticleMapper {

   /** 신규 게시글 등록 */
   public void create(Article article);
   
   /** 게시글에 대한 이미지 등록 */
   public void createImage(ArticleImage articleImage);
      
   /** 전체 게시글 목록 반환 */
   public List<Article> findAll(@Param("pageParams") PageParams pageParams, @Param("noticeNo") int noticeNo);

   /** 페이징 계산에 필요한 게시글 전체 갯수 반환 */
   public int getCount(@Param("noticeNo") int noticeNo,@Param("searchValue") String searchValue, @Param("searchType") String searchType);
   
   /** 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환 */
   public int getCountAll(PageParams pageParams);
   
   /** 댓글 쓰기 기능 */
   public void createComment(Article article);

   /** 게시글 상세보기 */
   public List<Article> readArticle(int groupNo);
   
   /** 게시글 이미지 상세보기 */
   public List<String> readImages(int reviewNo);
   
   /** 게시글 상세보기 시 조회수 갱신 */
   public boolean updateCount(int reviewNo);
   
   /** 게시글 삭제 기능 */
   public boolean deleteArticle(Article article);
   
   /** 게시글 수정 기능 */
   public boolean updateArticle();
   
   /** 게시글 댓글 갯수 */
   public int getCommentCount(int groupNo);
   
}