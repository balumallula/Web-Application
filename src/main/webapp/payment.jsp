<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Major+Mono+Display&display=swap" rel="stylesheet">

    <title> Payment</title>
    <style>
        body{
             background-image: url(./bg6.jpg);
             background-size:cover;
             /* overflow: hidden; */
             color:white;
             font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
             /* text-align:center; */
         }
         img{
          background-color: transparent;
          height: 90px;
          width: 9%;
           float: left;
           align-items: center;
        }
       
 
        .navbar{
            overflow: hidden;  
             text-align:center;
             color: white;
             align-items: baseline;
             /* padding: 20px; */
            background-color:#1F2D5A;
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
       .btns{
              background-image: url(./bg4.png);
              background-size: cover;
             border-radius: 5px;
             height: 42px;
             width: 50%;
             font-size:25px;
             font-weight:bold;
             margin: 20px;
              
         }
          .btns:hover{
          border:solid 2px white;         
         }
           #b1 {
        font-size:20px;
        color: white;
        background-color: #1F2D5A;
        border-radius: 5px;
        width:80px;
        margin-top:5px;
	    }
	    #b1:hover {
	         color: white;
	        background-color:#1f2d5ac5;
	    }
        
        nav h1{
            text-align: center;
            font-family: "Major Mono Display", monospace;   
             }
             h1{
                text-align: center;
             }
        
        form{
        background-color:#1F2D5A;
         border-radius: 10px;
        padding: 15px;
        border: solid 2px;
        border-color: white;
       }
     .container-fluid{
        padding: 70px;
     }
     footer{
        
        background-color:#1F2D5A;
         color: white;
        font-family: "Major Mono Display", monospace;
        position:absolute;
        right:0;
        left:0;
       bottom:0;
       }
       marquee h5{
            
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
         <a href="./admin.jsp"><button type ="button" class="btn" id="b1">Home</button></a>
    
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6 padd1">
                <form id="passwordForm" class="form-group" name="Payment" method="post" action="Payment" >
                    <h1>Payment</h1>
                    <hr>
                    <div class="row padd">
                        <div class="col-md-6">
                            <label for=" studid">*Student Id</label>
                            <input class="form-control brc" type="text" name="studid" id="studid" placeholder=" student id" required>
                                  <%
									String mdm = request.getParameter("mdm");
									%>

									<%
									if (mdm != null) {
									%>
									<p id="ai" style="color: red">
										<%=mdm%></p>
									<%
									}
									
									else if(mdm==""){
										 
									%>
										<p id="ai">
										<%=mdm%></p>

										
									<% }%>
									
									
									
									
                        </div>
                        <div class="col-md-6">
                            <label for="paid">*Amount Paid</label>
                            <input class="form-control brc" type="text" name="paid" id="paid" placeholder=" amount paid" required maxlength="5">
                             <%
									String mf = request.getParameter("mf");
									%>

									<%
									if (mf != null) {
									%>
									<p id="ai" style="color: red">
										<%=mf%></p>
									<%
									}
									%>
                        </div>
                    </div>

                    <div class="row padd">  
                        <div class="col-md-3"></div>  
                        <div class="col-md-6">
                            <label for="paiddate">*Date</label>
                            <input class="form-control brc" type="date" name="paiddate" id="paiddate" placeholder="">
                        </div>
                    </div>
                    <div class="row al">
                        <button type="submit" class="btns">SUBMIT</button>
                    </div>   
                </form>
            </div>  
        </div>
    </div>
</body>
<footer>
    <marquee behavior="" direction="right"><h5>@Satya_Vcube</h5></marquee>
</footer>
<script>
    //keypress id
    document.getElementById("studid").addEventListener("keypress",meth1);
     function meth1(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8||n1==32)){
            event.preventDefault();
        }
     }
   // keypress paid
     document.getElementById("paid").addEventListener("keypress",meth3);
     function meth3(event){
        var n1 = event.which;
        if(!((n1>=48&&n1<=57)||n1==0||n1==8||n1==32)){
            event.preventDefault();
        }
     }
</script>
</html>