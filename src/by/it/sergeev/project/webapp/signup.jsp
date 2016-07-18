<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNUP" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Welcome to the catalog...</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="id">ID</label>
            <div class="col-md-1">
                <input id="id" name="ID" value="0" type="text"

                placeholder="" class="form-control input-md" required="">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="login" name="Login" type="text" value="UserLogin" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Password</label>
            <div class="col-md-4">
                <input id="password" name="Password" type="password" value="UserPassword" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите пароль не менее 8 символов</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">E-mail</label>
            <div class="col-md-4">
                <input id="email" name="Email" type="text" value="email@gmail.com" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите почту</span>
            </div>
        </div>

        <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="name">Name/Lastname</label>
                    <div class="col-md-3">
                        <input id="name" name="Name" type="text" value="name" placeholder="" class="form-control input-md" required="">
                        <span class="help-block">Ваше имя</span>
                        </div>
                        <div class="col-md-3">
                        <input id="lastname" name="Lastname" type="text" value="lastname" placeholder="" class="form-control input-md" required="">
                                                <span class="help-block">Ваша фамилия</span>
                    </div>
                </div>

        <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="address">Address</label>
                    <div class="col-md-4">
                        <input id="address" name="Address" type="text" value="address" placeholder="" class="form-control input-md" required="">
                        <span class="help-block"> Адрес/span>
                    </div>
                </div>
        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Role</label>
            <div class="col-md-2">
                <select id="role" name="FK_role" class="form-control">
                    <option value="2">User</option>
                    <option value="1">Administrator</option>

                </select>
                <span class="help-block">Роль(не требуется)</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Create an account</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
