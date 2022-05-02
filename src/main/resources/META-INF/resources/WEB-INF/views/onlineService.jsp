<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Услуга</title>
</head>
<body>
<div class="container width-container">
    <div class="d-flex justify-content-center p-3">
        <h3 class="title">Услуга</h3>
    </div>
    <div class="d-flex justify-content-center p-3">
        <form method="post" action="/service/">
            <div class="col p-3">
                <input type="hidden" name="id"
                       value="${onlineService != null && onlineService.id != null ? onlineService.id : ''}">
                <div>Наименование</div>
                <input type="text" name="name"
                       value="${onlineService != null && onlineService.name  != null ? onlineService.name : ''}">
            </div>
            <div class="col p-3">
                <input type="hidden" name="id"
                       value="${onlineService != null && onlineService.id != null ? onlineService.id : ''}">
                <div>Код</div>
                <input type="text" name="code"
                       value="${onlineService != null && onlineService.code  != null ? onlineService.code : ''}">
            </div>
            <div>
                <input type="submit" class="btn btn-primary m-1" value="Сохранить">
                <a class="btn btn-primary" href="/service/">Список</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>