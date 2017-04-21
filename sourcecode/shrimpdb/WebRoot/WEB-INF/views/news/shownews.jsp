<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>新闻公告</title>
<%@ include file="/WEB-INF/views/layouts/meta.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/flexigrid.css" />

</head>
<body>
	<%@ include file="/WEB-INF/views/layouts/header.jsp"%>

	<div class="dev_one">
		<table>
			<tr>
				<td width="540" style="padding-left:36px;">制度公告</td>
				<shiro:hasPermission name="sys:news:add">
					<td width="320" align="right"><a class="welco1"
						href="addnews">添加制度公告</a>
					</td>
				</shiro:hasPermission>
				<shiro:lacksPermission name="sys:news:add">
					<td width="100"><font class="welco">...</font>
					</td>
				</shiro:lacksPermission>
			</tr>

		</table>
	</div>
<div class="dakuang">
	<div>
		<table id="newslist" style="display: none"></table>
	</div>
	
</div>

	<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
<script src="${ctx}/static/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/static/js/flexigrid.js"></script>
<script type="text/javascript"> 
$(function(){
	var newslist = {
		url:'${ctx}/news/newscc',
		dataType:'json',
		colModel:[
					{display:'序号',name:'xh',width:60,align:'center'},
					{display:'标题',name:'n.title',width:447},
					{display:'时间',name:'n.update',width:250,align:'center'},
					{display:'操作',name:'cz',width:130,align:'center',process:formatOpt}
				],
				
		usepager:true,
		title:false,
		useRp:true,
		rp:10,
		autoload:true,
		showTableToggleBtn:false,
		width:'auto',
		height:'auto',
		onError:function(data){alert(data.msg);}
	};	
	
    $("#newslist").flexigrid(newslist);
    
    function formatOpt(dom,value) {
		var value=$(dom).text();
		$(dom).html("<a href='${ctx}/news/news_one?id=" + value + "'>" + "查看" + "</a>");
        /*
		<shiro:hasPermission name="sys:news:edit">
		$(dom).html("<a href='${ctx}/news/news_one?id=" + value + "'>" + "查看" + "</a>" + "&nbsp;|&nbsp;<a href='${ctx}/news/editnews?id=" + value + "'>" + "编辑" + "</a>");
		</shiro:hasPermission>
        */
		<shiro:hasPermission name="sys:news:del">
		$(dom).html("<a href='${ctx}/news/news_one?id=" + value + "'>" + "查看" + "</a>" + "&nbsp;|&nbsp;<a href='${ctx}/news/editnews?id=" + value + "'>" + "编辑" + "</a>"+ "&nbsp;|&nbsp;<a href='${ctx}/news/deleteNews?id=" + value + "'>" + "删除" + "</a>");
		</shiro:hasPermission>
	}
});
</script> 
</body>
</html>