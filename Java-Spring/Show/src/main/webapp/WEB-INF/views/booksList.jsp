<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>All Books</title>
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
    </head>
    <body class="p-5">
        <div class="container">
            <h1 class="mb-4">All Books</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Description</th>
                        <th scope="col">Language</th>
                        <th scope="col">Pages</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td><c:out value="${book.title}"/></td>
                        <td><c:out value="${book.description}"/></td>
                        <td><c:out value="${book.language}"/></td>
                        <td><c:out value="${book.numberOfPages}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/books/add" class="btn btn-outline-info px-4 py-2">Add Book</a>
        </div>
    </body>
</html>
