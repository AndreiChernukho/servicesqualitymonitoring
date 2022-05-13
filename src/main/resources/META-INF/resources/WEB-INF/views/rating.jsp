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
    <div class="d-flex mb-3 btn_box justify-content-center">
        <form method="post" action="/rating/">
            <div class="col p-3">
                <input type="hidden" name="id" value="${rating != null && rating.id != null ? rating.id : ''}">
                <div>Рейтинг</div>
                <form:select path="ratingValues" name="rating" class="form-select">
                    <form:option value="${rating != null && rating.rating != null ? rating.rating : null}">
                        ${rating != null && rating.rating != null ? ratingValues.get(rating.rating) : ''}
                    </form:option>
                    <form:options items="${ratingValues.entrySet()}" itemValue="key" itemLabel="value"/>
                </form:select>
            </div>
            <div class="col p-3">
                <div>Категория</div>
                <form:select path="categories" name="categoryId" class="form-select">
                    <form:option value="${rating != null && rating.category != null ? rating.category.id : ''}">
                        ${rating != null && rating.category != null ? rating.category.name : ''}
                    </form:option>
                    <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
            <div class="col p-3">
                <div>Организация</div>
                <form:select path="companies" name="companyId" class="form-select">
                    <form:option value="${rating != null && rating.company != null ? rating.company.id : ''}">
                        ${rating != null && rating.company != null ? rating.company.name : ''}
                    </form:option>
                    <form:options items="${companies}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
            <div class="col p-3">
                <div>Услуга</div>
                <form:select path="services" name="serviceId" class="form-select">
                    <form:option
                            value="${rating != null && rating.onlineService != null ? rating.onlineService.id : ''}">
                        ${rating != null && rating.onlineService != null ? rating.onlineService.name : ''}
                    </form:option>
                    <form:options items="${services}" itemValue="id" itemLabel="name"/>
                </form:select>
            </div>
            <div class="col p-3">
                <div>Комментарий</div>
                <input type="text" name="comment" class="form-control"
                       value="${rating != null && rating.comment  != null ? rating.comment : ''}">

            </div>
            <c:if test="${rating != null && rating.id != null}">
                <div class="col p-3">
                    <div>Дата создания</div>
                    <span>${rating.creationDate  != null ? rating.creationDate : ""}</span>
                </div>
            </c:if>
            <div>
                <input type="submit" class="btn btn-primary m-1" value="Сохранить">
                <a class="btn btn-primary" href="/rating/">Список</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>