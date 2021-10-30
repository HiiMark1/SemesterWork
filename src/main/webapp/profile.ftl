<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Профиль</#macro>
<#macro header>Личный кабинет</#macro>

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
        ${user.imageUri}
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
</#macro>
</html>