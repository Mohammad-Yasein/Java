<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Product Page</title>
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
            <h1 class="mb-4"><c:out value="${product.name}"/></h1>
            <div class="row">
                <div class="col">
                    <h3>Categories:</h3>
                    <ul>
                    <c:forEach var="category" items="${product.categories}">
                        <li><c:out value="${category.name}"/></li>
                    </c:forEach>
                    </ul>
                </div>
                <div class="col">
                <form action="/products/${product.id}" method="post">
                    <div class="form-group">
                    <label for="categoryId">Add Category</label>
                    <select id="categoryId" name="categoryId" class="form-control">
                    <c:forEach var="cat" items="${categories}">
                        <option value="${cat.id}"><c:out value="${cat.name}"/></option>
                    </c:forEach>
                    </select>
                    </div>
                    <input type="submit" value="Add" class="btn btn-outline-info px-4 py-2"/>
                </form>
                </div>
            </div>
        </div>
    </body>
</html>
