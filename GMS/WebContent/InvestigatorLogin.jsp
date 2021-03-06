<%@page import="java.util.List"%>
<%@page import="com.gms.model.user.Admin"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link href="css/feather.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/metisMenu.css">
    <link rel="stylesheet" href="css/perfect-scrollbar.min.css">
    <link rel="stylesheet" href="css/slicknav.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet">
</head>
<body class="slim__theme">

<div class="limiter">
    <div class="container-login100">
    <%
            HashMap<String,String> errors = (HashMap)session.getAttribute("errors");
            session.removeAttribute("errors");               
        %>
        <div class="wrap-login100">
            <form class="login100-form validate-form" action="InvLogin" method="post">
            	<h1 class="mx-3 mx-md-5 mb-3 mb-md-5 mt-0 hrComplince">Grievance Management System</h1>
                <div class="login-form-body text-center p-4">
                    <div class="form-gp">
                        <label for="Inv_Id">Investigator Id</label>
                        <input type="text" id="Inv_Id" name="Inv_Id">
                        <i class="ti-email"></i>
                        <span class="error">
                 			<% if(errors!=null && errors.containsKey("adminId")){
                 				out.println("<div style=\"color:#cd5c5c ;font-size: 12px\">"+errors.get("adminId")+"</div>");
                       		} %>
               			</span>
                    </div>
                    <div class="form-gp">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password">
                        <i class="ti-lock"></i>
                        <span class="error">
                  			<%  if(errors!=null && errors.containsKey("password")){
                  				out.println("<div style=\"color:#cd5c5c ;font-size: 12px\">"+errors.get("password")+"</div>");
                        	} %>
                		</span> 
                    </div>
                    <div class="submit-btn-area">
                        <button id="form_submit" type="submit" class="btn btn-primary">Submit<i class="ti-arrow-right"></i></button>
                    </div>
                    <div class="submit-btn-area" style="margin-top:20px;">
                        <button type="button" class="btn btn-light cancel" id="employee">Login As Admin</button>
                    </div>
                    <div class="submit-btn-area" style="margin-top:20px;">
                        <button type="button" class="btn btn-light cancel" id="investigator">Login As Employee</button>
                    </div>
                    <%
	              		if(session.getAttribute("authError")!=null) {
	  	           			 out.println("<p class='text-center'><span class='error'>"+session.getAttribute("authError")+"</span></p>");
	  	            	session.removeAttribute("authError");
	              		} 
             		%>
                </div>
            </form>
            <div class="login100-more">
            	<div class="container-fluid py-2">
					<div class="row">
						<div class="col-md-12 logoLogin">
							<a href="index.jsp"><img src="images/tata-aia-logo.png" class="" alt="Logo"></a>
						</div>
					</div>
				</div>
			            
            	<div class="row mx-md-5">
                    
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/metisMenu.min.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<script src="js/jquery.slicknav.min.js"></script>
<script src="js/jquery.fancybox.pack.js"></script>
<script src="vendors/highcharts/highcharts.js"></script>
<script src="vendors/highcharts/exporting.js"></script>
<script>
    jQuery(document).ready(function ($) {
        $('.form-gp input').on('focus', function() {
            $(this).parent('.form-gp').addClass('focused');
        });
        $('.form-gp input').on('focusout', function() {
            if ($(this).val().length === 0) {
                $(this).parent('.form-gp').removeClass('focused');
            }
        });
    });
</script>
<script>
$('#employee').click(function(){
  	 location.href ="login.jsp"; 
  	 }); 
$('#investigator').click(function(){
 	 location.href ="EmployeeLogin.jsp"; 
 	 });   	 
</script>
</body>
</html>
