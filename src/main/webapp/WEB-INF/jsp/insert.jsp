<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/insert.js" charset="UTF-8"></script>
</head>
<body>
	<h3>번호 : <input id="boardId" type="number" name=boardId value="${id}" readonly="readonly"></h3>
	<h3>이름 : <input id="boardName" type="text" name=boardName placeholder="이름을 입력하세요"/></h3>
	<h3>제목 : <input id="boardTitle" type="text" name=boardTitle placeholder="제목을 입력하세요"/></h3>
	<h3>내용 : <textarea id="boardContent" name=boardContent placeholder="내용을 입력하세요"></textarea></h3>
	<button onclick="insert()">등록하기</button>
</body>
</html>