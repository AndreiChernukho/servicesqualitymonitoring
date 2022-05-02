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
    <div><a href="/rating/">Список</a></div>
    <div class="d-flex mb-3 btn_box">
        <form method="post" action="/rating/">
            <div>
                <input type="hidden" name="id" value="${rating != null && rating.id != null ? rating.id : ''}">
                <label>Рейтинг
                    <form:select path="ratingValues" name="rating">
                        <form:option value="${rating != null && rating.rating != null ? rating.rating : null}">
                            ${rating != null && rating.rating != null ? ratingValues.get(rating.rating) : ''}
                        </form:option>
                        <form:options items="${ratingValues.entrySet()}" itemValue="key" itemLabel="value"/>
                    </form:select>
                </label>
            </div>
            <div>
                <label>Категория
                    <form:select path="categories" name="categoryId">
                        <form:option value="${rating != null && rating.category != null ? rating.category.id : ''}">
                            ${rating != null && rating.category != null ? rating.category.name : ''}
                        </form:option>
                        <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </label>
            </div>
            <div>
                <label>Организация>
                    <form:select path="companies" name="companyId">
                        <form:option value="${rating != null && rating.company != null ? rating.company.id : ''}">
                            ${rating != null && rating.company != null ? rating.company.name : ''}
                        </form:option>
                        <form:options items="${companies}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </label>
            </div>
            <div>
                <label>Услуга
                    <form:select path="services" name="serviceId">
                        <form:option value="${rating != null && rating.onlineService != null ? rating.onlineService.id : ''}">
                            ${rating != null && rating.onlineService != null ? rating.onlineService.name : ''}
                        </form:option>
                        <form:options items="${services}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </label>
            </div>
            <div>
                <label>Комментарий
                    <input type="text" name="comment" value="${rating != null && rating.comment  != null ? rating.comment : ''}">
                </label>
            </div>
            <div>
                <label>Дата создания
                    <span>${rating != null && rating.creationDate  != null ? rating.creationDate : ''}</span>
                </label>
            </div>
            <div>
                <input type="submit" class="btn btn-primary" value="Сохранить">
            </div>
        </form>
    </div>
</div>
</body>
</html>