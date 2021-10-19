$(function(){
})

function findList(page2){
	$.ajax({
		url : "/find.do",
		type : "GET",
		data : {nowPage : page2, keyword : $("#keyword").val()},
		dataType : "JSON",
		success : function(result){
			
			var f_list = result.f_list;
			var f_total = result.f_total;
			
			$("#table").empty();
			$("#table").append("<tr><td>번호</td><td>이름</td><td>제목</td><td>내용</td></tr>");
			
			for (var i=0; i<f_list.length; i++){
				var html = "<tr>";
				html += "<td><a href=/detail.do?boardId=" + f_list[i].board_id + ">" + f_list[i].board_id +"</a></td>";
				html += "<td>" + f_list[i].board_name + "</td>";
				html += "<td>" + f_list[i].board_title + "</td>";
				html += "<td>" + f_list[i].board_content + "</td>";
				html += "</tr>";
				$("#table").append(html);
			}

			f_paging(f_total, page2);
		}
	});
}

function f_paging(total, page){
	var startPage = (Math.floor((page-1)/5))*5+1;
	var lastPage = startPage+4;
	var maxPage = Math.ceil(total/10);
	var btn = "";

	if(lastPage > maxPage){
		lastPage = maxPage;
	}
	
	if(page != 1){
		$("#btn").empty();
		btn += "<button onclick=findList(1)><<</button>";
		btn += "<button onclick=findList(" + (page-1) + ")><</button>";  
		$("#btn").append(btn);
	}
	
	for(var j=startPage; j<=lastPage; j++){
		$("#btn").empty();
		btn += "<button onclick=findList(" + j + ")>" + j + "</button>";  
		$("#btn").append(btn);
	}
	
	if(page != maxPage){
		$("#btn").empty();
		btn += "<button onclick=findList(" + (page+1) + ")>></button>";
		btn += "<button onclick=findList("+ maxPage +")>>></button>";
		$("#btn").append(btn);
	}
}