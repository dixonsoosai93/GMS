<%@page import="com.gms.model.admin.GrievanceDesc"%>
<%@page import="com.gms.dao.admin.ReopenCaseDAO"%>
<%@page import="com.gms.model.admin.GridCase"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.gms.model.masters.ManpowerModel"%>
<%@page import="com.gms.dao.grievance.EmployeeGrievanceDAO"%>
<%@ page import="com.gms.model.masters.CaseStatusMasterModel" %>
<%@ page import="java.util.*" %>
	<% 
		ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 		if (Manpower == null) {
    	    Manpower = new ManpowerModel();
    	    response.sendRedirect("login.jsp");
    	}
    %>
    <%
    	int grvdetId = (Integer)request.getAttribute("GRVDETID") != null?(Integer)request.getAttribute("GRVDETID"):0;
    	int GRVDETID = request.getParameter("GRVDETID") != null?Integer.parseInt(request.getParameter("GRVDETID")):0;
    	GrievanceDesc GrievanceDesc = ReopenCaseDAO.getGrievanceDesc(GRVDETID);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TATA AIA GMS</title>
<jsp:include page="head.jsp"></jsp:include> 
</head>
<body class="slim__theme">
<div class="vz_main_sec">
		<jsp:include page="sidebar.jsp"></jsp:include>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="vz_main_container">
			<div class="vz_main_content">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class = "heading__prdu mb-1">
	                          		<h4 class="card_title text-center mb-0">REOPEN CLOSED CASE</h4>
	                            </div>
                                <form action="ReopenCaseStatus" style="margin-top: 20px;">     
									<div class="row mb-4">
										<div class="col-md-6 ">
											<div class="form-group">
			                                    <label for=GRVDETID class="col-form-label">Grievance Reference Number</label>
			                                    <div class="d-flex">
			                                        <input class="form-control" type="text" id="GRVDETID" name="GRVDETID" value="<%=GRVDETID != 0?GRVDETID:0%>"  placeholder="Enter Grievance Reference Number" >
				                                    <span style="color: indianred; float: right;"> *</span>
				                                    <div class="flex-fill">
							  						      <button type="button" id="search" class="btn btn-inverse-secondary ml-3"><i class="fa fa-search"></i></button>
							  						</div>
			                                    </div>
			                                </div>
			                                <div class="form-group">
			                                    <label for="GRVID" class="col-form-label">Grievance HD ID</label>
			                                    <input class="form-control" type="text" id="GRVID" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="CASEID" class="col-form-label">Case ID	</label>
			                                    <input class="form-control" type="text" id="CASEID" name="CASEID" readonly>
			                                </div>
			                                <div class="form-group">
			                                    <label  for="CASENO" class="col-form-label">TALIC Case No</label>
			                                    <input class="form-control" type="text" id="CASENO" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="MAIN_CATEGORY_CODE"  class="col-form-label">Main Category Code</label>
			                                    <input class="form-control" type="text"  id="MAIN_CATEGORY_CODE"disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="MAIN_CATEGORY_NAME" class="col-form-label">Main Category Name</label>
			                                    <input class="form-control" type="text" id="MAIN_CATEGORY_NAME" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="SUB_CATEGORY_CODE" class="col-form-label">Sub Category Code</label>
			                                    <input class="form-control" type="text" id="SUB_CATEGORY_CODE" disabled>
			                                </div>
			                                <div class="form-group">
			                                    <label for="SUB_CATEGORY_NAME" class="col-form-label">Sub Category Name</label>
			                                    <input class="form-control" type="text" id="SUB_CATEGORY_NAME" disabled>
			                                </div>
			                                <div class="form-group">
			                                     <label class="col-form-label" for="COMPLAINT_DESC">Grievance Description</label>
			                                     <textarea class="form-control" id="COMPLAINT_DESC" disabled></textarea>
	                                       </div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="COMPLIANT_EMPLOYEE_ID" class="col-form-label">Aggrieved Employees ID</label> 
												<input class="form-control" id="COMPLIANT_EMPLOYEE_ID" type="text" disabled>
											</div>
											<div class="form-group">
												<label for="NAME" class="col-form-label">Aggrieved Employees Name</label> 
												<input class="form-control" id="NAME" type="text" disabled>
											</div>
											<div class="form-group">
												<label for="GROUP_COMPLIANT" class="col-form-label">Aggrieved Employees Type</label> 
												<input class="form-control" type="text" id="GROUP_COMPLIANT" disabled>
											</div>
											<div class="form-group">
												<label for="RESPONDENT_EMPLOYEE_ID" class="col-form-label">Respondent ID</label> 
												<input class="form-control" type="text" id="RESPONDENT_EMPLOYEE_ID" disabled>
											</div>
											<div class="form-group">
												<label for="RESPONDENT_EMPLOYEE_NAME" class="col-form-label">Respondent Name</label> 
												<input class="form-control" type="text" id="RESPONDENT_EMPLOYEE_NAME" disabled>
											</div>
											<div class="form-group">
												<label class="col-form-label" for="STATUSID">Case Status</label> 
												<select class="js-select2 form-control" name="STATUSID" id="STATUSID" aria-hidden="true">
													<option value="-1" selected="selected" disabled>Choose Status Name</option>
													<%
														int i = 1;
														List<CaseStatusMasterModel> CaseStatus = EmployeeGrievanceDAO.getStatus();
														if (CaseStatus != null) {
															for (CaseStatusMasterModel item : CaseStatus) {
													%>
													<option value="<%=item.getSTATUSID()%>"><%=item.getSTATUSNAME()%></option>
													<%
														i++;
															}
														}
													%>
												</select>
											</div>
											<div class="form-group">
												<label for="REOPEN_DATE" class="col-form-label">Case Reopen Date </label> 
												<input class="form-control datepicker" type="text" id="REOPEN_DATE" name="REOPEN_DATE" readonly data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy">
											</div>
											<div class="form-group">
												<label  class="col-form-label" for="REOPEN_HIERORDER">Case Reopen Level </label> 
												<select class="js-select2 form-control" name="REOPEN_HIERORDER" id="REOPEN_HIERORDER" aria-hidden="true">
												<option value="-1" selected="selected" disabled>Choose Case Reopen Level</option>
												<%	
													int j = 1;
													List<GridCase> GridCase = ReopenCaseDAO.getCaseReopenLevel(GRVDETID);
													if (GridCase != null) {
													for (GridCase item : GridCase) {
												%>
												<option value="<%=item.getHIERORDER()%>"><%=item.getHIERORDER()%></option>
												<%
													j++;
												} }
												%>
												</select>
											</div>
											<div class="form-group">
												<label class="col-form-label" for="REOPEN_REASON">Case Reopen Reason</label>
												<div class="d-flex">
													<textarea class="form-control" id="REOPEN_REASON" name="REOPEN_REASON"></textarea>
													<div class="flex-fill">
														<button type="button" id="attachbutton" class="btn btn-inverse-secondary attachbtn ml-3" style="margin-top: 11px;" ><i class="fa fa-folder-open-o"></i></button>
													</div>
												</div>
												<span style="color: indianred; float: right;"> *</span>
												<div id="Remark-error" class="invalid-feedback" style="display: none">Please enter reopen reason.</div>
											</div>
										</div>
									</div>
									<div class="table-responsive datatable-primary">
										<table style="width:100%;"  id="reopenClosed" class="text-center">
											<thead class="text-uppercase">
												<tr>
													<th>Sno</th>
													<th>Case ID</th>
													<th>Hierarchy Code</th>
													<th>Hierarchy Order</th>
													<th>TAT Start Date</th>
													<th>TAT Actual End Date</th>
													<th>Redressal Authority Completed Status</th>
													<th>Current Active Heirarchy</th>
													<th>Status</th>
													<th>Redressal Authority Employee ID</th>
													<th>Redressal Authority Name</th>
												</tr>
											</thead>
											<tbody id="grid_case">

											</tbody>
										</table>
									</div>
									<div class="form-group col-md-12 col-lg-12 text-right" style="margin-top:20px;">
	                                	<button type="submit" class="btn btn-primary" id="submit">Submit</button>
	                                	<button type="button" class="btn btn-light" id="cancel">Cancel</button>
	                            	</div>
	                            </form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		<jsp:include page="footerList.jsp"></jsp:include>
	</div>
	<script>
	$(function(){
		$('body').addClass('slim__theme');
	});
    $(document).ready(function() {
      $(".js-select2").select2();
      $(".js-select2-multi").select2();
    });
</script>
<script>
	$( "#search" ).click(function() {
      var GRVDETID =$("#GRVDETID").val();
      if(GRVDETID==""){
    	  alert("Please enter GRVDETID");
    	  return false;
      }
      $.ajax({
  	    type:'post',
  	    url : 'ReopenCase',
  	    data : {GRVDETID:GRVDETID},
  	    dataType : 'JSON',
  	    success : function(result)
  	    {
  	    	if(result.status == 200){
  	    		$("#grid_case").html(result.data);
  	    		$("#reopenClosed").DataTable();
  	    		$("#GRVID").val(result.GRVID);
  	    		$("#CASEID").val(result.CASEID);
  	    		$("#CASENO").val(result.CASENUMBER);
  	    		$("#MAIN_CATEGORY_CODE").val(result.MAIN_CATEGORY_CODE);
  	    		$("#MAIN_CATEGORY_NAME").val(result.MAIN_CATEGORY_NAME);
  	    		$("#SUB_CATEGORY_CODE").val(result.SUB_CATEGORY_CODE);
  	    		$("#SUB_CATEGORY_NAME").val(result.SUB_CATEGORY_NAME);
  	    		$("#NAME").val(result.NAME);
  	    		$("#COMPLIANT_EMPLOYEE_ID").val(result.COMPLIANT_EMPLOYEE_ID);
  	    		$("#GROUP_COMPLIANT").val(result.GROUP_COMPLIANT);
  	    		$("#COMPLAINT_DESC").val(result.COMPLAINT_DESC);
  	    		$("#RESPONDENT_EMPLOYEE_ID").val(result.RESPONDENT_EMPLOYEE_ID);
  	    		$("#RESPONDENT_EMPLOYEE_NAME").val(result.RESPONDENT_EMPLOYEE_NAME);
  	    		$('#STATUSID').select2("trigger", "select", {data: { id: result.STATUSID, text:  result.STATUSNAME}});
  	    		if(result.STATUSID!=64){
  	    			$('#STATUSID').prop("disabled",true);
  	    			$('#submit').prop("disabled",true);
  	    		}
  	    		else{
  	    			$('#STATUSID').prop("disabled",false);
  	    			$('#submit').prop("disabled",false);
  	    		}
  	    	} else {
  	    		$("#grid_case").html("");
  	    	}
  	    }
  	}); 	
	});
	
	$(document).ready(function(){
		var GRVDETID = <%=GRVDETID%>;
		if(GRVDETID == "" || GRVDETID ==0){
		  return false;
		}
	  	$.ajax({
		    type:'post',
		    url : 'ReopenCase',
		    data : {GRVDETID:GRVDETID},
		    dataType : 'JSON',
		    success : function(result){
		    	if(result.status == 200){
		    		$("#grid_case").html(result.data);
		    		$("#reopenClosed").DataTable();
		    		$("#GRVID").val(result.GRVID);
		    		$("#CASEID").val(result.CASEID);
		    		$("#CASENO").val(result.CASENUMBER);
		    		$("#MAIN_CATEGORY_CODE").val(result.MAIN_CATEGORY_CODE);
		    		$("#MAIN_CATEGORY_NAME").val(result.MAIN_CATEGORY_NAME);
		    		$("#SUB_CATEGORY_CODE").val(result.SUB_CATEGORY_CODE);
		    		$("#SUB_CATEGORY_NAME").val(result.SUB_CATEGORY_NAME);
		    		$("#NAME").val(result.NAME);
		    		$("#COMPLIANT_EMPLOYEE_ID").val(result.COMPLIANT_EMPLOYEE_ID);
		    		$("#GROUP_COMPLIANT").val(result.GROUP_COMPLIANT);
		    		$("#COMPLAINT_DESC").val(result.COMPLAINT_DESC);
		    		$("#RESPONDENT_EMPLOYEE_ID").val(result.RESPONDENT_EMPLOYEE_ID);
		    		$("#RESPONDENT_EMPLOYEE_NAME").val(result.RESPONDENT_EMPLOYEE_NAME);
		    		$('#STATUSID').select2("trigger", "select", {data: { id: result.STATUSID, text:  result.STATUSNAME}});
		    		if(result.STATUSID!=64){
		    			$('#STATUSID').prop("disabled",true);
		    			$('#submit').prop("disabled",true);
		    		}
		    		else{
		    			$('#STATUSID').prop("disabled",false);
		    			$('#submit').prop("disabled",false);
		    		}
		    	} else {
		    		$("#grid_case").html("");
		    	}
		    }
		}); 	
	});
</script>
<script type="text/javascript">
/* $("#search").click(function() {
    var GRVDETID =$("#GRVDETID").val();
    if(GRVDETID==""){
  	  alert("Please enter GRVDETID");
  	  return false;
    }
    $.ajax({
	    type:'post',
	    url : 'ReopenCaseLevel',
	    data : {GRVDETID:GRVDETID},
	    dataType : 'JSON',
	    success : function(result)
	    {
	    	if(result.status == 200){
	    		$("#grid_case").html(result.data);
	    		$('#REOPEN_HIERORDER').select2("trigger", "select", {data:{id:result.REOPEN_HIERORDER, text: result.REOPEN_HIERORDER}});
	    	} else {
	    		console.log("errorhbhaierrorh");
	    		$("#grid_case").html("");
	    	}
	    }
	}); 	
	}); */
</script>
<script>
	$('#cancel').click(function(){
 		location.href ="index.jsp"; 
 	}); 
	$("#REOPEN_DATE").datepicker('setEndDate', '+5d');
	$('#REOPEN_DATE').datepicker('setDate', 'now');
	$("#REOPEN_DATE").datepicker('setStartDate', 'now');
</script>
<script type="text/javascript">
	$('.attachbtn').click(function(){
		var CASEID=$("#CASEID").val();
		var GRVDETID=$("#GRVDETID").val();
	  	location.href ="ReopenClosedAttachment.jsp?CASEID="+CASEID+"&GRVDETID="+GRVDETID; 
	 });
</script>
<script type="text/javascript">
	 $( "#search" ).click(function() {
		var GRVDETID =$("#GRVDETID").val();
		if(GRVDETID == ""){
			  alert("Please enter GRVDETID");
			  $("#attachbutton").attr("disabled", true);
			  return false;
		} else{
			 $("#attachbutton").attr("disabled", false);
		}
	}); 
</script>
<script type="text/javascript">
	$('form').on('submit', function() {
		var REOPEN_REASON = $("#REOPEN_REASON").val(); 
		if(REOPEN_REASON == null || REOPEN_REASON == ""){
			$("#Remark-error").css('display','block');
			return false;
		}
	});
</script>
</body>
</html>