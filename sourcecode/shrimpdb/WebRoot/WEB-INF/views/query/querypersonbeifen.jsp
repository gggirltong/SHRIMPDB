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
  <script type="text/javascript" charset="utf8" src="${ctx}/static/js/echarts.min.js"></script>

</head>
<body>
<style>

</style>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<!--第二步：添加如下 HTML 代码-->
	<div  class="dev_one">
	<table>
	<tr>
	            <td width="200" style="padding-left:36px;">个人数据信息</td>
	            <td  style="padding-left:200px;"><a href="${ctx}/query/mapperson">个人数据分布</a></td>
	            <td style="padding-left:100px;"><a href="${ctx}/upload/metaupload">添加数据</a></td>    		        									
                <td style="padding-left:100px;"><a href="${ctx}/query/openlist">数据开放管理</a></td>    		        									
   
   </tr>	
	</table></div>
	<div class="dakuang">
<table id="example" class="display" cellspacing="0" width="100%">     
  <thead>
            <tr>
                <th>样品编号</th>
                <th>岩性信息</th>
                <th>采样地点</th>            
                <th>测样时间</th>               
            </tr>
        </thead>
    </table>
    <input id ="jsonbutton"  type="button" value="查询测试点数据" style="display:none;" >

<table id="examplejson"  cellspacing="0" width="100%">   
   <tr>
                 <th>spotname</th>
                <th>Pb206/U238age</th>
                <th>Pb206/U238error</th>            
                <th>U(ppm)</th>          
                <th>Th(ppm)</th>      
                <th>Th/U(ppm)</th>  
            </tr>    
</table> 
 </div>
 <%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>
 </body>
<!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/query/queryperson",
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
             { data: 'code' },
             { data: 'lithologic' },
             { data: 'position'},        
           
             { data: 'testdate'},       
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
		
		var dataid=table.rows('.selected').data();	
    	var a=dataid.length;
		var samplearr=new Array();
		for(var si=0;si<a;si++)
		{
			samplearr[si]=dataid[si].ssid;
		}
	
 		$.ajax({		           
					url: "${ctx}/query/personage",
					type: "POST",									
					dataType: "json",	
					data: {"sidz": samplearr },		
					traditional: true,							
					success: function(json)
					{
					showjson(json);
			   		console.log(json);	
			   		//chartjson(json);			   		 	     
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
             { data: 'spotname' },
             { data: 'age204' },        
             { data: 'err204' },          
             { data: 'U' }, 
             { data: 'Th' }, 
             { data: 'ThU' }, 
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

		$.ajax({		           
					url: "${ctx}/analysis/charge",
					type: "POST",									
					dataType: "json",	
					data: {"sidz": samplearr },		
					traditional: true,							
					success: function(json)
					{
					alert(1);	     
 		 		    },
 	       	   		error: function(XMLHttpRequest, textStatus, errorThrown)
 	       		    {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                    }
			});
		});}
		   // 基于准备好的dom，初始化echarts实例
      
/*function chartjson(json){ 
 var myChart = echarts.init(document.getElementById('main'));
 myChart.setOption({
            title: {
                text: 'Pb204/U238 Age Distribution'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: ${json.spotname}
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: ${json.age204}
            }]
        });}        // 指定图表的配置项和数据*/
    
</script></html>