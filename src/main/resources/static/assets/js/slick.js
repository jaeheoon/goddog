$(document).ready(function () {
  // 페이지 로드 시 첫 번째 탭의 Carousel 초기화
  // $('.carousel2').slick({
    $('#center1-tab-pane .carousel2').slick({
    slidesToShow: 4
  });

//   // 탭이 활성화될 때 Carousel 초기화
  $('.center-tab').on('shown.bs.tab', function (e) {
    // 현재 활성화된 탭의 Carousel 초기화
    var targetTab = $(e.target).attr('data-bs-target');
    $(targetTab + ' .carousel2').slick({
      slidesToShow: 4
    });
  });

//   // 탭이 비활성화될 때 Carousel 파괴
  $('.center-tab').on('hidden.bs.tab', function (e) {
    // 현재 비활성화된 탭의 Carousel 파괴
    var targetTab = $(e.target).attr('data-bs-target');
    $(targetTab + ' .carousel2').slick('unslick');
  });
});



