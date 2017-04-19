<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <script type="text/javascript" charset="utf8" src="${ctx}/static/js/echarts.min.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="margin-top:40px;width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
     myChart.setOption({
            title: {
                text: 'Pb204/U238 Age Distribution'
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
$.ajax({
                    url: "${ctx}/analysis/chart",
                    contentType: "application/json",
                    type: "post",
                    dataType: "json",
                   // data: selectedDate,
                    success: function(json){
                        myChart.setOption({
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
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>