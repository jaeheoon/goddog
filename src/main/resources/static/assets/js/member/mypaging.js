const replyBtns = document.querySelectorAll(".pagenate a");
replyBtns.forEach(btn => {
	//btn.addEventListener('click', getReply);
	btn.addEventListener('click', (event)=>{
		event.preventDefault();
		console.log('클릭됨.');	
		getReply(event);
	});
});

async function getReply(event) {
	let requestPage = event.target.textContent;
    let replys = await requestReplys(requestPage);
//	replys.forEach(a=>{
//		console.log(a.reservationNo);
//	})
    //showReply(replys);
}

function requestReplys(requestPage) {
    //const url = `/member/mypage?requestPage2=${requestPage}`;
    const url = `/member/mypage/${requestPage}`;
    return fetch(url).then(response => response.json());
}

function  showReply(replys) {
	const views = document.querySelectorAll(".reservation");
	views.forEach(p => {
		if(memoId === p.dataset.id){
			// HTML 태그에 맞게 출력
			let content = `<td>`;
			replys.forEach(reply => {
				ul += `<li>${reply.content}(${reply.regdate}) -  ${reply.id}</li>`;	
			});
			ul += `</td>`;
			content.innerHTML = ul;
		}
		
		
	});
}





