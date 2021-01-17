<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

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
    <h2><span>Welcome, ${ user.firstName }</span><span style="float: right"><a href="/logout">logout</a></span></h2>
    <hr/>
    <h2>Edit <strong>${ event.name }</strong></h2>
    <form:form action="/events/${ event.id }" method="post" modelAttribute="event">
        <input type="hidden" name="_method" value="put">
        <form:hidden value="${ userId }" path="planner"/>
        <div class="form-group">
            <form:label path="name">Name</form:label>
            <form:input class="form-control" path="name"/>
            <form:errors class="text-danger" path="name"/>
        </div>
        <div class="form-group">
            <form:label path="eventDate">Date</form:label>
            <form:input class="form-control" type="date" path="eventDate"/>
            <form:errors class="text-danger" path="eventDate"/>
        </div>
        <div class="form-group">
            <form:label path="city">City</form:label>
            <form:input class="form-control" path="city"/>
            <form:errors class="text-danger" path="city"/>
        </div>
        <div class="form-group">
            <form:label path="state">State</form:label>
            <form:select class="form-control" path="state">
                <c:forEach items="${ states }" var="state">
                    <c:choose>
                        <c:when test="${ state.equals(event.state) }">
                            <option selected value="${ state }">${ state }</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${ state }">${ state }</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <form:errors class="text-danger" path="state"/>
        </div>
        <button type="submit" class="btn btn-outline-info">Update Event</button>
    </form:form>
</div>
</body>
</html>
