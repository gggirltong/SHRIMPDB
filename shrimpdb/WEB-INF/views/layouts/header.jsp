<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<%@ include file="/WEB-INF/views/layouts/meta.jsp"%>
	

<div  class="logopic"><img src="${ctx}/static/img/top.fw.png"></div>
<div  class="loguser">  
<shiro:notAuthenticated> <font  class="welco1"><a href="${ctx}/reg">Sign in</a>|<a href="${ctx}/login">Login</a></font></shiro:notAuthenticated>	
<shiro:authenticated>hi,<a href="${ctx}/user/read" class="navbar-link"><shiro:principal property="name"/></a> | <a href="${ctx}/logout" class="navbar-link">log out</a></shiro:authenticated>  </div>
<div class="menutext">										
						<shiro:hasRole name="系统管理员">
						<table >				
						<tr>
						    <td><a href="${ctx}/home">Home</a></td>
				        	<td><a href="${ctx}/news/ptgk">About</a></td>
							<td><a href="${ctx}/news/shownews">News</a></td>			
							<!-- <td><a href="${ctx}/news/shownews">Lab</a></td>	 -->		
						    <td><a href="${ctx}/user/userlist">User</a></td>
							<td><a href="${ctx}/query/queryperson">Management</a></td>
							<td> <a href="${ctx}/query/samplequery">Fuzzy-Query </a></td>						
						    <td> <a href="${ctx}/query/querymap">GIS-Query</a></td>							    
						    <td><a href="${ctx}/query/maptools">Region-Query</a></td>   						                              										
							</tr>
						</table>
						</shiro:hasRole>
						<shiro:hasRole name="实验室人员">
						<table>
							<tr>						
						  <td><a href="${ctx}/home">Home</a></td>
				        	<td><a href="${ctx}/news/ptgk">About</a></td>
							<td><a href="${ctx}/news/shownews">Information</a></td>	
							
							<!--  <td><a href="${ctx}/business/measurement">Do-Test</a></td> -->	
	               		</table>
						</shiro:hasRole>
						
						<shiro:hasRole name="终身会员">
						<table>					
			     		<tr>
						  <td><a href="${ctx}/home">Home</a></td>
				        	<td><a href="${ctx}/news/ptgk">About</a></td>
							<td><a href="${ctx}/news/shownews">News</a></td>			
					<!-- 	  <td><a href="${ctx}/query/book">Test</a></td> -->	
							<td><a href="${ctx}/query/queryperson">Management</a></td>
						    <td><a href="${ctx}/query/samplequery">Fuzzy-Query</a></td>							
						    <td><a href="${ctx}/query/querymap">GIS-Query</a></td>	                  
	                         <td><a href="${ctx}/query/maptools">Region-Query</a></td>        		
						 <tr>
						</table>
						</shiro:hasRole>	
						<shiro:hasRole name="一级会员">
						<table>
						 <tr>
					        <td><a href="${ctx}/home">Home</a></td>
				        	<td><a href="${ctx}/news/ptgk">About</a></td>
							<td><a href="${ctx}/news/shownews">News</a></td>			
						<!-- 	<td><a href="${ctx}/query/book">Test</a></td> -->
							<td><a href="${ctx}/query/queryperson">Management</a></td>
						    <td><a href="${ctx}/query/samplequery">Fuzzy-Query</a></td>							
						    <td><a href="${ctx}/query/querymap">GIS-Query</a></td>	                  
	                          <td><a href="${ctx}/query/maptools">Region-Query</a></td>        	
						 <tr>
						</table>
						</shiro:hasRole>
					
						<shiro:hasRole name="二级会员">
						<table>
							<tr>
							
					  <td><a href="${ctx}/home">Home</a></td>
				        	<td><a href="${ctx}/news/ptgk">About</a></td>
							<td><a href="${ctx}/news/shownews">News</a></td>			
							<!-- 		<td><a href="${ctx}/query/book">Test</a></td>  -->
							  <td><a href="${ctx}/query/queryperson">Management</a></td>
						  <td> <a href="${ctx}/query/samplequery">Fuzzy-Query</a></td>							
						  <td><a href="${ctx}/query/querymap">GIS-Query</a></td>
	                         <td><a href="${ctx}/query/maptools">Region-Query</a></td>        
	           				<tr>
						</table>
						</shiro:hasRole>
					
						<shiro:hasRole name="三级会员">
						<table>
						<tr>							
				        <td><a href="${ctx}/home">Home</a></td>
				        	<td><a href="${ctx}/news/ptgk">About</a></td>
							<td><a href="${ctx}/news/shownews">News</a></td>			
						   	<!--			<td><a href="${ctx}/query/book">Test</a></td> -->
							  <td><a href="${ctx}/query/queryperson">Management</a></td>
						  <td> <a href="${ctx}/query/samplequery">Fuzzy-Query</a></td>							
						  <td><a href="${ctx}/query/querymap">GIS-Query</a></td>
						    <td><a href="${ctx}/query/maptools">Region-Query</a></td>        
	                     	<tr>
						</table>
						</shiro:hasRole>						
						<shiro:hasRole name="普通用户">
						<table>
							<tr>
			  <td><a href="${ctx}/home">Home</a></td>
				        	<td><a href="${ctx}/news/ptgk">About</a></td>
							<td><a href="${ctx}/news/shownews">News</a></td>			
						  	<!--  <td><a href="${ctx}/query/book">Test</a></td> -->
							<td><a href="${ctx}/query/queryperson">Management</a></td>
						  <td> <a href="${ctx}/query/samplequery">Fuzzy-Query</a></td>							
						  <td><a href="${ctx}/query/querymap">GIS-Query</a></td> 
						    <td><a href="${ctx}/query/maptools">Region-Query</a></td>                  
	                 		<tr>
						</table>
						</shiro:hasRole>
							<shiro:hasRole name="制靶人员">
						<table>
							<tr>
			  <td><a href="${ctx}/home">Home</a></td>
				        	<td><a href="${ctx}/news/ptgk">About</a></td>
							<td><a href="${ctx}/news/shownews">News</a></td>			
					 	<!--					  <td><a href="${ctx}/business/mount">Mount</a></td> 	 -->					
	                 		<tr>
						</table>
						</shiro:hasRole>
						
						<shiro:hasRole name="等待验证用户">
						<table>
						
							<tr><td>请等待超级管理员为您审核</td></tr>
						</table>
						</shiro:hasRole>
						
						<shiro:notAuthenticated>
						<table>
						<tr>
					     <td><a href="${ctx}/home">Home</a></td>
				         <td><a href="${ctx}/news/ptgk">About</a></td>
						 <td><a href="${ctx}/news/shownews">News</a></td>			
					<!--	 <td><a href="${ctx}/upload/metauploadbook">Test</a></td>  -->
						 <td><a href="${ctx}/query/queryperson">Management</a></td>
						 <td><a href="${ctx}/query/samplequery">Fuzzy-Query</a></td>							
						 <td><a href="${ctx}/query/querymap">GIS-Query</a></td>	  
						   <td><a href="${ctx}/query/maptools">Region-Query</a></td>                     
	                	<tr>
						</table>
						</shiro:notAuthenticated>										
					</div>