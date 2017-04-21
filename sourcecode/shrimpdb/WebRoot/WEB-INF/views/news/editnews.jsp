<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%><!DOCTYPE html>
<html>
<head>
<title>信息编辑</title>
<%@ include file="/WEB-INF/views/layouts/meta.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<script src="${ctx}/static/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/jquery.validator.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/local/zh_CN.js" type="text/javascript"></script>
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
			var editor1 = K.create('textarea[id="yqtp"]', {
				cssPath : '${ctx}/static/kindeditor-4.1.7/plugins/code/prettify.css',
				uploadJson : '${ctx}/static/kindeditor-4.1.7/jsp/upload_json.jsp',
				fileManagerJson : '${ctx}/static/kindeditor-4.1.7/jsp/file_manager_json.jsp',
				allowFileManager : true,
				 filterMode : true,
        items:[  'image'],
         
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
	<form:form  action="${ctx}/news/updatenews?id=${news.id}"  method="post"  modelAttribute="news" >
	<div  class="dev_one1 gzzd">
	<table>
	<tr>
	           <td style="padding-left:36px;"><form:input path="title" style="width:400px" value="${news.title}"/></td>
	        
	</tr>
	
	</table>
		</div>
	<div class="border">
	<div class="kinde">
			<form:textarea path="content" style="width: 900px;height:400px;" class="content" value="${news.content}"></form:textarea>
								
		</div>
	<div style="margin-top:15px;" ><p align="center"><button style="width:60px;background-color:#ddd;border-color:#ddd;line-height:20px;" type="submit" >保存 </button></p></div>
		
		</div>			

		</form:form>	
		
		
	</body></html>	

		