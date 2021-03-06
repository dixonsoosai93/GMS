<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.model.masters.ManpowerModel" %>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
if (Manpower == null) {
       Manpower = new ManpowerModel();
       response.sendRedirect("login.jsp");
   }%>  
   <%
   String Report_Type = request.getParameter("Report_Type") != null?request.getParameter("Report_Type"):"";
   %>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
	<title>TATA AIA GMS</title>
	<jsp:include page="head.jsp"></jsp:include>   
	
</head>
<body class="slim__theme">
<div class="vz_main_sec">
	<jsp:include page="InvSidebar.jsp"></jsp:include>
    <jsp:include page="headerRedressalAuthority.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
            <div class="row">
                <div class="col-12">
                   	<div class="card">
                   		<div class = "heading__prdu mb-1">
                       		
                        </div>
                       	<div class="card-body">
                       	<br>
							<div class="row">                      
								<div class="form-group col-md-6 col-lg-4">
									<label for="HierarchyLevel">Hierarchy Level</label>
									<input id="HierarchyLevel" class="form-control" name="HierarchyLevel" type="text" disabled/>
								</div>
								<div class="form-group col-md-6 col-lg-4">
									<label for="InvestigatorName">Redressal Authority Name </label>
									<input id="InvestigatorName" class="form-control" value="<%=Manpower.getNAME()%>" disabled type="text" />
								</div>
								<div class="form-group col-md-6 col-lg-4">
									<label for="InvestigatorEmpID">Redressal Authority Emp ID</label>
									<input id="InvestigatorEmpID" class="form-control" name="InvestigatorEmpID" value="<%=Manpower.getEMPLOYEE_ID() %>" disabled type="text" />
								</div>
							</div>
							<input type="hidden" id="reportType" value="<%=request.getParameter("Report_Type")%>" >	                                         
                            <br>
                            <label for="message">Please click on any of the below button to retrieve respective data.</label>
							<div class="row csmRad">
								<div class="col-lg-4 col-md-6 col-sm-12">
								  <div class="form-group mb-4">
								    <div class="custom-control custom-theme1 custom-radio pl-0">
								      <input type="radio" class="custom-control-input" id="activeCases" name="Report_Type" value="A" <%if(Report_Type != "" && Report_Type == null){%>checked<% } %>>
								      <label class="d-flex align-items-center border p-2 pr-5" for="activeCases">
								        <span class="radioIcon"><img src="images/Active-Cases.png"></span>
								        <div class="flex-fill ml-3"><p class="m-0">Active Cases</p></div>
								      </label>
								    </div>
								  </div>
								</div>
                                  <div class="col-lg-4 col-md-6 col-sm-12">
                                    <div class="form-group mb-4">
                                      <div class="custom-control custom-theme1 custom-radio pl-0">
                                        <input type="radio" class="custom-control-input" id="activeCases2" name="Report_Type" value="F" <%if(Report_Type != "" && Report_Type == "B"){%>checked<% } %>>
                                        <label class="d-flex align-items-center border p-2 pr-5" for="activeCases2">
                                          <span class="radioIcon"><img src="images/Forecasted-Cases.png"></span>
                                          <div class="flex-fill ml-3"><p class="m-0">Forecasted Cases</p></div>
                                        </label>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="col-lg-4 col-md-6 col-sm-12">
                                    <div class="form-group mb-4">
                                      <div class="custom-control custom-theme1 custom-radio pl-0">
                                        <input type="radio" class="custom-control-input" id="activeCases3" name="Report_Type" value="C" <%if(Report_Type != "" && Report_Type == "C"){%>checked<% } %>>
                                        <label class="d-flex align-items-center border p-2 pr-5" for="activeCases3">
                                          <span class="radioIcon"><img src="images/Closed-Cases.png"></span>
                                          <div class="flex-fill ml-3"><p class="m-0">Closed Cases</p></div>
                                        </label>
                                      </div>
                                    </div>
                                  </div>
                                </div>  
                                <h4 class="card_title text-center text-uppercase mb-0">Daily Diary & Proof Upload</h4>  
							<div class="table-responsive darkH datatable-primary">
								<table style="width:100%;"  id="Grv_Report" class="text-center table" style="width:100%;">
									<thead class="text-uppercase">
										<tr>
											<th>S.No.</th>
										    <th>Grievance Date</th>
										    <th>Grv ID (Header ID)</th>
										    <th>Grievance Reference Number</th>
										    <th style="display:none">Grv Number(TALIC & Employee Grievance Ref No)</th>
										    <th>Employee ID</th>
										    <th>Employee Name(Aggrieved Employee)</th>
										    <th>Respondent Employee ID</th>
										    <th>Respondent Name</th>
										    <th>TAT Days-Start Date</th>
										    <th>TAT Days-End Date</th>
										    <th>Employee Type(Active-Emp or Ex-Emp)</th>
										    <th>Grievance Description (brief 50 chars)</th>
										    <th>CASE ID</th>
										    <th>Daily Diary</th>
										    <th>Decision Report</th>
											<th>Final Verdict(Email to Aggrieved Employee, Respndnt & Redressal Authority)</th>
										</tr>  
                            		</thead>     
                            		<tbody id="report_result">
									</tbody>
                        		</table>
                    		</div>
                            <div class="form-group col-md-12 col-lg-12 text-right">
       							<button type="button" class="btn btn-light" id="back" style = "margin-top: 10px;">Back</button>
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
<div class="col-lg-6 stretched_card" style="display:none">
 <button type="button" class="btn btn-success mt-2 sweet_success_btn">Success Message</button>
</div> 
<script type="text/javascript">
	 $(function() {
	 	$('body').addClass('slim__theme');
	 });
	 
	 $('#back').click(function(){
			location.href ="DailyDairyUpdationList.jsp";			
	 });
</script>
<script>
$(document).ready(function(){
	$('input[type=radio]').on('change', function() {
		var Report_Type = $("input[name='Report_Type']:checked").val();
		console.log("Report_Type"+Report_Type);
		<%String repoType = null;%>
		
	});
});
</script>
<script>
$(document).ready(function(){
	$('input[type=radio]').on('change', function() {
		var Report_Type = $("input[name='Report_Type']:checked").val();
		var Investigator_Id=$("#InvestigatorEmpID").val();
		 $.ajax({
	         type:'post',
	         url : 'GetInvReport',
	         data : {'Report_Type':Report_Type,'Investigator_Id':Investigator_Id},
	         dataType : 'JSON',
	         success : function(result){
	         	if(result.status == 200){
	         		$("#report_result").html("");
	         		$("#report_result").html(result.data);
	         		$('#Grv_Report').DataTable();
	         		/*$('#Grv_Report').DataTable({ 
						scrollY: '50vh',
						"destroy": true,
					 });*/
	         		console.log("hello1");
	         	} else {
	         		$("#report_result").html("");
	         	}
	         }
	     }); 
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function(){
		var invId = <%=Manpower.getEMPLOYEE_ID() %>;
        $.ajax({
            type:'post',
            url : 'GetHierLevel',
            data : {'invId':invId},
            dataType : 'JSON',
            success : function(result){
            	if(result.status == 200){
            		let HierarchyLevel = result["HierarchyLevel"];
            		$('#HierarchyLevel').val(HierarchyLevel);
            	} else {
            		console.log("error while feching a branch data from Procedure.");
            	}
            }
        }); 
	});
</script>
<script>
	$(document).ready(function(){
		var Report_Type = $("#reportType").val();
		var Investigator_Id=$("#InvestigatorEmpID").val();
		if(Report_Type == null || Report_Type == ""){
			return false;
		} else{
			$.ajax({
		        type:'post',
		        url : 'GetInvReport',
		        data : {'Report_Type':Report_Type,'Investigator_Id':Investigator_Id},
		        dataType : 'JSON',
		        success : function(result){
		        	if(result.status == 200){
		        		$("#report_result").html("");
		        		$("#report_result").html(result.data);
		        		 /*$('#Grv_Report').DataTable({ 
							scrollY: '50vh',
							"destroy": true,
						 });*/
		        		 console.log("hello");
		        		$('#Grv_Report').DataTable();
		        	} else {
		        		$("#report_result").html("");
		        	}
		        }
		    }); 
		}
	});
</script>
</body>
</html>
