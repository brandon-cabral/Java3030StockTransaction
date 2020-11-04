<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Search Stock Quotes</title>
    <meta name="description" content="Stock Quotes Page">
    <meta name="author" content="Brandon Cabral">
    <meta name="date" content="10/30/2020">
</head>
<body>
<h2>Search Stock Quotes</h2>

<p>Enter the stock symbol, date from and date to in the boxes below</p>

<form name="stockquoteform" action="servlets/stocks/" method="post">
        Stock Symbol: <input type="text" name="symbol" maxlength="4" value="xxxx">
            <br>
        Date From: <input type="text" name="date_from" maxlength="10" value="yyyy/MM/dd">
            <br>
        Date Until: <input type="text" name="date_until" maxlength="10" value="yyyy/MM/dd">
            <br>
        <input type="submit" value="search">
        <input type="hidden" name="submit" value="true">
</form>
</body>
</html>