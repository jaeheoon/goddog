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
  buttons.forEach(function (button) {
      button.classList.remove("active");
  });
  var button = document.querySelector(".option-button.align-" + align);
  button.classList.add("active");
}

// 댓글 보기 누르면 접었다 폈다하는 함수
function doDisplay(){
  var conList = document.getElementsByClassName("commentBoxList");
  for (var i = 0; i < conList.length; i++) {
    var con = conList[i];
    if (con.style.display === 'none' || con.style.display === '') {
      con.style.display = 'block';
    } else {
      con.style.display = 'none';
    }
  }
}

document.querySelector('.confirm').addEventListener('click',(event)=>{
	event.preventDefault();
	//console.log('클릭');
	const form = document.querySelector('.commentForm');
	let content = document.querySelector('#commentInput').value;
	console.log(content);
	if(content){
		form.submit();	
	}else{
		alert('댓글내용을 입력하세요.');
	}
})

