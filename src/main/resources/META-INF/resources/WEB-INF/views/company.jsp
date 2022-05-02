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
    <div class="d-flex justify-content-center">
        <h3 class="title">Компания</h3>
    </div>
    <div><a href="/company/">Список</a></div>
    <div class="d-flex mb-3 btn_box">
        <form method="post" action="/company/">
            <div>
                <input type="hidden" name="id" value="${company != null && company.id != null ? company.id : ''}">
                <label>Наименование
                    <input type="text" name="name" value="${company != null && company.name  != null ? company.name : ''}">
                </label>
            </div>
            <div>
               <label>УНН
                    <input type="text" name="unn" value="${company != null && company.unn  != null ? company.unn : ''}">
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