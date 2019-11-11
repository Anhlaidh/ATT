<%@ page import="com.ATT.dao.initializeList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.LinkedList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门修改</title>
<link href="../css/style2.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
<script language="javascript">
function saveButton(){
 document.forms[0].action="deptSearch.html";
 document.forms[0].submit();
}
</script>


</head>

<body>
<%
    LinkedList manager = initializeList.get("ALL","DepartmentBean");
    session.setAttribute("managers",manager);
%>
<form action="/DeptUpdate">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">部门管理</a></li>
    <li><a href="#">修改部门</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li>
      <label>部门编号</label>
      </label><input name="Dept_id" type="text" class="dfinput" readonly="readonly" value="${pageContext.request.getParameter("id")}" readonly="readonly"/></li>
    <li>
      <label>部门名称</label>
      <input name="Dept_name" type="text" class="dfinput" value="${pageContext.request.getParameter("dept_name")}"/>
    </li>
     <li>
      <label>负责人 </label>
       <div class="vocation">
    <select name="Dept_manager" class="select3">
    <option value="">--请选择--</option>
        <c:forEach items="${sessionScope.managers}" var="managers">
        <option value="${managers.name}">${managers.name}</option>
    </c:forEach>
<%--    <option>余力</option>--%>
<%--    <option>张安娜</option>--%>
<%--    <option selected>张楠</option>--%>
<%--    <option>张丽丽</option>--%>
    </select>
    </div>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" /></li>
    </ul>
    </div>
</form>
</body>
</html>
