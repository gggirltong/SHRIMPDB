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
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
    <td width="800" style="padding-left:36px;">Data Sharing-fuzzy query</td>	        									                	        									
    </tr>	
	</table>
</div>
<!--第二步：添加如下 HTML 代码-->
<div class="dakuang">
<table id="example" class="display" cellspacing="0" width="100%">     
<thead>
            <tr>
                <th>Sample code</th>
                <th>Lithology</th>
                <th>Sampling position</th>            
                <th>Test Data</th>              
            </tr>
        </thead>
    </table>
<input id ="jsonbutton"  type="button" value="query analytical data" style="text-align:right;display:none;" >
<table id="examplejson"cellspacing="0" width="100%">     
<thead>
            <tr>
                 <th>spotname</th>
                <th>Pb206/U238 age</th>
                <th>Pb206/U238 error</th>            
                <th>U(ppm)</th>          
                <th>Th(ppm)</th>      
                <th>Th/U(ppm)</th>  
            </tr>
        </thead>
</table></div>
  <div id="main" style="margin-top:20px;width: 940px;height:500px;"></div>
  <div id="mainuth" style="margin-top:20px;width: 940px;height:500px;"></div>
  <div id="mainratio" style="margin-top:20px;width: 940px;height:500px;"></div>
  <%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
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
					url: "${ctx}/query/jsonage",
					type: "POST",									
					dataType: "json",	
					data: {"sidz": samplearr },		
					traditional: true,							
					success: function(json)
					{
					showjson(json);
			   		chart(json);	
                    chartuth(json);	 
                    chartratio(json);	
			   		   	     
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
  function chart(json)
{			   		  var id=[];    //类别数组（实际用来盛放X轴坐标值）      
			   		  var age204=[];    //销量数组（实际用来盛放Y坐标值）
			   	  for(var i=0;i<json.length;i++){                             
			   	       id.push(i);  
			   	       age204.push(json[i].age204 ); //挨个取出类别并填入类别数组                  
			   	        }			   	   
			   		var myChart = echarts.init(document.getElementById('main'));
// 显示标题，图例和空的坐标轴
myChart.setOption({
    title: {
        text: 'Pb206/U238 Age distribution'
    },
    tooltip: {},
    legend: {
        data:['age']
    },
    xAxis: {
        data: id
    },
    yAxis: {},
    series: [{
        name: 'age',
        type: 'bar',
        data: age204
    }]
});
	}
  function chartuth(json)
{
	  var id=[];    //类别数组（实际用来盛放X轴坐标值）      
			   		  var u=[];  
			   		   var th=[];    //销量数组（实际用来盛放Y坐标值）
			   		  
			   	  for(var i=0;i<json.length;i++){                             
			   	       id.push(i);  
			   	       u.push(json[i].U ); //挨个取出类别并填入类别数组       
			   	       th.push(json[i].Th); //挨个取出类别并填入类别数组                  
			   	   
			   	        }			   	   
			   		var myChart1 = echarts.init(document.getElementById('mainuth'));
// 显示标题，图例和空的坐标轴
option = {
    title: {
        text: 'distribution of U-Th concentration'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['U含量','Th含量']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: id
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'U concentration',
            type:'line',
            stack: 'total',
            data:u
        },
        {
            name:'Th concentration',
            type:'line',
            stack: 'total',
            data:th
        },
       
      
    ]
};

myChart1.setOption(option)
}
function chartratio(json)
{
	  var id2=[];    //类别数组（实际用来盛放X轴坐标值）      
			   		
			   		   var uth=[];
			   	  for(var i=0;i<json.length;i++){                             
			   	       id2.push(i);  
			   	                
			   	       uth.push(json[i].ThU);
			   	        }			   	   
			   		var myChart3 = echarts.init(document.getElementById('mainratio'));
// 显示标题，图例和空的坐标轴
options = {
    title: {
        text: 'Th/U'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['Th/U ratio']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: id2
    },
    yAxis: {
        type: 'value'
    },
    series: [
        
        {
            name:'Th/U ratio',
            type:'line',
            stack: 'total',
            data:uth
        },
      
    ]
};

myChart3.setOption(options)
}  
</script></html>