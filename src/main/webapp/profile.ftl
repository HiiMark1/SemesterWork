<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Профиль</#macro>
<#macro header>Личный кабинет</#macro>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<#macro content>
    <#if (user.name)??>
        ${user.name}
    </#if>
    <#if (user.surname)??>
        ${user.surname}
    </#if>
    <br>
    <#if (user.age)??>
        Возраст:
        ${user.age}
    </#if>
    <br>
    <#if (user.status)??>
        Статус:
        ${user.status}
    </#if>
    <br>
    <#if (user.imageUri)??>
        <div style="position: absolute; top: 70px; right: 70px">
            ${user.imageUri}
        </div>
    </#if>
    <br>
    <br>
    <br>
    <form action="/upload">
        <button>Установить новое фото профиля</button>
    </form>
    <form action="/settings">
        <button>Редактировать</button>
    </form>
    <br>
    <form action="/logout">
        <button>Выйти</button>
    </form>
    <div class="dropdown" style="position: absolute; top: 30px; left: 60px">
        <button class="btn btn-info dropdown-toggle" data-toggle="dropdown">Меню
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="/news">Новости</a> </li>
            <li><a href="/settings">Редактировать профиль</a> </li>
            <li><a href="/upload">Загрузить новое фото профиля</a> </li>
            <li><a href="/report">Репорт</a></li>
            <li><a href="/profile">Профиль</a> </li>
            <li class="divider"></li>
            <li><a href="/logout">Выйти</a></li>
        </ul>
    </div>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</#macro>
</html>