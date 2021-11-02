<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Новости</#macro>
<#macro header>Новости</#macro>
<title>Новости</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<#macro content>
    <br><br><br>
<#if news?has_content>
<#list news as post>
    <div class="card w-75" style="background: bisque">
        <div class="card-body">
            <h4 class="card-title">${post.name}</h4>
            <p class="card-text">${post.text}</p>
            <a href="/post?id=${post.id}">Перейти к посту</a>
        </div>
    </div>
<br><br>
</#list>
<#else>
    <p>Нет новостей</p>
</#if>
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
    <#if user?has_content>
        <a href="/new_post" class="btn btn-primary" style="position: absolute; top: 50px; right: 70px">Создать новый пост</a>
    </#if>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</#macro>
</html>