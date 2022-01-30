<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ABC Center Time Card</title>
	<link rel = "stylesheet" href="tStyle.css">
</head>
	<body>
		<header>
			<h1>ABC Center Time Card</h1>
		</header>
	 	<main>
	 	<br>
			<form action ="tourokuController" method="post">
			<h3>　ID : <input type="text" name = "newId"  style="width: 220px; height: 20px;" required></h3>
			<h3>PASS : <input type="password" name = "newPass" style="width: 220px; height: 20px;" required></h3>
			<h5>*IDは8文字の職員番号を入力してください</h5>
			<h5>*パスワードは8文字以内で設定してください</h5>
			<br>
			<input type="submit" name="btn" value="新規登録">
			</form>
			<br>
			<hr>
			<br>
			<h4><a href="controller"><font color= white>ログインページに戻る</font></a></h4>
		</main>
	</body>
</html>