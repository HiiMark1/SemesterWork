<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Настройки</#macro>
<#macro header>Редактирование профиля</#macro>
<#macro content>
    <form action="/settings" method="post" class="form">
        Имя:
        <#if (user.name)??>
            ${user.name}
        </#if>
        <br>
        <input name="name" type="text" class="name field" onkeyup="this.value = this.value.replace(/[^a-zA-ZА-Яа-я()]/g,'');">
        <br>
        Фамилия:
        <#if (user.surname)??>
            ${user.surname}
        </#if>
        <br>
        <input name="surname" type="text" class="surname field" onkeyup="this.value = this.value.replace(/[^a-zA-ZА-Яа-я()]/g,'');">
        <br>
        Возраст:
        <#if (user.age)??>
            ${user.age}
        </#if>
        <br>
        <input name="age" type="text" class="age field" onkeyup="this.value = this.value.replace(/[^\d]/g,'');">
        <br>
        Статус:
        <#if (user.status)??>
            ${user.status}
        </#if>
        <br>
        <input name="status" type="text" class="status field" style="width: auto;" maxlength="700">
        <br>
        <br>
        Для смены пароля введите старый и новый пароли
        <br>
        Старый пароль: <input name="oldPassword" type="password" class="oldPass field">
        <br>
        Новый пароль: <input name="newPassword" type="password" class="newPass field">
        <input class="validateBtn" type="submit" value="Сохранить изменённые поля и вернуться в профиль">
    </form>
</#macro>
</html>