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
			<form action = "kakuninController" method ="post">
			<br>
				<h3>ID : <input type="text" name ="paramId" style="width: 180px; height: 21px;" required ></h3>
				<h3>choose the period you want to confirm</h3>
				<div class="selectbox color">
				<select name ="paramYear">
				<option value="2021">Year</option>
				<option value= 2021>2021</option>
				<option value= 2022>2022</option>
				<option value= 2023>2023</option>
				<option value= 2024>2024</option>
				<option value= 2025>2025</option></select>
				</div>
				<div class="selectbox color">
				<select name = "paramMonth" >
				<option value= 1>Month</option>
				<option value= 1>1</option>
				<option value= 2>2</option>
				<option value= 3>3</option>
				<option value= 4>4</option>
				<option value= 5>5</option>
				<option value= 6>6</option>
				<option value= 7>7</option>
				<option value= 8>8</option>
				<option value= 9>9</option>
				<option value= 10>10</option>
				<option value= 11>11</option>
				<option value= 12>12</option>
				</select>
				</div>
			<br>
				<input type="submit" name="btn" value="確認する">
			</form>
			<br>
			<hr>
			<br>
			<h4><a href="controller"><font color= white>ログインページに戻る</font></a></h4>
		</main>
	</body>
</html>