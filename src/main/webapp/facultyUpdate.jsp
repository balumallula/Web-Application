
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
<script src="./studjs.js"></script>

<title>Faculty Details Update</title>
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

		<h1>Update Faculty</h1>
		<form id="passwordForm" class="form-group" name="FacultyUpdate"
			method="post" action="FacultyUpdate" onsubmit="return mail()">

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
				List<FacultyModel> list = (List<FacultyModel>) request.getAttribute("list");

				if (list != null) {
					for (FacultyModel faculty : list) {
				%>
				<tr>
					<td><input class="form-control brc" type="text"
						value="<%=faculty.getFid()%>" name="fid" id="fid"
						placeholder="Faculty ID" required readonly></td>

					<td><input class="form-control brc" type="text"
						value="<%=faculty.getFirstname()%>" name="fullname" id="fullname"
						placeholder="fullname" maxlength="30" required></td>
					<td><input class="form-control brc" type="text"
						value="<%=faculty.getMobile()%>" name="mobile" id="mobile"
						placeholder="Phone" required maxlength="10" minlength="10">

					</td>
					<td><input class="form-control brc" type="text"
						value="<%=faculty.getEmail()%>" name="email" id="email"
						placeholder="ex:satyammmmm31@gmail.com" required onblur="em()">
						<p id="emailError"></p></td>
					<td><input class="form-control brc"
						value="<%=faculty.getGender()%>" id="gender" name="gender"
						required></td>
					<td><input class="form-control brc" type="text"
						value="<%=faculty.getExp()%>" name="fexp" id="fexp"
						placeholder=" " required></td>


					<td><select class="form-control brc" type="text" name="course"
						id="course">
							<option value="<%=faculty.getCourse()%>"><%=faculty.getCourse()%>
							</option>
							<%
							List<CourseModel> clist = (List<CourseModel>) request.getAttribute("courselist");

							if (clist != null) {
								for (CourseModel course : clist) {

									int cid = course.getCid();
									String cname = course.getCoursename();

									out.println("<option value=" + cid + ">" + cname + "</option>");

								}

							}
							%>

					</select></td>
					<td><a href=><button type="submit" class="btn" id="b3">Save</button></a></td>

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
                        emailError.textContent = 'Invalid';
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
                    	 emailError.textContent = 'Invalid';
                         emailError.style.color="red";
                        return false;
                        
                    } else {
                    	
                        return true;
                        
                        
                    }

   }
 
</script>
<script>
    
     // keypress functions.........
      //fathername
      document.getElementById("fathername").addEventListener("keypress",fnmeth);
     function fnmeth(event){
        var n1 = event.which;
        if(!((n1>=65&&n1<=90)||(n1>=97&&n1<=122)||n1==0||n1==8||n1==32)){
            event.preventDefault();
        }
     }
         //sid
         document.getElementById("sid").addEventListener("keypress",fmeth3);
        function fmeth3(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8)){
            event.preventDefault();
        }
     }
        //fathermobile
        document.getElementById("fmobile").addEventListener("keypress",fmeth3);
       function fmeth3(event){
       var n1 = event.which;
       if(!((n1>=48&&n1<=57)||n1==0||n1==8)){
           event.preventDefault();
       }
    }
        // mobile
        document.getElementById("mobile").addEventListener("keypress",fmeth3);
       function fmeth3(event){
       var n1 = event.which;
       if(!((n1>=48&&n1<=57)||n1==0||n1==8)){
           event.preventDefault();
       }
    }
      //firstname
      document.getElementById("fullname").addEventListener("keypress",fmeth);
     function fmeth(event){
        var n1 = event.which;
        if(!((n1>=65&&n1<=90)||(n1>=97&&n1<=122)||n1==0||n1==8||n1==32)){
            event.preventDefault();
        }
     }

     //mobile
     document.getElementById("mobile").addEventListener("keypress",pmeth);
     function pmeth(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8)){
            event.preventDefault();
        }
     }
     
   

     //branch
     document.getElementById("branch").addEventListener("keypress",bmeth);
     function bmeth(event){
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