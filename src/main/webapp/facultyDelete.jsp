
<%@page import="java.sql.*"%>
<%@ page import="com.Model.FacultyModel"%>

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
<script src="./studjs.js"></script>

<title>Delete Faculty Details</title>
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

.btns:hover {
	border: solid 2px white;
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

	<nav class="navbar">
		<img src="./vcube-logo.png" alt="">
		<h1>Vcube Software Solutions</h1>
	</nav>

	<div class="container">
		<a href="FacList"><button type="button" class="btn" id="b1">Back</button></a>
		<a href="./admin.jsp"><button type="button" class="btn" id="b2">Home</button></a>

		<h1>Delete Faculty</h1>
		<form id="passwordForm" class="form-group" name="FacultyDelete"
			method="post" action="FacultyDelete" onsubmit="return mail()">

			<table class="table-responsive">

				<tr>
					<th>Faculty ID</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Experience</th>
					<th>Course ID</th>
					<th>Actions</th>

				</tr>

				<%
				List<FacultyModel> flist = (List<FacultyModel>) session.getAttribute("list");

				if (flist != null) {
					for (FacultyModel faculty : flist) {
				%>
				<tr>
					<td><input class="form-control brc" type="text"
						value="<%=faculty.getFid()%>" name="fid" id="fid"
						placeholder="Faculty ID"   readonly></td>

					<td><input class="form-control brc" type="text"
						value="<%=faculty.getFirstname()%>" name="fullname" id="fullname"
						placeholder="fullname"  readonly></td>
					<td><input class="form-control brc" type="text"
						value="<%=faculty.getMobile()%>" name="mobile" id="mobile"
						placeholder="Phone"   readonly>

					</td>
					<td><input class="form-control brc" type="text"
						value="<%=faculty.getEmail()%>" name="email" id="email"
						placeholder="ex:satyammmmm31@gmail.com" required onblur="em()" readonly>
						<p id="emailError"></p></td>
					<td><input class="form-control brc"
						value="<%=faculty.getGender()%>" id="gender" name="gender"
						 readonly></td>
					<td><input class="form-control brc" type="text"
						value="<%=faculty.getExp()%>" name="fexp" id="fexp"
						placeholder=" " readonly></td>


					<td><input class="form-control brc" type="text" value="<%=faculty.getCourse()%>"name="course"
						id="course" readonly>
							 

							<%
							}
							}
							%>
					</td>
					<td><a href=""><button type="submit" class="btn" id="b4">Confirm
								Delete</button></a></td>

				</tr>
			</table>
		</form>

	</div>
</body>
<footer>
	<marquee behavior="" direction="right">
		<h5>@Satya_Vcube</h5>
	</marquee>
</footer>

</html>