<%@ page import="az.hackathon.models.Food" %>
<%@ page import="az.hackathon.ApplicationConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/style.css"/>
    <title>Food</title>

    <style type="text/css">
        .row{ margin:20px 20px 20px 20px;}
        .ratings{ font-size:25px !important;}
        .thumbnail img {
            width: 100%;
        }

        .ratings {
            padding-right: 10px;
            padding-left: 10px;
            color: #d17581;
        }

        .thumbnail {
            padding: 0;
        }

        .thumbnail .caption-full {
            padding: 9px;
            color: #333;
        }
        .glyphicon-thumbs-up:hover{ color:#008000; cursor:pointer;}
        .glyphicon-thumbs-down:hover{ color: #E10000; cursor:pointer;}
        .counter{ color:#333333;}
        .thumbnail img{height:200px;}

        .food_profile{
            float: left;

        }

        .food_info {
            float: left;
            padding-left:  50px;
            padding-right: 50px;
            max-width: 100ch;
        }



        .description{
            float: left;
            clear: left;
            padding: 20px;
        }

    </style>

</head>
<body>

<c:import url="../includes/menu.jsp"/>

<div class="container">

    <div class="row" >
        <!-- Profile -->
        <div class="food_profile">
            <img src="../../assets/img/images.jpg" alt=""  border="solid" width="500px" height="380px">


        </div>


        <!-- Info -->
        <div class="food_info">
            <h1>Food Title:&nbsp;${requestScope.food.name}</h1>
            <h1>State:&nbsp;${requestScope.food.state}</h1>
            <h1>Amount:&nbsp;${requestScope.food.amount}</h1>
            <h1>Price:&nbsp;${requestScope.food.price} $</h1>
            <h1>Seller:&nbsp;${requestScope.food.user.name}</h1>
            <h1>Phone:&nbsp;${requestScope.food.user.phone}</h1>
        </div>



        <!-- Event Text -->
        <div class="description" >
            <h4><strong>Description:&nbsp;</strong> ${requestScope.food.description}</h4>
        </div>
    </div>

</div>

</div>
<div style="height: 40%;"></div>


<%@include  file="../includes/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>


</body>
</html>

