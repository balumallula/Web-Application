
<%@page import="java.sql.*"%>
<%@page import="jakarta.servlet.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Major+Mono+Display&display=swap"
	rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<title>Log in</title>
<style>
body {
	background-image: url(./bg6.jpg);
	background-size: cover;
	color: white;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	/* text-align:center; */
}

nav img {
	/* background-color: transparent; */
	height: 90px;
	width: 9%;
	float: left;
	align-items: center;
}

.img1 img {
	height: 490px;
	width: 100%;
	/* background-color: transparent; */
	padding-left: 40px;
	padding-top: 35px;
}

label {
	font-size: 18px;
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
	align-items: center;
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

.btn {
	/* background-image: url(./bg6.jpg);
            background-size:cover;*/
	background-color: white;
	color: #1F2D5A;
	border-radius: 2px;
	height: 42px;
	width: 48%;
	font-size: 28px;
	font-weight: bolder;
	margin: 20px;
	padding: 3px;
}

.btn:hover {
	color: #1F2D5A;
	border: solid 2px black;
}

form {
	/* background-image: url(./bg6.jpg); */
	overflow: hidden;
	width: 80%;
	border-color: white;
	border-radius: 10px;
}

/* .box{
        background-color: aliceblue;
       } */
#passwordForm {
	padding: 30px;
}

.brc {
	border-color: black;
}

h2 {
	text-align: center;
	color: white;
	font-weight: bold;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
}

nav h1 {
	font-family: "Major Mono Display", monospace;
}

.container {
	align-items: center;
	justify-content: center;
	padding: 30px;
}

footer {
	 
	left: 0;
	right: 0;
	height: 50px;
	font-family: "Major Mono Display", monospace;
	background-color: #1F2D5A;
	color: white;
	text-align: center;
	line-height:50px;
	bottom: 0;
}

footer p {
	color: white;
}

marquee h5 {
	font-family: "Major Mono Display", monospace;
}

#password {
	position: relative;
}

.img2 img {
	position: absolute;
	left: 329px;
	height: 37px;
	width: 12%;
	margin-top: -37px;
	cursor: pointer;
	padding: 10px;
}

a {
	margin-top: 3px;
	/* margin-left: 180px; */
	float: right;
}

a:hover {
	text-decoration: none;
}

.bg {
	background-color: #1F2D5A;
}

.pad1 {
	padding: 20px;
	border-radius: 10px;
}

.form-box {
	display: flex;
	align-items: center;
	justify-content: center;
	background-color: #1F2D5A;
	margin-top: 30px
}

p {
	color: #fa2200;
}

.cbg {
	height: 50vh;
	background-image: url(./contactbg.jpg);
	background-size: cover;
	align-items: center;
	justify-content: center;
	padding: 50px;
	text-align: center;
	margin-top: 20px;
	color: #04A6AD;
}

#icon {
	font-size: 40px;
	display: flex;
	align-items: center;
	justify-content: center;
	text-align: center;
}

marquee {
	padding: 20px;
	color: #1F2D5A;
	font-weight: bold;
	font-size: 20px;
	font-family: "Major Mono Display", monospace;
}
</style>
</head>
<body>

	<nav class="navbar">
		<img src="./vcube-logo.png" alt="">
		<h1>Vcube Software Solutions</h1>
	</nav>

	<div class="container">

		<div class="row">

			<div class="col-md-6 img1 form-box">
				<img src="./img1.png" alt="login">
			</div>
			<div class="col-md-6 img1 form-box">
				<form id="passwordForm" class="form-group" name="Login"
					method="post" action="Login">

					<h2>Log in</h2>
					<hr>
					<div class="row padd">
						<div class="col-md-12">
							<label for="UserName">User Name</label> <input
								class="form-control brc" type="text" name="adm_username"
								id="username" placeholder="username" required maxlength="15">
						</div>
					</div>


					<div class="row padd">
						<div class="col-md-12 img2">
							<label for="password">Password</label> <input
								class="form-control brc" type="password" name="adm_password"
								id="password" placeholder="password" required maxlength="10">
							<img src="./eye-close.png" class="eye" alt="" id="eye"
								onclick="show()"> <a href="./forgotPass.jsp">Forgotten
								your password?</a>

						</div>
					</div>
					<div class="row">

						<div class="col-md-12">
							<label for="login">Who're Log in</label> <select
								class="form-control" name="login" id="login" required>
								<option value="">Select</option>
								<option value="Admin">Admin</option>
								<option value="Faculty">Faculty</option>
								<option value="Student">Student</option>
							</select>
						</div>
					</div>
					 
<%
    String error = (String) request.getAttribute("msg");
%>

<% if (error != null) { %>
    
    <p id="error"><%= error %></p>
<% } else { %>
     
    <p id="error"></p>
<% } %>

 
  


 

<!-- The element where the error message will be displayed -->
<div id="error" style="color: red;"></div>

  
					<div class="row al">
						<button type="submit" class="btn  ">LOGIN</button>
					</div>

				</form>
			</div>
		</div>

		<div class="row" style="margin-top: 20px;">
			<div class="col-md-12">
				<marquee direction="right"> Java Full Stack</marquee>
				<marquee direction="right"> Python Full Stack</marquee>
				<marquee direction="right"> Azure DevOps</marquee>
				<marquee direction="right"> Data Science</marquee>
				<marquee direction="right"> Cyber Security</marquee>
				<marquee direction="right"> Artificial Intelligence</marquee>

			</div>

		</div>

		<div class="row cbg ">
			<div class="col-md-12">

				<h2 style="padding: 10px">Contact Us</h2>
				<h3>8008197255/8047151748</h3>

			</div>
			<div class="col-md-12">

				<h2>Social Media Handles</h2>
				<div id="icon">
					<a
						href="https://www.instagram.com/vcubesoftwaresolutions?igsh=ZXVrY216ZGFyaQ=="><i
						class="fa-brands fa-instagram" style="color: #04A6AD"></i></a>
				</div>

			</div>
		</div>
	</div>



</body>
<footer>
	<P>© Copyright 2024 vcube, Inc. All rights reserved. Various
		trademarks held by their respective owners.</P>
</footer>
<script>
	let pass = document.getElementById("password");
	let eye = document.getElementById("eye");

	function show() {
		if (password.type == "password") {
			password.type = "text";
			eye.src = "eye-open.png";
		} else {
			password.type = "password";
			eye.src = "eye-close.png";
		}
	}
	
	


</script>
	 
</html>
