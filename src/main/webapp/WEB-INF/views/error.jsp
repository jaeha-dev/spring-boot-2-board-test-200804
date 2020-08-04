<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<link rel="stylesheet" type="text/css" href="/resources/css/error.css"/>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="error">
    <spring:url var="board" value="/"/>
    <p>오류 페이지입니다.</p>
    <p><a href="${board}">게시판 페이지로 이동</a></p>
</div>