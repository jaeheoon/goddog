package tteogipbangbeomdae.goddog.web.donation.controller;

import java.text.DecimalFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.donahistory.dto.Donahistory;
import tteogipbangbeomdae.goddog.domain.donahistory.service.DonahistroyService;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;

/**
 * /donation관련 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 9. 10.
 * @version 1.0
 */
@Controller
@RequestMapping("/donation")
@RequiredArgsConstructor
public class DonationController {
	
	/**
	 * 도네이션 비즈니스 로직을 위한 서비스
	 * @author 문승욱
	 */
	private final DonahistroyService donahistroyService;
	
	/**
	 * 제일처음 보여주는 donation도메인 페이지 뷰
	 * @return 해당하는 메인 뷰 보여주기
	 * @author 조영호
	 * @since 2023. 09. 10.
	 */
	@GetMapping("")
	public String showDog(Model model) {		
		return "donation/donation";
	}
	
	/**
	 * 화면에서 선택한 금액을 ,로 파싱하여 모델에 담아주기
	 * @author 문승욱
	 * @param pay 사용자가 선택한 금액
	 * @param model
	 * @return 결제방법선택창 뷰로 이동
	 */
	@GetMapping("/method/{pay}")
	public String selectMethod(@PathVariable("pay") Integer pay , Model model) {
		model.addAttribute("pay", pay);
		DecimalFormat decimalFormat = new DecimalFormat("#,###원");
		String formattedPay = decimalFormat.format(pay);
		model.addAttribute("formattedPay", formattedPay);
		return "donation/payment_method";
	}
	
	/**
	 * @author 문승욱
	 * @param pay 사용자가 선택한 금액
	 * @return 결제결과창으로 이동
	 */
	@GetMapping("/result/{pay}")
	public String viewResult(@PathVariable("pay") Integer pay, Model model, HttpSession session) {
		model.addAttribute("payment", pay);
		
		DecimalFormat decimalFormat = new DecimalFormat("#,###원");
		String formattedPay = decimalFormat.format(pay);
		model.addAttribute("formattedPay", formattedPay);
		
		 Member loginMember = (Member) session.getAttribute("loginMember");
		
		 
		 if (loginMember != null) {
		        String memberId = loginMember.getMemberId();
		 Donahistory createDonahistory = Donahistory
				 .builder()
				 .donation(pay)
				 .memberId(memberId)
				 .build();
		donahistroyService.createDonaHistory(createDonahistory);	
		 } else {
			   // 사용자가 로그인되어 있지 않다면 로그인 페이지로 리다이렉트 또는 오류 처리를 수행합니다.
		    }
		return "donation/result";
	}
	
	
}