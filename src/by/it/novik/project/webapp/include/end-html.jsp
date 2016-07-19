<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer>
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
<c:if test="${not empty message}">
                <div class="row">
                <div class="col-sm-offset-8 col-sm-4">
                <div class="alert alert-${type} alert-dismissible fade in" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">×</span>
                </button>
                   ${message}
                 </div>
                 </div>
                 </div>
                 </c:if>
<p class="text-center navbar-text">© 2016 Kate Novik — All rights reserved.</p>
</div>
</nav>
</footer>
<script src="scripts/jquery.min.js"></script>
<script src="scripts/bootstrap.min.js"> </script>
</body>
</html>