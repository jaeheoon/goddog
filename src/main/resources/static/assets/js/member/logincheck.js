// 아이디 중복 체크를 위한 이벤트 리스너 등록
document.querySelector('.full-btn').addEventListener('click', (event) => {
	event.preventDefault();
	let userId = document.querySelector('#userId').value;
	let usetPw = document.querySelector('#userPw').value;
	//	console.dir(userId);
	//	console.dir(usetPw);
	//	console.dir(form);
	fetchIdAndPwDupCheck(userId, usetPw);
})

async function loginIdCheck(id, passwd) {
	const url = `/member/valid/${id}/${passwd}`;
	return fetch(url).then(response => response.json());
}

async function fetchIdAndPwDupCheck(userId, userPw) {

	if (Validator.isId(userId) && Validator.isPw(userPw)) {
		let exist = await loginIdCheck(userId, userPw);
		//console.log(exist);
		if (exist === true) {
			const form = document.querySelector('.login');
			form.submit();
		} else {
			showMessage('해당하는 회원을 찾지 못하였습니다. 아이디 또는 비밀번호를 확인해주세요.');
		}
	} else {
		showMessage('아이디 또는 비밀번호의입력 형식을 맞춰주세요');
	}

}

// 회원 체크 결과 출력
function showMessage(message) {
	const view = document.querySelector("#dup-result");
	if (view) {
		view.innerHTML = message;
		view.className = "text-danger";
	}
}