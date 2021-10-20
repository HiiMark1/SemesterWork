<#ftl encoding='UTF-8'>
<html lang="ru">
<#include "base.ftl">
<#macro title>Профиль</#macro>
<#macro header>${user.name} ${user.surname}</#macro>

<#macro content>
    <br>
    Статус:
    ${user.status}
    <br>
    Возраст:
    ${user.age}
    <br>
    Логин:
    ${user.login}
</#macro>
</html>