<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<br>
<br>
<c:if test="${listht == null}">
    <div class="alert alert-success" role="alert">
        No Notification!
    </div>
</c:if>
<table class="table"
>
    <tbody>
        <c:forEach items="${listht}" var="ht">
            <tr>
                <c:if test="${ht.status==0}">
                    <div class="alert alert-success" role="alert">
                        You paid for order ${ht.maHD} at time :
                        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${ht.dateTime}" />.
                        Please wait for delivery confirmation!
                    </div>
                </c:if>
                <c:if test="${ht.status==1}">
                    <div class="alert alert-success" role="alert">
                            ${ht.maHD} order is being delivered!
                    </div>
                </c:if>
                <c:if test="${ht.status==2}">
                    <div class="alert alert-success" role="alert">
                            ${ht.maHD} order delivered successfully!
                    </div>
                </c:if>
            </tr>
        </c:forEach>
    </tbody>
</table>