<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title><c:out value="${language.name}"/> Language</title>
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
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <h1 class="text-light"><c:out value="${language.name}"/> Language</h1>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#languageNavbar" aria-controls="languageNavbar" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="languageNavbar">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mr-4">
                            <a class="nav-link" href="/languages">Dashboard</a>
                        </li>
                        <li class="nav-item mr-4">
                            <a class="nav-link" href="/languages/${language.id}/edit">Edit</a>
                        </li>
                        <li class="nav-item">
                            <form action="/languages/${language.id}" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <input type="submit" value="Delete" class="nav-link btn btn-outline-secondary px-4 py-2">
                            </form>
                        </li>
                    </ul>
                </div>
            </nav>
            <table class="table mt-5">
                <tr>
                    <th scope="row">Name:</th>
                    <td><c:out value="${language.name}"/></td>
                </tr>
                <tr>
                    <th scope="row">Creator:</th>
                    <td><c:out value="${language.creator}"/></td>
                </tr>
                <tr>
                    <th scope="row">Version:</th>
                    <td><c:out value="${language.currentVersion}"/></td>
                </tr>
            </table>
        </div>
    </body>
</html>
