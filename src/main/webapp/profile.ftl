<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Профиль</#macro>
<#macro header>Личный кабинет</#macro>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<#macro content>
<#if (u)??>
    <#if (u.name)??>
        ${u.name}
    </#if>
    <#if (u.surname)??>
        ${u.surname}
    </#if>
<br>
    <#if (u.age)??>
        Возраст:
        ${u.age}
    </#if>
<br>
    <#if (u.status)??>
        Статус:
        ${u.status}
    </#if>
<br>
<#if (u.imageUri)??>
    <div style="position: absolute; top: 70px; right: 70px">
        ${u.imageUri}
    </div>
</#if>
<#else>
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
</#if>
    <br>
    <br>
    <br>
<#if (u.id)??>
<#if u.id==user.id>
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
</#if>
<#else>
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
</#if>
    <div class="btn-group" style="position: absolute; top: 30px; left: 60px;">
        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Меню
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="/news">Новости</a>
            <a class="dropdown-item" href="/settings">Редактировать профиль</a>
            <a class="dropdown-item" href="/upload">Загрузить новое фото профиля</a>
            <a class="dropdown-item" href="/report">Репорт</a>
            <a class="dropdown-item" href="/profile">Профиль</a>
            <a class="dropdown-item" href="/search">Поиск</a>
            <div class="dropdown-divider" style="color: darkgoldenrod"></div>
            <a class="dropdown-item" href="/logout">Выйти</a>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</#macro>
</html>