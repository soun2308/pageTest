$(function(){
})

function update(){
	$.ajax({
		url : "/update.do",
		type : "POST",
		data : {boardId : $("#boardId").val(), boardName : $("#boardName").val(),
				boardTitle : $("#boardTitle").val(), boardContent : $("#boardContent").val()},
		dataType : "JSON",
		success : function(result){
			var success = result.result;
			
			if(success == 1){
				alert("글이 수정되었습니다.");
				location.href = "/main.do";
			}
		}
	});
}
