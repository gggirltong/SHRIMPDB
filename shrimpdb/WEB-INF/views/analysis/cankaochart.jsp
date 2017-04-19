<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><html>
<head>
    <meta charset="utf-8">
    <title>图表查询</title>
    <!-- 引入 echarts.js -->
    <link rel="stylesheet" type="text/css" href="${ctx}/static/query/jquery.ui.css" />
    <script type="text/javascript" src="${ctx}/static/query/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/static/query/jquery.ui.js"></script>
    <link rel="stylesheet" href="${ctx}/static/css/epmadb.css" type="text/css" />
    <script src="${ctx}/static/query/echarts.min.js"></script>
</head>
<body>
<div><%@ include file="/WEB-INF/views/layouts/header.jsp"%></div>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 800px;height:600px;margin:0 auto;"></div><br/><br/>
    <div class="queryfont"style="text-align:center;" >选择年份<input id="year" name="year" readonly="readonly"/></div><br/>
    <div id="main2" style="width: 800px;height:600px; margin:0 auto;"></div><br/><br/>
    <div id="main3" style="width: 800px;height:600px; margin:0 auto;"></div><br/><br/>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var myChart2 = echarts.init(document.getElementById('main2'));
        var myChart3 = echarts.init(document.getElementById('main3'));
        myChart.setOption({
            title: {
                text: '按年统计数量'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: ${x}
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: ${y}
            }]
        });
        
        myChart2.setOption({
            title: {
                text: '按月统计数量'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: []
            }]
        });
        
        myChart3.setOption({
            title: {
                text: '按岩石类型统计数量'
            },
            tooltip: {},
            legend: {
                data:['数量']
            },
            xAxis: {
                data: ${xx},
                axisLabel:{
                    //X轴刻度配置
                    interval:0 //0：表示全部显示不间隔；auto:表示自动根据刻度个数和宽度自动设置间隔个数
               }
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: ${yy}
            }]
        });
        
        var dates = $("#year").datepicker({
        	dateFormat:"yy",
            changeYear:true,
            changeMonth:true,
            onSelect:function( selectedDate ) {
            	$.ajax({
                    url: "${ctx}/contribute/chart",
                    contentType: "application/json",
                    type: "post",
                    dataType: "json",
                    data: selectedDate,
                    success: function(json){
                        myChart2.setOption({
                            xAxis: {
                                data: json.x
                            },
                            series: [{
                                // 根据名字对应到相应的系列
                                data: json.y
                            }]
                        });
                    },
                    error: function(data){
                        alert("出现未知异常，请联系管理员");
                        return false;
                    } 
                });
            }
        });

    </script>
    <%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
</body>
</html>