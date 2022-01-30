<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel = "stylesheet" href="tStyle.css">
	<title>ABC Center Time Card</title>
</head>
	<body>
		<header>
			<h1>ABC Center Time Card</h1>
		</header>
		<main>
		<form action ="InsertController" method="post">
			<h2><c:out value="${id}"/> さん<br><br>
			<input type="hidden" name="id" value="${id}">
			下記の時間を登録してよろしいですか。<br>
			 <c:out value="${date}"/>/<c:out value="${time}"/></h2>
			<br>

			<input type="submit" name="btn" value="出勤">
			<br>
			<input type="submit" name="btn" value="退勤">
			<br><br><br><br><br><br>
			<hr>
			<h4><a href="controller"><font color= white>ログインページに戻る</font></a></h4>
		</form>
		</main>
	</body>
</html>
