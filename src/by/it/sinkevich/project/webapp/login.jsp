<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal" action="do?command=login_send_form" method="post" accept-charset="UTF-8">
                <fieldset>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="login">Логин</label>
                        <div class="col-md-5">
                            <input id="login" name="login" type="text" placeholder="Логин" class="form-control input-md"
                                   required="">

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="password">Пароль</label>
                        <div class="col-md-5">
                            <input id="password" name="password" type="password" placeholder="Пароль"
                                   class="form-control input-md"
                                   required="">

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for=""></label>
                        <div class="col-md-4">
                            <button id="" name="" class="btn btn-primary">Войти</button>
                        </div>

                        <div class="col-md-4">
                            <a class="btn btn-primary" href="do?command=register" role="button">Зарегистрироваться</a>
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
        </div>
    </div>
</div>

<%@ include file="include/footer.jsp" %>