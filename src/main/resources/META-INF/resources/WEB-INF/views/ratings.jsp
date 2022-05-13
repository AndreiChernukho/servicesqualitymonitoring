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
    <div class="d-flex justify-content-center p-3">
        <h3 class="title">Список рейтингов</h3>
    </div>

    <div class="d-flex justify-content-center">
        <div class="p-3"><a class="btn btn-primary" href="/rating/create/">Создать</a></div>
        <div class="p-3"><a class="btn btn-primary" href="/category/">Список категорий</a></div>
        <div class="p-3"><a class="btn btn-primary" href="/company/">Список компаний</a></div>
        <div class="p-3"><a class="btn btn-primary" href="/service/">Список услуг</a></div>
    </div>
    <div class="d-flex mb-3 btn_box">
        <table>
            <tr class="overflow-hidden">
                <th class="col p-3">Рейтинг</th>
                <th class="col p-3">Категория</th>
                <th class="col p-3">Организация</th>
                <th class="col p-3">Услуга</th>
                <th class="col p-3">Комментарий</th>
                <th class="col p-3">Дата создания</th>
                <th class="col p-3">Действия</th>
            </tr>
            <c:forEach items="${ratings}" var="rating">
                <tr class="overflow-hidden">
                    <td class="col p-3">${ratingValues.get(rating.rating)}</td>
                    <td class="col p-3">${rating.category.name}</td>
                    <td class="col p-3">${rating.company.name}</td>
                    <td class="col p-3">${rating.onlineService.name}</td>
                    <td class="col p-3">${rating.comment}</td>
                    <td class="col p-3">${rating.creationDate}</td>
                    <td class="col p-3">
                        <form method="GET" action="/rating/${rating.id}">
                            <input class="btn btn-primary btn-sm" type="submit" value="Редактировать">
                        </form>
                        <form method="POST" action="/rating/delete/${rating.id}">
                            <input class="btn btn-primary btn-sm" type="submit" value="Удалить">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>