<%--
  Created by IntelliJ IDEA.
  User: aryan
  Date: 08-Sep-18
  Time: 3:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<!-- Jeg tror det er her vi skal sette cookie og hente inn http header -->
<h1>Press to Enter store</h1>
    <form action="/home" method="post">
        <input type="submit" value="enter">
    </form>
<jsp:include page="products.jsp"></jsp:include>
</body>
</html>
