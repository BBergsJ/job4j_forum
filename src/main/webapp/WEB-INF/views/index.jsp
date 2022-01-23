<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <title>Форум job4j</title>
</head>
<body>
<div class="container mt-3">

    <nav class="navbar navbar-expand-sm bg-success text-white">
        <div class="container-fluid">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item" style="color: white">
                    <h4>
                        <i class="bi bi-chat-dots"></i> Форум job4j
                    </h4>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="<c:url value='/index'/>">
                        <i class="bi bi-diagram-3"></i> Главная страница
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="<c:out value='/edit?id=0'/>">
                        <i class="bi bi-plus-circle"></i> Добавить тему
                    </a>
                </li>
                <c:choose>
                    <c:when test="${user == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/login'/>" style="color: white">
                                <i class="bi bi-person-circle"></i> Войти
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/logout'/>" style="color: white">
                                <i class="bi bi-door-open-fill"></i> ${user.username} / Выйти
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>

    <div class="container-fluid">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
                <th scope="col">Добавлен</th>
                <th scope="col">Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>
                        <a class="link-success" style="text-decoration:none" href="<c:url value='/post?id=${post.id}'/>">
                            <b>
                                <c:out value="${post.name}"/>
                            </b>
                        </a>
                    </td>
                    <td>
                        <c:out value="${post.created.date}"/> <c:out value="${post.created.toLocalDateTime().month}"/>
                        <c:out value="${post.created.hours}"/>:<c:out value="${post.created.minutes}"/>
                    </td>
                    <td>
                        <a class="link-success" href="<c:out value='/edit?id=${post.id}'/>">
                            <i class="fa fa-gear custom"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>