<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <div class="row">
        <div class="col-md-9">
            <h1>Виртуальные скачки!</h1>
        </div>

        <div class="col-md-3">
            <div class="row">
                <p><strong>Логин: </strong>${sessionUser.login}</p>
            </div>

            <div class="row">
                <p><strong>Почта: </strong>${sessionUser.email}</p>
            </div>
            <div class="row">
                <p><a class="btn btn-primary btn-sm" href="do?command=logout" role="button">Выйти</a></p>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-9">
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

        <div class="col-md-3">
            <c:choose>
                <c:when test="${sessionUserRole.name=='Bookmaker'}">
                    <div class="row">
                        <p><a class="btn btn-primary" href="do?command=add_race" role="button">Добавить забег</a></p>
                    </div>

                    <div class="row">
                        <p><a class="btn btn-primary" href="do?command=view_clients" role="button">Список клиентов</a>
                        </p>
                    </div>

                    <div class="row">
                        <p><a class="btn btn-primary" href="do?command=view_bets" role="button">Список ставок</a></p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <p><a class="btn btn-primary" href="do?command=place_bet" role="button">Поставить ставку</a></p>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <c:if test="${sessionUserRole.name == 'Client'}">
        <div class="row">
            <div class="col-md-9">
                <h3>Список ставок</h3>

                <div class="row">
                    <div class="col-md-2">Номер ставки</div>
                    <div class="col-md-4">Время ставки</div>
                    <div class="col-md-2">Номер забега</div>
                    <div class="col-md-2">Лошадь</div>
                    <div class="col-md-2">Сумма ставки</div>
                </div>

                <c:forEach items="${sessionUserBets}" var="bet">
                    <div class="row">
                        <div class="col-md-2">${bet.id}</div>
                        <div class="col-md-4">${bet.time}</div>
                        <div class="col-md-2">${bet.fk_race}</div>
                        <div class="col-md-2">${bet.horse}</div>
                        <div class="col-md-2">${bet.betSum}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:if>
</div>

<%@ include file="include/footer.jsp" %>