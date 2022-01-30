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
			<br>
			<h2><c:out value="${id}"/> さん<br><br>
			<c:out value="${message}"/><br><br></h2>
			<h1><c:out value="${出勤時間}"/><c:out value="${退勤時間}"/></h1>
			<br>
			<hr>
			<br>
			<form action="controller"  method="post">
				<input type="submit" value="ログアウト" name="btn">
			</form>
		</main>
	</body>
</html>

