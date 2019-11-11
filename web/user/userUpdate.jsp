<%@ page import="com.ATT.dao.initializeList" %>
<%@ page import="java.util.LinkedList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户添加</title>
<link href="../css/style2.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
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
 document.forms[0].action="userSearch.html";
 document.forms[0].submit();
}
</script>


</head>

<body>
<%
    LinkedList manager = initializeList.get("ALL","DepartmentBean");
    session.setAttribute("managers",manager);
%>
<form action="/UserUpdateServlet" method="post">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户管理</a></li>
    <li><a href="#">修改用户</a></li>
    </ul>
    </div>

    <div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <ul class="forminfo">
    <li>
      <label>工号 <font color="red">*</font></label>
      </label><input name="id" type="text" class="scinput" value="${pageContext.request.getParameter("id")}" readonly="readonly"/></li>
    <li>
      <label>密码 <font color="red">*</font></label>
      <input name="password" type="password" class="dfinput" value=""/>
    </li>
     <li>
      <label>确认密码 <font color="red">*</font></label><input name="" type="password" class="dfinput" />
    </li>
    <li>
      <label>姓名 <font color="red">*</font></label>
      </label><input name="name" type="text" class="dfinput" value="${pageContext.request.getParameter("name")}"/>
      </li>
     <li><label>部门</label>
        <div class="vocation">
        <select name="department" class="select3">
        <option>--请选择--</option>
            <c:forEach items="${sessionScope.managers}" var="managers">
                <option value="${managers.departmentName}">${managers.departmentName}</option>
            </c:forEach>
        </select>
        </div>
    </li>
    <li>
      <label>性别</label>
      <cite><input name="sex" type="radio" value="0" checked="checked" />
      男&nbsp;&nbsp;&nbsp;&nbsp;
      <input name="sex" type="radio" value="1" />
      女</cite></li>
    <li><label>手机号码 <font color="red">*</font></label><input name="phone" type="text" class="dfinput" value="" /></li>
    <li><label>出生日期</label>
    <input name="birthday" type="text" class="dfinput" value="" onClick="WdatePicker({work_date:'',dateFmt:'yyyy-MM-dd'})"/></li>
    <li><label>邮箱 <font color="red">*</font></label><input name="email" type="text" class="dfinput" value="" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存" /></li>
    </ul>
    </div>
</form>
</body>
</html>
