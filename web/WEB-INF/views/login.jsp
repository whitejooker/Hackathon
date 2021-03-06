<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../../assets/css/style.css"/>
    <style>
        body  {
            background-image: url("../../assets/img/space1-3.jpg");
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
        label{
            color: #ffffff;
        }
    </style>
</head>
<body>
<%@include file="../includes/menu.jsp" %>
<div class="container">
    <div class="row">
        <form role="form" method="post" action="/?action=login">
            <div class="col-lg-6">
                <br>
                <div class="form-group">
                    <label>Username</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="username" id="username" placeholder="Enter Username" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required autocomplete="off">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <input type="submit" name="submit" id="submit" value="Log in" class="btn btn-info pull-right">
            </div>
        </form>
        <c:if test="${not empty requestScope.messages}">
            <div class="col-lg-5 col-md-push-1">
                <div class="col-md-12">
                    <div class="alert alert-danger">
                        <span class="glyphicon glyphicon-remove"></span><strong>${requestScope.messages}</strong>
                    </div>
                </div>
            </div>
        </c:if>

    </div>
</div>
<%@include file="../includes/footer.jsp" %>
<script src="../../assets/js/bootstrap.js"></script>
</body>
</html>