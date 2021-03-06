<%@ page import="az.hackathon.database.helpers.CityHelper" %>
<%@ page import="az.hackathon.models.City" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Register</title>
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
        <form role="form" method="post" action="/?action=register">
            <div class="col-lg-6">
                <br>
                <div class="form-group">
                    <label >Name</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="name" id="name" placeholder="Enter Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label>Username</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="username" id="username" placeholder="Enter Username" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label>Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" required>
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

                <div class="form-group">
                    <label>Confirm Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="password_confirm" name="password_confirm" placeholder="Confirm Password" required autocomplete="off">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="filter-col" style="margin-top:10px;" >City:</label>
                    <select id="city_id" name="city_id" class="form-control">
                        <% CityHelper cityHelper = new CityHelper();
                            List<City> alltypes = cityHelper.getAllCities();
                            for(City city : alltypes) {
                        %>
                        <option value="<%=city.getId() %>"> <%= city.getName() %></option>
                        <% } %>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </select>

                </div>


                <div class="form-group">
                    <label>Phone </label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter Phone Number" required autocomplete="off">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>

                <div class="form-group">
                    <label>Address </label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="address" name="address" placeholder="Enter Address" required autocomplete="off">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>


                <input type="submit" name="submit" id="submit" value="Register" class="btn btn-info pull-right">
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
<div style="height: 50%;"></div>
<%@include file="../includes/footer.jsp" %>
<script src="../../assets/js/bootstrap.js"></script>
</body>
</html>