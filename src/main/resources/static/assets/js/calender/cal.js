window.onload = function () { buildCalendar(); }    // 웹 페이지가 로드되면 buildCalendar 실행

let nowMonth = new Date();  // 현재 달을 페이지를 로드한 날의 달로 초기화
let today = new Date();     // 페이지를 로드한 날짜를 저장
today.setHours(0, 0, 0, 0);    // 비교 편의를 위해 today의 시간을 초기화

// 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
function buildCalendar() {

  let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1);     // 이번달 1일
  let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0);  // 이번달 마지막날

  let tbody_Calendar = document.querySelector(".Calendar > tbody");
  document.getElementById("calYear").innerText = nowMonth.getFullYear();             // 연도 숫자 갱신
  document.getElementById("calMonth").innerText = leftPad(nowMonth.getMonth() + 1);  // 월 숫자 갱신

  while (tbody_Calendar.rows.length > 0) {                        // 이전 출력결과가 남아있는 경우 초기화
    tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
  }

  let nowRow = tbody_Calendar.insertRow();        // 첫번째 행 추가           

  for (let j = 0; j < firstDate.getDay(); j++) {  // 이번달 1일의 요일만큼
    let nowColumn = nowRow.insertCell();        // 열 추가
  }

  for (let nowDay = firstDate; nowDay <= lastDate; nowDay.setDate(nowDay.getDate() + 1)) {   // day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복  

    let nowColumn = nowRow.insertCell();        // 새 열을 추가하고


    let newDIV = document.createElement("p");
    newDIV.innerHTML = leftPad(nowDay.getDate())        // 추가한 열에 날짜 입력

    nowColumn.appendChild(newDIV);

    if (nowDay.getDay() == 6) {                 // 토요일인 경우
      nowRow = tbody_Calendar.insertRow();    // 새로운 행 추가
    }

    if (nowDay < today) {                       // 지난날인 경우
      newDIV.className = "pastDay";
    }
    else if (nowDay.getFullYear() == today.getFullYear() && nowDay.getMonth() == today.getMonth() && nowDay.getDate() == today.getDate()) { // 오늘인 경우           
      newDIV.className = "today";
      newDIV.onclick = function () { choiceDate(this); }
    }
    else {                                      // 미래인 경우
      newDIV.className = "futureDay";
      newDIV.onclick = function () { choiceDate(this); }
    }
  }
}

// 날짜 선택
let day;
function choiceDate(newDIV) {
  if (document.getElementsByClassName("choiceDay")[0]) {                              // 기존에 선택한 날짜가 있으면
    document.getElementsByClassName("choiceDay")[0].classList.remove("choiceDay");  // 해당 날짜의 "choiceDay" class 제거
  }
  newDIV.classList.add("choiceDay");           // 선택된 날짜에 "choiceDay" class 추가
  day = document.querySelector(".choiceDay").textContent;
  //console.log(day);
}

document.getElementById("submit").addEventListener("click",()=>{
   let year = document.querySelector("#calYear").textContent;
   let month = document.querySelector("#calMonth").textContent;
   location.href="/volunteer/choice?regdate="+year+month+day;
   //console.log(day);
})

// 이전달 버튼 클릭
function prevCalendar() {
  nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() - 1, nowMonth.getDate());   // 현재 달을 1 감소
  buildCalendar();    // 달력 다시 생성
}
// 다음달 버튼 클릭
function nextCalendar() {
  nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, nowMonth.getDate());   // 현재 달을 1 증가
  buildCalendar();    // 달력 다시 생성
}

// input값이 한자리 숫자인 경우 앞에 '0' 붙혀주는 함수
function leftPad(value) {
  if (value < 10) {
    value = "0" + value;
    return value;
  }
  return value;
}

//다음버튼 클릭시 선택된 날짜까지 포함해서 요청


if (typeof _GUL == 'undefined') {

  var _GUL = 'weblog.knps.or.kr'; var _GPT = '80'; var _AIMG = new Image(); var _bn = navigator.appName; var _PR = location.protocol == "https:" ? "https://" + _GUL : "http://" + _GUL + ":" + _GPT; if (_bn.indexOf("Netscape") > -1 || _bn == "Mozilla") { setTimeout("_AIMG.src = _PR+'/?cookie';", 1); } else { _AIMG.src = _PR + '/?cookie'; };

}
var _AceGID = (function () { var Inf = ['gtp13.acecounter.com', '8080', 'AH5A44218380732', 'AW', '0', 'NaPm,Ncisy', 'ALL', '0']; var _CI = (!_AceGID) ? [] : _AceGID.val; var _N = 0; var _T = new Image(0, 0); if (_CI.join('.').indexOf(Inf[3]) < 0) { _T.src = "https://" + Inf[0] + '/?cookie'; _CI.push(Inf); _N = _CI.length; } return { o: _N, val: _CI }; })();
var _AceCounter = (function () { var G = _AceGID; var _sc = document.createElement('script'); var _sm = document.getElementsByTagName('script')[0]; if (G.o != 0) { var _A = G.val[G.o - 1]; var _G = (_A[0]).substr(0, _A[0].indexOf('.')); var _C = (_A[7] != '0') ? (_A[2]) : _A[3]; var _U = (_A[5]).replace(/\,/g, '_'); _sc.src = 'https:' + '//cr.acecounter.com/Web/AceCounter_' + _C + '.js?gc=' + _A[2] + '&py=' + _A[4] + '&gd=' + _G + '&gp=' + _A[1] + '&up=' + _U + '&rd=' + (new Date().getTime()); _sm.parentNode.insertBefore(_sc, _sm); return _sc.src; } })();