<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Настройки</#macro>
<#macro header>Редактирование профиля</#macro>
<#macro content>
    <form action="/settings" method="post">
        Имя:
        <#if (user.name)??>
            ${user.name}
        </#if>
        <br>
        <input name="name" type="text">
        <br>
        Фамилия:
        <#if (user.surname)??>
            ${user.surname}
        </#if>
        <br>
        <input name="surname" type="text">
        <br>
        Возраст:
        <#if (user.age)??>
            ${user.age}
        </#if>
        <br>
        <input name="age" type="text" onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
        <br>
        Статус:
        <#if (user.status)??>
            ${user.status}
        </#if>
        <br>
        <input name="status" type="text" style="width: auto;">
        <br>
        <br>
        Для смены пароля введите старый и новый пароли
        <br>
        Старый пароль: <input name="oldPassword" type="password">
        <br>
        Новый пароль: <input name="newPassword" type="password">
        <input type="submit" value="Сохранить изменённые поля и вернуться в профиль">
    </form>
</#macro>
</html>