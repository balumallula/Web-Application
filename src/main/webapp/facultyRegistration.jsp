
<%@page import="java.sql.*"%>
<%@ page import="com.Model.FacultyModel"%>
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
<script src="./facultyjs.js"></script>
<title>Faculty Registration</title>
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

.mynav {
	overflow: hidden;
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

a {
	margin-left: 10px;
	color: black;
	font-size: 20px;
	color: green;
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

.btns:hover {
	border: solid 2px white;
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
	margin-bottom: 50px;
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

.img2 img {
	height: 18px;
	width: 6%;
	margin-top: -26px;
	display: flex;
	float: right;
	margin-right: 7px;
	cursor: pointer;
}
</style>

</head>
<body>

	<nav class="navbar">
		<img src="./vcube-logo.png" alt="">
		<h1>Vcube Software Solutions</h1>
	</nav>

	<div class="container">
		<a href="./admin.jsp"><button type="button" class="btn" id="b1">Home</button></a>

		<div class="row">

			<div class="col-md-2"></div>
			<div class="col-md-8 padd1">


				<form id="passwordForm" class="form-group" name="FacultyRegister"
					method="post" action="FacultyRegister" onsubmit=" return match()">
					<h1>Faculty Registration</h1>
					<hr>
					<div class="row padd">
						<div class="col-md-6">
							<label for="firstname"> *Full Name</label> <input
								class="form-control brc" type="text" name="firstname"
								id="firstname" placeholder="firstname" required maxlength="30">
						</div>
						<div class="col-md-6">
							<label for="username">*User Name</label> <input
								class="form-control brc" type="text" name="username"
								id="username" placeholder="username" maxlength="10"
								minlength="6">

							<%
							String invalid = (String) request.getAttribute("invalid");
							%>

							<%
							if (invalid != null) {
							%>
							<p style="color: red">
								<%=invalid%></p>


							<%
							}
							%>
						</div>

					</div>
					<div class="row ">

						<div class="col-md-6 img2">
							<label for="password"> *Password</label> <input
								class="form-control brc" type="password" name="password"
								id="password" placeholder="password" onfocus="disppwd()"
								onblur="verifypwd1()" maxlength="10" minlength="6"> <img
								src="./eye-close.png" alt="" id="eye" onclick="show()">
							<p id="strengthMessage" class="message"></p>
						</div>
						<div class="col-md-6 img2">
							<label for="confirm-password"> *Confirm Password</label> <input
								class="form-control brc" type="password" name="confirm-password"
								id="confirm-password" placeholder="confirm password"
								onblur="match()" required maxlength="10"> <img
								src="./eye-close.png" alt="" id="ceye" onclick="show2()">
							<p id="cpwd"></p>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<label for="email"> *Gmail Id</label> <input
								class="form-control brc" type="text" name="email" id="email"
								placeholder="ex:satyammmmm31@gmail.com" required onblur="em()">
							<p id="emailError"></p>
						</div>
						<div class="col-md-6">
							<label for="mobile"> *Mobile</label> <input
								class="form-control brc" type="text" name="mobile" id="phone"
								placeholder=" " required maxlength="10" minlength="10">
						</div>
					</div>

					<div class="row padd">
						<div class="col-md-6">
							<label for="gender"> *Gender</label> <select
								class="form-control brc" id="gender" name="gender" required>
								<option value="">Select</option>
								<option value="Male">Male</option>
								<option value="Female">Female</option>
							</select>
						</div>
						<div class="col-md-6">
							<label for="exp"> *Years of Experience</label> <input
								class="form-control brc" type="text" name="exp" id="exp"
								placeholder=" " required maxlength="2" :>
						</div>
					</div>
					<div class="row padd">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<label for="course">*Course</label> <select
								class="form-control brc" name="course" id="course" required>
								<option value="">Select</option>
								<%
								List<CourseModel> clist = (List<CourseModel>) session.getAttribute("dclist");

								if (clist != null) {
									for (CourseModel course : clist) {

										int cid = course.getCid();
										String cname = course.getCoursename();

										out.println("<option value=" + cid + ">" + cname + "</option>");

									}

								}
								%>
							</select>
						</div>
					</div>




					<div class="row al">
						<button type="submit" class="btns" onclick="return mail()">SUBMIT</button>
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

    
     // keypress functions.........
      //firstname
      document.getElementById("firstname").addEventListener("keypress",meth1);
     function meth1(event){
        var n1 = event.which;
        if(!((n1>=65&&n1<=90)||(n1>=97&&n1<=122)||n1==0||n1==8||n1==32)){
            event.preventDefault();
        }
     }

     //mobile
     document.getElementById("phone").addEventListener("keypress",meth3);
     function meth3(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8)){
            event.preventDefault();
        }
     }
     //exp
     document.getElementById("exp").addEventListener("keypress",meth3);
     function meth3(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8)){
            event.preventDefault();
        }
     }
      //fathermobile
      document.getElementById("fmobile").addEventListener("keypress",meth3);
     function meth3(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8)){
            event.preventDefault();
        }
     }

     //batch
     document.getElementById("batch").addEventListener("keypress",meth4);
     function meth4(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8||n1==32)){
            event.preventDefault();
        }
     }
     //fathername
     document.getElementById("fathername").addEventListener("keypress",meth1);
     function meth1(event){
        var n1 = event.which;
        if(!((n1>=65&&n1<=90)||(n1>=97&&n1<=122)||n1==0||n1==8||n1==32)){
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