<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Catalog</h1>
      </div>
             <div class="row">
                     <div class="col-md-2"><b>Manufacturer</b></div>
                     <div class="col-md-2"><b>Name</b></div>
                     <div class="col-md-1"><b>Model</b></div>
                     <div class="col-md-4"><b>Description</b></div>
                     <div class="col-md-2"><b>Price</b></div>
                     <div class="col-md-1"></div>
                   </div>
         <c:forEach items="${ads}" var="ad">
                  <div class="row">
                      <div class=col-md-2>
                          <input id="textinput" name="manufacturer" type="text"
                          value="${ad.manufacturer}" class="form-control input-md">
                      </div>
                      <div class=col-md-2>
                          <input id="textinput" name="name" type="text"
                          value="${ad.name}" class="form-control input-md">
                      </div>
                      <div class=col-md-1>
                          <input id="textinput" name="model" type="text"
                          value="${ad.model}" class="form-control input-md">
                      </div>
                      <div class="col-md-4">${ad.description}</div>

                      <div class=col-md-2><b>
                          <input id="textinput" name="price" type="text"
                          value="${ad.price}" class="form-control input-md">
                          </b></div>

                      <div class=col-md-1>
                          <button id="singlebutton" name="singlebutton" class="btn btn-success"
                          onclick="document.getElementById('user_id_${user.id}').value=-document.getElementById('user_id_${user.id}').value;">
                              Buy
                          </button>
                      </div>
                  </form>
                  </div>
             <br>
             </c:forEach>
<%@ include file="include/end-html.jsp" %>
