<%@ page import="java.util.LinkedList" %>
<%@ page import="com.ATT.dao.initializeReport" %>
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
 document.forms[0].action="reportSearch.html";
 document.forms[0].submit();
}
</script>
</head>

<body>
<form action="/ReportUpdate?id=${pageContext.request.getParameter("id")}" method="post">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="/report/reportSearch.jsp">日报管理</a></li>
    <li><a href="#">修改日报</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>

    <ul class="forminfo">
    <li>
      <label>姓名</label>
      </label><input type="text" class="dfinput" name = "name" />
    </li>
    <li>
      <label>日期 <font color="red">*</font></label>
      <input name="report_date" type="text" class="dfinput"  onClick="WdatePicker({work_date:'',dateFmt:'yyyy-MM-dd'})"/>
    </li>
     <li>
      <label>作业进度 <font color="red">*</font></label><input name="work_process" type="text" class="dfinput" />
    </li>
    <li>
      <label>作业内容<font color="red">*</font></label>
        <input name = "work_content" type="text" class="dfinput"/>
    </li>
    
    <li>
      <label>明日计划 <font color="red">*</font></label>
        <input name = "tomorrow_plan" type="text" class="dfinput"/></li>
    <li>
      <label>问题点</label>
        <input name = "problem" type="text" class="dfinput"/>
    </li>
    <li>
      <label>需联络事项</label>
        <input name = "other" type="text" class="dfinput"/>
    </li>
    <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
    </ul>
  </div>
</form>
</body>
</html>
