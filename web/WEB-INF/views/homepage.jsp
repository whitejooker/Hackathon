<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/style.css"/>
    <title>$Title$</title>

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
    </style>

</head>
<body>
        <c:import url="../includes/menu.jsp"/>



<div class="container">
    <div class="row">
        <c:forEach var="food" items="${requestScope.foods}">
            <div class="col-sm-4 col-lg-4 col-md-4">
                <div class="thumbnail">
                    <%--<img src="/image/${food.image}" alt="" />--%>
                    <div class="caption">
                        <h4><a href="<c:url value="/?action=viewfood&id=${food.id}" /> "> ${food.name}</a></h4>
                        <p>${food.description}.</p>

                    </div>
                    <div class="ratings">
                        <p class="pull-right"></p>
                        <!-- Like Icon HTML -->
                        <span class="glyphicon glyphicon-thumbs-up" onClick="Like_It()"></span>&nbsp;
                        <!-- Like Counter -->
                        <span class="counter" id="like_count">10638</span>&nbsp;

                        <!-- view Icon HTML -->

                        <span class="glyphicon glyphicon-eye-open"></span>&nbsp;
                        <span class="counter" id="view_count">10638</span>&nbsp;
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</div>
<%@include  file="../includes/pagination.jsp" %>


<%@include  file="../includes/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>

