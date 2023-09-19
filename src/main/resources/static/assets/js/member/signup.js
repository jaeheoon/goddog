// 도메인 직접 입력 or domain option 선택
const domainListEl = document.querySelector('#domain-list')
const domainInputEl = document.querySelector('#domain-txt')
// select 옵션 변경 시
domainListEl.addEventListener('change', (event) => {
	// option에 있는 도메인 선택 시
	if (event.target.value !== "type") {
		// 선택한 도메인을 input에 입력하고 disabled
		domainInputEl.value = event.target.value;
		domainInputEl.disabled = true;
	} else { // 직접 입력 시
		// input 내용 초기화 & 입력 가능하도록 변경
		domainInputEl.value = "";
		domainInputEl.disabled = false;
	}
})

// '출생 연도' 셀렉트 박스 option 목록 동적 생성
const birthYearEl = document.querySelector('#birth-year')
// option 목록 생성 여부 확인
isYearOptionExisted = false;
birthYearEl.addEventListener('focus', function() {
	// year 목록 생성되지 않았을 때 (최초 클릭 시)
	if (!isYearOptionExisted) {
		isYearOptionExisted = true
		for (var i = 1940; i <= 2022; i++) {
			// option element 생성
			const YearOption = document.createElement('option')
			YearOption.setAttribute('value', i)
			YearOption.innerText = i
			// birthYearEl의 자식 요소로 추가
			this.appendChild(YearOption);
		}
	}
});

// '출생 달' 셀렉트 박스 option 목록 동적 생성
const birthMonthEl = document.querySelector('#birth-month')
// option 목록 생성 여부 확인
isMonthOptionExisted = false;
birthMonthEl.addEventListener('focus', function() {
	if (!isMonthOptionExisted) {
		isMonthOptionExisted = true
		for (var i = 1; i <= 12; i++) {
			// option element 생성
			const MonthOption = document.createElement('option')
			MonthOption.setAttribute('value', i)
			MonthOption.innerText = i
			// birthMonthEl의 자식 요소로 추가
			this.appendChild(MonthOption);
		}
	}
});

// '출생 일' 셀렉트 박스 option 목록 동적 생성
const birthDayEl = document.querySelector('#birth-day')
// option 목록 생성 여부 확인
isDayOptionExisted = false;
birthDayEl.addEventListener('focus', function() {
	if (!isDayOptionExisted) {
		isDayOptionExisted = true
		for (var i = 1; i <= 31; i++) {
			// option element 생성
			const DayOption = document.createElement('option')
			DayOption.setAttribute('value', i)
			DayOption.innerText = i
			// birthDayEl의 자식 요소로 추가
			this.appendChild(DayOption);
		}
	}
});

// 전체 동의 체크박스가 클릭될 때 모든 동의 체크박스의 상태를 변경하는 JavaScript 함수
function checkAll() {
	var allAgreeCheckbox = document.getElementById("allAgree");
	var termsCheckbox = document.getElementById("terms");
	var privacyCheckbox = document.getElementById("privacy");

	if (allAgreeCheckbox.checked) {
		termsCheckbox.checked = true;
		privacyCheckbox.checked = true;
	} else {
		termsCheckbox.checked = false;
		privacyCheckbox.checked = false;
	}
}

// 각 입력필드의 자바스크립트유효성검사 처리
document.querySelector('#submitbtn').addEventListener('click', (event) => {
	event.preventDefault();
	//유효성검사 통과하는 메소드
	let result = doValidate();
	
	if (result) {
		const form = document.querySelector('#signUpForm');
		console.dir(form);
		form.submit();
	} else {
		alert('입력값을 확인해 주세요');
	}
});

function doValidate() {
	//유효성 검사할 필드값들
	let memberId = document.signUpForm.memberId.value;
	
	let passwd = document.signUpForm.passwd.value;
	
	let name = document.signUpForm.name.value;
	
	let phoneNum = document.signUpForm.phoneNum.value;
	
	let emailF = document.signUpForm.emailF.value;
	let emailB = document.querySelector('#domain-txt').value;
	const fullEmail = emailF + '@' + emailB;
	
	let year = document.signUpForm.year.value;
	let month = document.signUpForm.month.value;
	let day = document.signUpForm.day.value;
	const fullBirthday = year + '-' + month + '-' + day;
	
	let adress = document.signUpForm.adress.value;
	let detailAdress = document.signUpForm.detailAdress.value;
	const fullAdress = adress + '' +detailAdress;
	//모든결과가 true일 경우 리턴시킬 결과값
	let result = true;
	
	if (!Validator.isId(memberId)) {
		const view = document.querySelector("#valid-id");
		showError(view, '아이디는 6~12자 사이의 영어와 숫자의 조합입니다.Test');
		//console.log('아이디오류');
		result = false;
	} 
	if (!Validator.isPw(passwd)) {
		const view = document.querySelector("#valid-passwd");
		showError(view, '비밀번호는 4~16자 사이의 영어와 숫자, 특수문자의 조합입니다.Test');
		//console.log('비밀번호 오류');
		result = false;
	}
	if (!Validator.isName(name)) {
		const view = document.querySelector("#valid-name");
		showError(view, '이름은 2~10자 사이의 영어이거나 한글입니다.Test');
		//console.log('이름오류');
		result = false;
	}
	if (!Validator.isPhoneNum(phoneNum)) {
		const view = document.querySelector("#valid-phoneNum");
		showError(view, '휴대폰 번호는 000-0000-0000의 형식입니다.');
		//console.log('휴대폰 오류');
		result = false;
	}
	if (!Validator.isEmail(fullEmail)) {
		const view = document.querySelector("#valid-email");
		showError(view, '이메일 입력은 필수입니다.');
		//console.log('이메일 오류');
		result = false;
	}
	if (!Validator.isBirthday(fullBirthday)) {
		const view = document.querySelector("#valid-birthday");
		showError(view, '생년월일입력은 필수입니다.');
		//console.log('생년월일 오류');
		result = false;
	}
	if (!Validator.isAdress(fullAdress)) {
		const view = document.querySelector("#valid-adress");
		showError(view, '주소입력은 필수입니다.');
		//console.log('주소오류');
		result = false;
	}
	return result;
}

// 회원 체크 결과 출력
function showError(view, message) {
	if (view) {
		view.innerHTML = message;
		view.className = "text-danger";
	}
}
