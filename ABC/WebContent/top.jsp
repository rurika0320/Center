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
				<form action ="PreInsertContoroller" method="post">
					<h2><c:out value="${id}"/>さん</h2>
					<h2>ログインに成功しました</h2>
					<br>
					<br>
					<input type="submit" name="btn" value="打刻する">
					<br>
					<br>
				</form>
				<hr>
				<form action ="kakuninController" method="get">
					<h2>過去の記録を確認する</h2>
				<input type="submit" name="btn" value="確認する">
				<br>
			</form>
			</main>
			</div>
	</body>
</html>