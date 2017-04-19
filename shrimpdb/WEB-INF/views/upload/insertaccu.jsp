<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>数据上传</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${ctx}/static/inputfile/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/inputfile/fileinput.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入）
<link rel="stylesheet" href="${ctx}/static/css/bootstrap-theme.min.css"> -->
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${ctx}/static/inputfile/jquery.se.js"></script>
<script src="${ctx}/static/js/jquery.min.js"></script>
<script src="${ctx}/static/inputfile/fileinput.min.js"></script>
<script src="${ctx}/static/inputfile/fa.js"></script>
<script src="${ctx}/static/inputfile/es.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${ctx}/static/inputfile/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<fieldset>
<legend> 请上传测试数据</legend></fieldset>
<input id="input-700" name="kartik-input-700[]" type="file" multiple class="file-loading"  >
<script>
window.onload = function(){ var value = prompt('输入样品靶名称：', '');  
    if(value == null){  
        alert('你取消了输入！');  
    }else if(value == ''){  
        alert('姓名输入为空，请重新输入！');  
        show_prompt();  
    }else{  
         
        sort(value);
    }  
}

function sort(value){

$("#input-700").fileinput({
   uploadUrl: '${ctx}/upload/uploadaccu', // server upload action
   uploadAsync: true,
   uploadExtraData:   {mountname:value},
   browseClass: "btn btn-success",
   browseLabel: "Pick files",
   browseIcon: "<i class=\"glyphicon glyphicon-picture\"></i> ",
   removeClass: "btn btn-danger",
   removeLabel: "Delete",
   removeIcon: "<i class=\"glyphicon glyphicon-trash\"></i> ",
   uploadClass: "btn btn-info",
   uploadLabel: "Upload",
   uploadIcon: "<i class=\"glyphicon glyphicon-upload\"></i> ",
   previewClass: "bg-warning",
   allowedFileExtensions: ["prn"],
       
});}

</script>
<!-- <label class="control-label">Select File</label>
<form action="uploadfiles" method="post">
<input id="input-43" name="input43[]" type="file" multiple class="file-loading"></form>
<div id="errorBlock" class="help-block"></div>
<script>
$(document).on('ready', function() {
    $("#input-43").fileinput({
        showPreview: false,
        elErrorContainer: "#errorBlock"
    });
});
</script> -->
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
</body>
</html>