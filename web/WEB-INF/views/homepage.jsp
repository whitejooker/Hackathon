<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/style.css"/>
    <title>$Title$</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.isRegistered==true}">
        <c:import url="../includes/menu-for-admin.jsp"/>
    </c:when>
    <c:otherwise>
        <c:import url="../includes/menu.jsp"/>
    </c:otherwise>
</c:choose>




<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <img src="">
        </div>
        <div class="col-sm-3">
            <img src="">
        </div>
        <div class="col-sm-3">
            <img src="">
        </div>
        <div class="col-sm-3">
            <img src="">
        </div>
    </div>
</div>

</div>
<%@include  file="../includes/pagination.jsp" %>

<%@include  file="../includes/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>

