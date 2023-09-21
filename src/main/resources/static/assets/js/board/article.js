commentListLoading();
// 글씨 크기 조절 함수
function changeFontSize(change) {
	var textarea = document.getElementById("cntns_bdtxt_cont");
	var currentSize = parseInt(window.getComputedStyle(textarea, null).getPropertyValue('font-size'));
	var newSize = currentSize + change;
	textarea.style.fontSize = newSize + "px";
}

// 밑줄 토글 함수
function toggleUnderline() {
	var textarea = document.getElementById("cntns_bdtxt_cont");
	var button = document.querySelector(".option-button.underline");
	textarea.style.textDecoration = textarea.style.textDecoration === "underline" ? "none" : "underline";
	button.classList.toggle("active");
}

// 가운데 줄 긋기 토글 함수
function toggleStrikeThrough() {
	var textarea = document.getElementById("cntns_bdtxt_cont");
	var button = document.querySelector(".option-button.strike-through");
	var currentStyle = window.getComputedStyle(textarea, null).getPropertyValue('text-decoration');

	if (currentStyle.includes("line-through")) {
		textarea.style.textDecoration = "none";
		button.classList.remove("active");
	} else {
		textarea.style.textDecoration = "line-through";
		button.classList.add("active");
	}
}

// 텍스트 정렬 함수들
function toggleAlign(align) {
	var textarea = document.getElementById("cntns_bdtxt_cont");
	textarea.style.textAlign = align;
	var buttons = document.querySelectorAll(".option-button.align-left, .option-button.align-center, .option-button.align-right");
	buttons.forEach(function(button) {
		button.classList.remove("active");
	});
	var button = document.querySelector(".option-button.align-" + align);
	button.classList.add("active");
}

// 댓글 보기 누르면 접었다 폈다하는 함수
function doDisplay() {
	var conList = document.getElementsByClassName("commentBoxList");
	createAndGetList();
	for (var i = 0; i < conList.length; i++) {
		var con = conList[i];
		if (con.style.display === 'none' || con.style.display === '') {
			con.style.display = 'block';
		} else {
			con.style.display = 'none';
		}
	}
}


//작성하기 버튼 누르면 페이지이동없이 바로 작성되는 이벤트 구현
document.querySelector('.confirm').addEventListener('click', (event) => {
	event.preventDefault();
	//console.log('클릭');
	let writer = document.querySelector('#username').value;
	let content = document.querySelector('#commentInput').value;
	//console.log(content);
	if (content) {
		createAndGetList(content, writer)
	} else {
		alert('댓글내용을 입력하세요.');
	}
})
function commentListLoading(){
	createAndGetList();
}
async function createAndGetList(content, writer) {
	//await로 GroupNo에 해당하는 전체리스트를 반환받음
	let result = await createRequest(content, writer);
	console.dir(result);
	//댓글만 동적표시할꺼니 맨앞의 매인글은 배열에서 삭제후 완성된 댓글만으로 이루어진 배열 반환.
	let commentList = result.slice(1);
	//댓글갯수만큼 루프돌면서 해당 변수에 동적태그가 생성될 그릇을 생성
	let resultTag = ``;
	//동적생성된 태그를 넣을 요소를 검색해옴
	const view = document.querySelector('.commentBoxList');
	//작성완료후 내용작성칸 초기화를 위해 TextArea찾아옴.
	const commentTextArea = document.querySelector('#commentInput');
	console.dir(commentList+'적힐갯수다요');
	console.dir(commentTextArea);
	console.dir(view+'뷰다요');
	//댓글 갯수만큼 루프돌면서 원하는 속성을 사용하여 태그내용 구성하여 그릇에 더함
	commentList.forEach(comment => {
		resultTag += `<li class="commentbox">
						<div class="container">
							<div class="comment-container">
								<div class="box commentt">
									<div class="comment">
										<div class="date">${comment.writeDate}</div>
										<div class="user">${comment.memberId}</div>
										<div class="message">${comment.reviewContents}</div>
									</div>
								</div>
							</div>
						</div>
					 </li>`
	});
	//댓글내용적는 TextArea 초기화
	commentTextArea.value = ``;
	//완성된동적태그 화면에 출력
	console.log(resultTag);
	view.innerHTML = resultTag;
}

//작성된 정보를 찾아 폼데이터객체에 담은후 바디에 보내 결과 얻어옴.
async function createRequest(content, writer) {
	const formData = new FormData();
	formData.append("content", content);
	formData.append("writer", writer);
	const url = `/article/comment`;
	return fetch(url, { method: 'POST', body: formData }).then(response => response.json());
}