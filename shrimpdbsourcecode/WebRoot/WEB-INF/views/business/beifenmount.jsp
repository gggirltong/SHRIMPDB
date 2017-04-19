<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>样品靶制备</title>
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
</head>
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
    <td width="200" style="padding-left:36px;">待处理样品</td>	
     <td style="padding-left:100px;"><a href="${ctx}/user/adduser">制靶</a></td>    		        									                	        									
    </tr>	
	</table>
</div>
<!--第二步：添加如下 HTML 代码-->
<table id="example" class="display" cellspacing="0" width="100%">     
<thead>
            <tr>
                <th>序号</th>
                <th>样品编号</th>
                <th>送样人</th>            
                <th>送样单位</th>          
                <th>送样时间</th>
                        
            </tr>
        </thead>
    </table>
   
<table id="examplejson" class="display" cellspacing="0" width="100%">     
</table>
 <%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
 </body>
 <!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/business/mount",
				type: "post",
				contentType: "application/json",
				dataType: "json",							
				success: function(json)
				{
				showtable(json);
			    console.log(json);			 	     
 	    	 	},
 	      	    error: function(XMLHttpRequest, textStatus, errorThrown)
 	      	    {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
                }
			});
});

function showtable(json)
{ 
	var data = json;
	var table=  $('#example').DataTable( 
	{
        data: data,
        //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
        //data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
        columns: [
             { data: 'id' },
             { data: 'code' },
             { data: 'name'},        
             { data: 'unit'},
             { data: 'phone'},
                      
       			 ],
        dom: 'Bfrtip',
        buttons: [
             {                         
                extend: 'excelHtml5',
                title: 'Data export'
             },
             {
                extend: 'pdfHtml5',
                title: 'Data export'
             },
             {
                extend: 'csvHtml5',
                title: 'Data export'
             },            
        ]  
     });}
</script></html>