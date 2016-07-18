<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Catalog</h1>
      </div>
             <div class="row">
                     <div class="col-md-1"><b>№</b></div>
                     <div class="col-md-2"><b>Electronics</b></div>
                     <div class="col-md-1"><b>Manufacturer</b></div>
                     <div class="col-md-1"><b>Name</b></div>
                     <div class="col-md-1"><b>Model</b></div>
                     <div class="col-md-1"><b>Price</b></div>
                     <div class="col-md-5"><b>Description</b></div>
                   </div>
          <% Integer i=0; %>
          <c:forEach items="${ads}" var="ad">
             <br />
             <div class="row">
                     <div class="row">
                     <div class="col-md-1"><%out.print(++i);%></div>
                     <div class="col-md-2">${ad.electronics} </div>
                     <div class="col-md-1">${ad.manufacturer}</div>
                     <div class="col-md-1">${ad.name}</div>
                     <div class="col-md-1">${ad.model}</div>
                     <div class="col-md-1">${ad.price}</div>
                     <div class="col-md-5">${ad.description}</div>
                     </div>
          </c:forEach>
<%@ include file="include/end-html.jsp" %>
