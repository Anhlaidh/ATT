<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>休假申请修改</title>
<link href="../css/style2.css" rel="stylesheet" type="text/css" />
<link href="../css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="../js/select-ui.min.js"></script>
<script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/jquery.select.js"></script>
<script type="text/javascript" src="../js/WdatePicker.js"></script>
<script type="text/javascript" src="../js/umeditor.config.js"></script>
<script type="text/javascript" src="../js/editor_api.js"></script>
<script type="text/javascript" src="../umeditor/lang/zh-cn/zh-cn.js"></script>
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
 document.forms[0].action="restSearch.html";
 document.forms[0].submit();
}
</script>

</head>

<body>
<form action="/RestUpdate?id=${pageContext.request.getParameter("id")}" method="post">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="restSearch.jsp">休假管理</a></li>
    <li><a href="#">修改休假申请</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>休假申请</span></div>
    
    <ul class="forminfo">
    <li>
      <label>工号</label>
      </label><input type="text" class="dfinput" value="account" readonly="readonly"/>
    </li>
    <li>
      <label>姓名</label>
      </label><input type="text" class="dfinput" value="name" readonly="readonly"/>
    </li>
    <li>
      <label>休假开始日期 <font color="red">*</font></label>
      <input type="text" class="dfinput"  name="start_date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
    </li>
   <li>
      <label>开始时间 <font color="red">*</font></label>
      <input type="text" class="dfinput"  name="start_time"/> (HH:mm)
    </li>
    <li>
      <label>休假结束日期 <font color="red">*</font></label>
      <input type="text" class="dfinput"  name="end_date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
    </li>
     <li>
      <label>终了时间 <font color="red">*</font></label>
      <input type="text" class="dfinput"  name="end_time"/> (HH:mm)
    </li>
      <li>
      <label>休假时间小计 </label>
      <input type="text" class="dfinput"  name="rest_time" />
    </li>
    <li>
    <br />
      <label>休假原因 <font color="red">*</font></label><input type="text" class="dfinput"  name="rest_cause" /> </li>
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
    </ul>
  </div>
</form>
</body>
</html>
