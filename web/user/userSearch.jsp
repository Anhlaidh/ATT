<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
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
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户管理</a></li>
    </ul>
    </div>
   
	<!--查询条件-->
    <br />
    <br />
    <form action="/DeptPageListServlet" method="post">
    <ul class="seachform">
  
    <li><label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名</label><input name="name" type="text" class="scinput" /></li>
    <li><label>部门</label>  
    <div class="vocation">

            <select class="select3" name="department">
                <option value="research_1">研发一部</option>
                <option value="research_2">研发二部</option>
                <option value="research_3">研发三部</option>
                <option value="test">测试</option>
            </select>


    </div>
    </li>

    <li><label>&nbsp;</label>
        <input name="" type="submit" class="scbtn" value="查询" /></li>
    
    </ul>
    </form>
    </div>

    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="../images/t01.png" /></span><a href="userInsert.jsp" target="rightFrame">添加</a></li>
        <li class="click"><img src="../images/trash.png" /></span><a href="#" target="rightFrame">删除</a></li>
        </ul>
    </div>
    
    
    <table class="tablelist"><tbody><tr><td><table class="tablelist"><tbody><tr><td><table class="tablelist">
      <tbody>
        <tr>
          <td><table class="tablelist">
              <thead>
                <tr>
                <th><input name="" type="checkbox" value="" checked="checked"/></th>
                  <th width="7%">工号<i class="sort"><img src="../images/px.gif" /></i></th>
                  <th width="11%">姓名</th>
                  <th width="10%">部门</th>
                  <th width="9%">职务</th>
                  <th width="11%">注册时间</th>
                  <th width="5%">性别</th>
                  <th width="10%">手机</th>
                  <th width="9%">出生日期</th>
                  <th width="12%">邮箱</th>
                  <th width="13%">操作</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                 <td><input name="" type="checkbox" value="" /></td>
                  <td>20130901</td>
                  <td>admin</td>
                  <td>研发一部</td>
                  <td>员工</td>
                  <td>2013-09-09 15:05</td>
                  <td>男</td>
                  <td>13356789067</td>
                  <td>1980-09-09</td>
                  <td>admin_163.com</td>
                  <td><span><a href="userUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>  
                 <td><input name="" type="checkbox" value="" /></td>              
                  <td>20130902</td>
                  <td>wanglin</td>
                  <td>研发二部</td>
                  <td>部门主管</td>
                  <td>2013-09-09 15:05</td>
                  <td>男</td>
                  <td>13356787689</td>
                  <td>1983-09-09</td>
                  <td>wanglin_inspur.com</td>
                  <td><span><a href="userUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>20130903</td>
                  <td>wangli</td>
                  <td>研发一部</td>
                  <td>部门主管</td>
                  <td>2013-09-09 15:05</td>
                  <td>男</td>
                  <td>13356789099</td>
                  <td>1989-09-09</td>
                  <td>ispur</td>
                  <td><span><a href="userUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>20130904</td>
                  <td>zhangli</td>
                  <td>测试部</td>
                  <td>员工</td>
                  <td>2013-09-09 15:05</td>
                  <td>女</td>
                  <td>18678987890</td>
                  <td>1989-04-09</td>
                  <td>admin_163.com</td>
                   <td><span><a href="userUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
                <tr>
                  <td><input name="" type="checkbox" value="" /></td>
                  <td>20130905</td>
                  <td>zhang_lin</td>
                  <td>测试部</td>
                  <td>员工</td>
                  <td>2013-09-09 15:05</td>
                  <td>男</td>
                  <td>13305317890</td>
                  <td>1989-09-12</td>
                  <td>admin_163.com</td>
                  <td><span><a href="userUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>
                </tr>
              </tbody>
          </table></td>
        </tr>
      </tbody>
    </table>
    </td>
          </tr>
    </tbody>
    </table></td>
        </tr>
    </tbody>
    </table>
    
   
<div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:;">1</a></li>
        <li class="paginItem current"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
