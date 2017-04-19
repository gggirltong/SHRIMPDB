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
<link rel="stylesheet" href="${ctx}/static/inputfile/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/inputfile/fileinput.min.css">
<script src="${ctx}/static/inputfile/fileinput.min.js"></script>
<script src="${ctx}/static/inputfile/fa.js"></script>
<script src="${ctx}/static/inputfile/es.js"></script>
<link   href="${ctx}/static/validator/jquery.validator.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/validator/jquery.validator.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/local/zh_CN.js" type="text/javascript"></script>

</head>
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
	 <td width="750" style="padding-left:36px;">已处理列表</td>
		 <td width="150" style="padding-left:36px;"><a href="${ctx}/business/testlist">已测试列表</a></td>		
  </tr>	
	</table>
	   </div>
	      <div class="dakuang">
<!--第二步：添加如下 HTML 代码-->
<table id="example" class="display" cellspacing="0" width="100%">     
  <thead>
            <tr>
               <tr>
               
                <th>靶号</th>     
                <th>测试时间</th>                                
                <th>完成时间</th>          
                 <th> 处理时间</th> 
                 <th>op 文件</th>    
                <th>处理结果</th>                                                           
            </tr>               
            </tr>
        </thead>
    </table>
    
    <div id ="jsonbutton" style="display:none;">
<form:form name="mounform" modelAttribute="testlist" method="post" action="uploadprocess" enctype ="multipart/form-data">
<div  class="control-group">
<label   class="control-label">测试结果文件:</label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="input-1" data-rule="required" name="paper1" type="file" class="file" data-show-upload="false" data-show-caption="true">
</div>	
 <input id="mount"  type="submit" value="上传"  >
  <input type="hidden" name="namemm">
      <input type="hidden" name="namess">
 
</form:form>
</div>
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
 </body>
<!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/business/processlist",
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
             
             { data: 'mountname' },                           
             { data: 'testdate'}, 
             { data: 'finishdate'},
             { data: 'processdate'},  
             { data: 'op',
              render: function ( data, type, row ) {
              if(data!=0){
              var a="<a href='${ctx}/files/"+data+" '/ target='_blank'>" +data+"</a>";
              return a;}
             else{
              return "正在测试";}
             }
             }, 
             { data: 'process',
             render: function ( data, type, row ) {
              if(data!=0){
              var a="<a href='${ctx}/files/"+data+" '/ target='_blank'>" +data+"</a>";
              return a;}
            else{
             
              return "等待上传";}
             }
             },                              
       			 ],
        dom: 'Bfrtip',
        buttons: [
                       
        ]  
     });
    
}



</script></html>