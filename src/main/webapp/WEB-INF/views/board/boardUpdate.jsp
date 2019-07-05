<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>${board} Update</h1>
	<form action="./${board}Update" method="POST">
	<div class="form-group">
			<label for="title">Title</label>
		    <input type="text" class="form-control" value="${boardDTO.title}" id="title" name="title">
		    <input type="hidden" name="num" value="${boardDTO.num}">
		 </div>
		 <div class="form-group">
		    <label for="Writer">Writer:</label>
		    <input type="text" class="form-control" value="${boardDTO.writer}" id="writer" name="writer" readonly="readonly">
		  </div>
		 <div class="form-group">
		    <label for="Contents">Contents:</label>
		    <textarea rows="5" class="form-group" cols="100" name="contents">${boardDTO.contents}</textarea>
		 </div>
	<button type="submit">UPDATE</button>
	</form>
</div>
</body>
</html>