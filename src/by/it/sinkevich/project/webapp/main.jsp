<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-9">
            <h1>Виртуальные скачки!</h1>
        </div>

        <div class="col-md-3">
            <form class="form-horizontal" action="do?command=login_send_form" method="post" accept-charset="UTF-8">
                <fieldset>
                    <div class="form-group input-sm">
                        <label class="col-md-3 control-label" for="login">Логин</label>
                        <div class="col-md-9">
                            <input id="login" name="login" type="text" placeholder="Логин" class="form-control input-sm"
                                   required="">

                        </div>
                    </div>

                    <div class="form-group input-sm">
                        <label class="col-md-3 control-label" for="password">Пароль</label>
                        <div class="col-md-9">
                            <input id="password" name="password" type="password" placeholder="Пароль"
                                   class="form-control input-sm"
                                   required="">

                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-4">
                            <a class="btn btn-primary btn-sm" href="do?command=logout" role="button">Выйти</a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-md-9">
            <h3>Список забегов</h3>
            <p>${races}</p>
        </div>

        <div class="col-md-3">
            <h3>
                Тут<br>
                могла<br>
                быть<br>
                ваша<br>
                реклама<br>
            </h3>
        </div>
    </div>
</div>

<%@ include file="include/footer.jsp" %>