<%@ page import="java.util.LinkedList" %>
<%@ page import="com.ATT.dao.initializeWorksyouninn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>加班审批</title>
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
    <%
        if (session.getAttribute("worksyouninnList")==null){
            LinkedList list= initializeWorksyouninn.get("ALL","ALL","ALL");
            pageContext.setAttribute("worksyouninnList",list);
        }
    %>
  
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
    <li><a href="#">审批</a></li>
    <li><a href="#">加班审批</a></li>
    </ul>
    </div>
   
	<!--查询条件-->
    <br />
    <br />
    <form action="/WorksyouninnPageListServlet" method="post" >
    <ul class="seachform">
    <li>
      <label> 加班日期:</label><input name="startdate" type="text" class="scinput"  value="请选择开始日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>
     <li>  <label> 到</label><input name="enddate" type="text" class="scinput" value="请选择结束日期" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></li>

    <li>
    <label>姓名：</label>  
    <input name="name" type="text" class="scinput" />
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>

    </ul>
    </form>
    </div>
    <table class="tablelist"><tbody><tr><td><table class="tablelist"><tbody><tr><td><table class="tablelist"><tbody><tr><td><table class="tablelist">
      <tbody>
        <tr>
          <td><table class="tablelist">
            <tbody>
              <tr>
                <td><table class="tablelist">
                      <tbody>
                        <tr>
                          <td><table class="tablelist">
                              <thead>
                                <tr>
                                  <th width="3%" height="45"><input name="input" type="checkbox" value="" checked="checked"/></th>
                                  <th width="7%">工号<i class="sort"><img src="../images/px.gif" /></i></th>
                                  <th width="11%">姓名</th>
                                  <th width="10%">加班日期</th>
                                  <th width="9%">开始时间</th>
                                  <th width="11%">终了时间</th>
                                  <th width="7%">加班原因</th>
                                  <th width="13%">操作</th>
                                </tr>
                              </thead>
                              <tbody>

                                <c:forEach items="${worksyouninnList}" var="list">
                                    <tr>
                                        <td><input name="input" type="checkbox" value="" /></td>
                                        <td>${list.account}</td>
                                        <td>${list.name}</td>
                                        <td>${list.work_date}</td>
                                        <td>${list.start_time}</td>
                                        <td>${list.end_time}</td>
                                        <td>${list.work_cause}</td>
                                        <td><span><a href="/WorkyouniAR?decision=yes&id=${list.account}" class="tablelink"><img src="../images/valid.png" onclick="confirm('确定审核通过吗？')"/></a><a href="/WorkyouniAR?decision=no&id2=${list.account}" class="tablelink" onclick="confirm('确定要驳回？')"> <img src="../images/error.png" /></a></span></td>
                                        <%--<td><span><a href="#" class="tablelink"><img src="../images/valid.png" /></a><a href="/WorkyouniAR?decision=yes&rbq=${list.account}" class="tablelink"  onclick="confirm('确定通过当前消息？')" /> <a href="/WorkyouniAR?decision=no&rbq=${list.account}" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" alt="驳回"/></a></span></td>--%>
                                    </tr>
                                </c:forEach>
                                <%--<tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td><%=request.getParameter("s2")%></td>
                                  <td><%=request.getParameter("s1")%></td>
                                  <td><%=request.getParameter("s3")%></td>
                                  <td><%=request.getParameter("s4")%></td>
                                  <td><%=request.getParameter("s5")%></td>
                                  <td><%=request.getParameter("s7")%></td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" onclick="confirm('确定审核通过吗？')"/></a><a href="#" class="tablelink" onclick="confirm('确定要驳回？')"> <img src="../images/error.png" /></a></span></td>
                                </tr>
                                <tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td></td>
                                  <td></td>
                                  <td> </td>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" /></a><a href="#" class="tablelink"  onclick="confirm('确定通过当前消息？')" /> <a href="#" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" alt="驳回"/></a></span></td>
                                </tr>
                                <tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td></td>
                                  <td></td>
                                  <td> </td>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" /> </a><a href="#" class="tablelink"  onclick="confirm('确定通过当前消息？')" /><a href="#" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" /></a></span></td>
                                </tr>
                                <tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td></td>
                                  <td></td>
                                  <td> </td>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" /> </a><a href="#" class="tablelink"  onclick="confirm('确定通过当前消息？')" /><a href="#" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" /></a></span></td>
                                </tr>
                                <tr>
                                  <td><input name="input" type="checkbox" value="" /></td>
                                  <td></td>
                                  <td></td>
                                  <td> </td>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  <td><span><a href="#" class="tablelink"><img src="../images/valid.png" /></a><a href="#" class="tablelink" onclick="confirm('确定要驳回当前消息？')"> <img src="../images/error.png" /></a></span></td>
                                </tr>--%>
                              </tbody>
                          </table></td>
                        </tr>
                      </tbody>
                  </table></td>
              </tr>
              </tbody>
          </table></td>
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
