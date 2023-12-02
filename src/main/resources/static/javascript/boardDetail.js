$(document).ready(function(){
    $("#list").on("click", function(){
        location.href = "openBoardList.do";
    });

    $("#edit").on("click", function(){
        var frm = $("#frm")[0];
        frm.action = "updateBoard.do";
        frm.submit();
    });

    $("#delete").on("click", function(){
        var frm = $("#frm")[0];
        frm.action = "deleteBoard.do";
        frm.submit();
    });
})