<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>WebSocket 简单对话示例</title>
    <script type="text/javascript" src="resources/jquery.js"></script>
</head>
<body>
<form action="message/login" method="post">
    用户名:
    <select name="id">
        <option value="24">科比</option>
        <option value="23">詹姆斯</option>
    </select><br>
    密码:
    <input name="password" type="text" value="123456">
    <input type="submit" value="登录">
    <br/><br/>
</form>
</body>
</html>
