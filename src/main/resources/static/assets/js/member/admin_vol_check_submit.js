const chkAll = document.querySelector("#chkAll")
chkAll.addEventListener("change", () => {
	const chkList = document.getElementsByName("chk");
	for (chk of chkList) {
		chk.checked = chkAll.checked;
	}
});

// 버튼이 '승인', '거절'인지 구분후 각각 check된 reservation항목의 고유번호를 패치로 post방식으로 요청함.
let submitBtns = document.querySelectorAll('.btnSubmit');
submitBtns.forEach((btn) => {
	btn.addEventListener('click', (event) => {
		//버튼 기본기능 제거
		event.preventDefault();
		//눌린 버튼이 '승인', '거절'인지 구분을 위해 값을알아옴.
		const btnType = event.currentTarget.getAttribute('data-btn-type');
		//console.log(btnType);
		//체크박스에 체크된 요소들을 불러옴
		const checkBoxes = document.querySelectorAll(".chkBox");
		console.log(checkBoxes);

		const selectedReservationNos = Array.from(checkBoxes)
			.filter(checkbox => checkbox.checked)
			.map(checkbox => checkbox.getAttribute("data-reservation-no"));

		console.log(selectedReservationNos);

		const formData = new FormData();
		if (selectedReservationNos.length === 0) {
			alert('선택된 항목이 없습니다. 항목을 선택해주세요.');
		} else {
			selectedReservationNos.forEach(reservationNo => {
				formData.append("reservationNo", reservationNo);
			})
			if (btnType === '승인') {
				sendCheckValue(btnType, formData);
				location.href = '/member/mypage/adminpage';
				alert('승인처리 완료되었습니다.');
			} else if (btnType === '거절') {
				sendCheckValue(btnType, formData);
				location.href = '/member/mypage/adminpage';
				alert('거절처리 완료되었습니다.');		
			}
		}
	})
});

async function getAgreeResult(formData) {
	const url = `/reservation/agreeReservations`;
	return fetch(url, { method: 'POST', body: formData }).then(response => response.json());
}

async function getCancelResult(formData) {
	const url = `/reservation/cancelReservations`;
	return fetch(url, { method: 'POST', body: formData }).then(response => response.json());
}

async function sendCheckValue(btnType, formData) {
	if (btnType === '거절') {
		let result = await getCancelResult(formData)
		resultAction(result);
	} else if (btnType === '승인') {
		let result = await getAgreeResult(formData)
		resultAction(result);
	}
}

function resultAction(result) {
	if (result) {
		//console.log(result);
		console.log('성공함!');
	} else {
		console.log(result);
		alert('실패함!');
	}
}