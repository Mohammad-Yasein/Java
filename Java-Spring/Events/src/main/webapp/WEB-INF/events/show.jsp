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
    <h2>${ event.name }</h2>
    <div class="event-details-side">
        <h4><strong>Host:</strong> ${ event.planner.firstName }</h4>
        <h4><strong>Date:</strong> ${ event.eventDate }</h4>
        <h4><strong>Location:</strong> ${ event.city }, ${ event.state }</h4>
        <h4><strong>People attending:</strong> ${ event.attendees.size() }</h4>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Location</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ event.attendees }" var="user">
                <tr>
                    <td>${ user.firstName } ${ user.lastName }</td>
                    <td>${ user.city }, ${ user.state }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="event-details-side">
        <h3>Message Wall</h3>
        <div class="messages">
            <c:forEach items="${ event.messages }" var="message">
                <p>${ message.author.firstName } says: ${ message.content }</p>
            </c:forEach>
        </div>
        <form action="/events/${ event.id }" method="post">
            <div class="form-group">
                <label for="comment">Add Comment</label>
                <textarea name="comment" id="comment" class="form-control"></textarea>
                <span class="text-danger">${ error }</span>
                <button type="submit" class="btn btn-outline-info">Submit</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
