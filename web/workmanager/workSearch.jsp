<%@ page import="com.ATT.dao.initializeWorkManager" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.ATT.dao.initializeWorkManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>加班管理</title>
    <link href="../css/style2.css" rel="stylesheet" type="text/css"/>
    <link href="../css/select.css" rel="stylesheet" type="text/css"/>
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
    <%
        if (session.getAttribute("workmanagerList") == null) {
            LinkedList list = initializeWorkManager.get("ALL","ALL",-1);
            pageContext.setAttribute("workmanagerList", list);
        }

    %>
</head>

<body>


<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">加班管理</a></li>
    </ul>
</div>

<!--查询条件-->
<br/>
<br/>
<form action="/WorkPageListServlet" method="post">
<ul class="seachform">
    <li>
        <label> 申请日期:</label><input name="start_date" type="text" class="scinput"
                                 /></li>
    <li><label> 到</label><input name="end_date" type="text" class="scinput"
                                /></li>
    <li>
        <label>状态：</label>
        <div class="vocation">
            <select class="select3" name="choice">
                <option>--请选择--</option>
                <option value="0">审批中</option>
                <option value="1">已批准</option>
                <option value="2">已驳回</option>
            </select>
        </div>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
</ul>
</div>
    <form action="/WorkManagerDelServlet" method="post"></form>

<div class="tools">

    <ul class="toolbar">
        <li class="click"><span><img src="../images/t01.png"/></span><a href="workInsert.jsp" target="_self">增加</a>
        </li>
        <li class="click"><img src="../images/trash.png"/></span><a href="#"
                                                                    target="rightFrame">删除</a></li>
    </ul>
</div>
<tr>

    </tr>



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
                                                <th width="3%"><input name="" type="checkbox" value=""
                                                                      checked="checked"/>
                                                </th>
                                                <th width="7%">工号<i class="sort"><img src="../images/px.gif"/></i></th>
                                                <th width="11%">姓名</th>
                                                <th width="10%">加班日期</th>
                                                <th width="9%">开始时间</th>
                                                <th width="11%">终了时间</th>
                                                <th width="7%">加班时间小计</th>
                                                <th width="8%">状态</th>
                                                <th width="13%">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${workmanagerList}" var="list">
                                                <tr>
                                                    <td> <input name="check" type="checkbox" value="${list.record_id}"/></td>
                                                    <td>${list.account}</td>
                                                    <td>${list.name}</td>
                                                    <td>${list.work_date}</td>
                                                    <td>${list.start_time}</td>
                                                    <td>${list.end_time}</td>
                                                    <td>${list.work_time}</td>
                                                    <td>${list.state}</td>
                                                    <td><span><a href="/workmanager/workUpdate.jsp?record_id=${list.record_id}" class="tablelink"><img
                                                            src="../images/user_edit.png"/>修改</a> <a href="/ManagerDelOne?record_id=${list.record_id}"
                                                                                                     class="tablelink"
                                                                                                     onclick="confirm('确定要删除吗？')"> <img
                                                            src="../images/trash.png"/>删除</a></span></td>
                                                </tr>
                                            </c:forEach>
                                            <%
                                                session.removeAttribute("workmanagerList");
                                            %>

                                            <%-- <tr>
                                                <td><input name="" type="checkbox" value=""/></td>
                                                <td>20130901</td>
                                                <td>admin</td>
                                                <td>2013-09-09</td>
                                                <td>16:00</td>
                                                <td>22:00</td>
                                                <td>5.0</td>
                                                <td>申请中</td>
                                                <td><span><a href="workDetail.html" target="_self"
                                                             class="tablelink"><img
                                                        src="../images/user_edit.png"/>详细</a> <a href="workUpdate.jsp"
                                                                                                 class="tablelink"
                                                                                                 onclick="confirm('确定要删除吗？')"> <img
                                                        src="../images/trash.png"/>删除</a></span></td>
                                            </tr>
                                            <tr>
                                                <td><input name="" type="checkbox" value=""/></td>
                                                <td>20130902</td>
                                                <td>wanglin</td>
                                                <td>2018-09-09</td>
                                                <td>16:00</td>
                                                <td>21:00</td>
                                                <td>4.0</td>
                                                <td>申请中</td>
                                                <td><span><a href="workDetail.html" class="tablelink"><img
                                                        src="../images/user_edit.png"/>详细</a> <a href="#"
                                                                                                 class="tablelink"
                                                                                                 onclick="confirm('确定要删除吗？')"> <img
                                                        src="../images/trash.png"/>删除</a></span></td>
                                            </tr>
                                            <tr>
                                                <td><input name="" type="checkbox" value=""/></td>
                                                <td>20130903</td>
                                                <td>wangli</td>
                                                <td>2015-09-10</td>
                                                <td>20:00</td>
                                                <td>22:00</td>
                                                <td>2.0</td>
                                                <td>已批准</td>
                                                <td><span><a href="workDetail.html" class="tablelink"><img
                                                        src="../images/user_edit.png"/>详细</a> <a href="#"
                                                                                                 class="tablelink"
                                                                                                 onclick="confirm('确定要删除吗？')"> <img
                                                        src="../images/trash.png"/>删除</a></span></td>
                                            </tr>
                                            <tr>
                                                <td><input name="" type="checkbox" value=""/></td>
                                                <td>20130904</td>
                                                <td>zhangli</td>
                                                <td>2015-09-09</td>
                                                <td>05:00</td>
                                                <td>06:00</td>
                                                <td>1.0</td>
                                                <td>已批准</td>
                                                <td><span><a href="workDetail.html" class="tablelink"><img
                                                        src="../images/user_edit.png"/>详细</a> <a href="#"
                                                                                                 class="tablelink"
                                                                                                 onclick="confirm('确定要删除吗？')"> <img
                                                        src="../images/trash.png"/>删除</a></span></td>
                                            </tr>
                                            <tr>
                                                <td><input name="" type="checkbox" value=""/></td>
                                                <td>20130905</td>
                                                <td>zhang_lin</td>
                                                <td>2015-09-09</td>
                                                <td>16:00</td>
                                                <td>22:00</td>
                                                <td>5.0</td>
                                                <td>已批准</td>
                                                <td><span><a href="workDetail.html" class="tablelink"><img
                                                        src="../images/user_edit.png"/>详细</a> <a href="#"
                                                                                                 class="tablelink"
                                                                                                 onclick="confirm('确定要删除吗？')"> <img
                                                        src="../images/trash.png"/>删除</a></span></td>
                                            </tr>--%>
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
