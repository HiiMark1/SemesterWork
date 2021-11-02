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
        <script type="text/javascript">
            function countChar() {
                var is_probel = document.getElementById("is_probel");
                var count_char = document.getElementById("count_char");
                var count_char_textarea = document.getElementById("count_char_textarea");
                var q = document.getElementById("q");
                if (is_probel.checked != false) {
                    count_char.value = count_char_textarea.value.replace(/ *n*r*t*/g, "").length;
                }
                else {
                    count_char.value = count_char_textarea.value.length;
                }
                q.innerHTML = 500 - parseInt(count_char_textarea.value.length);
            }

        </script>
        <div id="count_char_block">
            <textarea name="text" id="count_char_textarea" style="width: 600px;height: 300px;"
                      onchange="countChar()" onkeyup="countChar()" maxlength="500">${post.text}</textarea><br/>
            <input name="symbols" type="text" id="count_char" value="0" readonly="readonly" />
            <input type="checkbox" id="is_probel" onchange="countChar()" />
            <label for="is_probel">Сколько символов без пробелов</label>
            <div>Символов осталось: <span  id="q">0</span></div>
        </div>
        <br><br>
        <input type="submit" value="Сохранить изменённые поля и вернуться в профиль">
    </form>
</#macro>
</html>