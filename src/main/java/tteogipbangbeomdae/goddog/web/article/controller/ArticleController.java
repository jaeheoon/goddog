package tteogipbangbeomdae.goddog.web.article.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.article.dto.Article;
import tteogipbangbeomdae.goddog.domain.article.service.ArticleService;
import tteogipbangbeomdae.goddog.domain.common.web.dto.PageParams;
import tteogipbangbeomdae.goddog.domain.common.web.dto.Pagination;
import tteogipbangbeomdae.goddog.domain.file.dto.ArticleForm;
import tteogipbangbeomdae.goddog.domain.file.dto.UploadFile;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;
import tteogipbangbeomdae.goddog.web.common.filehandler.FileStore;

/**
 * 
 * /article요청에 대한 세부 컨트롤러 요청된 url에 따라 해당하는 DB작업을 이루고 템플릿으로 연동시켜줌.
 *
 * @author  떡잎방범대 신혜원, 최은비
 * @since   2023. 09. 10.
 * @version 1.0
 */

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
   
   private final int ELEMENT_SIZE = 10;
   private final int PAGE_SIZE = 10;
   
   private final ArticleService articleService;
   
   @Value("${common.uploadPath}")
   private String location = "C:/ezen-fullstack/workspace/goddog/upload/";
   
   private final FileStore fileStore;
   
   /**
    * @author 떡잎방범대 신혜원, 최은비
    * @param 뷰에담아줄 모델
    * @since 2023. 09. 10.
    * @version 1.0
    * @return /article요청에 해당하는 활동과 뷰 반환
    */

   /**
    * 봉사 후기 게시판 화면 처리
    * @author 신혜원
    * @param noticeNo
    * @param requestPage
    * @param session
    * @param model
    * @return
    */
   @GetMapping("/volunteer/board/{noticeNo}")
   public String viewVolunteerBoard(@PathVariable("noticeNo") int noticeNo,@RequestParam(value = "requestPage", defaultValue = "1") int requestPage, HttpSession session, Model model) {
      session.setAttribute("noticeNo", noticeNo);
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
   
  /**
   * 입양 후기 게시판 화면 처리
   * @author 최은비
   * @param noticeNo
   * @param requestPage
   * @param session
   * @param model
   * @return
   */
   @GetMapping("/adoption/board/{noticeNo}")
   public String viewAdoptionBoard(@PathVariable("noticeNo") int noticeNo,@RequestParam(value = "requestPage", defaultValue = "1") int requestPage, HttpSession session, Model model) {
      session.setAttribute("noticeNo", noticeNo);
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
   
   /**
    * 봉사활동 게시글 등록 화면
    * @author 신혜원
    * @param model
    * @return
    */
   @GetMapping("/volunteer/create")
   public String createVolunteerArticle(Model model) {
      return "article/volunteer_create";
   }
   
   /**
    * 입양 후기 게시글 등록 화면
    * @author 최은비
    * @param model
    * @return
    */
   @GetMapping("/adoption/create")
   public String createAdoptionArticle(Model model) {
      return "article/adoption_create";
   }
   
   /**
    * 봉사, 입양 게시글 이미지 등록 처리
    * @author 신혜원, 최은비
    * @param articleForm
    * @param session
    * @param model
    * @return
    */
   @PostMapping("/review/create")
   public String writeReview(@ModelAttribute ArticleForm articleForm, HttpSession session, Model model) {
      List<UploadFile> uploadFiles = null;
      try {
         uploadFiles = fileStore.storeFiles(articleForm.getUploadFiles());
      } catch (IOException e) {
         e.printStackTrace();
      }
      int noticeNo = (int)session.getAttribute("noticeNo");
      Member member = (Member)session.getAttribute("loginMember");
      String memberId = member.getMemberId();
      
      Article article = Article.builder()
                         .reviewTitle(articleForm.getTitle())
                         .reviewContents(articleForm.getContent())
                         .noticeNo(noticeNo)
                         .memberId(memberId)
                         .build();
      articleService.createArticle(article, uploadFiles);
      
      return noticeNo == 1 ? "redirect:/article/volunteer/board/"+noticeNo : "redirect:/article/adoption/board/"+noticeNo;
   }
   
   /**
    * 동적 이미지 출력 화면
    * @author 신혜원, 최은비
    * @param name
    * @return
    * @throws IOException
    */
   @GetMapping("/images/{name}")
   @ResponseBody
   public ResponseEntity<Resource> RenderImage(@PathVariable String name) throws IOException {

      Path path = Paths.get(location + "/" + name);
      String contentType = Files.probeContentType(path);
      Resource resource = new FileSystemResource(path);
      HttpHeaders headers = new HttpHeaders();
      headers.add(HttpHeaders.CONTENT_TYPE, contentType);
      return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

   }
   
   /**
    * 댓글 등록 처리
    * @author 최은비
    * @param memberId
    * @param reviewContents
    * @param session
    * @param model
    * @return
    */
   @PostMapping("/comment")
   public String insertComment(@RequestParam("memberId") String memberId, @RequestParam("reviewContents") String reviewContents,
      HttpSession session ,Model model) {

      int noticeNo = (int)session.getAttribute("noticeNo");
      int groupNo = (int)session.getAttribute("groupNo");

      Article comment = Article.builder()
                              .memberId(memberId)
                              .reviewContents(reviewContents)
                              .noticeNo(noticeNo)
                              .groupNo(groupNo)
                              .build();
      articleService.createNewComment(comment);
      
      if(noticeNo == 1) {
         return "redirect:volunteer/read?groupNo="+groupNo;         
      }else {
         return "redirect:adoption/read?groupNo="+groupNo;            
      }
   }
   
   /**
    * 봉사 후기 게시글 상세보기 화면 처리
    * @author 신혜원
    * @param groupNo
    * @param session
    * @param model
    * @return
    */
   @GetMapping("/volunteer/read")
   public String readVolunteerArticle(@RequestParam("groupNo") int groupNo, HttpSession session, Model model) {
      List<Article> articleList = articleService.datailArticle(groupNo);
      List<String> articleImages = articleService.articleImages(groupNo);
      
      model.addAttribute("articleList", articleList);
      model.addAttribute("articleImages", articleImages);
      session.setAttribute("groupNo", groupNo);
      
      return "article/volunteer_read";
   }
   
   /**
    * 입양 후기 게시글 상세보기 화면 처리
    * @author 최은비
    * @param groupNo
    * @param session
    * @param model
    * @return
    */
   @GetMapping("/adoption/read")
   public String readAdoptionArticle(@RequestParam("groupNo") int groupNo, HttpSession session, Model model) {
      List<Article> articleList = articleService.datailArticle(groupNo);
      List<String> articleImages = articleService.articleImages(groupNo);
            
      model.addAttribute("articleList", articleList);
      model.addAttribute("articleImages", articleImages);
      session.setAttribute("groupNo", groupNo);
      
      return "article/adoption_read";
   }
   
   /**
    * 봉사 후기 게시글 삭제 화면 처리
    * @author 최은비
    * @param groupNo
    * @param session
    * @param model
    * @return
    */
   @GetMapping("/volunteer/delete/{groupNo}")
   public String deleteVolunteerArticle(@PathVariable("groupNo") String groupNo, HttpSession session, Model model) {
	   int groupNumber = Integer.parseInt(groupNo);
	   Member member = (Member)session.getAttribute("loginMember");
	   int noticeNo = (int)session.getAttribute("noticeNo");
	   String memberId = member.getMemberId();
	   Article article = Article.builder()
			   					.memberId(memberId)
			   					.groupNo(groupNumber)
			   					.build();
	   articleService.delete(article);
       
	   return "redirect:"+"/article/volunteer/board/"+noticeNo;
   }
   
   /**
    * 입양 후기 게시글 삭제 화면 처리
    * @author 최은비
    * @param groupNo
    * @param session
    * @param model
    * @return
    */
   @GetMapping("/adoption/delete/{groupNo}")
   public String deletetAdoptionArticle(@PathVariable("groupNo") String groupNo, HttpSession session, Model model) {
	   int groupNumber = Integer.parseInt(groupNo);
	   Member member = (Member)session.getAttribute("loginMember");
	   int noticeNo = (int)session.getAttribute("noticeNo");
	   String memberId = member.getMemberId();
	   Article article = Article.builder()
			   					.memberId(memberId)
			   					.groupNo(groupNumber)
			   					.build();
	   articleService.delete(article);
	   
	   return "redirect:"+"/article/adoption/board/"+noticeNo;   
   }
}