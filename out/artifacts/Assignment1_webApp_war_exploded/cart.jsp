<%--
  Created by IntelliJ IDEA.
  User: magnu
  Date: 09.09.2018
  Time: 00.15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<jsp:include page="language.jsp"></jsp:include>


<fmt:bundle basename="Messages">
   <h1><fmt:message key="cart"/></h1>
</fmt:bundle>


<table>
    <tr>
        <th>Product</th>
        <th>Description</th>
        <th>Unit price</th>
        <th>Quantity</th>
        <th>Total</th>
    </tr>
<c:set var="total" value="${0}"/>

    <c:forEach items="${cart}" var="item">
        <c:set var="total" value="${total + item.getTotal()}"/>
        <tr>
            <td>${item.getProduct().getpName()}</td>
            <td>${item.getProduct().getDesc().getdText()}</td>
            <td>${item.getProduct().getPriceInEuro()}</td>
            <td> ${item.getQuantity()}</td>
            <td> ${item.getTotal()}</td>
        </tr>
    </c:forEach>
</table>
<p>${total}</p>
<a href="/cart?action=clear">EMPTY CART</a>
<p><a href="/">Hjem </a> <a href="/products"> Products</a></p>
</body>
</html>
