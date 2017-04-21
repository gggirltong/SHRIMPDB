<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="${ctx}/static/DataTables-1.10.12/media/css/jquery.dataTables.css">
 <link rel="stylesheet" type="text/css" href=" ${ctx}/static/DataTables-1.10.12/media/css/jquery-ui.css">
  
 <link rel="stylesheet" type="text/css" href=" ${ctx}/static/DataTables-1.10.12/media/css/dataTables.jqueryui.css">
 
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="${ctx}/static/DataTables-1.10.12/media/js/jquery.js"></script>
 
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="${ctx}/static/DataTables-1.10.12/media/js/jquery.dataTables.js"></script>
 
 
 
<title>welcome</title>

	</head>
	<body>
	<!-- <a href="${ctx}/query/querymap">地图查询</a> --> 
	
	<table id="example" class="display" cellspacing="0" width="100%">
    <thead>
            <tr>
                <th>lng</th>
                <th>lat</th>
                <th>sampleid</th>            
                <th>lithologic</th>
                <th>position</th>
                <th>ssid</th>               
            </tr>
        </thead>
</table>
 
 
	</body>
<script type="text/javascript">
$(function(){

          $.ajax({		           
				url: "${ctx}/test",
				type: "post",
				contentType: "application/json",
				dataType: "json",							
				success: function(json){
				showtable(json);
			    console.log(json);		
 		 	     
 		 	  },
 	       error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.status);
                        alert(XMLHttpRequest.readyState);
                        alert(textStatus);
                    }
			});
        });

  function showtable(json){
     var data = json;
        //object可以如下初始化表格
    $('#example').DataTable( {
         scrollY: 400,//表格内鼠标滚轮滚动，400设置的表格gaod
         scrollCollapse: true,
         jQueryUI: true,
        
        data: data,
        //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
        //data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
        columns: [
             { data: 'lng' },
             { data: 'lat' },
             { data: 'sampleid' },         
             { data: 'lithologic' },
             { data: 'position' },
             { data: 'ssid' },
             ]
    });}
    

</script>
</html>