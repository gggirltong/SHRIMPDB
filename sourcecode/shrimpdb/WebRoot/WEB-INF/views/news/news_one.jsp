<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%><!DOCTYPE html>
<html>
<head>
<title>制度公告</title>
<%@ include file="/WEB-INF/views/layouts/meta.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">

<script>
KindEditor.ready(function(K) {
			var editor = K.create('textarea[class="content"]', {
				cssPath : '${ctx}/static/kindeditor-4.1.7/plugins/code/prettify.css',
				uploadJson : '${ctx}/static/kindeditor-4.1.7/jsp/upload_json.jsp',
				fileManagerJson : '${ctx}/static/kindeditor-4.1.7/jsp/file_manager_json.jsp',
				allowFileManager : true,
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
	<div  class="dev_one1">
	<table>
	<tr>
	            <td width="540" style="padding-left:36px;" class="welco">${onenews.title}</td>
	            <td width="300" align="right" > <shiro:hasPermission name="sys:news:edit"> <a href="editnews?id=${onenews.id}" class="welco1">编辑</a></shiro:hasPermission>  </td>			        						
			
	        
	</tr>
	
	</table>
		</div>
<div class="ptgk" >
<table>

			
		<tr><td  style="padding-left:10px;padding-top:10px;">${onenews.content}</td><tr/>	
			
		</table>	
  </div>
		

	<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
</body>
</html>