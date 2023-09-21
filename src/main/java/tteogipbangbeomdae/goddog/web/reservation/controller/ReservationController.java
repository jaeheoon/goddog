package tteogipbangbeomdae.goddog.web.reservation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.reservation.service.ReservationService;

/**
 * /Reservation관련 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author 떡잎방범대 조영호
 * @since 2023. 9. 16.
 * @version 1.0
 */
@Controller
@RequestMapping("/reservation")
@RequiredArgsConstructor
@Slf4j
public class ReservationController {

	private final ReservationService reservationService;

	@PostMapping("/agreeReservations")
	@ResponseBody
	public boolean agreeReservation(@RequestParam("reservationNo") List<Integer> reservationNumbers, Model model) {
		boolean result = false;
		
		for (int reservationNo : reservationNumbers) {
			// 들어온 reservationNo를 이용하여 업데이트 실행
			result = reservationService.agreeUpdate(reservationNo);
		}
		
		return result;
	}
	
	@PostMapping("/cancelReservations")
	@ResponseBody
	public boolean cancelReservation(@RequestParam("reservationNo") List<Integer> reservationNumbers, Model model) {
		boolean result = false;
		
		for (int reservationNo : reservationNumbers) {
			// 들어온 reservationNo를 이용하여 업데이트 실행
			result = reservationService.cancelUpdate(reservationNo);
		}
		
		return result;
	}
	
	@GetMapping("/agreeReservations/{reservationNo}")
	public String agreeReservationPath(@PathVariable("reservationNo")int reservationNo, Model model) {
		reservationService.agreeUpdate(reservationNo);
		return "redirect:/member/mypage/adminpage";
	}
	
	@GetMapping("/cancelReservations/{reservationNo}")
	public String cancelReservationPath(@PathVariable("reservationNo")int reservationNo, Model model) {
		reservationService.cancelUpdate(reservationNo);
		return "redirect:/member/mypage/adminpage";
	}
	
}