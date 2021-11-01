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
    out.println("<br>");
    for (Comment comment:comments){
        out.println("<div class=\"card w-50\" style=\"background: bisque\">");
        out.println("<div class=\"card-body\">");
        out.println("<h4 class=\"card-title\">" + new Date(comment.getDate()) + "</h4>");
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
</body>
</html>
