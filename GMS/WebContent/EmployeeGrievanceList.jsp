<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gms.model.grievance.HdGrievanceModel" %>
<%@page import="com.gms.dao.grievance.EmployeeGrievanceDAO"%>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.model.user.MenuRole" %>
<%@ page import="com.gms.commons.Common" %>
  <%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
    <title>TATA AIA GMS</title>
    <jsp:include page="head.jsp"></jsp:include>
    <style>
	.table_setp .dataTables_wrapper .dataTables_filter { float: left !important; }
</style> 
</head>
<body class="slim__theme">
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
                <div class="col-lg-12 stretched_card mb-4">
                    <div class="card">
                        <div class="card-body">
                        <h4 class="card_title text-center text-uppercase mb-0">Employee Grievance-Aggrieved employee</h4>
	                         <div class="btnPosi">
	                          	<div class="rightpageBtn">
	                          		<a style="position: relative;" href="#" id="addGrievance">
									<span title="" data-toggle="popover" data-trigger="hover" data-content="Add Employee Grievance">
									<small style=" color: black;">Click here to raise Grievance</small>
										<i class="fa fa-plus-circle"></i>
									</span>
								</a>
							   </div>
							 </div>
                            <div class="single-table">
								<div class="table-responsive datatable-primary table_setp" id="grievanceDt">
							     	<table style="width:100%;"  id="dataTable2" class="text-center mt-0 mx-0 w-100">
                                      	<thead class="text-uppercase">
                                            <tr>
                                            <th scope="col">Sno</th>
		                                    <th>Grievance Date</th>
		                                    <th>GRVID (Header ID)</th>
		                                    <th>GRVNUMBER(TALIC & Employee Grievance Ref No)</th>
		                                    <th>Employee ID</th>
		                                    <th>Employee Name</th>
		                                    <th>Employee Type(Active-Emp or Ex-Emp)</th>
		                                    <th>Grievance Type</th>
		                                    <th>IS ACTIVE</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <% 
                                        int i=1;
                                        String id=Manpower.getEMPLOYEE_ID();
                                        List<HdGrievanceModel> list= EmployeeGrievanceDAO.gethdGrievanceEmp(id);
                                        if(list !=null){
                                        	for(HdGrievanceModel item :list){
                                        %>
		                                <tr>
		                                  <td><%=i%></td>
		                                  <td><%=Common.StringToDate(item.getGRVDATE())%></td>
		                                  <td style="text-decoration: underline;"><a data-toggle="popover" data-trigger="hover" data-content="Click on the GRVID (Header ID) to get the details" class="sendIdData" href="javascript:void();" data-id="<%=item.getGRVID()%>"><%=item.getGRVID()%></a></td>
		                                  <td><%=item.getGRVNUMBER()%></td>
		                                  <td><%=item.getCOMPLIANT_EMPLOYEE_ID()%></td>
		                                  <td><%=item.getCOMPLIANT_EMPLOYEE_NAME()%></td>
		                                  <td><%=item.getGRIEVANCE_TYPE()%></td>
		                                  <td><button style="width: 100%; height: 40px;" type="button" class="btn btn-primary empId" data-id="<%=item.getGRVID()%>" data-toggle="modal" data-target="#exampleModalCenter"><%=item.getCOMPLIANT_EMPLOYEE_TYPE()%></button></td>
		                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
										</tr>
										<%
												i++;
                                        	}}
										%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="form-group col-md-12 col-lg-12 text-right">
          						<button type="button" class="btn btn-light" id="back" style = "margin-top: 10px;">Back</button>
      						</div> 
                        </div>
                    </div>
                </div>
                <div class="col-lg-12 stretched_card mb-4">
                    <div class="card">
                    <h4 class="card_title text-center text-uppercase mb-0">Preview</h4>
                        <div class="card-body">
                            <div class="single-table">
								<div class="table-responsive datatable-primary table_setp" id="grievanceDt">
							     	<table style="width:100%;" id="grievance" class="text-center mt-0 mx-0 w-100">
                                      	<thead class="text-uppercase">
                                            <tr>
                                                <th>S.No</th>
												<th>GRVID (HDR ID)</th>
												<th>GRV Reference Number</th>
												<th>Aggrieved Employee Category</th>
												<th>Aggrieved Employee Sub-Category</th>
												<th>Aggrieved Main Category Name</th>
												<th>Aggrieved Sub-Category Name</th>
												<th>Employee Type(Active-Emp or Ex-Emp)</th>
												<th>Complainant Against ID(Active-Emp or Ex-Emp)</th>
												<th>Complainant Against Name</th>
												<th>Aggrieved Employee Description</th>
												<th>Case Number (TALIC's)</th>
												<th>Default Hierarchy Code</th>
												<th>Start Hierarchy Code</th>
												<th>Aggrieved Employee Status</th>
												<th>Reopen Closed Case</th>
                                            </tr>
                                        </thead>
                                        <tbody id="grievance-dt">  
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <jsp:include page="footerList.jsp"></jsp:include>
    </div>
</div>
<div class="modal fade show" id="exampleModalCenter" style="display: none; padding-right: 17px;">                        
	<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
		<div class="modal-content">
          	<form id="addGrievanceHandlingTatMaster" action="CreateGrievanceHandlingTatMaster" method="post">
				<div class="modal-header">
                   <h5 class="modal-title text-right">Group Of Employee</h5>
              	</div>
				     <div class="modal-body">
                         <div class="table-responsive datatable-primary">
		    		      <table style="width:100%;"  id="dataTable" class="text-center">
                          <thead class="text-uppercase">
                          	<tr>
                                <th>Sno</th>
                                <th>Employee ID</th>
                                <th>Name</th>
                                <th>Designation</th>
                                <th>Department</th>
                          	</tr>
                          </thead>
                          <tbody id="empGroup"></tbody>
                          </table>  
                       </div> 
                   </div>
               <div class="modal-footer">
                   <button type="button" class="btn btn-light" id="cancel" data-dismiss="modal">CANCEL</button>
               </div>
			</form>    
		</div>
	</div>
</div>
<script>
    $("#grievanceDt").on('click','.sendIdData', function() {
	        var GRVID = $(this).data('id');
	        $.ajax({
	            type:'post',
	            url : 'GetGrievanceDt',
	            data : {GRVID:GRVID},
	            dataType : 'JSON',
	            success : function(result)
	            {	
	            	if(result.status == 200){
	            		$("#grievance-dt").html(result.data);
	            		$("#grievance").dataTable().fnDestroy()
	            	} else {
	            		$("#grievance-dt").html("");
	            	}
	            }
	        });  
    });
</script>
<script>
    $("#grievanceDt").on('click','.empId', function() {
	        var GRVID = $(this).data('id');
	        $.ajax({
	            type:'post',
	            url : 'GetGroupOfEmployee',
	            data : {GRVID:GRVID},
	            dataType : 'JSON',
	            success : function(result)
	            {
	            	if(result.status == 200){
	            		$("#empGroup").html("");
	            		$("#empGroup").html(result.data);
	            	} else {
	            		$("#empGroup").html("");
	            	}
	            }
	        });  
    });
</script>
<script>
	$(document).ready(function(){
		document.getElementById("addGrievance").onclick = function(){
	 		location.href ="EmployeeGrievance.jsp";
	 	};
		$(function() {
			$('body').addClass('slim__theme');
		});
	});
</script>
<script type="text/javascript">
	$("#cancel").click(function(){
		$("#dataTable TBODY TR").remove();
	});
	$('#back').click(function(){
		location.href ="EmployeeGLP.jsp";			
	});
</script>
<script type="text/javascript">
    $('.sendIdData').click(function () {
        $('html, body').animate({scrollTop:$(document).height()}, 'slow');
    });	
</script>
<script>
	$("body").on("click", ".reopenCase", function () {
		var detId = $(this).data('key1');
		console.log("detId :"+detId)
		if (confirm("Are You Sure You Want To Reopen?") == true) {
		      $.ajax({
		    	    type:'post',
		    	    url : 'GrvEmpReopen',
		    	    data : {'detId':detId},
		    	    dataType : 'JSON',
		    	    success : function(result)
		    	    {
		    	    	if(result.status == 200){
		    	    		window.location = "EmployeeGrievanceList.jsp";
		    	    	} else {
		    	    		window.location = "EmployeeGrievanceList.jsp";
		    	    	}
		    	    }
		    	});
		} else {
		    alert("canceled");
		}
	});
</script>
</body>
</html>
