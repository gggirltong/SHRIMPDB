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
	 <td width="750" style="padding-left:36px;">待制靶列表</td>	 	        									
   </tr>	
	</table>
	   </div>
	      <div class="dakuang">
<!--第二步：添加如下 HTML 代码-->
<table id="example" class="display" cellspacing="0" width="100%">     
  <thead>
            <tr>
               <tr>
                <th>序号</th>
                <th>样品编号</th>
                <th>送样人</th>            
                <th>送样单位</th>          
                <th>送样时间</th>     
                <th>送样人电话</th>                      
            </tr>               
            </tr>
        </thead>
    </table>
    <div id ="jsonbutton" style="display:none;">
   <form:form name="mounform" modelAttribute="addmount" method="post" action="addmount" enctype ="multipart/form-data">
<div class="control-group">
<label class="control-label"   for="name">样品靶名称:</label>
<form:input path="mountname" type="text"  class="input-xlarge" data-rule="required"/>    
</div>	
<div  class="control-group"><label   class="control-label">样品靶图像:</label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="input-1" data-rule="required" name="paper1" type="file" class="file" data-show-upload="false" data-show-caption="true">
</div>	
 <input type="hidden" name="pName1">
 <input id="mount"  type="submit" value="制靶"  >  
	</form:form>
     </div>
</div>
<div  class="dev_one">
	<table>
	<tr>
	<td width="750" style="padding-left:36px;">完成列表</td>	 	        									
    </tr>	
	</table>
	</div>
<div class="dakuang">
<!--第二步：添加如下 HTML 代码-->
<table id="mountresult" class="display" cellspacing="0" width="100%">     
      <thead>
           
               <tr>          
                <th>样品编号</th>
                <th>靶号</th>            
                <th>送样时间</th>          
                <th>制靶时间</th>                   
                <th>状态</th>                      
                </tr>                        
        </thead>
    </table>
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
 </body>
<!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/business/mountlist",
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
             { data: 'name'},        
             { data: 'unit'},
              { data: 'createdate'},
             { data: 'phone'},                    
       			 ],
        dom: 'Bfrtip',
        buttons: [
                       
        ]  
     });
     $('#example tbody').on('click','tr',function()
	{
 	    $(this).toggleClass('selected');
		document.getElementById("jsonbutton").style.display="block";		 
    });
    $('#mount').click(function()
		{
		
		var dataid=table.rows('.selected').data();	
    	var a=dataid.length;
		var samplearr=new Array();
		var sampleid=dataid[0].ssid;
		for(var si=1;si<a;si++)
		{
			samplearr[si]=dataid[si].ssid;			
			sampleid+=","+samplearr[si];		
		}
	  document.mounform.pName1.value = sampleid;
 	
});
}
$.ajax({		           
				url: "${ctx}/business/examplejson",
				type: "post",
				contentType: "application/json",
				dataType: "json",							
				success: function(json)
				{
				showresulttable(json);
			    console.log(json);			 	     
 	    	 	},
 	      	    error: function(XMLHttpRequest, textStatus, errorThrown)
 	      	    {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
                }
			});
function showresulttable(json)
{ 
	var data = json;
	var table=  $('#mountresult').DataTable( 
	{
        data: data,
        //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
        //data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
        columns: [
             { data: 'code' }, 
             { data: 'mountname' },                           
             { data: 'sampledate'},            
             { data: 'makedate'},             
             { data: 'dataid',
              render: function ( data, type, row ){             
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
        }
             },   
                                        
       			 ]        
     });
     
 
}
</script></html>