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
import tteogipbangbeomdae.goddog.domain.board.mapper.ArticleMapper;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;

@SpringBootTest
@Slf4j

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
		log.info("게시글 등록 완료 : {}", article);
		assertThat(article).isNotNull();
	}
	
	@Test
	@DisplayName("게시글 페이징 목록 불러오기")
	@Disabled
	public void findAllTest() {
		//given
		PageParams pageParams = PageParams.builder()
											.elementSize(10)
											.requestPage(1)
											.build();
		int noticeNo = 1;
		//when
		List<Article> list = articleMapper.findAll(pageParams, noticeNo);
		//then
		for (Article article : list) {
			log.info("들어온 리뷰글 : {}",article.toString());
		}
	}
	
	@Test
	@DisplayName("전체 행 갯수")
	@Disabled
	public void getCountTest() {
		//given
		int noticeNo = 1;
		//when
		int count = articleMapper.getCount(noticeNo);
		//then
		log.info("들어온 총 행 갯수 : {}",count);
		
	}
	
	@Test
	@DisplayName("댓글 등록")
	@Transactional
//	@Disabled
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
		
		log.info("신규 댓글 등록 : {}", article);
		assertThat(article).isNotNull();
	}

	 @Test
	 @DisplayName("게시글 상세보기")
	 @Disabled
	 public void readArticleTest() {
		 //given
		 int groupNo = 1;
		 //when
		 List<Article> articleList = articleMapper.readArticle(groupNo);
		 //then
		 for (Article article : articleList) {
			log.info("가져온 게시글 상세 : {}", article);
		}

	}
	 
	 @Test
	 @DisplayName("게시글 수정")
	 @Disabled
	 public void createArticleTest() {
		 //given
		 
		 //when
		 
		 //then
		 
	 }
	
}
