<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<head>
  <title>加载海量点</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
  <style type="text/css">
  </style>
  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Bx5e36ewcaWGFjSGHhDWcgVWuyhvb5Cx"></script>
  <script type="text/javascript" src="${ctx}/static/js/points-sample-data.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.ui.js"></script>
<script type="text/javascript" src="${ctx}/static/js/DrawingManager.js"></script>
<script type="text/javascript" src="${ctx}/static/js/DrawingManager_min.js"></script>
<link rel="stylesheet" href="${ctx}/static/css/DrawingManager_min.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/static/css/shrimpdb.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/DataTables-1.10.12/media/css/jquery.dataTables.css"> 
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="${ctx}/static/DataTables-1.10.12/media/js/jquery.js"></script> 
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="${ctx}/static/DataTables-1.10.12/media/js/jquery.dataTables.js"></script>
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
<body><br />
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
	            <td width="200" style="padding-left:36px;">个人数据分布图</td>
	            <td  style="padding-left:300px;"><a href="${ctx}/query/queryperson">个人数据信息</a></td>
	            <td style="padding-left:100px;"><a href="${ctx}/upload/metaupload">添加数据</a></td>    		        									
   </tr>	
	</table>
	   </div>
<style>
.mapperson{width:938px;border: 1px solid #CCCCCC;padding-top:20px;height:200px;margin-top:10px;}
</style>
 <div id="map" class="mapperson"></div>  
	<div class="">
	<table id="example" class="display">
    <thead>
            <tr>
                <th>序号</th>
                <th>mountname</th>
                <th>spotname</th>            
                <th>age204</th>
                <th>err204</th>
                <th>sampleid</th>               
            </tr>
   </thead>
</table>
	</div>  
  <div id="main" style="margin-top:20px;width: 940px;height:500px;"></div>
  <div id="mainuth" style="margin-top:20px;width: 940px;height:500px;"></div>
  <div id="mainratio" style="margin-top:20px;width: 940px;height:500px;"></div>
 <script type="text/javascript">  
window.onload = function(){
      var map = new BMap.Map("map",{mapType:BMAP_HYBRID_MAP});          // 创建地图实例  
var point = new BMap.Point(116.404, 39.915);  // 创建点坐标  
map.centerAndZoom(point, 5);                 // 初始化地图，设置中心点坐标和地图级别
 map.enableScrollWheelZoom(); //添加放大缩小控件   
    var optdh={type:BMAP_NAVIGATION_CONTROL_LARGE}; 
    map.addControl(new BMap.NavigationControl(optdh));//添加导航控件
     var mapType1 = new BMap.MapTypeControl({mapTypes: [BMAP_HYBRID_MAP,BMAP_NORMAL_MAP]});
	//var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_RIGHT});
	map.addControl(mapType1);          //2D图，卫星图
	
   //触发showall按钮后调用Ajax取出数据    
			$.ajax({		           
				url: "${ctx}/query/mapperson",
				type: "post",
				contentType: "application/json",
				dataType: "json",				
				success: function(json){			
				var points= new Array();
				var num=json.length;			
     			for(var i=0;i<num;i++)
			   {   		   
			   points.push(jsonToPoint(json[i]));//将json数据转换为点数据函数
			     }     	
			  pointsNow=points;
 		 	  solve(pointsNow);  //绘制大量点函数
 		 	  },
 	       error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.status);
                        alert(XMLHttpRequest.readyState);
                        alert(textStatus);
                    }
			});	
		//将json数据转换为点数据函数
		function jsonToPoint(obj){	
     	p=new Object;
     	p.lng=obj.lng;
		p.lat=obj.lat;
		p.sampleid=obj.sampleid;	
		p.lithologic=obj.lithologic;
		p.position=obj.position;
		p.id=obj.ssid;				
		return p;
	}      
	
//绘制大量点函数
   function solve(pointsAll){	 
    if (document.createElement('canvas').getContext) {  // 判断当前浏览器是否支持绘制海量点
        //var points = [];  // 添加海量点数据
       // for (var i = 0; i < data.data.length; i++) {
        //  points.push(new BMap.Point(data.data[i][0], data.data[i][1]));
       // }
        var options = {
            size: BMAP_POINT_SIZE_BIG,
            shape: BMAP_POINT_SHAPE_STAR,
            color: 'red'
        };
        var pointCollection = new BMap.PointCollection(pointsAll, options);  // 初始化PointCollection
        pointCollection.addEventListener('click', function (e) {
        alert('样品编号:' + e.point.id+'\n岩性：'+e.point.lithologic +'\n位置：'+e.point.position);  // 监听点击事件
        		$.ajax({		           
				url: "${ctx}/query/queryage?id="+e.point.id,
				type: "post",
				contentType: "application/json",
				dataType: "json",	
				data:"sample"+e.point.id,			
				success: function(jsontable){
			
			   showtable(jsontable);
			     chart(jsontable);	
                    chartuth(jsontable);	 
                    chartratio(jsontable);	
 		 	  },
 	       error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.status);
                        alert(XMLHttpRequest.readyState);
                        alert(textStatus);
                    }
			});
        });
        map.addOverlay(pointCollection);  // 添加Overlay
    } else {
        alert('请在chrome、safari、IE8+以上浏览器查看本示例');
    }
    
    }
    function showanalytical(analytical)
    {
    alert(analytical[0].age204);
    }
    function showtable(jsontable)
  {
  
  var data = jsontable;
        //object可以如下初始化表格
    $('#example').DataTable( {
        data: data,
        //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
        //data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
        columns: [
            { data: 'id' },
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
    } );}    
    
    
    
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
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	</body>