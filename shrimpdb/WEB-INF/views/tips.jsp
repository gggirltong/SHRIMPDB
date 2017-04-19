<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/layouts/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>welcome</title>
</head>
<body>
1,jsp页面：mount.jsp 中显示的送样时间在JDBC中中借用的是m.remarke这个字段，为了不需要额外定义新的entity.
2,jsp页面：measurement.jsp中显示的样品靶名，用户名，用户单位，用户部门，用户电话分别在JDBC处的对应关系为
Last-operator->m.id;last_operate_time->m.mountname; LonEW->m.remarka;
operator->u.id; LonMin->u.name; Lonsec->u.department; LatDeg->u.unit; LatNS->u.phone


</body></html>
