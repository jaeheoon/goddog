$(function ($) {

  $('#_BTN_REMOVE').live('click', function () {
    var seq = $(this).parents('ul:first').attr('id');
    if (seq != '') {
      $('#_DEL_LIST').append('<input type="hidden" name="delFileList" value="' + seq + '" />');
    }
    $(this).parents('ul:first').remove();
  });

  // 취소버튼 클릭
  $('#btnCancel').css('cursor', 'pointer').click(function () {
    history.back();
  });

  // 확인버튼 클릭
  $('#btnSubmit').css('cursor', 'pointer').click(function () {
    if (basicValidate()) {

      confirmWinFn("게시글을 등록하시겠습니까?", function () {
        form.action = "/community/board/review/boardRegist.action";
        var t_nm = $("#ntart_subjc").val();
        if (t_nm == null || t_nm == "undefined" || t_nm == "") {
          alert("제목을 입력해 주세요.");
          return false;
        }

        var captcha = $("#captcha").val();
        if (captcha == null || typeof captcha == "undefined" || captcha == "") {
          alert("자동등록방지 숫자를 입력해 주세요.");
          return false;
        }

        form.submit();
      });



    }
  });

  // captcha reload
  $("#reloadCaptcha").click(function () {
    reloadCaptcha();
  });

  // 숫자입력만 가능
  $(".onlyNumber").keyup(function () {
    var regex = /[^0-9]/gi;
    var value = this.value;
    if (regex.test(value)) {
      alert("숫자만 입력 가능합니다.");
      $(this).val(value.replaceAll(/[^0-9]/gi, ""));
      $(this).blur();
    }
  });
});

/** Validate 체크 */
function basicValidate() {

  return true;
}

function reloadCaptcha() {
  var time = new Date().getTime();
  var src = "/boardCaptcha.action?time=" + time;
  $("#captchaImg").attr("src", src);
  $("#captcha").val("");
}

// 파일추가
function addFile(obj) {
  var id = obj.id;
  var index = parseInt(id.split("_")[1]) + 1;
  var newObj = $(obj).clone();
  newObj.attr("id", "multipartFile_" + index).val("");
  var parentObj = $(obj).parent();
  parentObj.append(newObj);
}

$(function () {
  // This is a check for the CKEditor class. If not defined, the paths must be checked.
  if (typeof CKEDITOR == 'undefined') {
    $("#cntns_bdtxt_cont").parent().html(
      '<strong><span style="color: #ff0000">Error</span>: CKEditor not found</strong>.' +
      'This sample assumes that CKEditor (not included with CKFinder) is installed in' +
      'the "/ckeditor/" path. If you have it installed in a different place, just edit' +
      'this file, changing the wrong paths in the &lt;head&gt; (line 5) and the "BasePath"' +
      'value (line 32).');
  }
  else {
    var editor = CKEDITOR.replace('cntns_bdtxt_cont');
    editor.config.width = $("#cntns_bdtxt_cont").width();
    editor.config.toolbar = [
      ['Source', '-', 'NewPage', 'Preview', '-', 'Templates'],
      ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo'],
      ['Bold', 'Italic'],
      ['Font']
    ];
    //editor.setData( '<p>Just click the <b>Image</b> or <b>Link</b> button, and then <b>&quot;Browse Server&quot;</b>.</p>' );

    // Just call CKFinder.setupCKEditor and pass the CKEditor instance as the first argument.
    // The second parameter (optional), is the path for the CKFinder installation (default = "/ckfinder/").
    CKFinder.setupCKEditor(editor, '/CKFinderJava/ckfinder/');

    // It is also possible to pass an object with selected CKFinder properties as a second argument.
    // CKFinder.setupCKEditor( editor, { basePath : '../', skin : 'v1' } ) ;
  }
});