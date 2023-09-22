package tteogipbangbeomdae.goddog.article;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.article.service.ArticleService;
import tteogipbangbeomdae.goddog.domain.board.mapper.ArticleMapper;

/**
 * 
 * ArticleService가 정상 작동 하는지 테스트하는 클래스
 *
 * @author  떡잎방범대 신혜원, 최은비
 * @since   2023. 09. 10.
 * @version 1.0
 */
@SpringBootTest
@Slf4j
public class ArticleServiceTest {

		@Autowired
		private ArticleService articleService;
		
		@Autowired
		private ArticleMapper articleMapper;
		
		@Test
		@Disabled
		@DisplayName("게시글 등록")
		public void createArticleTest() {
			Article article = Article.builder()
					          .memberId("bangry")
							  .noticeNo(1)
							  .reviewTitle("귀여운 강아지네요")
							  .reviewContents("강아지 한 마리를 봤는데 너무 귀여워요")
							  .count(0)
							  .levelNo(0)
							  .orderNo(0)
							  .build();
		}
		
		@Test
		@DisplayName("댓글 등록")
		@Disabled
		public void createNewCommentTest() {
			Article article = Article.builder()
								.memberId("bangry")
								.noticeNo(1)
								.reviewTitle("댓글 제목 등록 테스트")
								.reviewContents("댓글 내용 등록 테스트")
								.count(0)
								.groupNo(1)
								.levelNo(1)
								.orderNo(4)
								.build();
			articleService.createNewComment(article);
		}
}
