<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

    <title>Dojo Survey Form</title>
</head>
<body class="pt-5">
<div class="container border border-secondary rounded-lg p-5">
    <form action="/result" method="post">
        <label for="username" class="mb-2">Your Name: </label>
        <input type="text" name="username" id="username" class="form-control"/>
        <label for="location" class="mt-4 mb-2">Dojo Location: </label>
        <select name="location" id="location" class="form-control">
            <option value="California">California</option>
            <option value="Texas">Texas</option>
            <option value="Manhattan">Manhattan</option>
        </select>
        <label for="fav_language" class="mt-4 mb-2">Favorite Language: </label>
        <select name="fav_language" id="fav_language" class="form-control">
            <option value="Python">Python</option>
            <option value="Java">Java</option>
            <option value="C++">C++</option>
        </select>
        <label for="comment" class="mt-4 mb-2">Comment (optional): </label>
        <textarea name="comment" id="comment" rows="10" class="form-control mb-4"></textarea>
        <button type="submit" class="btn btn-secondary px-5 py-2">Submit</button>
    </form>
</div>
</body>
</html>
