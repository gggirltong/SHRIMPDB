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
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
	            <td width="750" style="padding-left:36px;">预约列表</td>
	            
	 	       <td  style="padding-left:36px;"><a href="${ctx}/upload/metauploadbook">添加预约</td> 									
   </tr>	
	</table>
	   </div>
	      <div class="dakuang">
<!--第二步：添加如下 HTML 代码-->
<table id="example" class="display" cellspacing="0" width="100%">     
  <thead>
            <tr>
                <th>序号</th>
                <th>样品编号</th>
                <th>预约时间</th>            
                <th>样品名称</th>
                <th>采样地点</th>        
                <th>测试状态</th>              
            </tr>
        </thead>
    </table>
<input id ="jsonbutton"  type="button" value="查询测试点数据" style="display:none;" >
<div  class="dev_one">
	<table>
	<tr>
	            <td width="750" style="padding-left:36px;">文件下载</td>
	            
   </tr>	
	</table>
	   </div>
	    <div class="dakuang">
<table id="result" class="display" cellspacing="0" width="100%">   
 <thead>
            <tr>
               <tr>
               <th>样品编号</th> 
               <th>靶号</th>     
               <th>测试时间</th>                                                   
               <th>处理时间</th>             
               <th>处理结果</th>                                                           
            </tr>               
            </tr>
        </thead>   
</table></div></div>
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
 </body>
<!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/query/booklist",
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
             { data: 'createdate'},        
             { data: 'samplename'},
             { data: 'position'},
             { data: 'dateid',
              render: function ( data, type, row ) {             
         if ( data==20  ) {
             return "已制靶";}       
        else if( data==30  ){
             return "已测试";}
         else if ( data==40  ){
             return "测试完成";}
        else if ( data==50  ){
              return "已处理";}
        else 
        return "已预约";
        }},       
       			 ],
        dom: 'Bfrtip',
        buttons: [
                     
        ]  
        
     });
     
 }    
      $.ajax({		           
				url: "${ctx}/business/resultlist",
				type: "post",
				contentType: "application/json",
				dataType: "json",							
				success: function(json)
				{
				showresult(json);
			   		 	     
 	    	 	},
 	      	    error: function(XMLHttpRequest, textStatus, errorThrown)
 	      	    {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
                }
			});

function showresult(json)
{ 
	var data = json;
	var table=  $('#result').DataTable( 
	{
        data: data,
        //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
        //data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
         columns: [
               { data: 'code' }, 
             { data: 'mountname' },                           
             { data: 'testdate'}, 
           
             { data: 'processdate'},  
            
             { data: 'process',
              render: function ( data, type, row ) {
              if(data!=0){
              var a="<a href='${ctx}/files/"+data+" '/ target='_blank'>" +data+"</a>";
              return a;}}
             },                              
       			 ]
        
     }); 
}
</script></html>