<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Пост</title>
</head>
<body style="margin: 100px">
<br><br><br><br><br><br><br><br><br><br>
<#if (result)??>
    <#if (type)??>
        <#if (posts)??>
            <#list posts as post>
                <div class="card w-75" style="background: bisque; margin-left:80px; margin-top:60px">
                    <div class="card-body">
                        <h4 class="card-title">${post.name}</h4>
                        <p class="card-text">${post.text}</p>
                        <#--        <p class="card-footer">${post.date}</p>-->
                        <a href="/post?id=${post.id}">Перейти к посту</a>
                    </div>
                </div>
                <br><br>
            </#list>
        </#if>
    </#if>

    <#if (users)??>
        <#list users as user>
            <div class="card w-75" style="background: bisque; margin-left:80px; margin-top:60px">
                <div class="card-body">
                    <h4 class="card-title">${user.login}</h4>
                    <p class="card-text">
                        <#if (user.name)??>
                            ${user.name}
                        </#if>
                        <#if (user.surname)??>
                            ${user.surname}
                        </#if>
                    </p>
                    <p class="card-footer">
                        <#if (user.status)??>
                            ${user.status}
                        </#if>
                    </p>
                    <a href="/profile?id=${user.id}">Перейти к профилю</a>
                </div>
            </div>
            <br><br>
        </#list>

    </#if>
</#if>

<form action="/search" method="post">
    <div class="input-group mb-3" style="margin: 60px; padding-right: 300px; position: absolute; top: 40px">
        <div class="input-group-prepend">
            <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">Тип поиска
            </button>
            <div class="dropdown-menu">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1"
                           value="posts" checked>
                    <label class="form-check-label" for="flexRadioDefault1">
                        Только посты
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2"
                           value="users">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Только пользователи
                    </label>
                </div>
            </div>
        </div>
        <input name="text" type="text" class="form-control" placeholder="Введите ключевые слова"
               aria-describedby="basic-addon2">
        <div class="input-group-append">
            <input type="submit" value="Поиск">
        </div>
    </div>
</form>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="btn-group" style="position: absolute; top: 30px; left: 60px">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>