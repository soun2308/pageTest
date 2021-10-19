<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/chart.js"></script>
<!-- Chart.JS -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>이름 1 : </td>
			<td><input type="text" id="name1" placeholder="이름을 입력하세요"></td>
			<td>값    1 : </td>
			<td><input type="number" id="data1" min="0" max="150" placeholder="0~150"></td>
		</tr>
		<tr>
			<td>이름 2 : </td>
			<td><input type="text" id="name2" placeholder="이름을 입력하세요"></td>
			<td>값    2 : </td>
			<td><input type="number" id="data2" min="0" max="150" placeholder="0~150"></td>
		</tr>
		<tr>
			<td>이름 3 : </td>
			<td><input type="text" id="name3" placeholder="이름을 입력하세요"></td>
			<td>값    3 : </td>
			<td><input type="number" id="data3" min="0" max="150" placeholder="0~150"></td>
		</tr>
		<tr>
			<td>이름 4 : </td>
			<td><input type="text" id="name4" placeholder="이름을 입력하세요"></td>
			<td>값    4 : </td>
			<td><input type="number" id="data4" min="0" max="150" placeholder="0~150"></td>
		</tr>
	</table>
	<div>
		<button onclick="creatChart()">차트보기</button>
		<button onclick="window.location.reload()">차트지우기</button>
		<button onclick=location.href="/main.do">메인으로</button>
	</div>
	
	<!-- 차트 공간(canvas) -->
	<!-- 	<canvas id="myChart" width="400" height="400"></canvas> -->
	<div id="canvasDiv"></div>
</body>
</html>