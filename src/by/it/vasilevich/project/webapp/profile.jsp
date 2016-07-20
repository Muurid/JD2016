<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <p><b>Добро пожаловать!</b></p>
    <p>Login:<b>          ${user.login}</b></p>
    <br />
    <p>Email:<b>          ${user.email}</b></p>
    <br />
    <p>Role:<b>          ${user.FK_Role}</b></p>
    <br />

    <p><b>Мои объявления</b></p><b>
      <div class="row">
        <div class="col-md-1">№</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-1">Марка</div>
        <div class="col-md-1">Модель</div>
        <div class="col-md-1">Тип кузова</div>
        <div class="col-md-1">Год выпуска</div>
        <div class="col-md-1">Двигатель</div>
        <div class="col-md-1">Трансмиссия</div>
        <div class="col-md-1">Привод</div>
        <div class="col-md-1">Пробег</div>
        <div class="col-md-1">Цвет</div>
        </b>
      </div>
   <% Integer i=0; %>
   <c:forEach items="${ads}" var="ad">
      <br />
      <div class="row">
        <div class="col-md-1"><% out.print(++i); %></div>
        <div class="col-md-1">${ad.price} </div>
        <div class="col-md-1">${ad.brand}</div>
        <div class="col-md-1">${ad.model}</div>
        <div class="col-md-1">${ad.type}</div>
        <div class="col-md-1">${ad.year}</div>
        <div class="col-md-1">${ad.engine}</div>
        <div class="col-md-1">${ad.transmission}</div>
        <div class="col-md-1">${ad.drive_unit}</div>
        <div class="col-md-1">${ad.mileage}</div>
        <div class="col-md-1">${ad.color}</div>

      </div>
   </c:forEach>

<br />
<form class="form-horizontal" action="do?command=PROFILE" method="POST">
   <fieldset>
        <!-- Form Name -->
        <legend>Вы хотите завершенить сеанс?</legend>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Да, завершить.</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
