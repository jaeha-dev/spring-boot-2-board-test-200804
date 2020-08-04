<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<link rel="stylesheet" type="text/css" href="/resources/css/save.css"/>

<div class="col-md-12">
    <div class="col-md-8">
        <form>
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" class="form-control" id="title" placeholder="제목">
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea class="form-control" id="content" placeholder="내용"></textarea>
            </div>
        </form>

        <div>
            <button type="button" class="btn btn-dark" onclick="board.save()">등록</button>
            <button type="button" class="btn btn-light" onclick="board.cancel()">취소</button>
        </div>
    </div>
</div>