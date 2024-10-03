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
<script src="./forgotPass.js"></script>
<title>Forgot password</title>
</head>
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
	width: 100%;
	font-size: 25px;
	font-weight: bold;
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
	padding: 20px;
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
}

h1 {
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
	width: 8%;
	margin-top: -26px;
	display: flex;
	float: right;
	margin-right: 7px;
	cursor: pointer;
}

.container {
	padding: 20px;
}
</style>
<body>

	<nav class="navbar">
		<img src="./vcube-logo.png" alt="">
		<h1>Vcube Software Solutions</h1>
	</nav>

	<div class="container">
		<a href="./index.jsp"><button type="button" class="btn" id="b1">Back</button></a>

		<div class="row">
			<div class="col-md-4 padd1"></div>
			<div class="col-md-4 padd1">
				<form id="passwordForm" class="form-group" name="Newpass"
					method="get" action="Newpass" onsubmit="return match()">
					<h1>New Password</h1>
					<hr>
					<div class="row padd">
						<div class="col-md-12 img2 padd">
							<label for="password"> *Password</label> <input
								class="form-control brc" type="password" name="password"
								id="password" placeholder="password" onfocus="disppwd()"
								onblur="verifypwd1()" maxlength="10" minlength="6"> <img
								src="./eye-close.png" alt="" id="eye" onclick="show()">
							<p id="strengthMessage" class="message"></p>
						</div>
						<div class="col-md-12 img2">
							<label for="confirm-password"> *Confirm Password</label> <input
								class="form-control brc" type="password" name="confirm-password"
								id="confirm-password" placeholder="confirm password"
								onblur="match()" required maxlength="10"> <img
								src="./eye-close.png" alt="" id="ceye" onclick="show2()">
							<p id="cpwd"></p>
						</div>
					</div>
					<div class="row al">
						<a href=""><button type="submit" class="btns">SUBMIT</button>
						</a>

					</div>
				</form>
			</div>

		</div>
	</div>

</body>
<footer>
	<marquee behavior="" direction="right">
		<h5>@Satya_Vcube</h5>
	</marquee>
</footer>
<script>
 //  confirm-password validation
 const pwd = document.getElementById("password").value;
          const cpwd = document.getElementById("confirm-password");

          cpwd.addEventListener('input', () => {
             const  lcpwd = cpwd.value;
             passcheck(lcpwd);
         });

         function passcheck(lcpwd){
             const pwd = document.getElementById("password").value;
             if(pwd==lcpwd){ 
         document.getElementById("cpwd").innerHTML = "Password and Confirm Password Matched";
         document.getElementById("cpwd").style.color = "green";  
         } 
         else{
         document.getElementById("cpwd").innerHTML = "Password and Confirm Password Not Matched"; 
         document.getElementById("cpwd").style.color = "red";
         }
    }
         
       //password
         function match(){ 
                 var pass = document.getElementById("password").value;
                 var cpass = document.getElementById("confirm-password").value;

                 if ( pass != cpass) {
                     document.getElementById("cpwd").innerHTML = "Password and Confirm Password Not Matched"; 
                     document.getElementById("cpwd").style.color = "red";
                     return false;
                      
                 } 
                else{
                 document.getElementById("cpwd").innerHTML = " "; 
                 return true

                }
             } 
         let pass = document.getElementById("password");
         let eye = document.getElementById("eye");

         function  show(){
             if(password.type == "password"){
                password.type ="text";
                eye.src = "eye-open.png";
             }
             else{
                 password.type = "password";
                 eye.src = "eye-close.png";
             }
         }

         let cpass = document.getElementById("confirm-password");
         let ceye = document.getElementById("ceye");

         function  show2(){
             if(cpass.type == "password"){
                cpass.type ="text";
                ceye.src = "eye-open.png";
             }
             else{
                 cpass.type = "password";
                 ceye.src = "eye-close.png";
             }
         }
         //onblur pass
         function verifypwd1(){
                // document.getElementById("pwd").innerHTML = "";
                document.getElementById("strengthMessage").innerHTML = "";

                
             }
 </script>
</html>