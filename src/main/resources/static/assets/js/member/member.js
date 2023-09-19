// 아이디 중복 체크를 위한 이벤트 리스너 등록
document.querySelector('.id').addEventListener('input', event => {
	fetchIdDupCheck(event);
});


async function fetchIdDupCheck(event) {
	let inputId = event.target.value;
	if(Validator.isId(inputId)){
		const exist = await httpRequest(inputId);
		if(exist){
			showMessage(false, "이미 사용중인 아이디입니다.");	
		}else {
			showMessage(true, "사용 가능한 아이디입니다.");
		}
	}else{
		showMessage(false, "아이디는 6~12자 사이어야 하며, 영문자/숫자만 사용할 수 있습니다.");		
	}
}


async function httpRequest(inputId) {
	const url = `/member/valid/${inputId}`;
	return fetch(url).then(response => response.json());
}

// 아이디 중복 결과 출력
function showMessage(valid, message) {
	const view = document.querySelector("#dup-result");
	if (view) {
		if (valid) {
			view.innerHTML = message;
			view.className = "text-primary";
		} else {
			view.innerHTML = message;
			view.className = "text-danger";
		}
	}
}