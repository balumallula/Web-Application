<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Major+Mono+Display&display=swap"
	rel="stylesheet">


<title>Admin</title>
<style>
body {
	background-image: url(./bg6.jpg);
	background-size: cover;
	overflow: hidden;
	color: black;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	text-align: center;
}

.navbar {
	text-align: center;
	color: white;
	align-items: baseline;
	/* padding: 20px; */
	background-color: #1F2D5A;
	align-items: center;
}

nav a {
	color: white;
	font-size: 20px;
}

.btn {
	color: white;
	background-color: #1F2D5A;
	border-radius: 5px;
	height: 42px;
	width: 20%;
	font-size: 25px;
	font-weight: bold;
	margin: 20px;
}

.btn:hover {
	color: white;
	background-color: #1f2d5adf;
	border: solid 2px white;
	align-items: center;
	text-align: center;
	/* background-color: rgb(11, 8, 222); */
}

.btnl {
	color: #1F2D5A;
	background-color: white;
	border-radius: 5px;
	height: 42px;
	width: 100%;
	font-weight: bold;
}

a .btnl:hover {
	color: white;
	background-color: #1f2d5adf;
	border: solid 2px white;
	align-items: center;
	text-align: center;
	/* background-color: rgb(11, 8, 222); */
}

h3 {
	padding: 20px;
	font-weight: bold;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
}

.container {
	padding: 20px;
}

img {
	background-color: transparent;
	height: 90px;
	width: 9%;
	float: left;
	align-items: center;
}

.padd {
	padding-bottom: 40px;
	padding-right: 0px;
}

nav h1 {
	font-family: "Major Mono Display", monospace;
}

h5 {
	color: black;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	font-weight: bold;
	font-size: 20px;
}

footer {
	position: fixed;
	left: 0;
	right: 0;
	height: 30px;
	font-family: "Major Mono Display", monospace;
	background-color: #1F2D5A;
	color: white;
	text-align: center;
	line-height: 50px;
	bottom: 0;
}

marquee h5 {
	color: white;
	font-family: "Major Mono Display", monospace;
}
</style>
</head>
<body>

	<nav class=" navbar">
		<img src="./vcube-logo.png" alt="">
		<h1>Vcube Software Solutions</h1>

		<form method="post" action="Logout">

			<a href=""><button type="submit" class="btnl">Log Out</button></a>
		</form>
	</nav>

	<h1>
		Welcome to admin
		<%=session.getAttribute("username")%>
	</h1>


	<div class="container">



		<div class="row">
			<div class="col-md-12">
				<a href="DropBatchList" class="btn">Add Student</a> <a
					href="DropCourseList" class="btn"> Add Faculty </a> <a
					href="BatchListForStud" class="btn">Student List</a> <a href="FacList"
					class="btn">Faculty List</a>

			</div>
		</div>

	</div>
	<div class="row">
		<div class="col-md-12 padd">
			<h5>Payment Details</h5>
			<a href="./payment.jsp" class="btn"> New Payment </a> <a
				href="PaymentList" class="btn"> Payment History </a>
			<h5>Course Details</h5>
			<a href="./addCourse.jsp" class="btn"> Add New Course </a> <a
				href="CourseList" class="btn"> Available Courses </a>
			<h5>Batch Details</h5>
			<a href="DropList" class="btn"> Add New Batch </a> <a
				href="BatchList" class="btn"> Current Batches </a>
		</div>
	</div>
	</div>

</body>
<footer>
	<marquee behavior="" direction="right">
		<h5>@Satya_Vcube</h5>
	</marquee>
</footer>
</html>