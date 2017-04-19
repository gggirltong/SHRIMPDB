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
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
</head>
<body>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
	 <td width="750" style="padding-left:36px;">待测样品靶列表</td>
	 <td width="150" style="padding-left:36px;"><a href="${ctx}/business/testlist">已测试列表</a></td>		
	 <td width="150" style="padding-left:36px;"><a href="${ctx}/business/processlist">已处理列表</a></td>			
	        									
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
                <th>靶号</th>  
                <th>制靶人</th>          
                <th>制靶时间</th>      
                <th>靶图 </th>                
                                              
            </tr>               
            </tr>
        </thead>
    </table>    
    <div id ="jsonbutton" style="display:none;">
<form:form name="mounform" modelAttribute="measurement" method="post" action="changemount" enctype ="multipart/form-data">
    <input type="hidden" name="namemm">
    <input type="hidden" name="namess">
<input id="mount"  type="submit" value="测试"  ></form:form>
</div>


<div  class="dev_one">
	<table>
	<tr>
	 <td width="750" style="padding-left:36px;">样品-靶号</td>	        									
   </tr>	
</table>
</div>
 <div class="dakuang">
<!--第二步：添加如下 HTML 代码-->
<table id="samplemount" class="display" cellspacing="0" width="100%">     
  <thead>
            <tr>
               <tr>
                <th>样品编号</th>
                <th>靶号</th>  
                <th>送样人</th>          
                <th>送样单位</th>      
                <th>送样时间 </th>                                                              
            </tr>               
            </tr>
        </thead>
    </table>  </div></div>

<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
 </body>
<!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/business/measurement",
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
             { data: 'mountname'}, 
             { data: 'mountuser'},
             { data: 'mountdate'},   
             { data: 'mountimg', 
             render: function ( data, type, row ) {
              var a="<a href='${ctx}/files/"+data+" '/ target='_blank'>" +data+"</a>";
              return a;
             }
              },               
                                      
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
		var mountarr=new Array();
		var sysarr=new Array();
		var mountid=dataid[0].mountid;
		var sysid=dataid[0].systemid;
		for(var si=1;si<a;si++)
		{
			mountarr[si]=dataid[si].mountid;
			sysarr[si]=dataid[si].systemid;					
			mountid+=","+mountarr[si];
			sysid+=","+sysarr[si];
			
		}
	
	  document.mounform.namemm.value = mountid;
	  document.mounform.namess.value = sysid;
 	
});
}
 $.ajax({		           
				url: "${ctx}/business/samplemount",
				type: "post",
				contentType: "application/json",
				dataType: "json",							
				success: function(json)
				{
				showsamplemount(json);	  	 	     
 	    	 	},
 	      	    error: function(XMLHttpRequest, textStatus, errorThrown)
 	      	    {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
                }
			});

function showsamplemount(json)
{ 
	var data = json;
	var table=  $('#samplemount').DataTable( 
	{
        data: data,
        //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
        //data 这里是固定不变的，name，position，salary，office 为你数据里对应的属性
        columns: [
             { data: 'code' }, 
             { data: 'mountname' },                           
             { data: 'username'},            
             { data: 'unit'},             
             { data: 'datid',
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
        }
             },   
                                        
       			 ]        
     });
     
 
}
</script></html>