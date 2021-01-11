<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>New Ninja</title>
        <link
                rel="stylesheet"
                href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
                integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
                crossorigin="anonymous"
        />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
                src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
                crossorigin="anonymous"
        ></script>
    </head>
    <body class="p-5">
        <div class="container">
            <h1 class="mb-4">New Ninja</h1>
            <form:form action="/ninjas" method="post" modelAttribute="ninja">
                <div class="form-group">
                    <form:label path="dojo">Dojo</form:label>
                    <form:select path="dojo" class="form-control">
                        <c:forEach items="${dojos}" var="dojo">
                            <form:option value="${dojo.id}">${dojo.name}</form:option>
                        </c:forEach>
                    </form:select>
                    <form:errors path="dojo" class="text-danger"/>
                </div>
                <div class="form-group">
                    <form:label path="firstName">First Name</form:label>
                    <form:input path="firstName" class="form-control"/>
                    <form:errors path="firstName" class="text-danger"/>
                </div>
                <div class="form-group">
                    <form:label path="lastName">Last Name</form:label>
                    <form:input path="lastName" class="form-control"/>
                    <form:errors path="lastName" class="text-danger"/>
                </div>
                <div class="form-group">
                    <form:label path="age">Age</form:label>
                    <form:input path="age" type="number" class="form-control"/>
                    <form:errors path="age" class="text-danger"/>
                </div>
                <input type="submit" value="Create" class="btn btn-outline-info px-4 py-2"/>
            </form:form>
        </div>
    </body>
</html>
