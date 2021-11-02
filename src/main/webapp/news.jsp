<%@ page import="com.example.demo.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.example.demo.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head style="margin: 130px">
    <title>Новости</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="margin: 105px">
<h2>Новости</h2>
<br>
<br>
<br>
<%
    List<Post> posts = (List<Post>) request.getAttribute("news");
    for (Post post: posts){
          out.println("<div class=\"card w-75\" style=\"background: bisque\">");
          out.println("<div class=\"card-body\">");
          out.println("<h4 class=\"card-title\">" + post.getName() + "</h4>");
          out.println("<p class=\"card-text\">" + post.getText() + "</p>");
        out.println("<p class=\"card-footer\">" + new Date(post.getDate()) + "</p>");
          out.println("<a href=\"/post?id=" + post.getId() + "\">" + "Перейти к посту" + "</a>");
          out.println("</div></div><br><br>");
    }
    out.print("<div class=\"dropdown\" style=\"position: absolute; top: 30px; left: 60px\">" +
            "<button class=\"btn btn-info dropdown-toggle\" data-toggle=\"dropdown\">Меню" +
            "<span class=\"caret\"></span></button><ul class=\"dropdown-menu\">" +
            "<li><a href=\"/news\">Новости</a> </li><li><a href=\"/settings\">Редактировать профиль</a> </li>" +
            "<li><a href=\"/upload\">Загрузить новое фото профиля</a> </li><li><a href=\"/report\">Репорт</a></li>");
    User user = (User) request.getAttribute("user");
    if (user!=null){
          out.print("<li><a href=\"/profile\">Профиль</a></li>");
    }
    out.print("<li><a href=\"/search\">Поиск</a> </li>");
    out.print("<li class=\"diviner\"></li>");
    if(user==null){
        out.print("<li><a href=\"/login\">Логин</a></li>");
        out.print("<li><a href=\"/reg\">Регистрация</a></li>");
    } else {
        out.print("<li><a href=\"/logout\">Выйти</a></li></ul></div>");
    }
    if(user!=null){
          out.print("<a href=\"/new_post\" class=\"btn btn-primary\" style=\"position: absolute; top: 50px; right: 70px\">Создать новый пост</a>");
    }
%>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
