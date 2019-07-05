<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>${board} Write</h1>
<form action="./${board}Comments" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="title">Title</label>
	    <input type="text" class="form-control" id="title" name="title" value="${boardDTO.title}의 답글" readonly="readonly">
	 </div>
   <div class="form-group">
	    <label for="Writer">Writer:</label>
	    <input type="text" class="form-control" id="writer" name="writer">
   </div>
   <div class="form-group">
	    <label for="Contents">Contents:</label>
	    <textarea rows="5" class="form-group" cols="" name="contents"></textarea>
   </div>
   <div class="form-group">
   		<input type="hidden" class="form-control" id="ref" name="ref"  value="${boardDTO.ref}">
   		<input type="hidden" class="form-control" id="step" name="step"  value="${boardDTO.step}">
   		<input type="hidden" class="form-control" id="depth" name="depth" value="${boardDTO.depth}">
   </div>
   <div class="form-group">
	  	<input type="file" name="multipartFiles">
	  	<input type="file" name="multipartFiles">
   </div>
  
  <button >Write</button>
</form>
</div>
</body>
</html>