<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>data upload</title>
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
<div  class="dev_one">
	<table>
	<tr>
    <td width="200" style="padding-left:36px;">add sample description</td>	 	        									
    </tr>	
	</table>
	</div>
	<div class="dakuang"><p>
<!-- Form Name -->
<form:form  class="form-horizontal" modelAttribute="uploadcontents" action="metaupload" method="post" >
<fieldset>

<!-- Text input-->
<table>
<tr><td><div class="control-group">
  <label class="control-label" for="code">sample code</label>
  <div class="controls">
    <form:input path="code"  type="text" placeholder="eg：D0839-1" class="input-xlarge"  data-rule="required"/>  
  </div>
</div></td>
<td>
  <div class="control-group">
  <label class="control-label" for="flag">open or private</label>
  <div class="controls">
    <label class="radio" for="flag-0">
    <input type="radio" name="flag" id="flag-0" value="0" checked="checked"/>
  open  
    </label>
    <label class="radio" for="flag-1">
    <input type="radio" name="flag" id="flag-1" value="1">
    private
    </label></div></div></td>
    <td></td></tr>
<!-- Text input-->
<tr><td><div class="control-group">
  <label class="control-label" for="textinput">lithology</label>
  <div class="controls">
  <form:input  path="lithologic"  type="text"  placeholder="Shallow celadon quartz diorite porphyrite"  class="input-xlarge"  data-rule="required"/>       
  </div>
</div></td>
<!-- Text input-->
<td><div class="control-group">
  <label class="control-label" for="position">sampling position</label>
  <div class="controls">
    <form:input path="postion" type="text" placeholder="eg：Nigu viliage, Wusha town, xingyi city, GUizhou province" class="input-xlarge" required=""/>    
  </div>
</div></td></tr>
<!-- Multiple Radios -->
<td><div class="control-group">
  <label class="control-label" for="LonEW">longitude</label>
  <div class="controls">
    <label class="radio" for="LonEW-0">
      <input type="radio" name="LonEW" id="LonEW-0" value="东经" checked="checked"/>
    east longitude
    </label>
    <label class="radio" for="LonEW-1">
      <input type="radio" name="LonEW" id="LonEW-1" value="西经">
      west longitude
    </label>
    <form:input  path="LonDeg"  type="text"  placeholder=""  data-rule="required"  class="input-mini"/>
    <form:input  path="LonMin"  type="text"  placeholder=""  data-rule="required"  class="input-mini"/>
    <form:input  path="LonSec"  type="text"  placeholder=""  data-rule="required"  class="input-mini"/>
  </div>
</div>
</td>
<td><div class="control-group">
  <label class="control-label" for="LatNS">latitude</label>
  <div class="controls">
    <label class="radio" for="LatNS-0">
      <input  type="radio" name="LatNS"  id="LatNS-0"  value="南纬"  checked="checked">
     south latitude
    </label>
    <label class="radio" for="LonEW-1">
      <input  type="radio" name="LatNS"  id="LatNS-1"  value="北纬">
    north latitude
    </label>
      <form:input  path="LatDeg"  type="text"  data-rule="required"  placeholder=""  class="input-mini"/>
      <form:input  path="LatMin"  type="text"  data-rule="required"  placeholder=""  class="input-mini"/>
      <form:input  path="LatSec"  type="text"  data-rule="required"  placeholder=""  class="input-mini"/>
  </div>
</div>
</td>
<!-- Form Name -->

<!-- Text input-->
<tr><td><div class="control-group">
  <label class="control-label" for="person">lab name</label>
  <div class="controls">
    <form:input path="person" type="text"  data-rule="required"  placeholder="eg:Beijing shrimp centre"  class="input-xlarge"  required=""/>
  </div>
</div></td>
<!-- Text input-->
<td><div class="control-group">
  <label class="control-label" for="name">lab location</label>
  <div class="controls">
  <form:input path="name" type="text"  data-rule="required"  placeholder="Beijing SHRIMP centre, 100037, Beijing, China "   class="input-xlarge"  required=""/>   
  </div>
</div>
</td></tr>
<!-- Text input-->
<tr><td><div class="control-group">
  <label class="control-label" for="samplename">lab qualification</label>
  <div class="controls">
    <form:input path="samplename" data-rule="required"  type="text" placeholder="yes or not"  class="input-xlarge" required=""/>
    
  </div>
</div>
</td><td>

<div class="control-group">
  <label class="control-label" for="projectcode">lab tel</label>
  <div class="controls">
    <form:input path="projectcode"  data-rule="required"  type="text"  placeholder="yes or not"  class="input-xlarge" required=""/> 
  </div>
</div>
</td></tr><!-- Text input-->
<tr><td><div class="control-group">
  <label class="control-label" for="source">publish or not</label>
  <div class="controls">
    <form:input path="source"  data-rule="required"  type="text" placeholder="yes" class="input-xlarge" required=""/>
    
  </div>
</div></td>

<!-- Text input-->
<td><div class="control-group">
  <label class="control-label" for="number">literature name</label>
  <div class="controls">
    <form:input path="number" data-rule="required,number"  type="text" placeholder="12" class="input-xlarge" required=""/>
    
  </div>
</div>
</td></tr>
<tr><td>
<!-- Text input-->
<div class="control-group">
  <label class="control-label"  for="sampling_date">publish title</label>
  <div class="controls">
    <form:input path="sampling_date" type="text" placeholder="2012-12-12" class="input-xlarge" required=""/>
  </div>
</div>
</td>
<td>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="method">page</label>
  <div class="controls">
    <form:input path="method"  data-rule="required" type="text" placeholder="1231-1239" class="input-xlarge" required=""/>
    
  </div>
</div></td></tr>
<tr><td></td><td><div class="control-group">
  
  <div class="controls">
    <button id="submit" name="submit" class="btn btn-info">SUBMIT</button>
  </div>
</div></td></tr>
<!-- Text input-->

</fieldset></table>
</form:form>
</p></div>
<%@ include file="/WEB-INF/views/layouts/footer1.jsp"%>	
</body>
</html>