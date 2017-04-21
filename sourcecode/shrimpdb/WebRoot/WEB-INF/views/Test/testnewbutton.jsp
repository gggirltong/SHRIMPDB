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
</head>
<!--第二步：添加如下 HTML 代码-->
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
    <input id ="jsonbutton"  type="button" value="查询测试点数据" style="display:none;" >
<table id="examplejson" class="display" cellspacing="0" width="100%">
      
    </table>
 
 </body>
<!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/test",
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
             { data: 'lng' },
             { data: 'lat' },
             { data: 'sampleid'},        
             { data: 'lithologic'},
             { data: 'position'},
             { data: 'ssid'},       
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
     });

	$('#example tbody').on('click','tr',function()
	{
 	    $(this).toggleClass('selected');
		document.getElementById("jsonbutton").style.display="block";
    });
	$('#jsonbutton').click(function()
		{
		alert(table.rows('.selected').data().length+'row(s) selected');
		var dataid=table.rows('.selected').data();	
    	var a=dataid.length;
		var samplearr=new Array();
		for(var si=0;si<a;si++)
		{
			samplearr[si]=dataid[si].ssid;
		}
	
 		$.ajax({		           
					url: "${ctx}/Test/jsonage",
					type: "POST",									
					dataType: "json",	
					data: {"sidz": samplearr },		
					traditional: true,							
					success: function(json)
					{
					showjson(json);
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
}
function showjson(json)
{
	var data = json;
        //object可以如下初始化表格
    var table=  $('#examplejson').DataTable( {
        data: data,
        //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
        //data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
        columns: [
             { data: 'mountname' },
             { data: 'spotname' },
             { data: 'age204' },        
             { data: 'err204' },
             { data: 'sampleid' },
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
      });
}
</script></html>