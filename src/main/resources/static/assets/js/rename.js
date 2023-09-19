if(document.querySelector('.centername') != undefined){
  let originalname = document.querySelector('.centername').textContent;
  if (originalname != undefined && originalname.length > 8) {
    // 문자열을 ...으로 대체
    let truncatedString = '(' + originalname.substring(0, 4) + '...' + originalname.substring(originalname.length - 3) + ')';
    // alert(truncatedString);
    document.querySelector('.centername').textContent = truncatedString;
  } else {
    let truncatedString = '(' + originalname + ')';
    document.querySelector('.centername').textContent = truncatedString;
  }
}
// alert(originalname);
// 문자열 길이 체크
if(document.querySelector('.username') != undefined){
  let originaluserName = document.querySelector('.username').textContent;
  if (originaluserName != undefined && originaluserName.length > 4) {
    // 문자열을 ...으로 대체
    let truncatedString = originaluserName.substring(0, 4) + '...';
    // alert(truncatedString);
    document.querySelector('.username').textContent = truncatedString;
  } else {
    truncatedString = originaluserName+'님 환영합니다.';
    document.querySelector('.username').textContent = truncatedString;
  }
}
// alert(originaluserName);
