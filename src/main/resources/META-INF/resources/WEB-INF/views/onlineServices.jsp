<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Список услуг</title>
</head>
<body>
<div class="container width-container">
    <div class="d-flex justify-content-center">
        <h3 class="title">Список услуг</h3>
    </div>
    <div><a href="/service/create/">Создать</a></div>
    <div class="d-flex mb-3 btn_box">
        <table>
            <tr>
                <th>Наименование</th>
                <th>Код</th>
                <th>Действия</th>
            </tr>
            <c:forEach items="${onlineServices}" var="onlineService">
                <tr>
                    <td>${onlineService.name}</td>
                    <td>${onlineService.code}</td>
                    <td>
                        <form method="GET" action="/service/${onlineService.id}">
                            <input type="submit" value="Редактировать">
                        </form>
                        <form method="POST" action="/service/delete/${onlineService.id}">
                            <input type="submit" value="Удалить">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>