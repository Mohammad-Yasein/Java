<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"
    ></script>

    <title>Ninja Gold Game</title>
</head>
<body class="pt-5">
<div class="container">
    <h5 class="mb-4 ml-2">Your Gold: <span class="score">${goldScore}</span></h5>
    <div class="text-center mb-4">
        <div class="form-container">
            <form action="/process" method="post">
                <h3>Farm</h3>
                <p>earns 10-20 golds</p>
                <input type="hidden" name="place" value="farm"/>
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div class="form-container">
            <form action="/process" method="post">
                <h3>Cave</h3>
                <p>earns 5-10 golds</p>
                <input type="hidden" name="place" value="cave"/>
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div class="form-container">
            <form action="/process" method="post">
                <h3>House</h3>
                <p>earns 2-5 golds</p>
                <input type="hidden" name="place" value="house"/>
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div class="form-container">
            <form action="/process" method="post">
                <h3>Casino</h3>
                <p>earns/takes 0-50 golds</p>
                <input type="hidden" name="place" value="casino"/>
                <button type="submit">Find Gold!</button>
            </form>
        </div>
    </div>
    <h5 class="ml-2">Activities:</h5>
    <div class="activities p-3">
        <c:forEach items="${activities}" var="activity">
            <p class="mb-2"><c:out value="${activity}"/></p>
        </c:forEach>
    </div>
</div>
</body>
</html>
