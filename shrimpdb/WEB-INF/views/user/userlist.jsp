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
<style type="text/css">
td.details-control {
    background: url('${ctx}/static/DataTables-1.10.12/examples/resources/details_open.png') no-repeat center center;
    cursor: pointer;
}
tr.shown td.details-control {
    background: url('${ctx}/static/DataTables-1.10.12/examples/resources/details_close.png') no-repeat center center;
}</style>
<title>UserList</title>
</head>
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	
<div  class="dev_one">
	<table>
	<tr>
    <td width="500" style="padding-left:36px;">User List</td>	
     <td style="padding-left:200px;"><a href="${ctx}/user/adduser">Add User</a></td>    		        									                	        									
    </tr>	
	</table>
</div>
<div class="dakuang">
<!--第二步：添加如下 HTML 代码-->
<table id="example" class="display" cellspacing="0" width="100%">     
<thead>
           <tr>
                <th>id</th>
                <th>Name</th>                    
                <th>Unit</th>
                <th>Department</th>
                <th>Degree</th>   
                <th>Operation</th>            
            </tr>
        </thead>
    </table>   
<table id="examplejson" class="display" cellspacing="0" width="100%">     
</table>
 <%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
 </body>
<!--第三步：初始化Datatables--><script type="text/javascript">
$(function()
{
    $.ajax({		           
				url: "${ctx}/user/userlist",
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
        {
                "class":          'details-control',
                "orderable":      false,
                "data":           'id',
                "defaultContent": ''
            },
             { data: 'name' },           
             { data: 'unit'},
             { data: 'department'},
             { data: 'degree'},       
             { data: 'type' },   
       			 ],
      columnDefs: [{
        //   指定第最后一列
        targets:5,
        render: function(data, type, row, meta) {
        if(data==8)
      {  
        return '<a type="button"  href="#" onclick="del('+row.id+')" >Qualified</a>';
        }
        else
       { return "common user";}
        }
    }],
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
        ],
        
     });
     
      $('#example tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );  
     function del(id) {

    $.ajax({
       url: "${ctx}/user/qualified",
	   type: "post",
	  
	   dataType: "json",	  					
        //在后台接受id这个参数
       data:  {"id": id },	
        traditional: true,
       success: function(data) {
            if (data.flag) {
            alert("1");
                //如果后台删除成功，则刷新表格，并提示用户删除成功
                //保留分页信息
                table.ajax.reload(null, false);
                alert(data.msg);
            }
        }
    })
}   
   

     }
   
 //删除方法

   function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>Profile Picture:</td>'+
            '<td><img src="${ctx}/files/'+d.image+'"></td>'+
        '</tr>'+
        '<tr>'+
            '<td>papers:</td>'+
            '<td><a href="${ctx}/files/'+d.paperb+'" target="_blank">'+d.papera+'</a></td>'+
        '</tr>'+
        '<tr>'+
            '<td>Extra info:</td>'+
            '<td>And any further details here (images etc)...</td>'+
        '</tr>'+
     '</table>';
}  
</script></div></html>