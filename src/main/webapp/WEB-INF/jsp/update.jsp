<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/update.js"></script>
</head>
<body>
	<h3>번호 : <input type="text" id=boardId name=boardId value="${detail.board_id}"></h3>
	<h3>이름 : <input type="text" id=boardName name=boardName value="${detail.board_name}"></h3>
	<h3>제목 : <input type="text" id=boardTitle name=boardTitle value="${detail.board_title}"></h3>
	<h3>내용 : <textarea id=boardContent name=boardContent>${detail.board_content}</textarea></h3>
	<button onclick="update()">수정하기</button>
</body>
</html>