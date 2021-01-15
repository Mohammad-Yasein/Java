<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Questions Dashboard</title>
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
            <h1 class="mb-5">Questions Dashboard</h1>
            <table class="table table-striped mb-5">
                <thead>
                    <tr>
                        <th scope="col">Question</th>
                        <th scope="col">Tags</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="q" items="${questions}">
                    <tr>
                        <td><a href="/questions/${q.id}"><c:out value="${q.question}"/></a></td>
                        <td>
                        <c:forEach var="tag" items="${q.tags}">
                            <c:out value="${tag.subject} "/>
                        </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/questions/new">Add Question</a>
        </div>
    </body>
</html>
