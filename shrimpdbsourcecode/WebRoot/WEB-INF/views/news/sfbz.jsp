<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%><!DOCTYPE html>
<html>
<head>
<title>仪器列表</title>
<%@ include file="/WEB-INF/views/layouts/meta.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
</head>
<body>
	<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
	
	<div class="dev_one">
	<table>
	<tr>
	            <td style="padding-left:38px;">收费标准</td></tr>

	</table>
	</div>	
<div class="ptgk" >
<table>

			
		<tr><td style="padding-left:8px;">${sfbz.content}</td><tr/>		
		</table>		
	</div>
	<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
</body>
</html>