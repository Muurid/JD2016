<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>

<div class="jumbotron text-center">
    <h1>Регистрация</h1>
    <p>${errorMessage}</p>
</div>

<form class="form-horizontal" action="do?command=register_send_form" method="post" accept-charset="UTF-8">
    <fieldset>
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Ф.И.О.</label>
            <div class="col-md-5">
                <input id="name" name="name" type="text" placeholder="Ф.И.О." class="form-control input-md" required="">
                <span class="help-block">Введите ваши фамилию, имя и отчество</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="dateOfBirth">Дата рождения</label>
            <div class="col-md-4">
                <input id="dateOfBirth" name="dateOfBirth" type="text" placeholder="ГГГГ-ММ-ДД"
                       class="form-control input-md" required="">
                <span class="help-block">Введите вашу дату рождения</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Адрес почты</label>
            <div class="col-md-4">
                <input id="email" name="email" type="email" class="form-control input-md" placeholder="Адрес почты">
                <span class="help-block">Введите ваш адрес почты в интернете</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Логин</label>
            <div class="col-md-5">
                <input id="login" name="login" type="text" placeholder="Логин" class="form-control input-md"
                       required="">
                <span class="help-block">Введите ваш логин</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-5">
                <input id="password" name="password" type="password" placeholder="Пароль" class="form-control input-md"
                       required="">
                <span class="help-block">Введите ваш пароль</span>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for=""></label>
            <div class="col-md-4">
                <button id="" name="" class="btn btn-primary">Зарегистрироваться</button>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for=""></label>
            <div class="col-md-4">
                <a class="btn btn-primary" href="do?command=index" role="button">На главную</a>
            </div>
        </div>
    </fieldset>
</form>

<%@ include file="include/footer.jsp" %>