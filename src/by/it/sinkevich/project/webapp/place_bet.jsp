<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
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

    <div class="jumbotron text-center">
        <h1>Выберите забег и введите имя победителя и сумму ставки</h1>
        <p>${errorMessage}</p>
    </div>

    <form class="form-horizontal" action="do?command=place_bet_send_form" method="post" accept-charset="UTF-8">
        <fieldset>
            <div class="form-group">
                <label class="col-md-4 control-label" for="fk_race">Номер забега</label>
                <div class="col-md-5">
                    <input id="fk_race" name="fk_race" type="text" placeholder="Номер забега"
                           class="form-control input-md" required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="horse">Лошадь</label>
                <div class="col-md-5">
                    <input id="horse" name="horse" type="text" placeholder="Лошадь" class="form-control input-md"
                           required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="betSum">Сумма ставки</label>
                <div class="col-md-5">
                    <input id="betSum" name="betSum" type="text" placeholder="Сумма ставки"
                           class="form-control input-md"
                           required="">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for=""></label>
                <div class="col-md-4">
                    <button id="" name="" class="btn btn-primary">Поставить ставку</button>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for=""></label>
                <div class="col-md-4">
                    <a class="btn btn-primary" href="do?command=main" role="button">Назад</a>
                </div>
            </div>
        </fieldset>
    </form>
</div>

<%@ include file="include/footer.jsp" %>