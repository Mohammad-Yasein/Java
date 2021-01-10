<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Profile Page</title>
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
            <h1 class="mb-5"><c:out value="${person.firstName} ${person.lastName}"/></h1>
            <table class="table">
                <tr>
                    <th scope="row">License Number:</th>
                    <td><c:out value="${person.license.numberAsString}"/></td>
                </tr>
                <tr>
                    <th scope="row">State:</th>
                    <td><c:out value="${person.license.state}"/></td>
                </tr>
                <tr>
                    <th scope="row">Expiration Date:</th>
                    <td><c:out value="${person.license.expirationDateFormatted}"/></td>
                </tr>
            </table>
        </div>
    </body>
</html>
