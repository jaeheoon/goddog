$(document).ready(function(){
	
	// 메뉴 디스플레이
	$(function(){		
		
		var gnb = $("#header #gnb");
		var bgmask = $("#header .bg");
		var m_height=$(document).height();
		
		$(".mnu").click(function() {				
	
			//if(gnb.css("display")=="none"){
			if($("#header #gnb").hasClass("m_hidden") === true) {
				gnb.removeClass("m_hidden");
				bgmask.css('display','block').fadeTo("fast", 1);
				$("#header_con #gnb").animate({right:"0"},300).css({height:m_height+"px"});
				return false;
			}else{
				gnb.addClass("m_hidden");
				bgmask.css('display','none').fadeOut();;
			}
		})
		
		//gnb	
		var dep1 = $("#gnb ul.dep1 > li");
		var dep2 = $("#gnb ul.dep2 li a");

		//mouseover
		dep1.bind("mouseover",function(){
			func_dep1(dep1.index(this));			
		});

		func_dep1 = function(depth1){
			for(i=0;i<dep1.length;i++){
				if(depth1==i){
					$(dep1[depth1]).addClass("on");					
				}else if(depth1!=i){
					$(dep1[i]).removeClass("on");
				}
			}
		}

		//keyboard focus
		$("> a", dep1).bind("focus",function(){
			var idx = $("> a", dep1).index(this);
			for(i=0;i<$("> a", dep1).length;i++){
				if(idx==i){
					$($("> a", dep1)[idx]).parent().addClass("on");
					$("#gnb").not(":animated").animate({height:"300px"},500);
				}else if(idx!=i){
					$($("> a", dep1)[i]).parent().removeClass("on");
				}
			}
			
		});
		dep2.bind("mouseover focus",function(){
			var idx = dep2.index(this);
			for(i=0;i<dep2.length;i++){
				if(idx==i){
					$(dep2[idx]).parent().addClass("on");
				}else if(idx!=i){
					$(dep2[i]).parent().removeClass("on");
				}
			}
		}).bind("mouseleave blur",function(){
			for(i=0;i<dep2.length;i++){
				$(dep2[i]).parent().removeClass("on");
			}
		});
		
		// 해상도 확인 (1000이상, 999이하)
		var responsive;

		$(window).on('load', function () {
			setResponsive();
		    if(responsive == 1){ setAnimate(); }
		});

		$(window).on('resize', function () {
		    
			setResponsive();
		    if(responsive == 1){ setAnimate();
			}else{ unSetAnimate(); }
		});
		
		//gnb
		
		//depth1 setting
		func_dep1(depth1);		
		
		// 메인메뉴 드랍다운 (1000이상)
		function setAnimate(){
			$('#gnb').css('height','88px');
			$('#gnb ul.dep2').css('display','none');
			$('#gnb').bind('mouseleave',function(){
				if(depth1!=null){
					$(this).stop().animate({height:"88px"},300);
					func_dep1(depth1);
				}else{
					$(this).stop().animate({height:"88px"},300,function(){
						$(this).css("height","50px")
					});
					for(i=0;i<dep1.length;i++){
						$(dep1[i]).parent().removeClass("on");
					}
				}
			}).bind("mouseover",function(){
				$('#gnb ul.dep2').css('display','block');
				$(this).stop().animate({height:"340px"},300);
			});
		}
		
		// 메인메뉴 드랍다운 (999이하)
		function unSetAnimate(){
			
			$('#gnb').unbind();			
			$('#gnb').removeAttr('style');
		}
		
		// 해상도 확인 (1000이상, 999이하)
		function setResponsive() {		    
			if ($('div#media_1000').css('display') == 'block') responsive = 1;
		    else if ($('div#media_999').css('display') == 'block') responsive = 0;    
		}
		
		var nav1;
		var nav2;
		nav1 = $("#s_navi_wrap ul li");
		nav2 = $('#s_navi');		
		
		nav1.bind("mouseover",function(){
			nav2.removeClass("hidden");		
		});
		nav1.bind("mouseleave",function(){
			nav2.addClass("hidden");
		});
	});
});

$(function() {
	/* Alert 창 */
	window.nativeAlert = window.alert;
	//window.nativeAlert = window.alertFn;	
	
	window.alert = function(msg,obj) {
		maskBackground("90000");
		
		$("body").append("<div id='AlertErrorMessage'></div>");
		alertlayer = $("#AlertErrorMessage");
	
		var html = "<div id='message_wrap'>" + 
		"	<div class='message_header'>" +
		"		<h2>경고 메세지</h2>" +
		"		<p class='map_close'><a href='#'><img src='/reservation/img/common/btn_close.png' /></a></p>" +
		"	</div>" +
		"	<div class='message_content'>" + msg + "</div>" +
		"	<div class='message_footer'>" + 
		"		<ul class='btn_set'>" +		
		"			<li class='btn_default close_btn'><a href='#'>확인</a></li>" +
		"		</ul>" +
		"	</div>" +
		"</div>";
		
		alertlayer.html(html);
		
		var alertleft = $(window).width() / 2 - $("#message_wrap").width() / 2;
		var alerttop = $(window).height() / 2 - alertlayer.height() / 2;
		alertlayer.css("z-index","999");
		alertlayer.css("position", "fixed");
		alertlayer.css("left", "0px");
		//alertlayer.css("top", "50%");
		alertlayer.css("top", "0px");
		//alertlayer.css("margin-top", "-750px");
		alertlayer.css("width", "100%");
		alertlayer.css("height", "100%");
		//alertlayer.css("background-color", "rgba(0,0,0,0.8)");
		
		alertlayer.find(".map_close > a, .close_btn > a").click(function() {
			alertlayer.remove();
			maskBackgroundOff();
			if(obj){
				obj.focus();
			}
			return false;
		});
		
		/*
		alertlayer.dialog({
			buttons: {OK: function() {$(this).dialog('close');}},
			close:function(){$(this).remove();},
			draggable: true,
			modal: true,
			resizable: false,
			width: 'auto'
		});
		*/
	};
	
	window.alertFn = function(title,msg,obj,fn) {
		maskBackground("90000");
		$("body").append("<div id='AlertErrorMessage'></div>");
		
		if(title==null){ title = "경고 메세지"; }
		
		alertlayer = $("#AlertErrorMessage");
		
		var html = "<div id='message_wrap'>" + 
		"	<div class='message_header'>" +
		"		<h2>경고 메세지</h2>" +
		"		<p class='map_close'><a href='#'><img src='/reservation/img/common/btn_close.png' /></a></p>" +
		"	</div>" +
		"	<div class='message_content'>" + msg + "</div>" +
		"	<div class='message_footer'>" + 
		"		<ul class='btn_set'>" +		
		"			<li class='btn_default close_btn'><a href='#'>확인</a></li>" +
		"		</ul>" +
		"	</div>" +
		"</div>";
		
		alertlayer.html(html);
		
		var alertleft = $(window).width() / 2 - $("#message_wrap").width() / 2;
		var alerttop = $(window).height() / 2 - alertlayer.height() / 2;
		alertlayer.css("z-index","999");
		alertlayer.css("position", "absolute");
		alertlayer.css("left", "0px");
		alertlayer.css("top", "0px");
		alertlayer.css("width", "100%");
		alertlayer.css("height", "100%");
		alertlayer.css("background-color", "rgba(0,0,0,0.8)");
		
		
		alertlayer.find(".map_close > a").click(function() {
			alertlayer.remove();
			maskBackgroundOff();
		});
		alertlayer.find(".close_btn > a").click(function() {
			alertlayer.remove();
			maskBackgroundOff();
			fn();
			return false;
		});
		
	};

	/* Confirm 창 */
	confirmWin = function(msg, fn) {
		maskBackground("90000");
		
		$("body").append("<div id='AlertErrorMessage'></div>");
		
		alertlayer = $("#AlertErrorMessage");
		
		var html = "<div id='message_wrap'>" + 
		"	<div class='message_header'>" +
		"		<h2>확인 메세지</h2>" +
		"		<p class='map_close'><a href='#'><img src='/reservation/img/common/btn_close.png' /></a></p>" +
		"	</div>" +
		"	<div class='message_content'>" + msg + "</div>" +
		"	<div class='message_footer'>" + 
		"		<ul class='btn_set'>" +
		"			<li class='btn_default'><a href='#'>확인</a></li>" +
		"		</ul>" +
		"	</div>" +
		"</div>";
		
		alertlayer.html(html);
		
				
		var alertleft = $(window).width() / 2 - $("#message_wrap").width() / 2;
		var alerttop = $(window).height() / 2 - alertlayer.height() / 2;
		alertlayer.css("z-index","999");
		alertlayer.css("position", "fixed");
		alertlayer.css("left", "0px");
		alertlayer.css("top", "0px");
		alertlayer.css("width", "100%");
		alertlayer.css("height", "100%");
		alertlayer.css("background-color", "rgba(0,0,0,0.8)");
		
		
		alertlayer.find(".map_close > a, .message_footer > img.close_btn").click(function() {
			alertlayer.remove();
			maskBackgroundOff();
		});
		
		alertlayer.find(".submit_btn").click(function() {
			alertlayer.remove();
			maskBackgroundOff();
			eval(fn);
		});
	};
	
	/* ConfirmFn 창 */
	confirmWinFn = function(msg, fn) {
		maskBackground("90000");
		
		$("body").append("<div id='AlertErrorMessage'></div>");
		
		alertlayer = $("#AlertErrorMessage");
		
		var html = "<div id='message_wrap'>" + 
		"	<div class='message_header'>" +
		"		<h2>확인 메세지</h2>" +
		"		<p class='map_close'><a href='#'><img src='/reservation/img/common/btn_close.png' /></a></p>" +
		"	</div>" +
		"	<div class='message_content'>" + msg + "</div>" +
		"	<div class='message_footer'>" + 
		"		<ul class='btn_set'>" +
		"			<li class='btn_default submit_btn'><a href='#'>확인</a></li>" +
		"			<li class='btn_default close_btn'><a href='#'>취소</a></li>" +
		"		</ul>" +
		"	</div>" +
		"</div>";
		
		alertlayer.html(html);
		
				
		var alertleft = $(window).width() / 2 - $("#message_wrap").width() / 2;
		var alerttop = $(window).height() / 2 - alertlayer.height() / 2;
		alertlayer.css("z-index","999");
		alertlayer.css("position", "fixed");
		alertlayer.css("left", "0px");
		alertlayer.css("top", "0px");
		alertlayer.css("width", "100%");
		alertlayer.css("height", "100%");
		alertlayer.css("background-color", "rgba(0,0,0,0.8)");
		
		
		alertlayer.find(".map_close > a, .btn_set > .close_btn").click(function() {
			alertlayer.remove();
			maskBackgroundOff();
		});
		
		alertlayer.find(".btn_set > .submit_btn").click(function() {
			alertlayer.remove();
			maskBackgroundOff();
			fn();
		});
	};
	
	/* 장애인 번호 및 유공자번호 입력시 한글 및 특수문자 입력 방지 */
	$(".meritNoinputChk").bind("blur keyup", function() {
		  $(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
		  $(this).val( $(this).val().replace( /[ \{\}\[\]\/?.,;:|\)*~`!^\_+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
	});
	/* 한글 입력 방지 */
	$(".hangleChk").bind("blur keyup", function() {
		  $(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
	});
	/* 특수문자 입력 방지 */
	$(".specialChk").bind("blur keyup", function() {
		  $(this).val( $(this).val().replace( /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
	});
});
//a 태그 점선테두리 없애기
function bluring(){
	if(event.srcElement.tagName=="A"||event.srcElement.tagName=="IMG") {
		document.body.focus();
	}
}

document.onfocusin=bluring;

function showFlash(flaFile, widths, heights, btrans) { 
  var strings = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" width="' + widths + '"  height="' + heights + '"><param name="movie" value="' + flaFile + '"> <param name="quality" value="high"> '; 
  if (btrans == 'y') { 
    strings += '<param name="wmode" value="transparent">'; 
  } 
  strings += '<embed src="' + flaFile + '" quality="high"  wmode="transparent" pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="' + widths + '" height="' + heights + '"> </embed> </object>'; 
  document.write(strings); 
  return; 
} 

function getObject(objectId) {
  if(document.getElementById && document.getElementById(objectId)) {  
    return document.getElementById(objectId); // check W3C DOM
  }
  else if (document.all && document.all(objectID)) {  
    return document.all(objectID); // IE4
  }
  else if (document.layers && document.layers[objectID]) {  
    return document.layer[objectID]; // NN4
  }
  else {
    return false;
  }
}

function divCls(comeon)
{
  
  if(comeon == 'close') {
    getObject('message').style.display="none";
  }
}  

    
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

//메인 검색탭
function MM_showHideLayers() { //v9.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) 
  with (document) if (getElementById && ((obj=getElementById(args[i]))!=null)) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}



function menuclick(srcID, pos, totalCnt)
{ 
  for(i=0; i < totalCnt; i++)
  {
      // Tab 메뉴 선택 표시
      var sub_srcID = srcID + i;

      if (i == pos) {
        getObject(sub_srcID).style.display = "block";
      }
      else {
        getObject(sub_srcID).style.display = "none";
      }
  }
}     


/* 방 상세정보 */
function win_roomInfo(URL) {
  downwin=window.open(URL,'win_roomInfo','scrollbars=yes,width=800,height=600')
  downwin.focus();
}

/* 방 상세정보 */
function winOpen(URL,w,h) {
	var winL = (screen.width-Number(w))/2;
    var winT = (screen.height-Number(h))/2;
    var opt = "menubar=no, scrollbars=yes,status=no,resizable=yes,width="+w+",height="+h+",top="+winT+",left="+winL;
	win=window.open(URL,'win',opt)
	win.focus();
}

//공백체크(null, space)
function isEmpty(str) {
  for (var i=0; i<str.length; i++) {
    if (str.substring(i, i+1) != " ") return false;
  }

  return true;
}

/**
 * 프린터 처리.
 */
function contentPrint() {
    var windowLeft = (screen.width-640)/2;
    var windowTop = (screen.height-480)/2;

    var printURL = "/common/popup/forPrint.action";

    window.open(printURL,"print",'width=700, height=550, menubar=no, scrollbars=yes,status=no,resizable=yes,top=' + windowTop + ',left=' + windowLeft + '');
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}

function Moves() {
  var myindex = SiteGo.selectedIndex;
  urls = SiteGo.options[myindex].value;
  window.open(urls);
}

ie = document.all?1:0

function CA(frm){

    if (frm.allbox.value == "Y"){
         frm.allbox.value = "";
    } else {
         frm.allbox.value = "Y";
    }
  for (var i=0;i<frm.elements.length;i++) {
    var e = frm.elements[i]; 
    if ((e.type=='checkbox') && (e.name=='sa')) {
      e.checked = frm.allbox.value;
      if (frm.allbox.value == "Y") {
        hL(e);
      } else {
        dL(e);
      }
    }
  }
}

function CCA(CB){
  if (CB.checked)
    hL(CB);
  else
    dL(CB);
}

function hL(E){
  if (ie) {
    while (E.tagName!="TR") {
      E=E.parentElement;
    }
  } else {
    while (E.tagName!="TR") {
      E=E.parentNode;
    }
  }
}
  
function dL(E){
  if (ie) {
    while (E.tagName!="TR") {
      E=E.parentElement;
    }
  } else {
    while (E.tagName!="TR") {
      E=E.parentNode;
    }
  }
//  E.className = "";
}

//이미지 리사이즈
function JsImgResize(img) {
  // 원본 이미지 사이즈 저장
  var width = img.width;
  var height = img.height; 

  // 가로, 세로 최대 사이즈 설정
  var maxWidth = 500;   // 원하는대로 설정. 픽셀로 하려면 maxWidth = 100  이런 식으로 입력
  var maxHeight = height * 0.5;   // 원래 사이즈 * 0.5 = 50%

  // 가로나 세로의 길이가 최대 사이즈보다 크면 실행  
  if (width > maxWidth) {  // 가로가 세로보다 크면 가로는 최대사이즈로, 세로는 비율 맞춰 리사이즈
    resizeWidth = maxWidth;
//    resizeHeight = Math.Round((height * resizeWidth) / width);
  } else {  // 최대사이즈보다 작으면 원본 그대로
    resizeWidth = width;
    resizeHeight = height;
  }

  // 리사이즈한 크기로 이미지 크기 다시 지정
  img.width = resizeWidth;
//  img.height = resizeHeight;
}

/**
 *  주민등록번호의 유효성을 체크한다.
 */
function isValidJuminNo(juminno) {
  if(juminno=="" || juminno==null || juminno.length!=13) {
    alert("주민등록번호를 적어주세요.");
    return false;
  }
  
  var jumin1 = juminno.substr(0,6);
  var jumin2 = juminno.substr(6,7);
  var yy     = jumin1.substr(0,2);        // 년도
  var mm     = jumin1.substr(2,2);        // 월
  var dd     = jumin1.substr(4,2);        // 일
  var genda  = jumin2.substr(0,1);        // 성별
  var msg, ss, cc;

  // 숫자가 아닌 것을 입력한 경우
  if (!isNumeric(jumin1)) {
    alert("주민등록번호 앞자리를 숫자로 입력하세요.");
    return false;
  }
  
  // 길이가 6이 아닌 경우
  if (jumin1.length != 6) {
    alert("주민등록번호 앞자리를 다시 입력하세요.");
    return false;
  }
  
  // 첫번째 자료에서 연월일(YYMMDD) 형식 중 기본 구성 검사
  if (yy < "00" 
      || yy > "99" 
      || mm < "01" 
      || mm > "12" 
      || dd < "01" 
      || dd > "31") {
    alert("주민등록번호 앞자리를 다시 입력하세요.");
    return false;
  }
  
  // 숫자가 아닌 것을 입력한 경우
  if (!isNumeric(jumin2)) {
    alert("주민등록번호 뒷자리를 숫자로 입력하세요.");
    return false;
  }

  // 길이가 7이 아닌 경우
  if (jumin2.length != 7) {
    alert("주민등록번호 뒷자리를 다시 입력하세요.");
    return false;
  }
  
  // 성별부분이 1 ~ 4 가 아닌 경우
  if (genda < "1" || genda > "4") {
    alert("주민등록번호 뒷자리를 다시 입력하세요.");
    return false;
  }
 
  // 연도 계산 - 1 또는 2: 1900년대, 3 또는 4: 2000년대
  cc = (genda == "1" || genda == "2") ? "19" : "20";
  // 첫번째 자료에서 연월일(YYMMDD) 형식 중 날짜 형식 검사
  if (isValidDate(cc+yy+mm+dd) == false) {
    alert("주민등록번호 앞자리를 다시 입력하세요.");
    return false;
  }
  
  // Check Digit 검사
  if (!isSSN(jumin1, jumin2)) {
    alert("입력한 주민등록번호를 검토한 후, 다시 입력하세요.");
    return false;
  }
  return true;
}

function isValidDate(iDate) {
  if( iDate.length != 8 ) {
    return false;
  }
   
  oDate = new Date();
  oDate.setFullYear(iDate.substring(0, 4));
  oDate.setMonth(parseInt(iDate.substring(4, 6)) - 1);
  oDate.setDate(iDate.substring(6));

  if( oDate.getFullYear()     != iDate.substring(0, 4) 
      || oDate.getMonth() + 1 != iDate.substring(4, 6) 
      || oDate.getDate()      != iDate.substring(6) ){
     
    return false;
  }
    
  return true;
}

 

function isNumeric(s) { 
  for (i=0; i<s.length; i++) { 
    c = s.substr(i, 1); 
    if (c < "0" || c > "9") return false; 
  } 
  return true; 
}

 

function isSSN(s1, s2) {
  n = 2;
  sum = 0;
  for (i=0; i<s1.length; i++)
    sum += parseInt(s1.substr(i, 1)) * n++;
  for (i=0; i<s2.length-1; i++) {
    sum += parseInt(s2.substr(i, 1)) * n++;
    if (n == 10) n = 2;
  }
  
  c = 11 - sum % 11;
  if (c == 11) c = 1;
  if (c == 10) c = 0;
  if (c != parseInt(s2.substr(6, 1))) return false;
  else return true;
}


/**
 *  사업자등록번호의 유효성을 체크한다.
 */

function isValidCsnNo(csn) {
    var strNumb = csn;
    if (strNumb.length != 10) {
        alert("사업자등록번호가 잘못되었습니다.");
        return false;
    }
    
        sumMod  =   0;
        sumMod  +=  parseInt(strNumb.substring(0,1));
        sumMod  +=  parseInt(strNumb.substring(1,2)) * 3 % 10;
        sumMod  +=  parseInt(strNumb.substring(2,3)) * 7 % 10;
        sumMod  +=  parseInt(strNumb.substring(3,4)) * 1 % 10;
        sumMod  +=  parseInt(strNumb.substring(4,5)) * 3 % 10;
        sumMod  +=  parseInt(strNumb.substring(5,6)) * 7 % 10;
        sumMod  +=  parseInt(strNumb.substring(6,7)) * 1 % 10;
        sumMod  +=  parseInt(strNumb.substring(7,8)) * 3 % 10;
        sumMod  +=  Math.floor(parseInt(strNumb.substring(8,9)) * 5 / 10);
        sumMod  +=  parseInt(strNumb.substring(8,9)) * 5 % 10;
        sumMod  +=  parseInt(strNumb.substring(9,10));
    
    if (sumMod % 10  !=  0) {
        alert("사업자등록번호가 잘못되었습니다.");
        return false;
    }
  return true;
}

function maskBackground(zidx) {
	$("body").append("<div id='BackMask' style='position:fixed;left:0;top:0;background-color:rgba(0,0,0,0.8);width:100%;height:100%'></div>");
	noclicklayer = $("#BackMask");
	
	noclicklayer.fadeTo("fast", 0.8);
}

function com(n) {
	n=Number(n);
	var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식
	n += ''; // 숫자를 문자열로 변환
	
	while (reg.test(n)) {
		n = n.replace(reg, '$1' + ',' + '$2');
	}
	return n;
}

function maskBackgroundOff() {
	noclicklayer = $("#BackMask");
	noclicklayer.remove();
}
/* jQuery IE Slide Function's Bug Fix */
$.fn.slideToggle = function (_speed,_function) {
	$(this).toggle('slide',{direction:'up'},_speed,_function);
}
$.fn.slideUp = function (_speed,_function) {
	if (!$(this).is(':hidden')) {
		$(this).hide('slide',{direction:'up'},_speed,_function);
	} else {
		if (_function)
			_function.call();
	}
}
$.fn.slideDown = function (_speed,_function) {
	if ($(this).is(':hidden')) {
		$(this).show('slide',{direction:'up'},_speed,_function);
	} else {
		if (_function)
			_function.call();
	}
}



//숫자입력
function isInputNumber(e) {
	// 숫자패드
	if (e.which >= 48 && e.which <= 57) { return true; }
	// 우측숫자패드
	if (e.which >= 96 && e.which <=105) { return true; }
	// 방향키
	if (e.which >= 73 && e.which <= 40) { return true; }
	// Home, End ..
	if (e.which >= 33 && e.which <= 36) { return true; }
	// 기능키들(Backspace, Del 등)
	if (e.which == 8 || e.which == 9 || e.which == 13 || e.which == 46) { return true; }
	
	return false;
}

function isStringChk(thisObj){
	thisObj.bind("blur keyup", function() {
	  $(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
	});
}

//@@@@@@@@@@ 스크립트 거리 체크 start
function distance_check(lat1,lat2,lon1,lon2){
	var theta = lon1 - lon2;
	var dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	dist = Math.acos(dist);
	dist = rad2deg(dist);
	dist = dist * 60 * 1.1515;
	 
	dist = dist * 1609.344;

	return (dist);
	
}

function deg2rad(deg){
	return (deg * Math.PI / 180.0);
}

function rad2deg(rad){
	return (rad * 180 / Math.PI);
}
//@@@@@@@@@@ 스크립트 거리 체크 end