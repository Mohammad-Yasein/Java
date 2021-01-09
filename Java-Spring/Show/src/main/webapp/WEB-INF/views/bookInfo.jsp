<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Book Info</title>
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
            <h1 class="mb-4"><c:out value="${book.title}"/></h1>
            <table class="table">
                <tr>
                    <th scope="row">Description:</th>
                    <td><c:out value="${book.description}"/></td>
                </tr>
                <tr>
                    <th scope="row">Language:</th>
                    <td><c:out value="${book.language}"/></td>
                </tr>
                <tr>
                    <th scope="row">Pages:</th>
                    <td><c:out value="${book.numberOfPages}"/></td>
                </tr>
            </table>
            <a href="/books/${book.id}/edit" class="btn btn-outline-info mr-2 px-4 py-2">Edit Book</a>
            <form action="/books/${book.id}" method="post" class="d-inline">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete" class="btn btn-outline-danger px-4 py-2">
            </form>
        </div>
    </body>
</html>
