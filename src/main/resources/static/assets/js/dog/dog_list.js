
// 필터 누르면 접었다 폈다하는 함수
function clickFilterDisplay(){
  var conList = document.getElementsByClassName("filter");
  for (var i = 0; i < conList.length; i++) {
    var con = conList[i];
    if (con.style.display === 'none' || con.style.display === '') {
      con.style.display = 'block';
    } else {
      con.style.display = 'none';
    }
  }
}

