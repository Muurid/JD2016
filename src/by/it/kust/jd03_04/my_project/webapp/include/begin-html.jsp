<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Dream Travel</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>

<div class="container">
      <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Главная</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="do?command=ORDERTOUR">Добавить тур</a></li>
              <li><a href="do?command=AllUsers">Список пользователей</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="do?command=SIGNUP">Зарегистрироваться</a></li>
              <li><a href='do?command=LOGIN'>Войти</a></li>
              <li><a href='do?command=Profile'>Профиль</a></li>
              <li><a href='do?command=LOGOUT'>Выйти</a></li>
              <li><a href="/manager/html/list">Tomcat</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>

<p style="Font-weight: bold; color: RED;">${msg_error}</p>
