<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<link rel="stylesheet" type="text/css" href="/resources/css/list.css"/>

<div class="container">
    <table class="table">
        <thead>
        <tr id="postHeader">
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <%-- Page 객체에서 List 객체를 꺼낸다. (getContent()) --%>
        <c:forEach var="post" items="${postList.content}" varStatus="loop">
            <tr data-toggle="modal" data-target="#viewPost" onclick="board.showPost(${post.id})">
                <td style="width: 20%;">${post.id}</td>
                <td style="width: 40%;">${post.title}</td>
                <td style="width: 40%;"><javatime:format value="${post.createdDate}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%-- 모달 --%>
<jsp:include page="/WEB-INF/views/post/post.jsp"/>
<jsp:include page="/WEB-INF/views/post/page.jsp"/>

<div>
    <button type="button" class="btn btn-dark" onclick="board.saveForm()">등록</button>
</div>