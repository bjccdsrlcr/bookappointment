<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/1 0001
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加图书</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>添加图书</h2>
        </div>
        <form>
            <div class="form-group">
                <label for="bookIdKey">图书ID</label>
                <input type="text" class="form-control" id="bookIdKey" name="bookId" placeholder="书籍ID">
            </div>
            <div class="form-group">
                <label for="bookNameKey">图书名称</label>
                <input type="text" class="form-control" id="bookNameKey" name="bookName" placeholder="书籍名称">
            </div>
            <div class="form-group">
                <label for="bookIntrodKey">图书介绍</label>
                <input type="text" class="form-control" id="bookIntrodKey" name="bookIntro" placeholder="书籍介绍">
            </div>
            <div class="form-group">
                <label for="bookNumberKey">图书数量</label>
                <input type="text" class="form-control" id="bookNumberKey" name="bookNumber" placeholder="书籍数量">
            </div>
            <button type="submit" class="btn btn-default" id="addBtn">添加</button>
        </form>


    </div>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="/resources/script/bookappointment.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        //使用EL表达式传入参数
        bookappointment.addBookPage.init();
    })
</script>
</body>
</html>
