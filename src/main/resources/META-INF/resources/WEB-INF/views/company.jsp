<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Компания</title>
</head>
<body>
<div class="container width-container">
    <div class="d-flex justify-content-center p-3">
        <h3 class="title">Компания</h3>
    </div>
    <div class="d-flex mb-3 btn_box justify-content-center">
        <form method="post" action="/company/">
            <div class="p-3">
                <input type="hidden" name="id" value="${company != null && company.id != null ? company.id : ''}">
                <div>Наименование</div>
                <input class="col form-control" type="text" name="name"
                       value="${company != null && company.name  != null ? company.name : ''}">
            </div>
            <div class="p-3">
                <div>УНН</div>
                <input class="col form-control" type="text" name="unn"
                       value="${company != null && company.unn  != null ? company.unn : ''}">
            </div>
            <div>
                <input type="submit" class="btn btn-primary m-1" value="Сохранить">
                <a class="btn btn-primary" href="/company/">Список</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>