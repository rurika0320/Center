<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel = "stylesheet" href="tStyle.css">
	<title>Center Time Card</title>
</head>
       <header>
			<h1>Center Time Card</h1>
		</header>
       <body>
		<main>
		<br>
			<form action ="controller" method="post">
				<h3>　ID : <input type="text" name = "paramId" style="width:220px; height:20px"></h3>
				<h3>Pass : <input type="password" name = "paramPass"  style="width:220px; height:20px"></h3>
			<br>
			<input type="submit" name="btn" value="ログイン">
			</form>
			<br>
			<br>
			<br>
			<br>
			<br>
			<hr>
			<form action ="tourokuController" method="get">
				<h3>初めての方はこちら</h3>
				<input type="submit" name="btn" value="新規登録">
			</form>
		</main>
	</body>
</html>