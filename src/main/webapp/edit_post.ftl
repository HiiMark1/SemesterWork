<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Настройки</#macro>
<#macro header>Редактирование профиля</#macro>
<#macro content>
    <form action="/edit_post" method="post">
        Название поста:
        ${post.name}
        <br>
        <input name="name" type="text">
        <br>
        Содержание поста:
        <textarea name="text" rows="30" style="width: 400px; height: 300px;">
            ${post.text}
        </textarea>
        <br><br>
        <input type="submit" value="Сохранить изменённые поля и вернуться в профиль">
    </form>
</#macro>
</html>