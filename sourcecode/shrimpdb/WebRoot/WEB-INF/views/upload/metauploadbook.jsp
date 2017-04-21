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
<link href="${ctx}/static/validator/jquery.validator.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/validator/jquery.validator.js" type="text/javascript"></script>
<script src="${ctx}/static/validator/local/zh_CN.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="/WEB-INF/views/layouts/header.jsp"%>	

<!-- Form Name -->
<div  class="dev_one">
	<table>
	<tr>
	<td width="450" style="padding-left:36px;">背景信息填写</td>
		<td  style="padding-left:36px;"><a href="${ctx}/upload/insertaccu">上传测试数据(开始匹配已有数据时使用的)</td>	 	
		 	        									
   </tr>	
	</table>
	   </div>
	      <div class="dakuang"><p>
<form:form  class="form-horizontal" modelAttribute="uploadcontents" action="metauploadbook" method="post" >
<fieldset>

<!-- Text input-->
<table>
<tr><td><div class="control-group">
  <label class="control-label" for="code">样品编号</label>
  <div class="controls">
    <form:input path="code" data-rule="required" type="text" placeholder="例：D0839-1" class="input-xlarge" required=""/>  
  </div>
</div></td>
<td>
  <div class="control-group">
  <label class="control-label" for="flag">数据是否公开</label>
  <div class="controls">
    <label class="radio" for="flag-0">
    <input type="radio" name="flag" id="flag-0" value="0" checked="checked"/>
     公开  
    </label>
    <label class="radio" for="flag-1">
    <input type="radio" name="flag" id="flag-1" value="1">
    保密
    </label></div></div></td>
    <td></td></tr>
<!-- Text input-->
<tr><td><div class="control-group">
  <label class="control-label" for="textinput">岩性信息</label>
  <div class="controls"> 
    <form:input path="lithologic"  data-rule="required"  type="text" placeholder="浅灰绿色石英闪长玢岩" class="input-xlarge" required=""/>   
  </div>
</div></td>
<!-- Text input-->
<td><div class="control-group">
  <label class="control-label" for="position">采样位置</label>
  <div class="controls">
    <form:input path="postion" data-rule="required"  type="text" placeholder="例：贵州省兴义市乌沙镇泥麦古村" class="input-xlarge" required=""/>    
  </div>
</div></td></tr>
<!-- Multiple Radios -->
<td><div class="control-group">
  <label class="control-label" for="LonEW">经度</label>
  <div class="controls">
    <label class="radio" for="LonEW-0">
      <input type="radio" data-rule="required" name="LonEW" id="LonEW-0" value="东经" checked="checked"/>
      东经
    </label>
    <label class="radio" for="LonEW-1">
      <input type="radio" data-rule="required" name="LonEW" id="LonEW-1" value="西经">
      西经
    </label>
    <form:input  path="LonDeg" data-rule="required" type="text" placeholder="" class="input-mini"/>
    <form:input  path="LonMin" data-rule="required" type="text" placeholder="" class="input-mini"/>
    <form:input  path="LonSec" data-rule="required" type="text" placeholder="" class="input-mini"/>
  </div>
</div>
</td>
<td><div class="control-group">
  <label class="control-label" for="LatNS">纬度</label>
  <div class="controls">
    <label class="radio" for="LatNS-0">
      <input type="radio" name="LatNS" id="LatNS-0" value="南纬" checked="checked">
      南纬
    </label>
    <label class="radio" for="LonEW-1">
      <input type="radio" name="LatNS" id="LatNS-1" value="北纬">
      北纬
    </label>
      <form:input  path="LatDeg" data-rule="required" type="text" placeholder="" class="input-mini"/>
      <form:input  path="LatMin" data-rule="required" type="text" placeholder="" class="input-mini"/>
      <form:input  path="LatSec" data-rule="required" type="text" placeholder="" class="input-mini"/>
  </div>
</div>
</td>
<!-- Form Name -->
<!-- Text input-->
<tr><td><div class="control-group">
  <label class="control-label" for="person">项目负责人</label>
  <div class="controls">
    <form:input path="person" data-rule="required" type="text" placeholder="例：范润龙" class="input-xlarge" required=""/>
  </div>
</div></td>
<!-- Text input-->
<td><div class="control-group">
  <label class="control-label" for="name">项目名称</label>
  <div class="controls">
  <form:input path="name" type="text" data-rule="required" placeholder="例：相山火山盆地深部地质调查" class="input-xlarge" required=""/>   
  </div>
</div>
</td></tr>
<!-- Text input-->
<tr><td><div class="control-group">
  <label class="control-label" for="samplename">样品名称</label>
  <div class="controls">
    <form:input path="samplename" data-rule="required" type="text" placeholder="例：锆石" class="input-xlarge" required=""/>
    
  </div>
</div>
</td><td>

<div class="control-group">
  <label class="control-label" for="projectcode">项目编号</label>
  <div class="controls">
    <form:input path="projectcode" data-rule="required" type="text" placeholder="例：1212011220248" class="input-xlarge" required=""/> 
  </div>
</div>
</td></tr><!-- Text input-->
<tr><td><div class="control-group">
  <label class="control-label" for="source">项目来源</label>
  <div class="controls">
    <form:input path="source" data-rule="required"  type="text" placeholder="例：中国地质调查局" class="input-xlarge" required=""/>
    
  </div>
</div></td>

<!-- Text input-->
<td><div class="control-group">
  <label class="control-label" for="number">样品数量</label>
  <div class="controls">
    <form:input path="number" data-rule="required" type="text" placeholder="12" class="input-xlarge" required=""/>
    
  </div>
</div>
</td></tr>
<tr><td>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="sampling_date">采样时间</label>
  <div class="controls">
    <form:input path="sampling_date" data-rule="required" type="text" placeholder="2012-12-12" class="input-xlarge" required=""/>
  </div>
</div>
</td>
<td>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="method">分析方法</label>
  <div class="controls">
    <form:input path="method" data-rule="required"  type="text" placeholder="例：SHRIMP定年" class="input-xlarge" required=""/>
    
  </div>
</div></td></tr>
<tr><td></td><td><div class="control-group">
  <label class="control-label" for="submit">提交</label>
  <div class="controls">
    <button id="submit" name="submit" class="btn btn-info">提交</button>
  </div>
</div></td></tr>
<!-- Text input-->

</fieldset></table>
</form:form>
</p></div>
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
</body>
</html>