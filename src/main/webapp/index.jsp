<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Страница приветствия - Movies v.1.0</title>
</head>
<body>
<form method="post" action="login">
    <table style="text-align: center">
        <tr>
            <td>
                <h2>Введите ваши логин и пароль для входа в систему:</h2>
                <br/>
            </td>
        </tr>
        <tr>
            <td>
            Логин:<input type="text" name="login" required="required"/>
                <br/>
            </td>
        </tr>
        <tr>
            <td>
            Пароль:<input type="password" name="password" required="required"/>
            <br/>
            <br/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Войти"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
