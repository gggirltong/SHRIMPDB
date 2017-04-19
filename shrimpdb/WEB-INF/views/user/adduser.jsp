<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>数据上传</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${ctx}/static/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${ctx}/static/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<link href="${ctx}/static/validator/jquery.validator.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/validator/jquery.validator.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/local/zh_CN.js" type="text/javascript"></script>
<title></title>
</head>
<body>
vas<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<p>
<!-- Form Name -->
<form:form  class="form-horizontal" modelAttribute="user"  method="post" enctype ="multipart/form-data">
<fieldset>
<div>
</div>
<div class="dakuang">
<legend> Fill in the form</legend>
 <p class="alert fade in alert-danger<c:if test='${error==null}'> hide</c:if>">
	<button type="button" class="close" data-dismiss="alert">×</button>${error}
 </p>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="selectbasic">Select User Type</label>
  <div class="controls">
    <form:select path="type" class="input-xlarge">
      <form:option value="2">实验员</form:option>
      <form:option value="9">制靶员</form:option>
      <form:option value="7">普通用户</form:option>
    </form:select>
  </div>
</div>
<div class="control-group">
  <label class="control-label" for="username">Username:</label>
  <div class="controls">
  <form:input path="username" type="text" data-rule="required;username" class="input-xlarge" />   
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="name">Name:</label>
  <div class="controls">
    <form:input path="name" type="text"  class="input-xlarge" data-rule="required"/>    
  </div>
</div>
<div class="control-group">
  <label class="control-label" for="phone">Telephone:</label>
  <div class="controls">
    <form:input path="phone" type="text"  class="input-xlarge" data-rule="required;mobile" />
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="email">Email:</label>
  <div class="controls">
  <form:input path="email" type="text"  class="input-xlarge" data-rule="required;email"/>   
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="unit">Unit:</label>
  <div class="controls">
    <form:input path="unit" type="text"  class="input-xlarge" data-rule="required"/>
    
  </div>
</div>
 
</div>
<div class="control-group">
  <label class="control-label" for="submit">Submit</label>
  <div class="controls">
    <button id="submit" name="submit" class="btn btn-info">Submit</button>
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
</p>
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>
</body>
</html>
<script type="text/javascript">

</script>