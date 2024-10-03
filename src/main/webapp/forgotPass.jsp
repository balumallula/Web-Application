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

.btnotp1 {
	background-image: url(./bg4.png);
	background-size: cover;
	border-radius: 5px;
	height: 35px;
	width: 40%;
	font-size: 18px;
	font-weight: bold;
	margin: 15px 0px opx opx;
}

.btnotp1:hover {
	border: solid 2px white;
}

.btnotp {
	background-image: url(./bg4.png);
	background-size: cover;
	border-radius: 5px;
	height: 35px;
	width: 30%;
	font-size: 18px;
	font-weight: bold;
	margin-top: 15px;
}

.btnotp:hover {
	border: solid 2px white;
}

.align {
	text-align: center;
}

form {
	background-color: #1F2D5A;
	border-radius: 10px;
	padding: 25px;
	border: solid 2px;
	border-color: white;
	margin: 40px auto;
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
	width: 6%;
	margin-top: -26px;
	display: flex;
	float: right;
	margin-right: 7px;
	cursor: pointer;
}

.md {
	display: flex;
	justify-content: center;
	align-items: center;
}

#form2 {
	margin-bottom: 20px;
	padding: 0;
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
			<div class="col-md-5 padd1">
				<form id="passwordForm" class="form-group" name="Forgot"
					method="post" action="Forgot" onsubmit="return match()">
					<h1>Verification</h1>
					<hr>
					<div class="row padd">
						<div class="col-md-12 padd">
							<label for="login">Who're Forgot</label> <select
								class="form-control" name="login" id="login" required>
								<option value="">Select</option>
								<option value="Admin">Admin</option>
								<option value="Faculty">Faculty</option>
								<option value="Student">Student</option>
							</select>
						</div>
						<div class="col-md-12 padd">
							<label for="username"> *Enter Your User Name</label> <input
								class="form-control brc" type="text" name="username"
								id="username" placeholder="username" required>
						</div>
						<div class="col-md-12 ">
							<label for="email"> *Gmail Id</label> <input
								class="form-control brc" type="text" name="email" id="email"
								placeholder="ex:satyammmmm31@gmail.com" required onblur="em()">
							<p id="emailError"></p>
							<button type="submit" class="btnotp1"
								style="margin-bottom: 20px;" onclick="return mail()">Send
								OTP</button>
							<%
							String invalid = (String) request.getAttribute("error");
							%>

							<%
							if (invalid != null) {
							%>
							<p id="ai" style="color: red">
								<%=invalid%></p>


							<%
							}
							%>
							<%
							String msg = request.getParameter("msg");
							%>

							<%
							if (msg != null) {
							%>
							<p id="ai" style="color: #32CD32">
								<%=msg%></p>


							<%
							}
							%>
						</div>
				</form>
			</div>
			<div class="col-md-12 padd1" id="form2">
				<form action="VerifyOtpServlet" method="POST">
					<div class="col-md-12 padd1">
						<label for="otp">Enter the OTP:</label> <input
							class="form-control" type="text" name="otp" id="otp"
							placeholder="otp" required onblur="em()" maxlength="6">
						<button class="btnotp" type="submit">Verify</button>
						<%
						String msg1 = request.getParameter("msg1");
						%>

						<%
						if (msg1 != null) {
						%>
						<p id="ai" style="color: red">
							<%=msg1%></p>
						<%
						}
						%>
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
     
           //  email validation
    const emailInput = document.getElementById('email');
   const emailError = document.getElementById('emailError');

        emailInput.addEventListener('input', () => {
                const emailValue = emailInput.value;
                const emailError = check(emailValue);
            });

            function check(emailValue){

                const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,3}$/;

                    if (!emailPattern.test(emailValue)) {
                        emailError.textContent = 'Please enter a valid email address.';
                        emailError.style.color="red";
                        event.preventDefault(); 
                        
                        
                    } else {
                        emailError.textContent = ' ';
                        
                        
                    }
            }

     

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


 //onblur pass
 function verifypwd1(){
        // document.getElementById("pwd").innerHTML = "";
        document.getElementById("strengthMessage").innerHTML = "";

        
     }
 function em(){
     // document.getElementById("pwd").innerHTML = "";
     document.getElementById("emailError").innerHTML = "";

     
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

   
//onclick
    function mail(){
        var email = document.getElementById("email").value;
        const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,3}$/;

                    if (!emailPattern.test(email)) {
                    	 emailError.textContent = 'Please enter a valid email address.';
                         emailError.style.color="red";
                        return false;
                        
                    } else {
                        return true;
                        
                        
                    }

   }
 
</script>
<script>
    
     // keypress functions.........
      
    //otp
         document.getElementById("otp").addEventListener("keypress",fmeth3);
        function fmeth3(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8||n1==13)){
            event.preventDefault();
        }
     }
    
 
    
</script>
<script>
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

   
</script>
</html>