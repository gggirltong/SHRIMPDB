<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/buttons.dataTables.min.css">
<script type="text/javascript" charset="utf8" src="${ctx}/static/DataTables-1.10.12/media/js/jquery.js"></script>
<script type="text/javascript" charset="utf8" src="${ctx}/static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="${ctx}/static/js/dataTables.buttons.min.js"></script>
<!-- <script type="text/javascript" charset="utf8" src="${ctx}/static/js/buttons.flash.min.js"></script>
 --><script type="text/javascript" charset="utf8" src="${ctx}/static/js/jszip.min.js"></script>
<script type="text/javascript" charset="utf8" src="${ctx}/static/js/pdfmake.min.js"></script>
<script type="text/javascript" charset="utf8" src="${ctx}/static/js/vfs_fonts.js"></script>
<script type="text/javascript" charset="utf8" src="${ctx}/static/js/buttons.html5.min.js"></script>
<script type="text/javascript" charset="utf8" src="${ctx}/static/js/buttons.print.min.js"></script>
<link rel="stylesheet" href="${ctx}/static/inputfile/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/inputfile/fileinput.min.css">
<script src="${ctx}/static/inputfile/fileinput.min.js"></script>
<script src="${ctx}/static/inputfile/fa.js"></script>
<script src="${ctx}/static/inputfile/es.js"></script>
<link   href="${ctx}/static/validator/jquery.validator.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/validator/jquery.validator.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/local/zh_CN.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
	 <td width="750" style="padding-left:36px;">已处理列表</td>
		 <td width="150" style="padding-left:36px;"><a href="${ctx}/business/testlist">已测试列表</a></td>		
    </tr>	
	</table>
</div>
<div class="dakuang">
<!--第二步：添加如下 HTML 代码-->

    
   
<form name="mounform" method="post" action="uploadprocess" enctype ="multipart/form-data">
<div  class="control-group">
<label   class="control-label">测试结果文件:</label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="input-1" data-rule="required" name="paper1" type="file" class="file" data-show-upload="false" data-show-caption="true">
<input type="submit" value="submit"/>
</div>	 
</form>
</div>