
<%@page import="java.sql.*"%>

<%@ page import="com.Model.CourseModel"%>

<%@ page import="java.util.List"%>
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

<title>Delete Course</title>
<style>
body {
	background-image: url(./bg6.jpg);
	background-size: cover;
	/* overflow: hidden; */
	color: white;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	/* text-align:center; */
}

img {
	background-color: transparent;
	height: 90px;
	width: 9%;
	float: left;
	align-items: center;
}

label {
	font-size: 18px;
}

.dot {
	color: orange;
	font-size: 3rem;
}

.navbar {
	overflow: hidden;
	text-align: center;
	color: white;
	align-items: baseline;
	/* padding: 20px; */
	background-color: #1F2D5A;
	align-items: center;
	display: flex;
	justify-content: center;
}

.padd {
	/* padding-top: 15px; */
	padding-bottom: 12px;
}

.padd1 {
	padding-top: 15px;
	/* padding-bottom: 12px;   */
}

.al {
	display: flex;
	justify-content: center;
	text-align: center;
	padding-top: 15px;
}

.btns {
	background-image: url(./bg4.png);
	background-size: cover;
	border-radius: 5px;
	height: 42px;
	width: 50%;
	font-size: 25px;
	font-weight: bold;
	margin: 20px;
}

#b1 {
	font-size: 20px;
	color: white;
	background-color: #1F2D5A;
	border-radius: 5px;
	width: 80px;
	margin-top: 5px;
}

#b1:hover {
	color: white;
	background-color: #1f2d5ac5;
}

#b2 {
	font-size: 20px;
	float: right;
	color: white;
	background-color: #1F2D5A;
	border-radius: 5px;
	width: 80px;
	margin-top: 5px;
}

#b2:hover {
	color: white;
	background-color: #1f2d5ac5;
}

#b3 {
	font-size: 15px;
	color: white;
	background-color: green;
	border-radius: 5px;
}

#b3:hover {
	color: white;
	background-color: rgba(0, 128, 0, 0.823);
}

#b4 {
	font-size: 15px;
	color: white;
	background-color: red;
	border-radius: 5px;
}

#b4:hover {
	color: white;
	background-color: rgba(255, 0, 0, 0.632);
}

.btns:hover {
	border: solid 2px white;
}

.align {
	text-align: center;
}

form {
	background-color: #1F2D5A;
	border-radius: 10px;
	padding: 15px;
	border: solid 2px;
	border-color: white;
}

#passwordForm {
	padding: 30px;
}

.brc {
	border-color: black;
}

.weak {
	color: red;
}

.medium {
	color: orange;
}

.strong {
	color: green;
}

h3 {
	text-align: center;
	padding: 20px;
	font-weight: bold;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
}

nav h1 {
	font-family: "Major Mono Display", monospace;
	color: white;
}

div h1 {
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	padding-bottom: 10px;
	color: #1F2D5A;
	text-align: center;
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
	font-family: "Major Mono Display", monospace;
}

.img2 img {
	height: 18px;
	width: 6%;
	margin-top: -26px;
	display: flex;
	float: right;
	margin-right: 7px;
	cursor: pointer;
}

table {
	table-layout: auto;
	padding: 10px;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid white;
	padding: 20px;
	text-align: center;
	max-width: 300px;
}

th {
	background-color: #1F2D5A;
	color: white;
}

td {
	background-color: #1F2D5A;
	color: white;
}

.table-responsive input {
	width: 250px;
	overflow-x: auto;
}

.table-responsive select {
	width: 100px;
	overflow-x: auto;
}

#emailError {
	margin: 0;
}
</style>

</head>
<body>

	<nav class=" navbar">
		<img src="./vcube-logo.png" alt="">
		<h1>Vcube Software Solutions</h1>
	</nav>

	<div class="container">
		<a href="CourseList"><button type="button" class="btn"
				id="b1">Back</button></a> <a href="./admin.jsp"><button
				type="button" class="btn" id="b2">Home</button></a>

		<h1>Delete Course</h1>
		<form id="passwordForm" class="form-group" name="CourseDelete"
			method="post" action="CourseDelete" onsubmit="return mail()">

			<table class="table-responsive">

				<tr>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Course Fee</th>
					<th>Duration</th>
					<th>Action</th>
				</tr>


				<%
				List<CourseModel> clist = (List<CourseModel>) request.getAttribute("list");

				if (clist != null) {
					for (CourseModel course : clist) {
				%>
				<tr>
					<td><input class="form-control brc" type="text"
						value="<%=course.getCid()%>" name="cid" id="cid" placeholder=""
						readonly></td>

					<td><input class="form-control brc" type="text"
						value="<%=course.getCoursename()%>" name="cname" id="cname"
						placeholder="" readonly></td>
					<td><input class="form-control brc" type="text"
						value="<%=course.getCoursefees()%>" name="cfee" id="cfee"
						placeholder="" readonly></td>
					<td><input class="form-control brc" type="text"
						value="<%=course.getDuration()%>" name="duration" id="duration"
						placeholder=""readonly></td>
					<td><a href=><button type="submit" class="btn" id="b4">Confirm
								Delete</button></a></td>

				</tr>
				<%
				}
				}
				%>


			</table>
		</form>

	</div>
</body>
<footer>
	<marquee behavior="" direction="right">
		<h5>@Satya_Vcube</h5>
	</marquee>
</footer>
<script>
	//keypress batch
	document.getElementById("cname").addEventListener("keypress", meth1);
	function meth1(event) {
		var n1 = event.which;
		if (!((n1 >= 65 && n1 <= 90) || (n1 >= 97 && n1 <= 122) || n1 == 0
				|| n1 == 8 || n1 == 32 || n1 >= 48 && n1 <= 57)) {
			event.preventDefault();
		}
	}
	// keypress fees
	document.getElementById("coursefees").addEventListener("keypress", meth3);
	function meth3(event) {
		var n1 = event.which;
		if (!((n1 >= 48 && n1 <= 57) || n1 == 0 || n1 == 8 || n1 == 32)) {
			event.preventDefault();
		}
	}
</script>
</html>