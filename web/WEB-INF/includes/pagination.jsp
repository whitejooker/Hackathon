
<c:if test="${requestScope.numberOfFood>8}">

    <c:set var="numberOfPages"  scope="session"
           value="${requestScope.numberOfFood%9==0?requestScope.numberOfFood/9:requestScope.numberOfFood/9+1}"/>

    <fmt:parseNumber var="numberOfPages" type="number" value="${numberOfPages}" />

<nav style="margin-left:40%; ">
    <ul class="pagination">

        <%--For displaying Previous link --%>
        <c:if test="${requestScope.currentPage >1}">
            <li> <a href="/?page=${requestScope.currentPage - 1}">Previous</a></li>
        </c:if>
        <c:if test="${requestScope.currentPage <=1}">
            <li class="disabled"> <a  class="btn btn-large disabled"  href="/?page=${requestScope.currentPage - 1}">Previous</a></li>
        </c:if>

        <c:forEach begin="1" end="${numberOfPages}" var="i" step="1">
            <c:choose>
                <c:when test="${requestScope.currentPage eq i}">
                    <li class="active"><a href="#">${i}</a></li>
                </c:when>
                <c:otherwise>
                        <li><a href="/?page=${i}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>


        <%--For displaying Next link --%>
        <c:if test="${currentPage <numberOfPages}">
            <li><a href="<c:url value="/?page=${currentPage + 1}"/>">Next</a></li>
        </c:if>
        <c:if test="${currentPage >=numberOfPages}">
            <li class="disabled"><a class="btn btn-large disabled"  href="<c:url value="/?page=${currentPage + 1}"/>">Next</a></li>
        </c:if>

    </ul>
</nav>
</c:if>


