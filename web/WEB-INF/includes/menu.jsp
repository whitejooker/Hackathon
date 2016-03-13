<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Nowaste.az</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <c:if test="${requestScope.isHomePage==true || requestScope.isRegisterPage==true || requestScope.isLoginPage==true}">
            <li><a href="/?action=about">About</a></li>
            </c:if>

        </ul>
                <c:choose>
            <c:when test="${requestScope.isHomePage==true || requestScope.isRegisterPage==true || requestScope.isLoginPage==true}">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/?action=register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/?action=login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/?action=exit"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                </ul>
            </c:otherwise>
        </c:choose>

    </div>
</nav>

<c:choose>
    <c:when test="${requestScope.isHomePage==true || (requestScope.isLogged==true && requestScope.isProfilePage==false) || requestScope.isRegisterPage==true || requestScope.isLoginPage==true }">

        <div id="filter-panel" class="collapse filter-panel">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline" role="form" >
                        <div class="form-group">
                            <label class="filter-col" style="margin-right:0;" >Price:</label>
                            <input type="text" class="form-control input-sm" id="search-price">

                            <label class="filter-col" style="margin-right:0;" >Amount:</label>
                            <input type="text" class="form-control input-sm" id="search-amount">

                            <label class="filter-col" style="margin-right:0;" >State:</label>
                            <input type="text" class="form-control input-sm" id="search-state">

                            <label class="filter-col" style="margin-right:0;" >City:</label>
                            <input type="text" class="form-control input-sm" id="search-city">

                            <div class="form-group">
                                <label class="filter-col" style="margin-top:10px;">City:</label>
                                <select id="city" class="form-control">
                                    <c:forEach var="city" items="${requestScope.cities}">
                                        <option value="${city.id}">${city.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div><!-- form group [search] -->
                        <div class="form-group">
                            <label class="filter-col" style="margin-top:10px;">Type:</label>
                            <select id="type" class="form-control">
                                <c:forEach var="type" items="${requestScope.types}">
                                    <option value="${type.id}">${type.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        &nbsp;
                        <button type="submit" class="btn btn-default filter-col">
                            <span>Submit</span>
                        </button>
                    </form>
                </div>
            </div>
        </div>

        <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#filter-panel">
        <span class="glyphicon glyphicon-search"></span>Search

    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>

</button>


