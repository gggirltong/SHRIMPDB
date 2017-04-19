<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>数据上传</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${ctx}/static/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${ctx}/static/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${ctx}/static/js/bootstrap.min.js"></script>
</head>
<body>
<table>
<form:form  class="form-horizontal" modelAttribute="uploadcontents" action="metaupload" method="post" >
<fieldset>
<legend> 背景信息</legend>
<!-- Text input-->

 <tr><td> <label class="control-label" for="code">样品编号</label>
  <div class="controls">
    <form:input path="code"  type="text" value="${sample_detail.code}" class="input-medium" required=""/>  
  </div></td>
  <td> <label class="control-label" for="textinput">岩性信息</label>
  <div class="controls">
    <form:input path="lithologic"  type="text" value="${sample_detail.lithologic}" class="input-medium" required=""/>  
  </div></td>
  <td>  <label class="control-label" for="position">采样位置</label>
  <div class="controls">
    <form:input path="postion" type="text" value="${sample_detail.postion}"  class="input-medium" required=""/>    
  </div></td>
  <td>
   <label class="control-label" for="LonEW">经度</label>
   <form:input   path="LonEW" type="text"  value="${sample_detail.lonEW}" class="input-mini"/>
   <form:input  path="LonDeg" type="text"  value="${sample_detail.lonDeg}" class="input-mini"/>
   <form:input  path="LonMin" type="text"  value="${sample_detail.lonMin}" class="input-mini"/>
   <form:input   path="LonSec" type="text"  value="${sample_detail.lonSec}" class="input-mini"/></td>
<td>
   <label class="control-label" for="LonEW">纬度</label>
   <form:input   path="LatNS" type="text"  value="${sample_detail.latNS}" class="input-mini"/>
   <form:input  path="LatDeg" type="text"  value="${sample_detail.latDeg}" class="input-mini"/>
   <form:input  path="LatMin" type="text"  value="${sample_detail.latMin}" class="input-mini"/>
   <form:input   path="LatSec" type="text"  value="${sample_detail.latSec}" class="input-mini"/></td> 
 
 </tr>
 <tr>
 <td>  
  <label class="control-label" for="name">项目名称</label> 
  <form:input path="name"  type="text" value="${project.name}" class="input-Xlarge" required=""/>  
 </td>
 <td>
  <label class="control-label" for="person">项目负责人</label> 
  <form:input path="person"  type="text" value="${project.person}" class="input-medium" required=""/>  
 </td>
 <td>
  <label class="control-label" for="projectcode">项目编号</label> 
  <form:input path="projectcode"  type="text" value="${project.projectcode}" class="input-medium" required=""/>  
 </td>
 <td>
  <label class="control-label" for="source">项目来源</label> 
  <form:input path="source"  type="text" value="${project.source}" class="input-medium" required=""/>  
 </td>
 <td>
   <label class="control-label" for="samplename">样品名称、数量、采样时间</label> 
  <form:input path="samplename"  type="text" value="${project.samplename}" class="input-mini" required=""/>  

  <form:input path="number"  type="text" value="${project.number}" class="input-mini" required=""/>  
  <form:input path="number"  type="text" value="${project.sampling_date}" class="input-medium" required=""/>  
 
 </td>
 </tr>
 <tr>
 <td>
  <label class="control-label" for="userid">送样人</label> 
   <form:input path="userid"  type="text" value="${project.userid}" class="input-mini" required=""/>  
 
 </td>
 </tr>
</fieldset></form:form></table>

</body>
</html>