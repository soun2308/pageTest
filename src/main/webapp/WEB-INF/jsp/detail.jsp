<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>번호 : ${detail.board_id}</h3>
	<h3>이름 : ${detail.board_name}</h3>
	<h3>제목 : ${detail.board_title}</h3>
	<h3>내용 : ${detail.board_content}</h3>
	<a href="/updatePage.do?boardId=${detail.board_id}"><input type="button" value="수정하기"></a>
	<a href="/delete.do?boardId=${detail.board_id}"><input type="button" value="삭제하기"></a>
</body>
</html>