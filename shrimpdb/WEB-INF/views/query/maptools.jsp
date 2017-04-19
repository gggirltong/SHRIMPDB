
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<head><!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap{width:940PX;height:500px;}
		p{margin-left:5px; font-size:14px;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZlI1n3gNPoPoYbj1pNOXyG4XZIetoz2U"></script>
	<!--加载鼠标绘制工具-->
	<script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
	<link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
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
	
	<title>Region GIS query</title>
</head>
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
    <td width="400" style="padding-left:36px;"> Data Sharing -region query</td>	        									                	        									
    </tr>	
	</table>
</div>
	<div id="allmap"></div>
<table id="examplejson" class="display" cellspacing="0" width="100%">     
</table>
   <div id="main" style="margin-top:20px;width: 940px;height:500px;"></div>
  <div id="mainuth" style="margin-top:20px;width: 940px;height:500px;"></div>
  <div id="mainratio" style="margin-top:20px;width: 940px;height:500px;"></div>
 
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	

</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap",{mapType:BMAP_HYBRID_MAP}); // 创建地图实例
	var point = new BMap.Point(116.403694, 39.927552); // 创建点坐标
	var options = {
		renderOptions: {
			map: map
		},
		onSearchComplete: function(results) {
		alert('Search Completed');
		showdata(results);
			//可添加自定义回调函数
		}
	};
	var localSearch = new BMap.LocalSearch(map, options);	
	map.centerAndZoom(point, 5); // 初始化地图，设置中心点坐标和地图级别
	map.enableScrollWheelZoom();
	map.addControl(new BMap.NavigationControl()); //添加默认缩放平移控件
	var drawingManager = new BMapLib.DrawingManager(map, {
		isOpen: false, //是否开启绘制模式
		enableDrawingTool: true, //是否显示工具栏
		drawingToolOptions: {
		anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
		offset: new BMap.Size(5, 5), //偏离值
		scale: 0.8, //工具栏缩放比例
		drawingModes: [
				BMAP_DRAWING_POLYGON
			]
		}
	});
	var polygon = null;
	drawingManager.addEventListener('polygoncomplete', function(e, overlay) {	
	    map.clearOverlays();
		polygon = e;
		map.addOverlay(overlay);
		var bounds=e.getBounds();		
		//var radius = parseInt(e.getRadius());
		//var center = e.getCenter();
		drawingManager.close();
		localSearch.searchInBounds('样品id', bounds, {
			customData: {
				geotableId:  159104
			}
		});
	});
	function showdata(resultsa)
	{
	var count=resultsa.getCurrentNumPois();
	var sampleid=new Array();	
	var idpost=new  Array();
	if (localSearch.getStatus() == 0){			  		
	for (var i = 0; i <count; i ++){
//s.push(results.getPoi(i).title + ", " + results.getPoi(i).address);			 
	sampleid.push(resultsa.getPoi(i).title);
	var length=sampleid[i].length;
	var idf=sampleid[i].substring(4,length);				   
    idpost.push(idf);
	}
	}
	$.ajax({		           
					url: "${ctx}/query/jsonage",
					type: "POST",									
					dataType: "json",	
					data: {"sidz": idpost },		
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
        text: 'U-Th含量分布堆叠折线图'
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
            name:'U含量',
            type:'line',
            stack: '总量',
            data:u
        },
        {
            name:'Th含量',
            type:'line',
            stack: '总量',
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
        text: 'Th/U比率'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['Th/U比率']
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
            name:'Th/U比率',
            type:'line',
            stack: '总量',
            data:uth
        },
      
    ]
};

myChart3.setOption(options)
}		
</script>
