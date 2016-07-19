<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                            <button id="" name="" class="btn btn-primary btn-sm">Войти</button>
                        </div>

                        <div class="col-md-8">
                            <a class="btn btn-primary btn-sm" href="do?command=register" role="button">Зарегистрироваться</a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h3>Список забегов</h3>

            <div class="row">
                <div class="col-md-1">Номер забега</div>
                <div class="col-md-2">Время забега</div>
                <div class="col-md-1">Лошадь№1</div>
                <div class="col-md-1">Лошадь№2</div>
                <div class="col-md-1">Лошадь№3</div>
                <div class="col-md-1">Лошадь№4</div>
                <div class="col-md-1">Лошадь№5</div>
                <div class="col-md-1">Лошадь№6</div>
                <div class="col-md-1">Лошадь№7</div>
                <div class="col-md-1">Лошадь№8</div>
                <div class="col-md-1">Победитель</div>
            </div>

            <c:forEach items="${races}" var="race">
                <div class="row">
                    <div class="col-md-1">${race.id}</div>
                    <div class="col-md-2">${race.time}</div>
                    <div class="col-md-1">${race.horse1}</div>
                    <div class="col-md-1">${race.horse2}</div>
                    <div class="col-md-1">${race.horse3}</div>
                    <div class="col-md-1">${race.horse4}</div>
                    <div class="col-md-1">${race.horse5}</div>
                    <div class="col-md-1">${race.horse6}</div>
                    <div class="col-md-1">${race.horse7}</div>
                    <div class="col-md-1">${race.horse8}</div>
                    <div class="col-md-1">${race.winner}</div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="include/footer.jsp" %>