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
<style>

</style>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
<!--第二步：添加如下 HTML 代码-->
	<div  class="dev_one">
	<table>
	<tr>
	            <td width="200" style="padding-left:36px;">data open</td>
	          		        									
   
   </tr>	
	</table></div>
	<div class="dakuang">
<table id="example" class="display" cellspacing="0" width="100%">     
  <thead>
            <tr>
                <th>longitude</th>
                <th>latitude</th>
                <th>sample code</th>            
                <th>lithology</th>
                <th>sampling position</th>
                            
            </tr>
        </thead>
    </table>
    <input id ="jsonbutton"  type="button" value="data open" style="display:none;" >
<table id="examplejson" class="display" cellspacing="0" width="100%">
      
</table></div>
 <%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>
 </body>
<!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/query/openprocess",
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
             { data: 'lng' },
             { data: 'lat' },
             { data: 'sampleid'},        
             { data: 'lithologic'},
             { data: 'position'},
          
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
					url: "${ctx}/query/chageopen",
					type: "POST",									
					dataType: "json",	
					data: {"sidz": samplearr },		
					traditional: true,							
					success: function(json)
					{	
					result(json);					
 		 		    },
 	       	   		error: function(XMLHttpRequest, textStatus, errorThrown)
 	       		    {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                    }
			});
		});	}		
function result(json)
{
var id=json.type;

if(id==4){
var typeuser="VIP1 user，500 items can be searched form databases";
	}
else if(id==5){
var typeuser="VIP2 user，1000items can be searched from databases";
	}
else if(json.type==6){
var typeuser="VIP3 user，5000 items can be searched from databases";}
else if(json.type==7){
var typeuser="common user，100 items can be searched from databases";	}
else if(json.type==3){
var typeuser="VIP super ，all sharing data can be searched";}								
alert("you have update"+json.id+"items this time \n the total number you have submited into database is"+json.number+"items\n the total open number is"+json.open+"items\n your current user type is"+typeuser);									
window.location.reload();   
}
</script></html>