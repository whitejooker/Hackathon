<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/style.css"/>
    <%--<link rel="stylesheet" href="../assets/css/register.css">--%>
</head>
<body>
<%@include  file="../WEB-INF/includes/menu.jsp" %>
<div class="container">
    <div class="row">
        <form role="form">
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
        <%--<div class="col-lg-5 col-md-push-1">--%>
        <%--<div class="col-md-12">--%>
        <%--<div class="alert alert-success">--%>
        <%--<strong><span class="glyphicon glyphicon-ok"></span> Success! Message sent.</strong>--%>
        <%--</div>--%>
        <%--<div class="alert alert-danger">--%>
        <%--<span class="glyphicon glyphicon-remove"></span><strong> Error! Please check all page inputs.</strong>--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--</div>--%>
    </div>
</div>
<%@include  file="../WEB-INF/includes/pagination.jsp" %>
<%@include  file="../WEB-INF/includes/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="../assets/js/bootstrap.js"></script>
</body>
</html>