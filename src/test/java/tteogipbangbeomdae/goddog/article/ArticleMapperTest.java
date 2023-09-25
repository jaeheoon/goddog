package tteogipbangbeomdae.goddog.article;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.article.dto.ArticleImage;
import tteogipbangbeomdae.goddog.domain.board.mapper.ArticleMapper;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;

/**
 * 
 * ArticleMapper가 정상 작동 하는지 테스트하는 클래스
 *
 * @author  떡잎방범대 신혜원, 최은비
 * @since   2023. 09. 10.
 * @version 1.0
 */
@SpringBootTest

public class ArticleMapperTest {
   
   @Autowired
   private ArticleMapper articleMapper;
   
   @Test
   @DisplayName("게시글 등록")
   @Transactional
   @Disabled
   void createTest() {
      Article article = Article.builder()
                    .memberId("bangry")
                    .noticeNo(1)
                    .reviewTitle("귀여운 강아지네요")
                    .reviewContents("강아지 한 마리를 봤는데 너무 귀여워요")
                    .count(0)
                    .levelNo(0)
                    .orderNo(0)
                    .build();
      articleMapper.create(article);
      assertThat(article).isNotNull();
   }
   
   @Test
   @DisplayName("게시글 이미지 등록")
   @Transactional
   @Disabled
   void createImageTest() {
      ArticleImage articleImage = ArticleImage.builder()
                        .img("1-b.jpg")
                        .reviewNo(211)
                        .memberId("bangry")
                        .noticeNo(2)
                        .build();
      articleMapper.createImage(articleImage);
   }

   @Test
   @DisplayName("게시글 이미지 불러오기")
   @Transactional
   @Disabled
   void selectImagesTest() {
      List<String> names = articleMapper.readImages(214);
   }
   
   @Test
   @DisplayName("게시글 페이징 목록 불러오기")
   @Disabled
   public void findAllTest() {
      PageParams pageParams = PageParams.builder()
                                 .elementSize(10)
                                 .requestPage(1)
                                 .build();
      int noticeNo = 1;
      List<Article> list = articleMapper.findAll(pageParams, noticeNo);
      for (Article article : list) {
      }
   }
   
   @Test
   @DisplayName("전체 행 갯수")
   @Disabled
   public void getCountTest() {
	  String searchType = "memberId";
	  String searchValue = "bangry";
      int noticeNo = 1;
//      int count = articleMapper.getCount(noticeNo,,);
   }
   
   @Test
   @DisplayName("댓글 등록")
   @Transactional
   @Disabled
   void createCommentTest() {
      Article article = Article.builder()
                    .memberId("bangry")
                    .noticeNo(1)
                    .reviewTitle("댓글 제목 등록 테스트")
                    .reviewContents("댓글 내용 등록 테스트")
                    .count(0)
                    .groupNo(1)
                    .levelNo(1)
                    .orderNo(2)
                    .build();
      articleMapper.createComment(article);
      
      assertThat(article).isNotNull();
   }

    @Test
    @DisplayName("게시글 상세보기")
    @Disabled
    public void readArticleTest() {
       int groupNo = 1;
       List<Article> articleList = articleMapper.readArticle(groupNo);
       for (Article article : articleList) {
      }

    }
    
    @Test
    @DisplayName("게시글 상세보기 시 조회수 갱신")
    @Disabled
    public void updateCountTest() {
       int reviewNo = 149;
       articleMapper.updateCount(reviewNo);
       List<Article> readArticle= articleMapper.readArticle(reviewNo);
       
      }

     @Test
     @DisplayName("게시글 삭제")
     @Transactional
     @Disabled
     public void deleteArticleTest() {
       Article article = Article.builder()
                           .memberId("furkids")
                           .groupNo(201)
                           .levelNo(0)
                           .build();
       boolean result = articleMapper.deleteArticle(article);
     }
}