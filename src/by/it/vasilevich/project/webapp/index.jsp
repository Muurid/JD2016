<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Объявления о продаже автомобилей</h1>
        <p class="lead"></p>
      </div>
             <div class="row"><B>
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
                     </B>
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
<%@ include file="include/end-html.jsp" %>