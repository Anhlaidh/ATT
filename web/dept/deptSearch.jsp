<%@ page import="com.ATT.bean.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ATT.bean.DepartmentBean" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.ATT.dao.initializeDepartment" %>
<%@ page import="com.ATT.dao.initializeUserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>部门管理</title>
    <link href="../css/style2.css" rel="stylesheet" type="text/css"/>
    <link href="../css/select.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="../js/select-ui.min.js"></script>
    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".select1").uedSelect({
                width: 345
            });
            $(".select2").uedSelect({
                width: 167
            });
            $(".select3").uedSelect({
                width: 100
            });
        });
    </script>
</head>

<body>
<%
    if (session.getAttribute("departmentList") == null) {
        LinkedList list = initializeDepartment.get("ALL");
        pageContext.setAttribute("departmentList", list);
    }

%>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">部门管理</a></li>
    </ul>
</div>

<!--查询条件-->
<br/>
<br/>
<form action="/DeptPageListServlet">
    <ul class="seachform">

        <li>
            <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门名称</label><input name="management" type="text"
                                                                                 class="scinput"/></li>

        <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>

    </ul>
</form>
</div>
<form action="/DeptDelServlet">
    <div class="tools">

        <ul class="toolbar">
            <li class="click"><span><img src="../images/t01.png"/></span><a href="/dept/deptInsert.jsp" target="_self">添加</a>
            </li>
            <li class="click"><span><img src="../images/trash.png"/></span><input type="submit"
                                                                                  style="outline: none;border: none;background:none;height: 33px;cursor: pointer"
                                                                                  value="删除"></li>

            <%--            <a href="/DeptDelServlet?" target="rightFrame">删除</a>--%>
        </ul>
    </div>


    <table class="tablelist">
        <tbody>
        <tr>
            <td>
                <table class="tablelist">
                    <tbody>
                    <tr>
                        <td>
                            <table class="tablelist">

                                <tbody>
                                <tr>
                                    <td>
                                        <table class="tablelist">
                                            <thead>
                                            <tr>
                                                <th width="5%" height="83"><input name="" type="checkbox" value=""
                                                                                  checked="checked"/></th>
                                                <th width="12%">部门编号<i class="sort"><img src="../images/px.gif"/></i>
                                                </th>
                                                <th width="16%">部门名称</th>
                                                <th width="15%">负责人</th>
                                                <th width="13%">人数</th>
                                                <th width="21%">注册时间</th>
                                                <th width="18%">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>


                                            <tr>
                                                <%--                 <td><input name="" type="checkbox" value="" /></td>--%>

                                                <%--                    <c:forEach >--%>
                                                <c:forEach items="${departmentList}" var="list">
                                            <tr>
                                                <td><input name="check" type="checkbox" value="${list.departmentId}"/>
                                                </td>
                                                <td>${list.departmentId}</td>
                                                <td>${list.departmentName}</td>
                                                <td>${list.name}</td>
                                                <td>${list.totalUser}</td>
                                                <td>${list.createTime}</td>
                                                <td><span><a
                                                        href="/dept/deptUpdate.jsp?id=${list.departmentId}&dept_name=${list.departmentName}"
                                                        class="tablelink"><img src="../images/user_edit.png"/>修改</a> <a
                                                        href="/DeptDelOne?DepartmentId=${list.departmentId}"
                                                        class="tablelink" onclick="confirm('确定要删除吗？')"> <img
                                                        src="../images/trash.png"/>删除</a></span></td>
                                            </tr>
                                            </c:forEach>
                                            <%
                                                session.removeAttribute("departmentList");
                                            %>


                                            <%--                    </c:forEach>--%>

                                            <%--                  <td>10001</td>--%>
                                            <%--                  <td>研发一部</td>--%>
                                            <%--                  <td>张楠</td>--%>
                                            <%--                  <td>20</td>--%>
                                            <%--                  <td>2013-09-09 15:05</td>--%>
                                            <%--                  <td><span><a href="deptUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>--%>
                                            <%--                </tr>--%>
                                            <%--                <tr>  --%>
                                            <%--                 <td><input name="" type="checkbox" value="" /></td>              --%>
                                            <%--                  <td>10002</td>--%>
                                            <%--                  <td>研发二部</td>--%>
                                            <%--                  <td>张婧研</td>--%>
                                            <%--                  <td>10</td>--%>
                                            <%--                  <td>2013-09-09 15:05</td>--%>
                                            <%--                  <td><span><a href="deptUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>--%>
                                            <%--                </tr>--%>
                                            <%--                <tr>--%>
                                            <%--                  <td><input name="" type="checkbox" value="" /></td>--%>
                                            <%--                  <td>10003</td>--%>
                                            <%--                  <td>研发三部</td>--%>
                                            <%--                  <td>张东</td>--%>
                                            <%--                  <td>30</td>--%>
                                            <%--                  <td>2013-09-09 15:05</td>--%>
                                            <%--                  <td><span><a href="deptUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>--%>
                                            <%--                </tr>--%>
                                            <%--                <tr>--%>
                                            <%--                  <td><input name="" type="checkbox" value="" /></td>--%>
                                            <%--                  <td>10004</td>--%>
                                            <%--                  <td>测试部</td>--%>
                                            <%--                  <td>王丽丽</td>--%>
                                            <%--                  <td>40</td>--%>
                                            <%--                  <td>2013-09-09 15:05</td>--%>
                                            <%--                   <td><span><a href="deptUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>--%>
                                            <%--                </tr>--%>
                                            <%--                <tr>--%>
                                            <%--                  <td><input name="" type="checkbox" value="" /></td>--%>
                                            <%--                  <td>10005</td>--%>
                                            <%--                  <td>质量保证部</td>--%>
                                            <%--                  <td>余力</td>--%>
                                            <%--                  <td>20</td>--%>
                                            <%--                  <td>2013-09-09 15:05</td>--%>
                                            <%--                  <td><span><a href="deptUpdate.jsp" class="tablelink"><img src="../images/user_edit.png" />修改</a> <a href="#" class="tablelink" onclick="confirm('确定要删除吗？')"> <img src="../images/trash.png" />删除</a></span></td>--%>
                                            <%--                </tr>--%>
                                            </tbody>
                                        </table>
                                    </td>
                                </tr>
                                </tbody>
                            </table>

                        </td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>

</form>
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
        <span><img src="images/ticon.png"/></span>
        <div class="tipright">
            <p>是否确认对信息的修改 ？</p>
            <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
    </div>

    <div class="tipbtn">
        <input name="" type="button" class="sure" value="确定"/>&nbsp;
        <input name="" type="button" class="cancel" value="取消"/>
    </div>

</div>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
