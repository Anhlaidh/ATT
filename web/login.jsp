<%--
  Created by IntelliJ IDEA.
  User: Anhlaidh
  Date: 2019/10/25 0025
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>考勤管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/style1.css" />
    <link rel="stylesheet" type="text/css" href="css/body.css"/>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="/LoginServlet">
            <h1>考勤管理系统</h1>
            <div>
                <input type="text" placeholder="用户名" required="" id="username" name="username" />
            </div>
            <div>
                <input type="password" placeholder="密码" required="" id="password" name="password" />
            </div>
            <div class="">
                <span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div>
            <div>
                <!-- <input type="submit" value="Log in" /> -->
                <input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
                <label> <input name="" type="checkbox" value="" checked="checked" />记住密码</label>
                <label> <input name="" type="checkbox" value="" />自动登录</label>
            </div>
        </form><!-- form -->

    </section><!-- content -->
</div>
<br><br><br><br>

</body>
</html>
