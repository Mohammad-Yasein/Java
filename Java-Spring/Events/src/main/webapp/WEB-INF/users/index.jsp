<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
            crossorigin="anonymous"
    />
    <style>
        .user-form {
            display: inline-block;
            width: 45%;
            vertical-align: top;
            margin: 20px;
        }

        .event-details-side {
            display: inline-block;
            width: 45%;
            vertical-align: top;
            margin: 20px;
        }

        .messages {
            border: solid black;
            min-height: 10px;
            max-height: 200px;
            overflow-y: scroll;
        }

        .delete-form {
            display: inline-block;
        }
    </style>

    <title>Event Planner</title>
</head>
<body>
<div class="container">
    <form:form class="user-form" action="/" method="post" modelAttribute="registration">
        <h2>Register</h2>
        <div class="form-group">
            <form:label path="firstName">First Name</form:label>
            <form:input class="form-control" path="firstName"/>
            <form:errors class="text-danger" path="firstName"/>
        </div>
        <div class="form-group">
            <form:label path="lastName">Last Name</form:label>
            <form:input class="form-control" path="lastName"/>
            <form:errors class="text-danger" path="lastName"/>
        </div>
        <div class="form-group">
            <form:label path="email">Email</form:label>
            <form:input type="email" class="form-control" path="email"/>
            <form:errors class="text-danger" path="email"/>
        </div>
        <div class="form-group">
            <form:label path="city">City</form:label>
            <form:input class="form-control" path="city"/>
            <form:errors class="text-danger" path="city"/>
        </div>
        <div class="form-group">
            <form:label path="state">State</form:label>
            <form:select path="state">
                <c:forEach items="${ states }" var="state">
                    <option value="${ state }">${ state }</option>
                </c:forEach>
            </form:select>
            <form:errors class="text-danger" path="state"/>
        </div>
        <div class="form-group">
            <form:label path="password">Password</form:label>
            <form:password class="form-control" path="password"/>
            <form:errors class="text-danger" path="password"/>
        </div>
        <div class="form-group">
            <form:label path="passwordConfirmation">Confirm Password</form:label>
            <form:password class="form-control" path="passwordConfirmation"/>
            <form:errors class="text-danger" path="passwordConfirmation"/>
        </div>
        <button type="submit" class="btn btn-outline-success">Register</button>
    </form:form>
    <form action="/login" class="user-form" method="post">
        <h2>Login</h2>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" id="email" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control"/>
        </div>
        <p>${ error }</p>
        <button type="submit" class="btn btn-outline-info">Login</button>
    </form>
</div>
</body>
</html>
