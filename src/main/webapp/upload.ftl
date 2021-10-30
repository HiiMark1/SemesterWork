<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Загрузка изображения</#macro>
<#macro header>Выберите изображение</#macro>
<#macro content>
    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <br>
        <input type="submit" value="Загрузить фото">
    </form>
    <br> <br> <br>
    <form action="/profile">
        <button>Вернуться в профиль</button>
    </form>
</#macro>
</html>