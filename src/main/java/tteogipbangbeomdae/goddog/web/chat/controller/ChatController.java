package tteogipbangbeomdae.goddog.web.chat.controller;

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
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
	
	@GetMapping("")
	public String connectChat() {
		return "chat/view";
	}

}