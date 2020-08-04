<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" type="text/css" href="/resources/css/page.css"/>

<nav aria-label="Page navigation">
    <ul class="pagination">
        <c:set var="startNumber"
               value="${postList.number - (postList.number % 1) * 10 + 1}"/>
        <c:set var="endNumber"
               value="${(postList.totalPages > startNumber + 9) ? startNumber + 9 : postList.totalPages}"/>

        <%-- 첫 페이지 --%>
        <li class="page-item">
            <a class="page-link" href="/posts?page=1" aria-label="previous">
                <span aria-hidden="true"><i class="fas fa-angle-double-left"></i></span>
                <span class="sr-only">First</span>
            </a>
        </li>

        <%-- 이전 페이지 --%>
        <li class="page-item" style="<c:if test="${postList.first}">display:none</c:if>">
            <a class="page-link" href="/posts?page=${postList.number}" aria-label="previous">
                <span aria-hidden="true"><i class="fas fa-angle-left"></i></span>
                <span class="sr-only">Previous</span>
            </a>
        </li>

        <%-- 페이지(style, class 모두 지정할 수 있다.) --%>
        <c:forEach var="page" begin="${startNumber}" end="${endNumber}" varStatus="loop">
            <li class="page-item <c:if test="${page == postList.number + 1}">active</c:if>">
                <a class="page-link" href="/posts?page=${page}">${page}</a>
            </li>
        </c:forEach>

        <%-- 다음 페이지 --%>
        <li class="page-item" style="<c:if test="${postList.last}">display:none</c:if>">
            <a class="page-link" href="/posts?page=${postList.number + 2}" aria-label="next">
                <span aria-hidden="true"><i class="fas fa-angle-right"></i></span>
                <span class="sr-only">Next</span>
            </a>
        </li>

        <%-- 끝 페이지 --%>
        <li class="page-item">
            <a class="page-link" href="/posts?page=${postList.totalPages}" aria-label="next">
                <span aria-hidden="true"><i class="fas fa-angle-double-right"></i></span>
                <span class="sr-only">Last</span>
            </a>
        </li>
    </ul>
</nav>

<%--<nav aria-label="Page navigation">--%>
<%--    <ul class="pagination">--%>
<%--        <c:set var="startNumber"--%>
<%--               value="${postList.number - (postList.number % 1) * 10 + 1}"/>--%>
<%--        <c:set var="endNumber"--%>
<%--               value="${(postList.totalPages > startNumber + 9) ? startNumber + 9 : postList.totalPages}"/>--%>

<%--        &lt;%&ndash; 첫 페이지 &ndash;%&gt;--%>
<%--        <li><a aria-label="previous" href="/posts?page=1">First</a></li>--%>

<%--        &lt;%&ndash; 이전 페이지 &ndash;%&gt;--%>
<%--        <li style="<c:if test="${postList.first}">display:none</c:if>">--%>
<%--            <a href="/posts?page=${postList.number}">Prev</a>--%>
<%--        </li>--%>

<%--        &lt;%&ndash; 페이지(style, class 모두 지정할 수 있다.) &ndash;%&gt;--%>
<%--        <c:forEach var="page" begin="${startNumber}" end="${endNumber}" varStatus="loop">--%>
<%--            <li class="<c:if test="${page == postList.number + 1}">active</c:if>">--%>
<%--                <a href="/posts?page=${page}">${page}</a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>

<%--        &lt;%&ndash; 다음 페이지 &ndash;%&gt;--%>
<%--        <li style="<c:if test="${postList.last}">display:none</c:if>">--%>
<%--            <a href="/posts?page=${postList.number + 2}">Next</a>--%>
<%--        </li>--%>

<%--        &lt;%&ndash; 끝 페이지 &ndash;%&gt;--%>
<%--        <li><a aria-label="next" href="/posts?page=${postList.totalPages}">Last</a></li>--%>
<%--    </ul>--%>
<%--</nav>--%>

<%--삼항--%>
<%--<c:set var="ternaryResult"--%>
<%--       value="${(relAttributeValue != 'false') ? 'rel=\"nofollow\"' : ''}" />--%>
<%--floor--%>
<%--<fmt:formatNumber var="expiry"--%>
<%--                  value="${(postList.number / 10) * 10 + 1}"--%>
<%--                  maxFractionDigits="0" />--%>
<%--<fmt:parseNumber var="expiry1"--%>
<%--                 value="${(postList.number / 10) * 10 + 1}"--%>
<%--                 integerOnly="true" />--%>