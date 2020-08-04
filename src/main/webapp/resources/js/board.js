let saveMessage = '게시글이 등록되었습니다.';
let updateMessage = '게시글이 수정되었습니다.';
let deleteMessage = '게시글이 삭제되었습니다.';
let errorMessage = '오류가 발생하였습니다.';

let board = {

    // 게시글 등록 폼
    saveForm : function () {
        window.location.href = '/posts/save';
    },

    // 게시글 수정 폼
    updateForm : function () {
        let id = $('#id').text();

        window.location.href = `/posts/update/${id}`;
    },

    // 게시글 등록 및 수정 취소
    cancel : function () {
        window.location.href = '/';
    },

    // 게시글 등록
    save : function () {
        let data = {
            title: $('#title').val(),
            content: $('#content').val(),
        };

        // done, fail, always
        $.ajax({
            type: 'POST',
            url: '/api/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (result) {
            console.log(`${result.id}, ${result.title}, ${result.content}`);

            alert(saveMessage);
            window.location.href = '/';
        }).fail(function (error) {
            console.log(JSON.stringify(error));

            alert(errorMessage);
        });
    },

    // 게시글 수정
    update : () => {
        let data = {
            id: $('#id').text(),
            title: $('#title').val(),
            content: $('#content').val(),
        };

        $.ajax({
            type: 'PUT',
            url: `/api/posts/${data.id}`,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(result => {
            console.log(`${result.id}, ${result.title}, ${result.content}`);

            alert(updateMessage);
            window.location.href = '/';
        }).fail(error => {
            alert(JSON.stringify(error));
        });
    },

    // 게시글 삭제
    delete : () => {
        let id = $('#id').text();

        $.ajax({
            type: 'DELETE',
            url: `/api/posts/${id}`,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(() => {
            alert(deleteMessage);
            window.location.href = '/';
        }).fail(error => {
            alert(JSON.stringify(error));
        });
    },

    // 게시글 상세 조회
    showPost : (id) => {
        $.ajax({
            type: 'GET',
            url: `/api/posts/${id}`,
        }).done(result => {
            $('#id').text(result.id);
            $('#title').text(result.title);
            $('#content').text(result.content);
            // $('#viewPost').modal('show');
        });
    },

    showPostList : () => {

    },
}

// // 게시글 목록
// function showPostList() {
//     $.ajax({
//         url: '/api/posts',
//         type: 'get',
//         success: function (result) {
//             console.log('get: ' + result);
//             for (var i = 0; i < result.length; i++) {
//                 $('#list').append(result[i].title + "<br>");
//                 $('#list').append(result[i].content + "<br>");
//                 $('#list').append("<br/>")
//             }
//         }
//     })
// }