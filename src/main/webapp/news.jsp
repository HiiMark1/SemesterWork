<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новости</title>
    <style>
        .outline {
            border: 1px solid red;
            padding: 0 10px;
        }
    </style>
</head>
<body>
<h2>Новости</h2>

<br>
<br>
<br>
<c:forEach var="news" items="${news}">
    <h1>${news.name}</h1>
    <br>
    <div class="outline">
        ${news.text}
        <br>
        ${news.rating}
    </div>
</c:forEach>
<form action="/new_post">
    <button>Создать новый пост</button>
</form>
</body>
</html>
