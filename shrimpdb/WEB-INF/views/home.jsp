<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>welcome</title>
<script type="text/javascript" src="${ctx}/static/index_files/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/static/index_files/coin-slider.min.js"></script>
<link rel="stylesheet" href="${ctx}/static/index_files/coin-slider-styles.css" type="text/css" />
 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Bx5e36ewcaWGFjSGHhDWcgVWuyhvb5Cx"></script>
<style type="text/css">  
html{height:100%}  
body{height:100%;margin:0px;padding:0px}  
#container{height:250px;width:940px;}  
</style>  
</head>
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div id='coin-slider'>
<img src="${ctx}/static/img/devpic/shrimpwhole.png" alt="shrimpwhole" title="shrimpwhole" id="wows1_0"/>
<span>SHRIMPII in BeiJing SHRIMP Center</span>
<img src="${ctx}/static/img/devpic/shrimpyl.png" alt="shrimpyl" title="shrimpyl" id="wows1_1"/>
<span>SHRIMP schematics</span>
<img src="${ctx}/static/img/devpic/shrimpcurtin.jpg" alt="shrimpcurtin" title="shrimpcurtin" id="wows1_2"/>
<span>SHRIMP in Curtin University</span>

</div>
<script type="text/javascript">
    $(document).ready(function()  {
        $('#coin-slider').coinslider({ width: 400, navigation: false, delay: 4000 ,height: 270});
    });
</script>
<div class="information">
	<fieldset>
	<legend>NEWS</legend>
	<table>
	<tbody>
	<c:forEach var="news" begin="0" end="6" varStatus="status" items="${newsList}">			
	<tr style="line-height:25px;">
	<td width="330" style="padding-left:8px;font-size:14px;">
	<a href="${ctx}/news/news_one?id=${news.id}">${news.title}</a>
    </td>
	<td width="70" style="padding-left:8px;font-size:14px;">${news.update}</td>
    </tr>
    </c:forEach>
	</tbody>
	</table>
	</fieldset></div>	
<div id="description"></div>
	<div id="container"></div> 
<script type="text/javascript"> 
window.onload = function(){
      var map = new BMap.Map("container",{mapType:BMAP_HYBRID_MAP});          // 创建地图实例  
var point = new BMap.Point(116.404, 39.915);  // 创建点坐标  
map.centerAndZoom(point, 5);                 // 初始化地图，设置中心点坐标和地图级别
 map.enableScrollWheelZoom(); //添加放大缩小控件   
    var optdh={type:BMAP_NAVIGATION_CONTROL_LARGE}; 
    map.addControl(new BMap.NavigationControl(optdh));//添加导航控件
   //触发showall按钮后调用Ajax取出数据    
			$.ajax({		           
				url: "${ctx}/home",
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
     
        map.addOverlay(pointCollection);  // 添加Overlay
    } else {
        alert('请在chrome、safari、IE8+以上浏览器查看本示例');
    }
    
    }
} 

		
</script>  
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
</body>
</html>