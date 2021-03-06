<%@page import="com.gms.model.masters.ManpowerModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    } 
  %>
<head>
 <title>TATA AIA GMS</title>
     <jsp:include page="head.jsp"></jsp:include>
</head>
<div class="vz_main_sec">
    <nav class="vz_navbar navbar-collapsed">
	        <div class="navbar-wrapper">
	            <div class="navbar-content scroll-div">
	                <div class="vz_navigation">
	                    <ul class="sidebar nav flex-column">
	                        <li class="active"><a class="nav-link text-center" href="EmployeeGLP.jsp" data-nav="staffConduct"><span>Employee Grievance</span></a></li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	    </nav>
    <jsp:include page="headerEmployeeGrivence.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
    		<div class="row">
        		<div class="col-12">
            		<div class="card">
						<div class="card-body">
							<h1 class="card_title text-center text-uppercase mb-5">Employee Grievance</h1>
							<div class="row csmRadEmployeeGrv">
								<div class="col-md-3 text-center">
									<a href="#">
										<img class="iconSet2 d-block mx-auto mb-2" src="images/Raised-Employee-Grievance.png" >
								        <p class="m-0">Raise Employee Grievance</p>
							        </a>
						        </div>
								<div class="col-md-3 text-center">
									<a href="#">
										<img class="iconSet2 d-block mx-auto mb-2" src="images/View-Grievance-History.png" >
								        <p class="m-0">View Grievance History</p>
							        </a>
						        </div>
								<div class="col-md-3 text-center">
									<a href="#">
										<img class="iconSet2 d-block mx-auto mb-2" src="images/View-Grievance-Policy.png" >
								        <p class="m-0">View Grievance Policy</p>
							        </a>
						        </div>
								<div class="col-md-3 text-center">
									<a href="#">
										<img class="iconSet2 d-block mx-auto mb-2" src="images/View Good-Conduct-Policy.png" >
								        <p class="m-0">View Good conduct Policy</p>
							        </a>
						        </div>
								  <div class="form-group mb-4 d-none">
								    <div class="custom-control custom-theme1 custom-radio pl-0">
								      <input type="button" class="custom-control-input">
								      <label class="d-flex align-items-center border p-3 pr-5" for="raiseEmployeeGrievance" id="raiseEmployeeGrievance">
								        <span class="radioIcon"  ><img src="images/Raised-Employee-Grievance.png" ></span>
								        <div class="flex-fill ml-3"><p class="m-0">Raise Employee Grievance</p></div>
								      </label>
								    </div>
								  </div>
                                <div class="col-md-12 text-center d-none">
                                  <div class="form-group mb-4">
                                    <div class="custom-control custom-theme1 custom-radio pl-0">
                                      <input type="button" class="custom-control-input">
                                      <label class="d-flex align-items-center border p-3 pr-5" for="addGrievance" id="addGrievance">
                                        <span class="radioIcon"><img src="images/View-Grievance-History.png"></span>
                                        <div class="flex-fill ml-3"><p class="m-0">View Grievance History</p></div>
                                      </label>
                                    </div>
                                  </div>
                                </div>
                                <div class="col-md-12 text-center d-none">
                                  <div class="form-group mb-4">
                                    <div class="custom-control custom-theme1 custom-radio pl-0">
                                      <input type="button" custom-control-input">
                                      <label class="d-flex align-items-center border p-3 pr-5" for="GrievancePolicy" id="GrievancePolicy">
                                        <span class="radioIcon"><img src="images/View-Grievance-Policy.png"></span>
                                        <div class="flex-fill ml-3"><p class="m-0">View Grievance Policy</p></div>
                                      </label>
                                    </div>
                                  </div>
                                </div>
                                <div class="col-md-12 text-center d-none">
                                  <div class="form-group mb-4">
                                    <div class="custom-control custom-theme1 custom-radio pl-0">
                                      <input type="button" class="custom-control-input">
                                      <label class="d-flex align-items-center border p-3 pr-5" for="Policy" id="Policy">
										<span class="radioIcon"><img src="images/View Good-Conduct-Policy.png"></span>
                                        <div class="flex-fill ml-3"><p class="m-0">View Good conduct Policy</p></div>		
                                      </label>
                                    </div>
                                  </div>
                                </div>
                            </div>
						</div>
					</div>
        		</div>
    		</div>
		</div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		$("#raiseEmployeeGrievance").click( function(){
			location.href ="EmployeeGrievance.jsp";			
		});
		$("#addGrievance").click( function(){
			location.href ="EmployeeGrievanceList.jsp";			
		});
		$("#GrievancePolicy").click( function(){
			location.href ="GrievancePolicy.jsp";			
		});
		$("#Policy").click( function(){
			location.href ="Policy.jsp";			
		});
	});
</script>
</body>
</html>