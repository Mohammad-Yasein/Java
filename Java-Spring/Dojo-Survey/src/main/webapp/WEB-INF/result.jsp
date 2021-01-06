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

    <title>Dojo Survey Result</title>
</head>
<body class="pt-5">
<div class="container border border-secondary rounded-lg p-5">
    <h3 class="border-bottom mb-4 pb-2">Submitted Info</h3>
    <div class="row">
        <div class="col-2 font-weight-bold mb-2">Name:</div>
        <div class="mb-2">${ data.getUsername() }</div>
    </div>
    <div class="row">
        <div class="col-2 font-weight-bold mb-2">Dojo Location:</div>
        <div class="mb-2">${ data.getLocation() }</div>
    </div>
    <div class="row">
        <div class="col-2 font-weight-bold mb-2">Favorite Language:</div>
        <div class="mb-2">${ data.getFav_language() }</div>
    </div>
    <div class="row">
        <div class="col-2 font-weight-bold mb-4">Comment:</div>
        <div class="mb-2">${ data.getComment() }</div>
    </div>
    </table>
    <a href="/" class="btn btn-secondary px-5 py-2">Go Back</a>
</div>
</body>
</html>
