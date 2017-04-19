<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
	
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<link href="${ctx}/static/css/style.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/css/demo.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/css/bootstrap.css" type="text/css" rel="stylesheet" />
<%@ include file="/WEB-INF/views/layouts/meta.jsp" %>
<style type="text/css">
.form-signin{max-width:350px;padding:19px 29px 29px;margin:60px auto 20px;border:1px solid #e5e5e5;}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
	<div class="dakuang">
		<div >
			<section class="main">    
		<form  class="form-4" id="loginForm" method="post" action="${ctx}/login" >
			<h1>Login or Register</h1>
		    <p class="alert fade in alert-danger<c:if test='${error==null}'> hide</c:if>">
		    <button type="button" class="close" data-dismiss="alert">×</button>${error}
			<i class="icon-user icon-large"></i>
			</p>
			<p class="field">
			<input id="username" name="username" data-rule="required;username" value="${username}" type="text" placeholder="用户名" class="input-xlarge">
			</p>
				<p>
					<input id="pass" name="pass" data-rule="required;password" type="password" placeholder="密码" class="input-xlarge">
				</p>
			<p class="field">
					<input id="password" name="password" type="password" placeholder="密码" class="input-xlarge" style="display: none">
				<i class="icon-user icon-large"></i>
					</p>
				<p align="center"><input type="submit" id="save" class="buttoncss" value="登录" ></p>				
		</form>
		</section>
	</div></div>
<script src="${ctx}/static/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/static/js/md5.js" type="text/javascript"></script>
<script src="${ctx}/static/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/jquery.validator.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/local/zh_CN.js" type="text/javascript"></script>
<script>$(document).ready(function(){if($("#username").val()) $("#pass").focus(); else $("#username").focus();});</script>
<script type="text/javascript">  
$("#save").click(function() {
	var pwd=document.getElementById("pass").value;
	document.getElementById("password").value=hex_md5(pwd);   
	$('#loginForm').submit();		
});
</script> 
	<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
</body>
</html>