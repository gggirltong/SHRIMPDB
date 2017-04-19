<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%><!DOCTYPE html>
<html>
<head>
<title>添加制度公告</title>
<%@ include file="/WEB-INF/views/layouts/meta.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<link href="${ctx}/static/css/globle.css" type="text/css" rel="stylesheet" />

<script src="${ctx}/static/js/jquery.js" type="text/javascript"></script>

<script type="text/javascript" src="${ctx}/static/js/jquery.form.js"></script>
<link rel="stylesheet" href="${ctx}/static/kindeditor-4.1.7/themes/default/default.css" />
<link rel="stylesheet" href="${ctx}/static/kindeditor-4.1.7/plugins/code/prettify.css" />
<script charset="utf-8" src="${ctx}/static/kindeditor-4.1.7/kindeditor.js"></script>
<script charset="utf-8" src="${ctx}/static/kindeditor-4.1.7/lang/zh_CN.js"></script>
<script charset="utf-8" src="${ctx}/static/kindeditor-4.1.7/plugins/code/prettify.js"></script>
<script>
//主要功能
 KindEditor.ready(function(K) {
			var editor = K.create('textarea[class="content"]', {
				cssPath : '${ctx}/static/kindeditor-4.1.7/plugins/code/prettify.css',
				uploadJson : '${ctx}/static/kindeditor-4.1.7/jsp/upload_json.jsp',
				fileManagerJson : '${ctx}/static/kindeditor-4.1.7/jsp/file_manager_json.jsp',
				allowFileManager : true,
				 resizeType:1,
				filterMode : true,
        items:[ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
                'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                'anchor', 'link', 'unlink', '|', 'about'
  ],


         
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			
			prettyPrint();
		});
		</script>
</head>

<body>
	<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
	<form:form  modelAttribute="news" method="post" action="addnews">
	<div  class="dev_one1 gzzd">
	<table >
	<tr>
	     <td width="540" style="padding-left:36px;" >标题：<form:input path="title"  style="width:400px"/></td>            
	<td width="400" align="right" ><form:select path="flag"  style="width:100px" >
        <option selected="selected" value="2">新闻公告</option>
        <option value="1">规章制度</option>
        <option value="0">平台概况</option>
        </form:select></td>
	</tr>
	</table>
		</div>
<div class="border">
	<div class="kinde"><form:textarea  path="content" style="width: 900px;height:400px;text-align:center;" class="content" /></div>
	<div style="margin-top:30px;position:relative;" ><p align="center"><button style="width:60px;background-color:#ddd;border-color:#ddd;line-height:20px;" type="submit" >保存 </button></p></div>
		
		</div>
	</form:form>
	<%@ include file="/WEB-INF/views/layouts/footer.jsp"%></body></html>
	