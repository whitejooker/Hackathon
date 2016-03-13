<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/style.css"/>
    <title>Search</title>

    <style type="text/css">
        .row{ margin:20px 20px 20px 20px;}
        .thumbnail img{height:200px;}
        body  {
            background-image: url("../../assets/img/form1.jpg");
            background-size: 100% 100%;
            background-repeat: no-repeat;
        }
    </style>

</head>
<body>
<c:import url="../includes/menu.jsp"/>



<div class="container">
    <div class="row">
        <c:forEach var="food" items="${requestScope.searchResult}">
            <div class="col-sm-4 col-lg-4 col-md-4">
                <div class="thumbnail">
                        <%--<img src="/image/${food.image}" alt="" />--%>
                    <div class="caption">
                        <h4><a href="<c:url value="/?action=viewfood&id=${food.id}" /> "> ${food.name}</a></h4>
                        <p>${food.description}.</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</div>



<%--<%@include  file="../includes/footer.jsp" %>--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>

