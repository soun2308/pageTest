$(function(){
	getList(1);
})

function getList(page){
	$.ajax({
		url : "/list.do",
		type : "GET",
		data : {nowPage : page},
		dataType : "JSON",
		success : function(result){
			
			var list = result.list;
			var total = result.total;
			
			$("#table").empty();
			$("#table").append("<tr><td>번호</td><td>이름</td><td>제목</td><td>내용</td></tr>");
			
			for (var i=0; i<list.length; i++){
				var html = "<tr>";
				html += "<td><a href=/detail.do?boardId=" + list[i].board_id + ">" + list[i].board_id +"</a></td>";
				html += "<td>" + list[i].board_name + "</td>";
				html += "<td>" + list[i].board_title + "</td>";
				html += "<td>" + list[i].board_content + "</td>";
				html += "</tr>";
				$("#table").append(html);
			}
			
			paging(total, page);
		}
	});
}

function paging(total, page){
	var startPage = (Math.floor((page-1)/5))*5+1;
	var lastPage = startPage+4;
	var maxPage = Math.ceil(total/10);
	var btn = "";
	
	if(lastPage > maxPage){
		lastPage = maxPage;
	}
	
	if(page != 1){
		$("#btn").empty();
		btn += "<button onclick=getList(1)><<</button>";
		btn += "<button onclick=getList(" + (page-1) + ")><</button>";  
		$("#btn").append(btn);
	}
	
	for(var j=startPage; j<=lastPage; j++){
		$("#btn").empty();
		btn += "<button onclick=getList(" + j + ")>" + j + "</button>";  
		$("#btn").append(btn);
	}
	
	if(page != maxPage){
		$("#btn").empty();
		btn += "<button onclick=getList(" + (page+1) + ")>></button>";
		btn += "<button onclick=getList("+ maxPage +")>>></button>";
		$("#btn").append(btn);
	}
}