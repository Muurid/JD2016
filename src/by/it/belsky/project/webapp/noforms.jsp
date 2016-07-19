<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Login:<b>          ${user.login}</b></p>
    <br />
    <p>Email:<b>          ${user.email}</b></p>
    <br />


<p><b>У Вас нет ни одной заявки для автосервиса</b></p>
 <!-- Form Name -->

<form class="form-horizontal" action="do?command=LOGOUT" method="POST">
<br />

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Завершить сеанс</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>