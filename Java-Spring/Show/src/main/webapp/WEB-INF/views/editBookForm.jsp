<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Edit Book</title>
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
            <h1 class="mb-4">Edit Book</h1>
            <form:form action="/books/${book.id}" method="post" modelAttribute="book">
                <input type="hidden" name="_method" value="put">
                <div class="form-group">
                    <form:label path="title">Title</form:label>
                    <form:errors path="title"/>
                    <form:input path="title" value="${book.title}" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="description">Description</form:label>
                    <form:errors path="description"/>
                    <form:textarea path="description" value="${book.description}" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="language">Language</form:label>
                    <form:errors path="language"/>
                    <form:input path="language" value="${book.language}" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="numberOfPages">Pages</form:label>
                    <form:errors path="numberOfPages"/>
                    <form:input type="number" path="numberOfPages" value="${book.numberOfPages}" class="form-control"/>
                </div>
                <input type="submit" value="Update" class="btn btn-outline-info px-4 py-2"/>
            </form:form>
        </div>
    </body>
</html>
