<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
<jsp:include page="language.jsp"></jsp:include>
<!-- Jeg tror det er her vi skal sette cookie og hente inn http header -->
<h1>
    <fmt:bundle basename="Messages">
        <fmt:message key="greeting"/>
    </fmt:bundle>
</h1>
<img src="images/logo.png" style="height: 500px">

    <p>
        <a href="/products">
            <fmt:bundle basename="Messages">
                <fmt:message key="products"/>
            </fmt:bundle>
        </a>
    </p>
<jsp:include page="footer.jsp"/>

</body>
</html>
