<%@page import="com.gms.dao.masters.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.model.user.*" %>
<%@ page import="com.gms.model.masters.ManpowerModel" %>

<% ManpowerModel Manpower=(ManpowerModel)session.getAttribute("manpower"); 
if (Manpower == null) {
    Manpower = new ManpowerModel();
    response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TATA AIA GMS</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link href="css/feather.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/slicknav.min.css">
    <script src="js/modernizr-2.8.3.min.js"></script>
    <link rel="stylesheet" href="css/metisMenu.css">
    <link rel="stylesheet" href="css/perfect-scrollbar.min.css">
    <link rel="stylesheet" href="css/slicknav.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet">
</head>

<body class="slim__theme">
<div class="vz_main_sec">
	<jsp:include page="sidebar.jsp"></jsp:include>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
<!--             <div class="row"> -->
<!--                 <div class="col-md-4 mb-4"> -->
<!--                     <div class="card card-icon rt_icon_card text-center"> -->
<!--                         <div class="card-body"> -->
<!--                             <span class="heading_icon"> -->
<!--                                 <img src="images/icon-bg.png" alt="Icon"> -->
<!--                                 <i class="fa fa-briefcase"></i> -->
<!--                             </span> -->
<!--                             <div class="icon_specs"> -->
<!--                                 <p>Total Manpower </p> -->
<!--                                 <span> -->
<%--                                 <%=ManpowerModel.getCount()%> --%>
<!--                                 </span> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-md-4 mb-4"> -->
<!--                     <div class="card card-icon rt_icon_card text-center"> -->
<!--                         <div class="card-body"> -->
<!--                             <span class="heading_icon"> -->
<!--                                 <img src="images/icon-bg.png" alt="Icon"> -->
<!--                                 <i class="fa fa-file"></i> -->
<!--                             </span> -->
<!--                             <div class="icon_specs"> -->
<!--                                 <p>Total Licenses</p> -->
<!--                                 <span> -->
<%--                                 <%=LicenseModel.getCount()%> --%>
<!--                                 </span> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-md-4 mb-4"> -->
<!--                     <div class="card card-icon rt_icon_card text-center"> -->
<!--                         <div class="card-body"> -->
<!--                             <span class="heading_icon"> -->
<!--                                 <img src="images/icon-bg.png" alt="Icon"> -->
<!--                                 <i> -->
<!--                                     <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 60 60" style="fill: #5e2572; enable-background:new 0 0 30 30;" xml:space="preserve" width="30px" height="30px" > -->
<!--                                         <polygon points="49,12 49,0 6,0 6,55 9,55 9,3 40,3  "/> -->
<!--                                         <path d="M39.414,5H11v55h43V19.586L39.414,5z M20,17h10c0.552,0,1,0.447,1,1s-0.448,1-1,1H20c-0.552,0-1-0.447-1-1S19.448,17,20,17 -->
<!--                                         z M45,51H20c-0.552,0-1-0.447-1-1s0.448-1,1-1h25c0.552,0,1,0.447,1,1S45.552,51,45,51z M45,43H20c-0.552,0-1-0.447-1-1 -->
<!--                                         s0.448-1,1-1h25c0.552,0,1,0.447,1,1S45.552,43,45,43z M45,35H20c-0.552,0-1-0.447-1-1s0.448-1,1-1h25c0.552,0,1,0.447,1,1 -->
<!--                                         S45.552,35,45,35z M45,27H20c-0.552,0-1-0.447-1-1s0.448-1,1-1h25c0.552,0,1,0.447,1,1S45.552,27,45,27z M38,21V7l14,14H38z"/> -->
<!--                                     </svg> -->
<!--                                 </i> -->
<!--                             </span> -->
<!--                             <div class="icon_specs"> -->
<!--                                 <p>Total Form</p> -->
<!--                                 <span> -->
<%--                                 <%=FormModel.getCount()%> --%>
<!--                                 </span> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-md-4 mb-4"> -->
<!--                     <div class="card card-icon rt_icon_card text-center"> -->
<!--                         <div class="card-body"> -->
<!--                             <span class="heading_icon"> -->
<!--                                 <img src="images/icon-bg.png" alt="Icon"> -->
<!--                                 <i class="fa fa-users"></i> -->
<!--                             </span> -->
<!--                             <div class="icon_specs"> -->
<!--                                 <p>Member Head Count</p> -->
<!--                                 <span> -->
<%--                                 <%=BranchModel.getCount()%> --%>
<!--                                 </span> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-md-4 mb-4"> -->
<!--                     <div class="card card-icon rt_icon_card text-center"> -->
<!--                         <div class="card-body"> -->
<!--                             <span class="heading_icon"> -->
<!--                                 <img src="images/icon-bg.png" alt="Icon"> -->
<!--                                 <i class="fa fa-book"></i> -->
<!--                             </span> -->
<!--                             <div class="icon_specs"> -->
<!--                                 <p>Total Act</p> -->
<!--                                 <span>  -->
<%--                             	<%=ActModel.getCount()%> --%>
<!--                                 </span> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-md-4 mb-4"> -->
<!--                     <div class="card card-icon rt_icon_card text-center"> -->
<!--                         <div class="card-body"> -->
<!--                             <span class="heading_icon"> -->
<!--                                 <img src="images/icon-bg.png" alt="Icon"> -->
<!--                                 <i class="fa fa-bullhorn"></i> -->
<!--                             </span> -->
<!--                             <div class="icon_specs"> -->
<!--                                 <p>Total Complaint</p> -->
<!--                                 <span> -->
<%--                                 <%=ComplaintModel.getCount() %> --%>
<!--                                 </span> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->

<!--             <div class="row"> -->
<!--                 <div class="col-lg-6 mb-4 stretched_card"> -->
<!--                     <div class="card"> -->
<!--                         <div class="card-body"> -->
<!--                             <div class="card_title d-flex flex-wrap justify-content-between align-items-center"> -->
<!--                                 <div> -->
<!--                                     <h4 class="card_title mb-0">License Validity Status</h4> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <div id="licenseValidityStatus" class="high-chart"></div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-lg-6 mb-4 stretched_card"> -->
<!--                     <div class="card"> -->
<!--                         <div class="card-body"> -->
<!--                             <div class="card_title d-flex flex-wrap justify-content-between align-items-center"> -->
<!--                                 <div> -->
<!--                                     <h4 class="card_title mb-0">License Expiry Status</h4> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                             <div id="licenseExpiryStatus" class="high-chart"></div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
        </div>
    </div>
  <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
