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
            <c:forEach items="${users}" var="user">
                <div class="row">
                    <form class="form-user-${user.id}" action="do?command=view_clients" method=post>
                        <div class=col-md-1>
                            <input id="user_id_${user.id}" name="id" type="text"
                                   value="${user.id}" class="form-control input-md">
                        </div>

                        <div class=col-md-2>
                            <input id="name_${user.id}" name="name" type="text"
                                   value="${user.name}" class="form-control input-md">
                        </div>

                        <div class=col-md-2>
                            <input id="dateOfBirth_${user.id}" name="dateOfBirth" type="text"
                                   value="${user.dateOfBirth}" class="form-control input-md">
                        </div>

                        <div class=col-md-2>
                            <input id="email_${user.id}" name="email" type="text"
                                   value="${user.email}" class="form-control input-md">
                        </div>

                        <div class=col-md-2>
                            <select id="role_${user.id}" name="fk_role" class="form-control">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role.id}" ${role.id==user.fk_role?"selected":""}>
                                        ${role.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class=col-md-2>
                            <input id="login_${user.id}" name="login" type="text"
                                   value="${user.login}" class="form-control input-md">
                        </div>

                        <div class=col-md-2>
                            <input id="password_${user.id}" name="password" type="text"
                                   value="${user.password}" class="form-control input-md">
                        </div>

                        <div class=col-md-1>
                            <button id="update_${user.id}" name="operation" value="update" class="btn btn-success">
                                Обновить
                            </button>
                        </div>

                        <div class=col-md-1>
                            <button id="delete_${user.id}" name="operation" value="delete" class="btn btn-danger">
                                Удалить
                            </button>
                        </div>
                    </form>
                </div>
                <br>
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
</div>

<%@ include file="include/footer.jsp" %>