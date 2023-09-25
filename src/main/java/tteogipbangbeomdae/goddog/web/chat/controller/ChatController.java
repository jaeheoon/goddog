package tteogipbangbeomdae.goddog.web.chat.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
/**
 * 
 * /chat요청에 대한 세부 컨트롤러
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 20.
 * @version 1.0
 */
@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
	
	@GetMapping
	public String connectChat() {
		return "chat/view";
	}

}