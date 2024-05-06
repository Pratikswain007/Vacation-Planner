<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thank You</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	text-align: center;
}

h1 {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
	font-family: Arial, sans-serif;
	text-decoration: underline;
	font-weight: bold;
}

h2 {
	color: #333;
	margin-bottom: 20px;
}

.button {
	display: inline-block;
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	text-decoration: none;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
<form action="home">
	<div class="container">
		<h1>Vacation Planner</h1>
		<h2>Thanking You for Planning a Vacation with Us</h2>
		<h3>Your Trip has been Booked Successfully</h3>
		<a href="home" class="button">Return to Homepage</a>
	</div>
	</form>
</body>
</html>
