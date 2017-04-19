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
<!--  <div  class="dev_one">
	<table>
	<tr>
	<td width="200" style="padding-left:36px;">测试数据添加</td> 	        									
   </tr>	
	</table>
	   </div>
	   <div class="dakuang">
<table>
<fieldset>
<legend> 背景信息</legend>-->
<!-- Text input-->
 <!--<tr><td> <label class="control-label" for="code">样品编号</label>
  <div class="controls">
   ${sample_detail.code}
  </div></td>
  <td> <label class="control-label" for="textinput">岩性信息</label>
  <div class="controls">
   ${sample_detail.lithologic}
  </div></td>
  <td>  <label class="control-label" for="position">采样位置</label>
  <div class="controls">
   ${sample_detail.postion} 
  </div></td>
  <td>
  <label class="control-label" for="LonEW">经度</label>
  ${sample_detail.lonEW}
  ${sample_detail.lonDeg}
  ${sample_detail.lonMin}
  ${sample_detail.lonSec}
  <td>
  <label class="control-label" for="LonEW">纬度</label>
  ${sample_detail.latNS}
  ${sample_detail.latDeg}
  ${sample_detail.latMin}
  ${sample_detail.latSec}
 </tr>
<tr><td>&nbsp;</td></tr>
 <tr>
 <td>  
  <label class="control-label" for="name">项目名称</label> 
 ${project.name}
 </td>
 <td>
  <label class="control-label" for="person">项目负责人</label> 
 ${project.person}
 </td>
 <td>
  <label class="control-label" for="projectcode">项目编号</label> 
  ${project.projectcode}
 </td>
 <td>
  <label class="control-label" for="source">项目来源</label> 
 ${project.source}
 </td>
<td>
   <label class="control-label" for="samplename">样品名称、数量、采样时间</label> 
${project.samplename}
${project.number}
${project.sampling_date}
</td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td>
  <label class="control-label" for="userid">送样人</label> 
  ${project.userid}
 </td>
 </tr>

</fieldset></table>-->
<br/>
<fieldset>
<legend> upload analytical file in excel format</legend></fieldset>
<input id="input-700" name="kartik-input-700[]" type="file" multiple class="file-loading" >
<script>
$("#input-700").fileinput({
   
   uploadUrl: '${ctx}/upload/uploadfiles', // server upload action
   uploadAsync: true,
   uploadExtraData:   {sampleid:'${sample_detail.id}'},
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
       
});
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
</script> --></div><%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	</body>
</html>