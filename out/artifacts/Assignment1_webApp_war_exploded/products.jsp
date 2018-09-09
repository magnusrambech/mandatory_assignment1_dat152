<%--
  Created by IntelliJ IDEA.
  User: aryan
  Date: 08-Sep-18
  Time: 3:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<jsp:include page="language.jsp"></jsp:include>
<h1>
    <fmt:bundle basename="Messages"><fmt:message key="products"/></fmt:bundle></h1>
<!-- Jeg tror det er her vi skal sette cookie og hente inn http header -->
<jsp:useBean id='product' scope='session' class='Entities.Product'/>












<fmt:bundle basename="Messages">
    <a href="/GetProducts">TEST</a>
    <p><a href="home.jsp">
        <fmt:message key="home"/>
    </a> <a href="cart.jsp">
        <fmt:message key="cart"/>
    </a></p>
</fmt:bundle>
</body>
</html>
