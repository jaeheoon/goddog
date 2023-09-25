package tteogipbangbeomdae.goddog.web.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.adminmember.dto.AdminMember;
import tteogipbangbeomdae.goddog.domain.adminmember.service.AdminMemberService;
import tteogipbangbeomdae.goddog.domain.donahistory.dto.Donahistory;
import tteogipbangbeomdae.goddog.domain.donahistory.service.DonahistroyService;
import tteogipbangbeomdae.goddog.domain.member.dto.LoginForm;
import tteogipbangbeomdae.goddog.domain.member.dto.Member;
import tteogipbangbeomdae.goddog.domain.member.service.MemberService;
import tteogipbangbeomdae.goddog.domain.reservation.dto.Reservation;
import tteogipbangbeomdae.goddog.domain.reservation.service.ReservationService;
import tteogipbangbeomdae.goddog.domain.web.dto.PageParams;
import tteogipbangbeomdae.goddog.domain.web.dto.Pagination;

/**
 * 사용자 관련 웹 요청을 처리하는 세부 컨트롤러 구현 클래스
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 9. 10.
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	/** 회원 관련 비즈니스 메소드 제공 */
	private final MemberService memberService;
	
	/** 후원 관련 비즈니스 메소드 제공 */
	private final DonahistroyService donahistroyService;
	
	/** 봉사 관련 비즈니스 메소드 제공 */
	private final ReservationService reservationService;
	
	/** 센터관리자회원 비즈니스 메소드 제공 */
	private final AdminMemberService adminMemberService;
	
	/** 페이징 처리를 위한 엘리먼트 사이즈와 페이지사이즈 상수로 선언 */
	private static final int ELEMENT_SIZE = 5;
	private static final int PAGE_SIZE = 5;

	/**
	 * 사용자 회원가입 화면 요청 처리 
	 * @param model  뷰에서 필요한 데이터 저장
	 * @return  뷰의 논리적 이름
	 */
	@GetMapping("/signup")
	public String registerForm(Model model) {
		Member member = Member.builder().build();
		model.addAttribute("member", member);
		return "member/signup";
	}
	
	/**
	 * 사용자 회원가입 요청 처리
	 * 회원 데이터 검증 시 Bean Validation 사용
	 * @param @validated  Global Validator 사용 설정 
	 * @param member  사용자 입력 정보
	 * @param bindingResult  검증 오류 메시지 설정
	 * @param redirectAttributes  회원 가입 요청 정상 처리 후 리다이렉트 정보 설정 
	 * @param model  뷰에서 필요한 데이터 저장
	 * @return  뷰의 논리적 이름
	 */
	@PostMapping("/signup")
	public String register(@Validated @ModelAttribute Member member, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		log.info("들어온 멤버 {}",member);
		// 데이터 검증 실패 시 회원가입 화면으로 포워드
		if (bindingResult.hasErrors()) {
//			 model에 bindingResult 자동 저장
			return "member/signup";
		}
		member.setFullAdress(member.combineFullAdress());
		member.setFullBirthday(member.combineFullBirthday());
		member.setFullEmail(member.combineFullEmail());
		
		// 데이터 검증 성공 시 회원 등록 처리 후 회원 상세 페이지로 리다이렉트
		memberService.register(member);
		return "redirect:login";
	}
	
	/** 회원 로그인 화면 요청 처리 */
	@GetMapping("/login")
	public String loginForm(Model model) {
		LoginForm loginForm = LoginForm.builder().build();
		model.addAttribute("loginForm", loginForm);
		return "member/login";
	}
	
	/** 회원 로그인 요청 처리 */
	@PostMapping("/login") 
	public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
		
		// 데이터 검증 실패 시 로그인 화면으로 포워드
		if (bindingResult.hasErrors()) {
			return "member/login";
		}
		// 데이터 검증 정상 처리 시
		boolean type = false;
		if(loginForm.getLoginType() == null) {
			type = false;
		} else {
			type = true;
		};
		log.info("들어온 로그인 타입. {}",type);
		HttpSession session =  request.getSession();
			
		if(type == true) {
			
			AdminMember loginMember = adminMemberService.isAdminMember(loginForm.getLoginId(),loginForm.getPasswd());
			log.info("찾아온 회원 {}", loginMember);
			// 회원이 아닌 경우
			if (loginMember == null) {
				bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
				return "member/login";
			}
			
			// 회원인 경우 세션 생성 및 로그인 아이디 설정
			session.setAttribute("loginMember", loginMember);
			
		} else if(type == false) {
			
			Member loginMember = memberService.isMember(loginForm.getLoginId(), loginForm.getPasswd());
			log.info("찾아온 회원 {}", loginMember);
			// 회원이 아닌 경우
			if (loginMember == null) {
				bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
				return "member/login";
			}
			// 회원인 경우 세션 생성 및 로그인 아이디 설정
			session.setAttribute("loginMember", loginMember);
		}
		
		
		// 로그인 처리 후 사용자가 원래 요청하려던 URL로 리다이렉트 처리
		String redirectURI = (String)session.getAttribute("redirectURI");
		log.warn("들어온 redirectURI {}",redirectURI);
		String uri = redirectURI == null ? "/" : redirectURI;
		return "redirect:" + uri;
	}
	
	/** 회원 로그아웃 요청 처리 */
	@GetMapping("/logout")  
	public String logout(HttpServletRequest request) {
		// 세션이 있으면 기존 세션 반환, 없으면 생성하지 않고 null 반환
		HttpSession session =  request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	/** 아이디 중복 여부 요청 처리 */
	@GetMapping("/valid/{id}")
	@ResponseBody
	public boolean isMemberId(@PathVariable("id") String id) {
		Member member = memberService.getMember(id);
		return member != null ? true : false;
	}
	
	/** 로그인 요청시 회원여부 체크 */
	@GetMapping("/valid/{id}/{passwd}")
	@ResponseBody
	public boolean isMemberIdAndPw(@PathVariable("id") String id, @PathVariable("passwd") String passwd) {
		Member member = memberService.isMember(id,passwd);
		AdminMember adminMember = adminMemberService.isAdminMember(id, passwd);
		return member != null || adminMember != null ? true : false;
	}
	
	/** 기본 마이페이지 뷰 보여주는 요청처리 */
	@GetMapping("/mypage")
	public String selectMethod(Model model, HttpSession session) {		

		return "member/mypage";
	}
	
	//관리자가 자기 봉사관리 페이지에 들어갔을 때 처리
	@GetMapping("/mypage/adminpage")
	public String moveToAdminpage(@RequestParam(value = "requestPage" , defaultValue = "1") int requestPage ,Model model, HttpSession session) {	
		//세션에 들어있는 관리자 정보에서 careNo를 추출
		AdminMember adminMember = (AdminMember)session.getAttribute("loginMember");
		int careNo = adminMember.getCareNo();
		
		//페이징 처리를 위한 해당 보호소 봉사내역갯수.
		int rowCount = reservationService.getCount(careNo);
		
		//페이징 처리를 위한 Pagination객체 생성.
		PageParams pageParams = PageParams.builder()
				.elementSize(ELEMENT_SIZE)
				.pageSize(PAGE_SIZE)
				.requestPage(requestPage)
				.rowCount(rowCount)
				.build();
		Pagination pagination = new Pagination(pageParams);
		
		//페이징 처리를 위한 해당 보호소의 봉사내역리스트.
		List<Reservation> reservations = reservationService.getReservationList(pageParams, careNo);

		//준비된 정보들 페이지에 보내기위해 모델에 저장.
		model.addAttribute("pagination", pagination);
		model.addAttribute("reservations", reservations);
		
		return "member/adminpage";
	}
	
	//봉사예약리스트를 RestAPI로 JSON으로 넘겨주기
	@GetMapping("/mypage/reser/{requestPage}")
	@ResponseBody
	public Map<String, Object> restReservationList(@PathVariable("requestPage") int requestPage, Model model, HttpSession session) {		
		//세션에 들어있는 관리자 정보에서 careNo를 추출
		Member loginMember = (Member)session.getAttribute("loginMember");
		String loginId = loginMember.getMemberId();
		//log.info("들어온 리퀘스트페이지 {}",requestPage);
		//페이징 처리를 위한 해당 보호소 봉사내역갯수.
		int reserRowCount = reservationService.getReserCountById(loginId);
		int donaRowCount = donahistroyService.getDonaCountById(loginId);
		//페이징 처리를 위한 Pagination객체 생성.
		PageParams pageParams2 = PageParams.builder()
				.elementSize(ELEMENT_SIZE)
				.pageSize(PAGE_SIZE)
				.requestPage(requestPage)
				.rowCount(reserRowCount)
				.build();
		Pagination pagination2 = new Pagination(pageParams2);
		
		//페이징처리된 목
		List<Reservation> reserList = reservationService.findAllReservationById(pageParams2,loginId);
		
	    Map<String, Object> responseMap = new HashMap<>();
	    responseMap.put("pagination2", pagination2);
	    responseMap.put("reserList", reserList);
		
		//페이징 처리를 위한 해당 보호소의 봉사내역리스트.
		return responseMap;
	}
	
	//후원내역을 RestAPI로 JSON데이터로 넘겨주기
	@GetMapping("/mypage/dona/{requestPage}")
	@ResponseBody
	public Map<String, Object> restDonahistoryList(@PathVariable("requestPage") int requestPage, Model model, HttpSession session) {		
		//세션에 들어있는 관리자 정보에서 careNo를 추출
		Member loginMember = (Member)session.getAttribute("loginMember");
		String loginId = loginMember.getMemberId();
		//log.info("들어온 리퀘스트페이지 {}",requestPage);
		//페이징 처리를 위한 해당 보호소 봉사내역갯수.
		int donaRowCount = donahistroyService.getDonaCountById(loginId);
		//페이징 처리를 위한 Pagination객체 생성.
		//donahistory를 위한 페이징
		PageParams pageParams1 = PageParams.builder()
				.elementSize(ELEMENT_SIZE)
				.pageSize(PAGE_SIZE)
				.requestPage(requestPage)
				.rowCount(donaRowCount)
				.build();
		Pagination pagination1 = new Pagination(pageParams1);

		//페이징처리된 목록
		List<Donahistory> donaList = donahistroyService.getAllDonaHistory(pageParams1,loginId);
		
	    Map<String, Object> responseMap = new HashMap<>();
	    responseMap.put("pagination1", pagination1);
	    responseMap.put("donaList", donaList);
		
		//페이징 처리를 위한 해당 보호소의 봉사내역리스트.
		return responseMap;
	}
}