<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Пост</title>
</head>
<body style="margin: 100px">
<form action="/post" method="post">
    <div class="card w-100" style="background: bisque">
        <div class="card-body">
            <h4 class="card-title">${post.name}</h4>
            <p class="card-text">${post.text}</p>
            <#if (post.date)??>
                <p class="card-footer">${post.date}</p>
            </#if>
        </div>
    </div>
    <br><br>
    <hr align="center" width="max-content" size="2px" color="colar"/>
    <br>
    <form action="/post" method="post">
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Оставить комментарий</label>
            <textarea name="text" class="form-control" id="exampleFormControlTextarea1" rows="3" maxlength="500"></textarea>
        </div>
        <input type="submit" value="Отправить">
    </form>
    <br><br>
    <h2>Комментарии</h2><br><br>
    <#if comments?has_content>
        <#list comments as comment>
    <div class="card w-50" style="background: bisque">
        <div class="card-body">
            <a href="/profile?id=${comment.id}" class="card-title">Профиль пользователя</a>
            <p class="card-text">${comment.text}</p>
        </div>
    </div>
            <br>
        </#list>
    <#else>
        <h1>Будьте первым кто оставит комментарий!</h1>
    </#if>
</form>
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