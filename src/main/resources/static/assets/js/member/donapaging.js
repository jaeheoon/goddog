donahandlePageClick();
// 페이지 번호를 클릭할 때의 이벤트 핸들러
async function donahandlePageClick(event) {
	let requestPage1;
	if (event === null || event === undefined) {
		requestPage1 = 1;
	} else {
		event.preventDefault();
		requestPage1 = event.target.getAttribute('data-page');
	}

	// 서버에 요청 보내서 데이터를 가져옴
	const response = await fetch(`/member/mypage/dona/${requestPage1}`);
	const data = await response.json();

	// pagination 정보와 봉사 내역 리스트를 받아옴
	const pagination1 = data.pagination1;
	const replys = data.donaList;
	console.dir(pagination1);
	// 봉사 내역을 화면에 표시
	showReply2(replys);

	// pagination 정보를 사용하여 페이지 버튼을 업데이트
	updatePaginationButtons2(pagination1,requestPage1);
}

//눌린페이지에 따라 테이블 내용 변경
function showReply2(replys) {
	const viewss = document.querySelector(".donation");
	let content = ``;

	replys.forEach(reply => {
		content += `<tr id="table-content">
						<td class="m_hidden">${reply.donahistoryNo}1</td>
						<td class="m_hidden">${reply.donationDate}</td>
						<td class="m">${reply.donation}</td>
					</tr>`;
	});

	viewss.innerHTML = content;
}

// Pagination 객체를 사용하여 화면을 업데이트
function updatePaginationButtons2(pagination1, requestPage1) {
	const pageLinksContainer2 = document.querySelector(".donahistory");
	pageLinksContainer2.innerHTML = ''; // 기존 페이지 링크를 초기화

	// << 버튼을 추가
	if (pagination1.showFirst) {
		const firstButtons = document.createElement("li");
		firstButtons.className = "page-item";
		firstButtons.innerHTML = `<a class="page-link" href="#" data-page="1">&lt;&lt;</a>`;
		firstButtons.addEventListener("click", donahandlePageClick);


		pageLinksContainer2.appendChild(firstButtons);
	}

	// < 버튼을 추가
	if (pagination1.showPrevious) {
		const previousButton = document.createElement("li");
		previousButton.className = "page-item";
		previousButton.innerHTML = `<a class="page-link" href="#" data-page="${pagination1.previousStartPage}">&lt;</a>`;
		previousButton.addEventListener("click", donahandlePageClick);
		pageLinksContainer2.appendChild(previousButton);
	}

	// 페이지 번호를 추가
	for (let i = pagination1.startPage; i <= pagination1.endPage; i++) {
		const pageListItem = document.createElement("li");
		pageListItem.className = "page-item";

		const pageLink = document.createElement("a");
		//선택된 리퀘스트번호에 따라 클래스를 나눠줘서 선택된 번호를 알기 쉽게사용자에게 보여줌
		if(requestPage1 == i){
		pageLink.className = "page-link active";
		} else {
		pageLink.className = "page-link";
		}
		pageLink.href = `/member/mypage/${i}`;
		pageLink.dataset.page = i;
		pageLink.textContent = i;

		pageLink.addEventListener("click", function(event) {
			event.preventDefault();
			donahandlePageClick(event);
		});

		pageListItem.appendChild(pageLink);
		pageLinksContainer2.appendChild(pageListItem);
	}

	// > 버튼을 추가
	if (pagination1.showNext) {
		const nextButton = document.createElement("li");
		nextButton.className = "page-item";
		nextButton.innerHTML = `<a class="page-link" href="#" data-page="${pagination1.nextStartPage}">&gt;</a>`;
		nextButton.addEventListener("click", donahandlePageClick);
		pageLinksContainer2.appendChild(nextButton);
	}

	// >> 버튼을 추가
	if (pagination1.showLast) {
		const lastButton = document.createElement("li");
		lastButton.className = "page-item";
		lastButton.innerHTML = `<a class="page-link" href="#" data-page="${pagination1.totalPages}">&gt;&gt;</a>`;
		lastButton.addEventListener("click", donahandlePageClick);
		pageLinksContainer2.appendChild(lastButton);
	}
}

const pageLinks2 = document.querySelectorAll(".donahistory .page-link");
pageLinks2.forEach(link => {
	link.addEventListener("click", donahandlePageClick);
});