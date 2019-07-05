<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>${board} select</h1>
	<form action="./${board}Comments" method="GET">
	<table class="table table-hover">
		<tr>
			<td>NUM</td>
			<td>TILTE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		<tr>
			<td>${boardDTO.num}</td>
			<td>${boardDTO.title}</td>
			<td>${boardDTO.writer}</td>
			<td>${boardDTO.reg_date}</td>
			<td>${boardDTO.hit }</td>
			<td><input type="hidden" value="${boardDTO.num}" name="num"></td>
		</tr>
		<tr>
			<c:forEach items="${files}" var="files">
				<td><a>${files.oname}</a></td>
			</c:forEach>
		</tr>
	</table>
	<table class="table">
		<tr>
			<td>${boardDTO.contents}</td>
		</tr>
	</table>
		<button class="btn btn-primary">Comments</button>
	</form>
	<h3><a href="./${board}Update?num=${boardDTO.num}">Update</a></h3>
	<h3><a href="./${board}Delete?num=${boardDTO.num}">Delete</a></h3>
</div>
</body>
</html>