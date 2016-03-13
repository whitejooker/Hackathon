<%@ page import="az.hackathon.database.helpers.TypeHelper" %>
<%@ page import="az.hackathon.models.Type" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../../assets/css/style.css"/>
    <%--<link rel="stylesheet" href="../assets/css/register.css">--%>
    <style>
        body  {
            background-image: url("../../assets/img/form1.jpg");
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<%@include  file="../includes/menu.jsp" %>
<div class="container">
    <div class="row">
        <form role="form" action="/?action=add" method="post">
            <div class="col-lg-6">
                <br>

                <div class="form-group">
                    <label >Food Title</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="food_title" id="food_title" placeholder="Enter Food Title" required>
                        <span class="input-group-addon"></span>
                    </div>
                </div>

                <div class="form-group">
                    <label >State</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="state" name="state" placeholder="Enter State " required autocomplete="off">
                        <span class="input-group-addon"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label >Price</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="price" name="price" placeholder="Enter Price " required autocomplete="off">
                        <span class="input-group-addon"></span>
                    </div>
                </div>

                <div class="form-group">
                    <label >Amount</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="amount" name="amount" placeholder="Enter Amount of Food" required autocomplete="off">
                        <span class="input-group-addon"></span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="filter-col" style="margin-top:10px;" >Type:</label>
                    <select id="type" name="type" class="form-control">
                        <% TypeHelper typeHelper = new TypeHelper();
                            List<Type> alltypes = typeHelper.getAllTypes();
                            for(Type type : alltypes) {
                        %>
                        <option value="<%=type.getId() %>"> <%= type.getName() %></option>
                        <% } %>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </select>

                </div>

                <div class="form-group">
                    <label>Description</label>
                    <div class="input-group">
                        <textarea name="description" id="description" class="form-control" rows="5" required></textarea>
                        <span class="input-group-addon"></span>
                    </div>
                </div>

                <%--<div class="form-group">--%>
                    <%--<div class="input-group">--%>
                        <%--<label class="control-label">Select Picture of  Food</label><br>--%>
                        <%--<input id="food_image" name="food_image" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">--%>
                    <%--</div>--%>
                <%--</div>--%>



                <input type="submit" name="submit" id="submit" value="Add" class="btn btn-info pull-right">
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

<script src="../../assets/js/bootstrap.js"></script>
</body>
</html>
