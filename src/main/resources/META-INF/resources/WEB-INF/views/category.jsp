<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Категория</title>
</head>
<body>
<div class="container width-container">
    <div class="d-flex justify-content-center p-3">
        <h3 class="title">Категория</h3>
    </div>
    <div class="d-flex mb-3 justify-content-center">
        <form method="post" action="/category/">
            <div class="p-3">
                <input class="col" type="hidden" name="id"
                       value="${category != null && category.id != null ? category.id : ''}">
                <div>Наименование</div>
                <input class="col form-control" type="text" name="name"
                       value="${category != null && category.name  != null ? category.name : ''}">
            </div>
            <div>
                <input type="submit" class="btn btn-primary m-1" value="Сохранить">
                <a class="btn btn-primary" href="/category/">Список</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>