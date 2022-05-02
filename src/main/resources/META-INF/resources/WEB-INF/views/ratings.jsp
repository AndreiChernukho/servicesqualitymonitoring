<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Список рейтингов</title>
</head>
<body>
<div class="container width-container">
    <div class="d-flex justify-content-center">
        <h3 class="title">Список рейтингов</h3>
    </div>
    <div><a href="/rating/create/">Создать</a></div>
    <div class="d-flex mb-3 btn_box">
        <table>
            <tr>
                <th>Рейтинг</th>
                <th>Категория</th>
                <th>Организация</th>
                <th>Услуга</th>
                <th>Комментарий</th>
                <th>Дата создания</th>
                <th>Действия</th>
            </tr>
            <c:forEach items="${ratings}" var="rating">
                <tr>
                    <td>${ratingValues.get(rating.rating)}</td>
                    <td>${rating.category.name}</td>
                    <td>${rating.company.name}</td>
                    <td>${rating.service.name}</td>
                    <td>${rating.comment}</td>
                    <td>${rating.creationDate}</td>
                    <td>
                        <form method="GET" action="/rating/${rating.id}">
                            <input type="submit" value="Редактировать">
                        </form>
                        <form method="POST" action="/rating/delete/${rating.id}">
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