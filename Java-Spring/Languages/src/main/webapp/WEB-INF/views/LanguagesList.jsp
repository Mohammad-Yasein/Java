<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Languages</title>
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
            <h1 class="mb-4">All Languages</h1>
            <table class="table table-striped mb-5">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Creator</th>
                        <th scope="col">Version</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${languages}" var="language">
                    <tr>
                        <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
                        <td><c:out value="${language.creator}"/></td>
                        <td><c:out value="${language.currentVersion}"/></td>
                        <td>
                            <a href="/languages/${language.id}/edit" class="btn btn-outline-info mr-2 px-4 py-2">Edit</a>
                            <form action="/languages/${language.id}" method="post" class="d-inline">
                                <input type="hidden" name="_method" value="delete">
                                <input type="submit" value="Delete" class="btn btn-outline-danger px-4 py-2">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <h3 class="mb-4">Add New Language:</h3>
            <form:form action="/languages" method="post" modelAttribute="language">
                <div class="form-group">
                    <form:label path="name">Name</form:label>
                    <form:errors path="name"/>
                    <form:input path="name" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="creator">Creator</form:label>
                    <form:errors path="creator"/>
                    <form:input path="creator" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="currentVersion">Version</form:label>
                    <form:errors path="currentVersion"/>
                    <form:input path="currentVersion" class="form-control"/>
                </div>
                <input type="submit" value="Add" class="btn btn-outline-info px-4 py-2"/>
            </form:form>
        </div>
    </body>
</html>
