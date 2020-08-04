<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<link rel="stylesheet" type="text/css" href="/resources/css/post.css"/>

<div class="modal fade" id="viewPost" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <p id="id" hidden="hidden"></p>
                <h5 class="modal-title" id="title"></h5>
                <%-- 모달 닫기 --%>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="content"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-dark" onclick="board.updateForm()">수정</button>
                <button type="button" class="btn btn-light" onclick="board.delete()">삭제</button>
            </div>
        </div>
    </div>
</div>