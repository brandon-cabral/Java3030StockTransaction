<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- get the Mood instance out of the session context --%>
<jsp:useBean id="stockquote" class="edu.uml.bcabral.stocktrader.model.StockQuote" scope="session">
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