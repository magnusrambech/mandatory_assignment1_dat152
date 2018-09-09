<%--
  Created by IntelliJ IDEA.
  User: aryan
  Date: 08-Sep-18
  Time: 3:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        <fmt:bundle basename="Messages">
            <fmt:message key="greeting"/>
        </fmt:bundle>
    </title>
</head>
<body>
<jsp:include page="language.jsp"></jsp:include>
<h1>
    <fmt:bundle basename="Messages"><fmt:message key="products"/></fmt:bundle></h1>

<c:forEach items="${products}" var="item">

    <div style="border: 1px solid black; width: 20%">
        <h1>${item.getpName()}</h1>
        <h2>${item.getPriceInEuro()} ${item.getDesc().getSymbol()} </h2>
        <p>${item.getDesc().getdText()}</p>
        <img src='images/${item.getImageFile()}' style="width: 200px"><br>
        <a href='/cart?action=add&pNo=${item.getPno()}'>
            <fmt:bundle basename="Messages">
                <fmt:message key="addToCart" />
            </fmt:bundle>
        </a>
    </div>
</c:forEach>












<fmt:bundle basename="Messages">
    <p><a href="/">
        <fmt:message key="home"/>
    </a> <a href="/cart">
        <fmt:message key="cart"/>
    </a></p>
</fmt:bundle>

<jsp:include page="footer.jsp"/>
</body>
</html>
