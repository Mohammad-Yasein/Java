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
    <h2><span>Welcome, ${ user.firstName }</span><span style="float: right"><a href="/logout">logout</a></span></h2>
    <hr/>
    <div class="new-event float float-right">
        <p>Plan an Event:</p>
        <form:form action="/events" method="post" modelAttribute="event">
            <form:hidden value="${ user.id }" path="planner"/>
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input class="form-control" path="name"/>
                <form:errors class="text-danger" path="name"/>
            </div>
            <div class="form-group">
                <form:label path="eventDate">Date</form:label>
                <form:input class="form-control" type="date" value="${ now }" path="eventDate"/>
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
                        <option value="${ state }">${ state }</option>
                    </c:forEach>
                </form:select>
                <form:errors class="text-danger" path="state"/>
            </div>
            <button type="submit" class="btn btn-outline-success">Create Event</button>
        </form:form>
    </div>
    <div class="float float-left">
        <h3>Here are some events in your state:</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>City</th>
                <th>Host</th>
                <th>Action/Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ userStateEvents }" var="event">
                <tr>
                    <td><a href="/events/${ event.id }">${ event.name }</a></td>
                    <td>${ event.eventDate }</td>
                    <td>${ event.city }</td>
                    <td>${ event.planner.firstName }</td>
                    <td>
                        <c:choose>
                            <c:when test="${ event.planner.id == user.id }">
                                <a href="/events/${ event.id }/edit">Edit</a> |
                                <form class="delete-form" action="/events/${ event.id }" method="post">
                                    <input type="hidden" name="_method" value="delete"/>
                                    <button type="submit" class="btn btn-outline-danger">Delete</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${ event.attendees.contains(user) }">
                                        <span>Joining <a href="/events/${ event.id }/action/cancel">Cancel</a></span>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="/events/${ event.id }/action/join">Join</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h3>Here are some events in other states:</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>City</th>
                <th>State</th>
                <th>Host</th>
                <th>Action/Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ otherStateEvents }" var="event">
                <tr>
                    <td><a href="/events/${ event.id }">${ event.name }</a></td>
                    <td>${ event.eventDate }</td>
                    <td>${ event.city }</td>
                    <td>${ event.state }</td>
                    <td>${ event.planner.firstName }</td>
                    <td>
                        <c:choose>
                            <c:when test="${ event.planner.id == user.id }">
                                <a href="/events/${ event.id }/edit">Edit</a> |
                                <form class="delete-form" action="/events/${ event.id }" method="post">
                                    <input type="hidden" name="_method" value="delete"/>
                                    <button type="submit" class="btn btn-outline-danger">Delete</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${ event.attendees.contains(user) }">
                                        <span>Joining <a href="/events/${ event.id }/action/cancel">Cancel</a></span>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="/events/${ event.id }/action/join">Join</a>
                                    </c:otherwise>

                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
