$(function(){
})

function insert(){
	$.ajax({
		url : "/insert.do",
		type : "POST",
		data : {boardId : $("#boardId").val(), boardName : $("#boardName").val(),
				boardTitle : $("#boardTitle").val(), boardContent : $("#boardContent").val()},
		dataType : "JSON",
		success : function(result){
			var success = result.result;
			
			if(success == 1){
				alert("글이 등록되었습니다.");
				location.href = "/main.do";
			}
		}
	});
}
