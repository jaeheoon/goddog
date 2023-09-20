reserhandlePageClick();
// 페이지 번호를 클릭할 때의 이벤트 핸들러
async function reserhandlePageClick(event) {
	let requestPage2;
	if (event === null || event === undefined) {
		requestPage2 = 1;
	} else {
		event.preventDefault();
		requestPage2 = event.target.getAttribute('data-page');
	}

	// 서버에 요청 보내서 데이터를 가져옴
	const response = await fetch(`/member/mypage/reser/${requestPage2}`);
	const data = await response.json();

	// pagination 정보와 봉사 내역 리스트를 받아옴
	const pagination2 = data.pagination2;
	const replys = data.reserList;
	console.dir(pagination2);
	// 봉사 내역을 화면에 표시
	showReply(replys);

	// pagination 정보를 사용하여 페이지 버튼을 업데이트
	updatePaginationButtons(pagination2,requestPage2);
}

//눌린페이지에 따라 테이블 내용 변경
function showReply(replys) {
	const views = document.querySelector(".reservation");
	let content = ``;

	replys.forEach(reply => {
		content += `<tr id="table-content">
						<td class="m_hidden">${reply.insertDate}</td>
						<td class="m_hidden" style="width: 154.22px;">${reply.shelterName}</td>
						<td class="m_hidden">${reply.regdate}</td>
						<td class="m_hidden">${reply.regtime}</td>
						<td class="m">
							<ul class="btn_set" id="btn-set" style="margin-top: 0; margin-bottom: 0;">
								<div class="btn_default_s">
									<a class="detail" href="/volunteer/detail/${reply.reservationNo}">상세보기</a>
								</div>
							</ul>
						</td>
					</tr>`;
	});

	views.innerHTML = content;
}

// Pagination 객체를 사용하여 화면을 업데이트
function updatePaginationButtons(pagination2, requestPage2) {
	const pageLinksContainer = document.querySelector(".reserhistory");
	pageLinksContainer.innerHTML = ''; // 기존 페이지 링크를 초기화

	// << 버튼을 추가
	if (pagination2.showFirst) {
		const firstButtons = document.createElement("li");
		firstButtons.className = "page-item";
		firstButtons.innerHTML = `<a class="page-link" href="#" data-page="1">&lt;&lt;</a>`;
		firstButtons.addEventListener("click", reserhandlePageClick);


		pageLinksContainer.appendChild(firstButtons);
	}

	// < 버튼을 추가
	if (pagination2.showPrevious) {
		const previousButton = document.createElement("li");
		previousButton.className = "page-item";
		previousButton.innerHTML = `<a class="page-link" href="#" data-page="${pagination2.previousStartPage}">&lt;</a>`;
		previousButton.addEventListener("click", reserhandlePageClick);
		pageLinksContainer.appendChild(previousButton);
	}

	// 페이지 번호를 추가
	for (let i = pagination2.startPage; i <= pagination2.endPage; i++) {
		const pageListItem = document.createElement("li");
		pageListItem.className = "page-item";

		const pageLink = document.createElement("a");
		//선택된 리퀘스트번호에 따라 클래스를 나눠줘서 선택된 번호를 알기 쉽게사용자에게 보여줌
		if(requestPage2 == i){
		pageLink.className = "page-link active";
		} else {
		pageLink.className = "page-link";
		}
		pageLink.href = `/member/mypage/${i}`;
		pageLink.dataset.page = i;
		pageLink.textContent = i;

		pageLink.addEventListener("click", function(event) {
			event.preventDefault();
			reserhandlePageClick(event);
		});

		pageListItem.appendChild(pageLink);
		pageLinksContainer.appendChild(pageListItem);
	}

	// > 버튼을 추가
	if (pagination2.showNext) {
		const nextButton = document.createElement("li");
		nextButton.className = "page-item";
		nextButton.innerHTML = `<a class="page-link" href="/member/mypage/${pagination2.nextStartPage}" data-page="${pagination2.nextStartPage}">&gt;</a>`;
		nextButton.addEventListener("click", reserhandlePageClick);
		pageLinksContainer.appendChild(nextButton);
	}

	// >> 버튼을 추가
	if (pagination2.showLast) {
		const lastButton = document.createElement("li");
		lastButton.className = "page-item";
		lastButton.innerHTML = `<a class="page-link" href="#" data-page="${pagination2.totalPages}">&gt;&gt;</a>`;
		lastButton.addEventListener("click", reserhandlePageClick);
		pageLinksContainer.appendChild(lastButton);
	}
}

const pageLinks = document.querySelectorAll(".reserhistory .page-link");
pageLinks.forEach(link => {
	link.addEventListener("click", reserhandlePageClick);
});