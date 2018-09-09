<%--
  Created by IntelliJ IDEA.
  User: magnu
  Date: 09.09.2018
  Time: 00.15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="CustomTags.ShortTextTag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="custom-tags" prefix="custom" %>

<html>
<head>
    <title>Title</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 30%;
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
            <td>
                <custom:shortText maxchars="10" fullText='${item.getProduct().getDesc().getdText()}'/>
            </td>
            <td>${item.getProduct().getPriceInEuro()} ${item.getProduct().getDesc().getSymbol()}</td>
            <td> ${item.getQuantity()}</td>
            <td> ${item.getTotal()} ${item.getProduct().getDesc().getSymbol()}</td>
        </tr>
    </c:forEach>
</table>
<p>Sum: ${total} ${item.getProduct().getDesc().getSymbol()}</p>
<a href="/cart?action=clear">EMPTY CART</a>
<p><a href="/">Hjem </a> <a href="/products"> Products</a></p>


<jsp:include page="footer.jsp"/>
</body>
</html>
