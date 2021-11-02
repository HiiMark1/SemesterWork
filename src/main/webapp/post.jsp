<%@ page import="com.example.demo.model.Post" %>
<%@ page import="com.example.demo.model.User" %>
<%@ page import="com.example.demo.model.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head style="margin: 130px">
    <title>Пост</title>
</head>
<body style="margin: 105px">
<%
    Post post = (Post) request.getAttribute("post");
    User user = null;
    if(request.getAttribute("user")!=null){
        user = (User) request.getAttribute("user");
    }
    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
    out.println("<div class=\"card w-100\" style=\"background: bisque\">");
    out.println("<div class=\"card-body\">");
    out.println("<h4 class=\"card-title\">" + post.getName() + "</h4>");
    out.println("<p class=\"card-text\">" + post.getText() + "</p>");
    out.println("<p class=\"card-footer\">" + new Date(post.getDate()) + "</p>");
    out.println("</div></div><br><br><hr align=\"center\" width=\"max-content\" size=\"2px\" color=\"colar\"/>\n<br>");
    //Добавление комментов
    out.println("<form action=\"/post\" method=\"post\"><div class=\"form-group\"><label for=\"exampleFormControlTextarea1\">" +
            "Оставить комментарий</label>\n" +
            "<textarea name=\"text\" class=\"form-control\" id=\"exampleFormControlTextarea1\" rows=\"3\">" +
            "</textarea></div>");
    out.println("<input type=\"submit\" value=\"Отправить\">");
    out.println("</form><br><br><h2>Комментарии</h2><br><br>");
    for (Comment comment:comments){
        out.println("<div class=\"card w-50\" style=\"background: bisque\">");
        out.println("<div class=\"card-body\">");
        out.println("<h6 class=\"card-title\">" + new Date(comment.getDate()) + "</h6>");
        out.println("<p class=\"card-text\">" + comment.getText() + "</p>");
        out.println("</div></div><br>");
    }
    if(user!=null){
        if(user.getId()==post.getUserId()){
            out.print("<div style=\"position: absolute; top: 40px; right: 70px;\" type=\"button\" class=\"btn btn-secondary\"><a href=\"/edit_post?id="
                    + post.getId() + "\" style=\"color: black\">Редактировать пост</a></div>");
        }
    }
%>
<form action="/post" method="post"></form>
<form action="/report" method="post">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="btn-group" style="position: absolute; top: 30px; left: 60px">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Меню
    </button>
    <div class="dropdown-menu">
        <a class="dropdown-item" href="/news">Новости</a>
        <a class="dropdown-item" href="/settings">Редактировать профиль</a>
        <a class="dropdown-item" href="/upload">Загрузить новое фото профиля</a>
        <a class="dropdown-item" href="/report">Репорт</a>
        <a class="dropdown-item" href="/profile">Профиль</a>
        <a class="dropdown-item" href="/search">Поиск</a>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="/logout">Выйти</a>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
