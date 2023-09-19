const replyBtns = document.querySelectorAll(".pagenate a");
replyBtns.forEach(btn => {
	//btn.addEventListener('click', getReply);
	btn.addEventListener('click', (event) => {
		event.preventDefault();
		//console.log('클릭됨.');	
		getReply(event);
	});
});

async function getReply(event) {
	let requestPage = event.target.textContent;
	let replys = await requestReplys(requestPage);
	replys.forEach(reservation => {
		console.log(`${reservation.insertDate}  ${reservation.shelterName}  ${reservation.regdate} ${reservation.regtime} ${reservation.status}`);
	})
	//showReply(replys);
}

function requestReplys(requestPage) {
	//const url = `/member/mypage?requestPage2=${requestPage}`;
	const url = `/member/mypage/${requestPage}`;
	return fetch(url).then(response => response.json());
}

function showReply(replys) {
	const views = document.querySelector(".reservation");

	// HTML 태그에 맞게 출력
	let content = `<td>`;
	
	replys.forEach(reply => {
		content += `여기에 td안의 내용을 구현해야할듯`;
	});
	
	content += `</td>`;
	// 완성된 문장 출력
	views.innerHTML = content;

}





