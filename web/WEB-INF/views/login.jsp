<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../../assets/css/style.css"/>
    <%--<link rel="stylesheet" href="../assets/css/register.css">--%>
</head>
<body>
<%@include  file="../includes/menu-for-login-and-register.jsp" %>
<div class="container">
    <div class="row">
        <form role="form" action="/?action=login">
            <div class="col-lg-6">
                <br>

                <div class="form-group">
                    <label >Username</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="username" id="username" placeholder="Enter Username" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label >Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required autocomplete="off">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <input type="submit" name="submit" id="submit" value="Log in" class="btn btn-info pull-right">
            </div>
        </form>
        <c:forEach var="message" items="${requestScope.messages}">
            <span class="glyphicon glyphicon-remove"></span><strong> ${message} </strong>
        </c:forEach>
    </div>
</div>
<%@include  file="../includes/footer.jsp" %>
<script src="../../assets/js/bootstrap.js"></script>
</body>
</html>