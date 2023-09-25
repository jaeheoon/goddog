package tteogipbangbeomdae.goddog.domain.article.service;

import java.util.List;

import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.article.dto.ArticleImage;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;
import tteogipbangbeomdae.goddog.domain.file.dto.UploadFile;

/**
 * /Article관련 요청을 처리하는 인터페이스
 *
 * @author  떡잎방범대 신혜원, 최은비
 * @since   2023. 9. 10.
 * @version 1.0
 */
public interface ArticleService {
   
   // Insert--------------------------
   
   /** 입양후기 및 봉사 후기 게시글 등록 */
   public void createArticle(Article article, List<UploadFile> uploadFiles);
   
   /** 게시글에 해당하는 이미지 등록 */
   public void registerImage(ArticleImage articleImage);
   
   /** 댓글 등록 */
   public void createNewComment(Article article);
   
   // Select---------------------------
   
   /** 페이징 계산에 필요한 게시글 전체 갯수 반환 */
   public List<Article> getAllPagingArticle(PageParams pageParams, int noticeNo);
   
   /** 페이징 계산에 필요한 게시글 전체 갯수 반환 */
   public int getAllcount(int noticeNo,String searchValue,String searchType);
   
   /** 게시글 상세보기 */
   public List<Article> datailArticle(int groupNo);
   
   /** 게시글 이미지 상세보기 */
   public List<String> articleImages(int reviewNo);
   
   /** 게시글에 해당하는 댓글 갯수 반환 */
   public int getCountByGroupNo(int groupNo);
   
   //-----------------Update, Delete---------------
   
   /** 게시글 삭제하기 */
   public boolean delete(Article article);
   
   /** 게시글 상세보기 시 조회수 갱신 */
   public void updateCount(int reviewNo);
   
}