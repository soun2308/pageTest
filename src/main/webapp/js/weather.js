//$(function() {
//	var today = new Date();
//	var yesterday = new Date(today.setDate(today.getDate()-1));
//	
//	$( "#datepicker1" ).datepicker({
//		dateFormat: 'yy-mm-dd',
//		maxDate: yesterday
//	});
//	$( "#datepicker1" ).datepicker('setDate', yesterday);
//});
$(function(){
	getData();
})

function getData(){
	$.ajax({
		url : "/data.do",
		type : "GET",
		//data : {nowPage : page},
		dataType : "JSON",
		success : function(result){
         	var data = result.data;

			var html = "<h5>"
				html += "발표시간 : " + data[1].baseTime;
				html += "</h5>"
				$("#body").append(html);
				
         	for (var i=0; i<data.length; i++){
				$("#body").empty();
				if(data[i].category == "TMP"){
						html += "<h5>"
						html += "시간 : " + data[i].fcstTime;
						html += " 기온 : " + data[i].fcstValue;
				}else if(data[i].category == "SKY"){
					html += " 하늘상태 : " + data[i].fcstValue;
				}else if(data[i].category == "PTY"){
					html += " 강수형태 : " + data[i].fcstValue;
				}else if(data[i].category == "POP"){
					html += " 강수확률 : " + data[i].fcstValue;
				}else if(data[i].category == "PCP"){
					html += " 강수량 : " + data[i].fcstValue;
					html += "</h5>"
				}
				$("#body").append(html);
				//TMP(기온), SKY(하늘상태), PTY(강수형태), POP(강수확률), PCP(강수량), SNO(신적설)
//            	console.log("category : " + data[i].category + " 발표시간 : " + data[i].baseTime + " 예측시간 : " + data[i].fcstTime
//							 + "발표시간 : " + data[i].baseTime);
        	}
		}
	});
}


//$("#data").empty();
//				var html = "category"
//				$("#data").append("<tr><td>번호</td><td>이름</td><td>제목</td><td>내용</td></tr>");