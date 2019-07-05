<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		var kind = '${pager.kind}';
		$('.k').each(function() {
			if($(this).val()==kind){
				$(this).prop("selected", true);
			}
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1> ${board} List</h1>
	<form class="form-inline" action="${board}List">
		<div class="form-group col-xs-2">
			<select class="form-control" name="kind">
				<option class="k" value="1">Title</option>
				<option class="k" value="2">Writer</option>
				<option class="k" value="3">Contents</option>
			</select>
		</div>
		<div class="form-group col-xs-2">
		  <input type="text" class="form-control" value="${pager.search}" name="search">
		</div>
		<div class="form-group col-xs-2">
		  <button class="form-control">Search</button>
		</div>
	<table class="table table-hover">
		<tr>
			<td>NUM</td>
			<td>TILTE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		<c:forEach items="${list}" var="boardDTO">
		<tr>
			<td>${boardDTO.num}</td>
		<td>
			<c:forEach begin="0" end="${boardDTO.step}">
				&nbsp;&nbsp;&nbsp;
			</c:forEach>
			<c:if test="${boardDTO.step ne 0}">
				<img alt="commnets" src="${pageContext.request.contextPath}/resources/img/comments.gif">
			</c:if>
			<a href="./${board}Select?num=${boardDTO.num}">${boardDTO.title}</a>
		</td>
			<td>${boardDTO.writer}</td>
			<td>${boardDTO.reg_date}</td>
			<td>${boardDTO.hit }</td>
		</tr>
		</c:forEach>
	</table>
	<ul class="pagination">
		<c:if test="${pager.curBlock  > 1}">
			<li><a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">[이전]</a></li>
		</c:if>
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var ="i">
			<li><a href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
		</c:forEach>
		<c:if test="${pager.curBlock <pager.totalBlock }">
			<li><a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">[다음]</a></li>
		</c:if>
	</ul>
	</form>
	<h3><a href="./qnaWrite">QNA Write</a></h3>
</div>
</body>
</html>