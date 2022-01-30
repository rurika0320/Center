<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel = "stylesheet" href="tStyle.css">
	<title>ABC　Center Time Card</title>
</head>
<body>
	<header>
		<h1>ABC　Center Time Card</h1>
	</header>
	<main>
		<h3><font color="red"><c:out value="${errormessage}"></c:out></font></h3>
		<table>
			<tr>
			<th>ID</th>
			<th>日にち</th>
			<th>出勤時刻</th>
			<th>退勤時刻</th>
			<th>勤務時間</th>
		<c:forEach var="emp" items="${requestScope.empList}">
		<tr>
			<td><c:out value="${emp.id }"/></td>
			<td><c:out value="${emp.date }"/></td>
			<td><c:out value="${emp.clockIn}"/></td>
			<td><c:out value="${emp.clockOut }"/></td>
			<td><c:out value="${emp.workingHours }"/></td>
		</c:forEach>
		</table>
		<br>
		<hr>
		<br>
		<form action="controller"  method="post">
			<input type="submit" value="ログアウト" name="btn">
		</form>
	</main>
</body>
</html>