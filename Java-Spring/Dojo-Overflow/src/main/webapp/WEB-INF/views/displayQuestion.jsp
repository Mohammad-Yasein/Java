<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Question Profile</title>
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
            <h1 class="mb-5"><c:out value="${question.question}"/></h1>
            <h3 style="height: 35px" class="mb-5">Tags:
            <c:forEach var="tag" items="${question.tags}">
                <span class="badge badge-secondary mx-2 px-3 h-100"><c:out value="${tag.subject}"/></span>
            </c:forEach>
            </h3>
            <div class="row">
                <div class="col px-4">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Answers</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="answer" items="${question.answers}">
                            <tr>
                                <td><c:out value="${answer.answer}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col px-4">
                    <form action="/questions/${question.id}" method="post">
                        <div class="form-group">
                            <label for="answer">Add your Answer</label>
                            <textarea id="answer" name="answer" class="form-control"></textarea>
                        </div>
                        <input type="submit" value="Add Answer" class="btn btn-outline-info px-4 py-2"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
