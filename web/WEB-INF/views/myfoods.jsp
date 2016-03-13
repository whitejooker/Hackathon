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
        <c:forEach var="food" items="${requestScope.myfoods}">
            <div class="col-sm-4 col-lg-4 col-md-4">
                <div class="thumbnail">
                        <%--<img src="/image/${food.image}" alt="" />--%>
                    <div class="caption">
                        <h4><a href="<c:url value="/?action=viewfood&id=${food.id}" /> "> ${food.name}</a></h4>

                        <p>${food.description}.</p>
                        <a  href="#myModal" role="button" data-toggle="modal" rel="tooltip" data-original-title='Hello' ><i class="glyphicon glyphicon-pencil"></i> </a>&nbsp;&nbsp;
                        <a href="<c:url value="/?action=removefood&id=${food.id}" /> "><i class="glyphicon glyphicon-trash"></i></a>
                    </div>
                </div>

            </div>

            <form action="/?action=editfood&id=${food.id}" method="post">
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-md">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Edit Profile</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="control-label">Name:</label>
                                <input type="text" class="form-control" id="name" name="name" value="${food.name}">
                            </div>

                            <div class="form-group">
                                <label class="control-label">State:</label>
                                <input type="text" class="form-control" id="state" name="state" value="${food.state}">
                            </div>

                            <div class="form-group">
                                <label class="control-label">Amount:</label>
                                <input type="text" class="form-control" id="amount" name="amount" value="${food.amount}">
                            </div>

                            <div class="form-group">
                                <label class="control-label">Price:</label>
                                <input type="text" class="form-control" id="price" name="price" value="${food.price}">
                            </div>

                            <div class="form-group">
                                <label class="control-label">Description:</label>
                                <input type="text" class="form-control" id="description" name="description" value="${food.description}">
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" >Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
                </form>
        </c:forEach>
    </div>

</div>


</div>
<%@include  file="../includes/pagination.jsp" %>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
</body>
</html>

