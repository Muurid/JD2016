<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <p>Login:<b>          ${user.login}</b></p>
    <br />
    <p>Email:<b>          ${user.email}</b></p>
    <br />

    <p><b>Purchases</b></p>
      <div class="row">
        <div class="col-md-1"><b>№</b></div>
        <div class="col-md-1"><b>Electronics</b></div>
        <div class="col-md-1"><b>Manufacturer</b></div>
        <div class="col-md-1"><b>Name</b></div>
        <div class="col-md-1"><b>Model</b></div>
        <div class="col-md-1"><b>Price</b></div>
        <div class="col-md-6"><b>Description</b></div>
      </div>
   <% Integer i=0; %>
   <c:forEach items="${ads}" var="ad">
      <br />
      <div class="row">
        <div class="col-md-1"><% out.print(++i); %></div>
        <div class="col-md-1">${ad.electronics} </div>
        <div class="col-md-1">${ad.manufacturer}</div>
        <div class="col-md-1">${ad.name}</div>
        <div class="col-md-1">${ad.model}</div>
        <div class="col-md-1">${ad.price}</div>
        <div class="col-md-6">${ad.description}</div>
      </div>
   </c:forEach>

<br />
<form class="form-horizontal" action="do?command=PROFILE" method="POST">
   <fieldset>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-danger">GO OUT</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
