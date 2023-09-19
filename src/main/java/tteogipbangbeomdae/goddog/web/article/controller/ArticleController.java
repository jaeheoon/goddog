package tteogipbangbeomdae.goddog.web.article.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.article.service.ArticleService;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;
import tteogipbangbeomdae.goddog.domain.common.web.dto.Pagination;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;

/**
 * 
 * /article요청에 대한 세부 컨트롤러 요청된 url에 따라 해당하는 DB작업을 이루고 템플릿으로 연동시켜줌.
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 10.
 * @version 1.0
 */
@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {
	
	private final int ELEMENT_SIZE = 10;
	private final int PAGE_SIZE = 10;
	
	private final ArticleService articleService;
	
	/**
	 * @author 떡잎방범대 조영호
	 * @param 뷰에담아줄 모델
	 * @since 2023. 09. 10.
	 * @version 1.0
	 * @return /volunteer요청에 해당하는 활동과 뷰 반환
	 */
	@GetMapping("/volunteer/board/{noticeNo}")
	public String viewVolunteerBoard(@PathVariable("noticeNo") int noticeNo,@RequestParam(value = "requestPage", defaultValue = "1") int requestPage, HttpSession session, Model model) {
		session.setAttribute("noticeNo", noticeNo);
		log.info("들어온 요청페이지 : {}",requestPage);
		int rowCount = articleService.getAllcount(noticeNo);
		PageParams pageParams = PageParams.builder()
										  .elementSize(ELEMENT_SIZE)
										  .requestPage(requestPage)
										  .rowCount(rowCount)
										  .pageSize(PAGE_SIZE)
										  .build();
		Pagination pagination = new Pagination(pageParams);
		List<Article> volunteerList = articleService.getAllPagingArticle(pageParams, noticeNo);
		
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("volunteerList", volunteerList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("requestPage", requestPage);
		return "article/volunteer_board";
	}
	
	@GetMapping("/adoption/board/{noticeNo}")
	public String viewAdoptionBoard(@PathVariable("noticeNo") int noticeNo,@RequestParam(value = "requestPage", defaultValue = "1") int requestPage, HttpSession session, Model model) {
		session.setAttribute("noticeNo", noticeNo);
		log.info("들어온 요청페이지 : {}",requestPage);
		int rowCount = articleService.getAllcount(noticeNo);
		PageParams pageParams = PageParams.builder()
										  .elementSize(ELEMENT_SIZE)
										  .requestPage(requestPage)
										  .rowCount(rowCount)
										  .pageSize(PAGE_SIZE)
										  .build();
		Pagination pagination = new Pagination(pageParams);
		List<Article> adoptionList = articleService.getAllPagingArticle(pageParams, noticeNo);
		
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("adoptionList", adoptionList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("requestPage", requestPage);
		return "article/adoption_board";
	}
//	==============================================Create=========================================================================
	
	@GetMapping("/volunteer/create")
	public String createVolunteerArticle(Model model) {
		return "article/volunteer_create";
	}
	
	@GetMapping("/adoption/create")
	public String createAdoptionArticle(Model model) {
		return "article/adoption_create";
	}
	
	@PostMapping("/volunteer/create")
	public String createVolunteerArticleResult(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("multipartFile") List<MultipartFile> files, HttpSession session, Model model) {
		log.info("받은 제목 : {}", title);
		log.info("받은 내용 : {}", content);
		log.info("받은 첨부파일 : {}",files);
		int noticeNo = (int)session.getAttribute("noticeNo");
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		Article article = Article.builder()
								 .reviewTitle(title)
								 .reviewContents(content)
								 .noticeNo(noticeNo)
								 .memberId(memberId)
								 .build();
		articleService.createArticle(article);
		return "redirect:board/"+noticeNo;
	}
	
	@PostMapping("/adoption/create")
	public String createAdoptionArticleResult(Model model) {
		return "redirect:adoption_board";
	}
	
	@PostMapping("/comment")
	public String insertComment(@RequestParam("memberId") String memberId, @RequestParam("reviewContents") String reviewContents,
			HttpSession session ,Model model) {

		int noticeNo = (int)session.getAttribute("noticeNo");
//		int levelNo = (int)session.getAttribute("levelNo");
		int groupNo = (int)session.getAttribute("groupNo");

		Article comment = Article.builder()
										.memberId(memberId)
										.reviewContents(reviewContents)
										.noticeNo(noticeNo)
										.groupNo(groupNo)
										.build();
		articleService.createNewComment(comment);
		
		return "redirect:volunteer/read?groupNo="+groupNo;
	}
	
// ==============================================Read===========================================================================
	@GetMapping("/volunteer/read")
	public String readVolunteerArticle(@RequestParam("groupNo") int groupNo, HttpSession session, Model model) {
		List<Article> articleList = articleService.datailArticle(groupNo);
		
		model.addAttribute("articleList", articleList);
		session.setAttribute("groupNo", groupNo);
		
		return "article/volunteer_read";
	}
	
	@GetMapping("/adoption/read")
	public String readAdoptionArticle(Model model) {
		return "article/adoption_read";
	}

// =============================================Update=========================================================================
	@GetMapping("/volunteer/correct")
	public String correctVolunteerArticle(Model model) {
		return "article/volunteer_correct";
	}
	
	@GetMapping("/adoption/correct")
	public String correctAdoptionArticle(Model model) {
		return "article/adoption_correct";
	}
	
	@PostMapping("/volunteer/correct")
	public String correctAdoptionArticleResult(Model model) {
		return "redirect:volunteer_board";
	}
	
	@PostMapping("/adoption/correct")
	public String correctVolunteerArticleResult(Model model) {
		return "redirect:adoption_board";
	}
	
//============================================Delete===========================================================================
	@GetMapping("/volunteer/delete")
	public String deleteVolunteerArticle(Model model) {
		return "redirect:volunteer_board";
	}
	
	@GetMapping("/adoption/delete")
	public String deletetAdoptionArticle(Model model) {
		return "redirect:adoption_board";
	}
}