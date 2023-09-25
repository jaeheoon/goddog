package tteogipbangbeomdae.goddog.domain.article.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.article.dto.ArticleImage;
import tteogipbangbeomdae.goddog.domain.board.mapper.ArticleMapper;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;
import tteogipbangbeomdae.goddog.domain.file.dto.UploadFile;

/**
 * ArticleServiceImpl
 * @author 신혜원, 최은비
 *
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{
   
   private final ArticleMapper articleMapper;
   /**
    * 입양후기 및 봉사 후기 게시글 등록   
    */
   @Override
   @Transactional
   public void createArticle(Article article, List<UploadFile> uploadFiles) {
      articleMapper.create(article);
      
      // 업로드된 파일 등록
      ArticleImage articleImage = ArticleImage.builder()
            .memberId(article.getMemberId())
            .noticeNo(article.getNoticeNo())
            .reviewNo(article.getReviewNo())
            .build();
      
      for (UploadFile uploadFile : uploadFiles) {
         String fileName = uploadFile.getStoreFileName();
         articleImage.setImg(fileName);
         registerImage(articleImage);
      }
      
   }
   
   /**
    * 게시글에 해당하는 이미지 등록
    */
   @Override
   @Transactional
   public void registerImage(ArticleImage articleImage) {
      articleMapper.createImage(articleImage);
   }
   
   /**
    * 댓글 등록
    */
   @Override
   public void createNewComment(Article article) {
      articleMapper.createComment(article);
   }
   
   /**
    * 요청 페이지, 페이지당 보여지는 목록 갯수에 따른 목록 반환
    */
   @Override
   public List<Article> getAllPagingArticle(PageParams pageParams, int noticeNo) {
      return articleMapper.findAll(pageParams, noticeNo);
   }
   
   /**
    * 페이징 계산에 필요한 게시글 전체 갯수 반환
    */
   @Override
   public int getAllcount(int noticeNo,String searchValue,String searchType) {
      return articleMapper.getCount(noticeNo,searchValue,searchType);
   }

   /**
    * 게시글 상세보기
    */
   @Override
   public List<Article> datailArticle(int groupNo) {
      articleMapper.updateCount(groupNo);
      return articleMapper.readArticle(groupNo);
   }
   
   /**
    * 게시글 이미지 상세보기
    */
   @Override
   public List<String> articleImages(int reviewNo) {
      return articleMapper.readImages(reviewNo);
   }

   /**
    * 게시글 삭제하기
    */
   @Override
   public boolean delete(Article article) {
      return articleMapper.deleteArticle(article);
   }

   /**
    * 게시글 상세보기 시 조회수 갱신
    */
   @Override
   public void updateCount(int reviewNo) {
      articleMapper.updateCount(reviewNo);      
   }
   
   /**
    * 게시글에 해당하는 댓글 갯수 반환
    */
	@Override
	public int getCountByGroupNo(int groupNo) {
		return articleMapper.getCommentCount(groupNo);
	}
}