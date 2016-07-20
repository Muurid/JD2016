<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <form class="form-horizontal" action="do?command=DeleteTour" method=POST>
 <fieldset>
    <p>Name:<b>${user.name}</b></p>
    <p>Login: <b>${user.login}</b></p>
    <p>Email: <b>${user.email}</b></p>
    <p>Address: <b>${user.address}</b></p>
    <br/>

    <p><b>Мои Туры</b></p>
    <legend>Список заказанных туров</legend>

       <div class="row">
         <div class="col-md-1">ID</div>
         <div class="col-md-1">Страна</div>
         <div class="col-md-1">Город</div>
         <div class="col-md-1">Отель</div>
         <div class="col-md-1">Сайт</div>
         <div class="col-md-1">Кол-во дней</div>
         <div class="col-md-1">Цена</div>
         <div class="col-md-1">Тип тура</div>
         <div class="col-md-1">Перелет</div>
         <div class="col-md-1">Страховка</div>
       </div>

  <c:forEach items="${tours}" var="tour" >
         <div class="row">
         <form class="form-tour-${tour.id}" action="do?command=DeleteTour" method=POST>
             <div class=col-md-1>
                 <input id="tour_id_${tour.id}" name="id" type="text"
                 value="${tour.id}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                 <input id="textinput" name="country" type="text"
                 value="${tour.country}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                 <input id="textinput" name="city" type="text"
                 value="${tour.city}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                 <input id="textinput" name="hotel" type="text"
                 value="${tour.hotel}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                 <input id="textinput" name="url" type="text"
                 value="${tour.url}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                 <input id="textinput" name="days" type="text"
                 value="${tour.days}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                 <input id="textinput" name="price" type="text"
                 value="${tour.price}" class="form-control input-md">
             </div>

             <div class=col-md-1>
                 <input id="textinput" name="type" type="text"
                 value="${tour.type}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                 <input id="textinput" name="option1" type="text"
                 value="${tour.option1}" class="form-control input-md">
             </div>
             <div class=col-md-1>
                 <input id="textinput" name="option2" type="text"
                 value="${tour.option2}" class="form-control input-md">
             </div>

             <div class=col-md-1>
                 <button id="singlebutton" name="singlebutton" class="btn btn-success">
                     Удалить
                 </button>
             </div>


         </form>
         </div>
    <br>
    </c:forEach>

    </fieldset>
 </form>

<%@ include file="include/end-html.jsp" %>