<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Nowaste.az</a>
        </div>
        <ul class="nav navbar-nav">
            <c:choose>
                <c:when test="${requestScope.isHomePage==true}"> <li class="active"><a href="/">Home</a></li></c:when>
                <c:otherwise> <li ><a href="/">Home</a></li></c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${requestScope.isAboutPage==true}"> <li class="active"><a href="/?action=about">About</a></li></c:when>
                <c:otherwise> <li><a href="/?action=about">About</a></li></c:otherwise>
            </c:choose>


<c:choose>
    <c:when test="${requestScope.isLogged==true}">

        <li><a href="#myModal" role="button" data-toggle="modal" rel="tooltip" data-original-title='Hello' >
            <span class="glyphicon glyphicon-pencil"></span> Edit Profile</a></li>
        <c:choose>
            <c:when test="${requestScope.isMyFoodPage==true}">
                <li class="active" ><a  href="/?action=myfoods">My Food${requestScope.isMyFoodPage}</a></li>
            </c:when>
            <c:otherwise> <li><a href="/?action=myfoods">My Food</a></li></c:otherwise>
        </c:choose>

        <li><a href="/?action=add_food">  <span class="glyphicon glyphicon-plus"></span> Add Food</a></li>

        <form action="/?action=editprofile&id" method="post">
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
                                <input type="text" class="form-control" id="name" name="name" value="${sessionScope.userLogged.name}">
                            </div>

                            <div class="form-group">
                                <label class="control-label">Phone:</label>
                                <input type="text" class="form-control" id="phone" name="phone" value="${sessionScope.userLogged.phone}">
                            </div>

                            <div class="form-group">
                                <label class="control-label">Email:</label>
                                <input type="text" class="form-control" id="email" name="email" value="${sessionScope.userLogged.email}">
                            </div>

                            <div class="form-group">
                                <label class="control-label">Address:</label>
                                <input type="text" class="form-control" id="address" name="address" value="${sessionScope.userLogged.address}">
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
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>c:
        </ul>
                <c:choose>
            <c:when test="${requestScope.isLogged==true}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/?action=exit"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li> <a href="#" class=" disabled btn  btn-lg">
                        <span class="glyphicon glyphicon-user"></span> ${sessionScope.userLogged.name}
                    </a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/?action=register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="/?action=login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </c:otherwise>
        </c:choose>

        <form class="navbar-form navbar-right"  action="/">
            <div class="form-group">
                <input type="hidden" value="search" name="action" />
                <input type="text" class="form-control" name="search" placeholder="Search"/>
            </div>
        </form>
    </div>
</nav>




