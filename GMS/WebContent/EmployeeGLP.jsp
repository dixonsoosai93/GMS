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
	                        <li class="active"><a class="nav-link text-center" href="EmployeeGLP.jsp" data-nav="staffConduct"><i class="fa fa-home"></i><span>Employee Grievance</span></a></li>
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
							<div class="employeeGLPCard">
				            	<div class="row m-0 csmRadEmployeeGrv">
				                    <div class="col-lg-6 p-0 login50card">
				                    	<div class="form-group mb-0 w-100 h-100">
											<a class="aSetBa d-block border d-flex align-items-center justify-content-center p-3 h-100" href="EmployeeGrievance.jsp">
												<span class="radioIcon2 mr-3"><img src="images/Raised-Employee-Grievance.png"></span>
										        <p class="m-0">Raise Employee Grievance</p>
									        </a>
										  </div>
				                    </div>
				                    <div class="col-lg-6 p-0 login50card">
				                    	<div class="form-group mb-0 w-100 h-100">
											<a class="aSetBa d-block border d-flex align-items-center justify-content-center p-3 h-100" href="EmployeeGrievanceList.jsp">
												<span class="radioIcon2 mr-3"><img src="images/View-Grievance-History.png"></span>
										        <p class="m-0">View Grievance History</p>
									        </a>
										  </div>
				                    </div>
				                    <div class="col-lg-6 p-0 login50card">
				                    	<div class="form-group mb-0 w-100 h-100">
											<a class="aSetBa d-block border d-flex align-items-center justify-content-center p-3 h-100" href="GrievancePolicy.jsp">
												<span class="radioIcon2 mr-3"><img src="images/View-Grievance-Policy.png"></span>
									        <p class="m-0">View Grievance Policy</p>
									        </a>
										  </div>
				                    </div>
				                    <div class="col-lg-6 p-0 login50card">
				                    	<div class="form-group mb-0 w-100 h-100">
											<a class="aSetBa d-block border d-flex align-items-center justify-content-center p-3 h-100" href="Policy.jsp">
												<span class="radioIcon2 mr-3"><img src="images/View Good-Conduct-Policy.png"></span>
									        <p class="m-0">View Good conduct Policy</p>
									        </a>
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