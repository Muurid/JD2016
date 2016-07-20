<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=LOGOUT" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Выйти</legend>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton">Покинуть профиль:</label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" class="btn btn-success">LogOut</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>