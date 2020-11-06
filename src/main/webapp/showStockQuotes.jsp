<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- get the quote list instance out of the session context --%>
<jsp:useBean id="quotes" class="java.util.ArrayList" scope="session">
    <c:set target='${quotes}'  value='${sessionScope.get("quotes")}'/>
</jsp:useBean>

<html>

<head>
    <title>Stock Quotes</title>
</head>

<body>
Stock Quotes: <br>
<c:out value="${quotes}"> </c:out>
</body>

</html>