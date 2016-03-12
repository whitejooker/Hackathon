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
        <form role="form" action="/?action=add" method="post">
            <div class="col-lg-6">
                <br>

                <div class="form-group">
                    <label >Food Title</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="food_title" id="food_title" placeholder="Enter Food Title" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label >Description</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="description" name="description" placeholder="Enter Description about Food" required autocomplete="off">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label >Amount</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="amount" name="amount" placeholder="Enter Amount of Food" required autocomplete="off">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="filter-col" style="margin-top:10px;" for="pref-orderby">Type:</label>
                    <select id="pref-orderby" class="form-control">
                        <option>Chicken Meals</option>
                        <option> Beef Meals</option>
                        <option> Fish Meals</option>
                        <option> Lamb Meals</option>
                        <option> Pork Meals</option>
                        <option> Vegetarian Meals</option>
                    </select>
                </div>

                <div class="form-group">
                    <label >Description</label>
                    <div class="input-group">
                        <label class="control-label">Select Picture of  Food</label>
                        <input id="food_image" name="food_image" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">
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
<%@include  file="../includes/footer.jsp" %>
<script src="../../assets/js/bootstrap.js"></script>
</body>
</html>
