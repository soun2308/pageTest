$(function(){
})

function creatChart(name, data){
	
	var name = [];
	name[0] = $("#name1").val();
	name[1] = $("#name2").val();
	name[2] = $("#name3").val();
	name[3] = $("#name4").val();
	
	var data = [];
	data[0] = $("#data1").val();
	data[1] = $("#data2").val();
	data[2] = $("#data3").val();
	data[3] = $("#data4").val();
	
	$("#myChart").remove();
	$("#canvasDiv").append("<canvas id='myChart' width='400' height='400'></canvas>")
	//차트 생성
	var context = document.getElementById('myChart').getContext('2d');
   	var myChart = new Chart(context,
         {	// 차트의 타입을 지정 (종류 : 'bar', 'line', 'radar', 'doughnut', 'pie', 'polarArea')
            type : 'bar',
            data : {
               labels : [ name[0], name[1], name[2], name[3] ],
               datasets : [ {
                  // 차트 상단에 위치한 라벨 (클릭 시 차트 초기화 가능)
                  label : '대표라벨',
                  // 보통 출력을 원하는 데이터를 AJAX를 통해 가져와서 표현한다
                  data : [ data[0], data[1], data[2], data[3]],
                  // 차트의 표현방법에 따른 내부색상(ex. BAR차트 내부 색상)
                  backgroundColor : [ 	'rgba(255, 99, 132, 0.2)',
				                        'rgba(54, 162, 235, 0.2)',
				                        'rgba(255, 206, 86, 0.2)',
				                        'rgba(75, 192, 192, 0.2)'],
                  // 차트의 표현방법에 따른 외부라인 색상 (ex. BAR차트 외부 라인 색상)
                  borderColor : [	'rgba(255, 99, 132, 1)',
			                        'rgba(54, 162, 235, 1)',
			                        'rgba(255, 206, 86, 1)',
			                        'rgba(75, 192, 192, 1)'],
                  // 차트 속 선의 굵기      
                  borderWidth : 1
               } ]
            },
            options : {
               // 차트크기를 개발자가 지정가능하게 하는 옵션
               responsive : false,
               scales : {
                  // y축에 관한 지정
                  yAxes : [{
                     ticks : {
                        beginAtZero : true,
                        min : 0,
                        max : 150,
                        stepSize : 10
                     }
                  }]
               }
            }
		});	
}
