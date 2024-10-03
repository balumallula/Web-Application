<%@ page import="java.sql.*"%>
<%@ page import="com.Model.StudentModel"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Major+Mono+Display&display=swap"
	rel="stylesheet">
<title>Students List</title>

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

h1 {
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
	width: 90%;
	margin: 40px auto;
	padding: 10px;
	border-collapse: collapse;
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
	align-items: center;
}

.search .search-container {
	float: right;
}

.search .search-container button {
	float: right;
	padding: 2.5px 10px;
	margin: 10px 10px 10px 0px;
	background: #1F2D5A;
	font-size: 20px;
	border: none;
	cursor: pointer;
	color: white;
}

.search input {
	font-size: 20px;
	border: 2px solid #1F2D5A;
	margin: 10px 0px 10px 10px;
}

.search .search-container button:hover {
	background-color: #1f2d5ac5;
}

@media screen and (max-width: 600px) {
	.topnav .search-container {
		float: none;
	}
}
</style>
</head>
<body>

	<nav class="navbar">
		<img src="./vcube-logo.png" alt="Logo">
		<h1>Vcube Software Solutions</h1>
	</nav>

	<div class="container-fluid search">
		<a href="BatchListForStud"><button type="button" class="btn" id="b1">Back</button></a>

		<div class="search-container">
			<form action="StudListWithId">
				<input type="text" placeholder="Search with Id" name="id" id="id"
					required>
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>

		<form>
			<table>

				<tr>
					<th>Student ID</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Branch</th>
					<th>Year of Passout</th>
					<th>Father's Name</th>
					<th>Father's Mobile</th>
					<th>Batch ID</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>


				<%
				List<StudentModel> list = (List<StudentModel>) request.getAttribute("list");

				if (list != null) {
					for (StudentModel student : list) {
				%>
				<tr>
					<td><%=student.getSid()%></td>
					<td><%=student.getFirstname()%></td>
					<td><%=student.getMobile()%></td>
					<td><%=student.getEmail()%></td>
					<td><%=student.getGender()%></td>
					<td><%=student.getBranch()%></td>
					<td><%=student.getYear()%></td>
					<td><%=student.getFathername()%></td>
					<td><%=student.getFmobile()%></td>
					<td><%=student.getBatch()%></td>

					<td><a href="StudUpdateWithId?id=<%=student.getSid()%>">
							<button type="button" class="btn" id="b2">Update</button>
					</a></td>
					<td><a href="StudDeleteWithId?id=<%=student.getSid()%>">
							<button type="button" class="btn" id="b3">Delete</button>
					</a></td>
				</tr>
				<%
				}
				}
				%>



			</table>
			<%
			String na = (String) request.getAttribute("NA");
			if (na != null) {
			%>

			<h1><%=na%></h1>
			<%
			}
			%>
		</form>
	</div>
</body>
<footer>
	<marquee behavior="" direction="right">
		<h5>@Satya_Vcube</h5>
	</marquee>
</footer>
</html>
<script>
	//fathermobile
	document.getElementById("id").addEventListener("keypress", meth3);
	function meth3(event) {
		var n1 = event.which;
		if (!((n1 >= 48 && n1 <= 57) || n1 == 0 || n1 == 8)) {
			event.preventDefault();
		}
	}
</script>