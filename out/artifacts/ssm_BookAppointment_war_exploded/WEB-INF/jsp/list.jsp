<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/1 0001
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>图书列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>图书列表</h2>
        </div>
        <form name="firstForm" action="<%= request.getContextPath()%>/books/search" method="post">
        	<div class="panel-heading ">
        	    <table class="table table-bookName">
        	       <thead>
        	       		<tr>
        					<th width="90" align="lift">图书名称：</th>
        					<th width="150" align="lift">
        						<input type="text" name="name" class="allInput" value="${name}" placeholder="输入检索书名^o^" />
        					</th>
        					<th>
        						<input type="submit" id="tabSub" value="检索" />
                                <button type="button" class="btn btn-info" id="clearCache">清除缓存</button>
        					</th>
                            <th>
                                <button type="button" class="btn btn-info" id="addBook" style="float: right;">添加图书</button>
                            </th>
        				</tr>
        	       </thead>
        	    </table>
         	</div>
        </form>


        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><a id="bookID">图书ID</a><div class="glyphicon glyphicon-arrow-up arrow-up"></div>
                        <div class="glyphicon glyphicon-arrow-down arrow-down"></div></th>
                    <th>图书名称</th>
                    <th><a id="number">馆藏数量</a><div  class="glyphicon glyphicon-arrow-up arrow-up"></div>
                        <div class="glyphicon glyphicon-arrow-down arrow-down"></div></th>
                    <th>详细</th>
                </tr>
                </thead>
                <tbody id="bookList">
                <c:forEach items="${list}" var="sk">
                    <tr>
                        <td>${sk.bookId}</td>
                        <td>${sk.name}</td>
                        <td>${sk.number}</td>
                        <td><a class="btn btn-info" href="/books/${sk.bookId}/detail" >详细</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>

        <nav aria-label="Page navigation">
            <ul class="pager pagination-lg">
                <li>
                    <a href="#" aria-label="Previous" id="previous"><span aria-hidden="true">&laquo;</span></a>
                </li>
                <li><a href="#" id="first-column"></a></li>
                <li><a href="#" id="second-column"></a></li>
                <li><a href="#" id="third-column"></a></li>
                <li><a href="#" id="forth-column"></a></li>
                <li><a href="#" id="fifth-column"></a></li>
                <li>
                <a href="#" aria-label="Next" id="next"><span aria-hidden="true">&raquo;</span></a>
                </li>
                <li><input type="text" id="recordNum" value="5"></li>
            </ul>
        </nav>
    </div>
</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="/resources/script/bookappointment.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        bookappointment.list.init();
    })
</script>
</body>
</html>

