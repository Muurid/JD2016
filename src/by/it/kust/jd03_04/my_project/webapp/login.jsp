<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=LOGIN" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Авторизация</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Логин:</label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">
                <span class="help-block">*Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль:</label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
                <span class="help-block">*Введите Ваш пароль</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>