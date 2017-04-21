<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>register page</title>
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
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${ctx}/static/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<link   href="${ctx}/static/validator/jquery.validator.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/validator/jquery.validator.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/local/zh_CN.js" type="text/javascript"></script>
<style type="text/css">
.kongbai{}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
    <td width="200" style="padding-left:36px;">Registration Form</td>	       									                	        									
    </tr>	
	</table>
</div>
<div  class="dakuang kongbai">
<!-- Form Name -->
<form:form  class="form-horizontal" modelAttribute="user" action="reg" method="post" enctype ="multipart/form-data">
<fieldset>

<p class="alert fade in alert-danger<c:if test='${error==null}'> hide</c:if>">
<button type="button" class="close" data-dismiss="alert">×</button>${error}
</p>
<!-- Text input-->
<div class="control-group">
<label   class="control-label"  for="username" >Username:</label>

<form:input path="username" type="text" data-rule="required;username"  class="input-xlarge" />   

</div>
<!-- Text input-->
<div class="control-group">
<label class="control-label"   for="name">Name:</label>

<form:input path="name" type="text"  class="input-xlarge" data-rule="required"/>    

</div>
<div class="control-group">
<label class="control-label"    for="phone">Telephone:</label>

<form:input path="phone" type="text"  class="input-xlarge" data-rule="required;mobile" />

</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="email">Email:</label>

  <form:input path="email" type="text"  class="input-xlarge" data-rule="required;email"/>   
 
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label"   for="unit">Unit:</label>
 
    <form:input path="unit" type="text"  class="input-xlarge" data-rule="required"/>
    

</div>

<!-- Text input-->
<div class="control-group"> 
  <label class="control-label"   for="department">Department:</label>

    <form:input path="department" type="text"  class="input-xlarge" data-rule="required"/> 

</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label"  for="degree">Degree:</label>
   <form:input path="degree" type="text"  class="input-xlarge" data-rule="required"/>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label"  for="address">Address:</label>
  <form:input path="address" type="text" placeholder="12" class="input-xlarge" data-rule="required"/>   
</div>
<div  class="control-group"><label   class="control-label">Published Literature(请使用英文title):</label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="input-1" data-rule="required" name="paper1" type="file" class="file" data-show-upload="false" data-show-caption="true">
</div>
<div  class="control-group"><label class="control-label">Published Literature:</label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="input-2" data-rule="required" name="paper2" type="file" class="file"  data-show-upload="false" data-show-caption="true">
</div>
<div  class="control-group"><label class="control-label">Published Literature:</label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="input-3" data-rule="required" name="paper3" type="file" class="file"  data-show-upload="false" data-show-caption="true">
</div>
<div  class="control-group">
<label class="control-label">Profile Picture </label>
<input id="input-7" name="imag" type="file" class="file file-loading"  data-allowed-file-extensions='["jpg", "png"]'>
<div class="control-group">
  <label class="control-label" for="submit"></label>
  <div class="controls">
	<p align="center"><button id="submit" name="submit" class="btn btn-info">Register</button></p>				
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="LonEW"></label>
  <div class="controls">  
  </div>
</div>
</fieldset>
</form:form>
</div>
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
</body>
</html>