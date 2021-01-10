<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>New License</title>
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
            <h1 class="mb-4">New License</h1>
            <form:form action="/licenses" method="post" modelAttribute="license">
                <div class="form-group">
                    <form:label path="person">Person</form:label>
                    <form:select path="person" class="form-control">
                    <c:forEach items="${persons}" var="person">
                        <form:option value="${person}">${person.firstName} ${person.lastName}</form:option>
                    </c:forEach>
                    </form:select>
                    <form:errors path="person"/>
                </div>
                <div class="form-group">
                    <form:label path="state">State</form:label>
                    <form:input path="state" class="form-control"/>
                    <form:errors path="state"/>
                </div>
                <div class="form-group">
                    <form:label path="expirationDate">Expiration Date</form:label>
                    <form:input path="expirationDate" type="date" class="form-control"/>
                    <form:errors path="expirationDate"/>
                </div>
                <input type="submit" value="Create" class="btn btn-outline-info px-4 py-2"/>
            </form:form>
        </div>
    </body>
</html>
