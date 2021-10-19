<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/list.js"></script>
<script type="text/javascript" src="/js/find.js"></script>

</head>
<body>
	<div>
		<h3>
			<input type="text" id="keyword" name="keyword" placeholder="검색어를 입력하세요">
 			<button onclick="findList(1)">검색 🔍</button>
			<button onclick=location.href="/main.do">초기화</button>
		</h3>
	</div>
	<table id="table" border="1" width="70%"></table>
	<div id="btn"></div>
	<div id="insert">
		<input type="button" value="글쓰기" onclick=location.href="/insertPage.do">
		<input type="button" value="차트만들기" onclick=location.href="/chartPage.do">
		<input type="button" value="지도보기" onclick=location.href="/map.do">
		<input type="button" value="방문객 등록" onclick=location.href="/weather.do">
	</div>
</body>
</html>