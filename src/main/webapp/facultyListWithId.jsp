<%@ page import="java.sql.*"%>
<%@ page import="com.Model.FacultyModel"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Major+Mono+Display&display=swap"
	rel="stylesheet">

<title>Faculty List</title>

<style>
body {
	background-image: url(./bg6.jpg);
	background-size: cover;
	color: black;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
}

.navbar {
	overflow: hidden;
	text-align: center;
	color: white;
	align-items: baseline;
	background-color: #1F2D5A;
	align-items: center;
	display: flex;
	justify-content: center;
}

nav img {
	height: 90px;
	width: 9%;
	float: left;
	align-items: center;
}

nav h1 {
	font-family: "Major Mono Display", monospace;
	color: white;
}

p {
	font-size: 40px;
	font-weight: bold;
	color: #1F2D5A;
	text-align: center;
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
	font-size: 15px;
	color: white;
	background-color: green;
	border-radius: 5px;
}

#b2:hover {
	color: white;
	background-color: rgba(0, 128, 0, 0.823);
}

#b3 {
	font-size: 15px;
	color: white;
	background-color: red;
	border-radius: 5px;
}

#b3:hover {
	color: white;
	background-color: rgba(255, 0, 0, 0.632);
}

table {
	table-layout: auto;
	padding: 10px;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid black;
	padding: 20px;
	text-align: center;
	max-width: 300px;
}

th {
	background-color: #1F2D5A;
	color: white;
}

td {
	background-color: white;
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

.container-fluid {
	padding: 20px;
	justify-content: center;
	align-items: center;
}
</style>

</head>
<body>
	<nav class=" navbar">
		<img src="./vcube-logo.png" alt="">
		<h1>Vcube Software Solutions</h1>
	</nav>

	<div class="container-fluid search">
		<a href="FacList"><button type="button" class="btn" id="b1">Back</button></a>

		<div class="container">
			<table>
				<tr>
					<th>Faculty id</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Gmail</th>
					<th>Gender</th>
					<th>Experience</th>
					<th>Course Id</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>


				<%
				List<FacultyModel> list = (List<FacultyModel>) request.getAttribute("fidlist");

				if (list != null) {
					for (FacultyModel faculty : list) {
				%>
				<tr>
					<td><%=faculty.getFid()%></td>
					<td><%=faculty.getFirstname()%></td>
					<td><%=faculty.getMobile()%></td>
					<td><%=faculty.getEmail()%></td>
					<td><%=faculty.getGender()%></td>
					<td><%=faculty.getExp()%></td>
					<td><%=faculty.getCourse()%></td>
					<td><a href="FacUpdateWithId?id=<%=faculty.getFid()%>">
							<button class="btn" id="b2">Update</button>
					</a></td>
					<td><a href="FacDeleteWithId?id=<%=faculty.getFid()%>">
							<button class="btn" id="b3">Delete</button>
					</a></td>
				</tr>
				<%
				}
				}
				%>

			</table>
		</div>
	</div>
</body>
<footer>
	<marquee behavior="" direction="right">
		<h5>@Satya_Vcube</h5>
	</marquee>
</footer>
</html>
