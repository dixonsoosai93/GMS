<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.model.masters.ZoneModel"%>
<%@ page import="com.gms.dao.admin.EmpGrievanceCaseViewDAO" %>
<%@ page import="com.gms.model.masters.ManpowerModel" %>
<%@ page import="com.gms.model.masters.HdRegionModel" %>
<%@ page import="com.gms.model.masters.BranchModel" %>
 <% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 	if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
	}
%>  
<!DOCTYPE html>
<html>
<head>
 <title>TATA AIA GMS</title>
     <jsp:include page="head.jsp"></jsp:include>
</head>
<style>
</style>
<div class="vz_main_sec">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sidebar.jsp"></jsp:include>
	<div class="vz_main_container">
		<div class="vz_main_content">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<h4 class="card_title text-center mb-0">VIEW GRIEVANCE</h4>
							<div class="row mb-4">
								<div class="col-md-6 border-right">
									<div class="form-group">
										<label class="col-form-label" for="empCase">View Employee Grievance Case</label>
										<div>
											<div
												class="custom-control custom-radio primary-radio custom-control-inline">
												<input type="radio" class="custom-control-input" id="emp" name="empCase" value="E">
												<label class="custom-control-label" for="emp">Employee-Wise </label>
											</div>
											<div
												class="custom-control custom-radio primary-radio custom-control-inline">
												<input type="radio" class="custom-control-input" id="investigator" name="empCase" value="A"> 
												<label class="custom-control-label" for="investigator">Redressal Authority-Wise</label>
											</div>
										</div>
									</div>
									<div class="searchDropdown">
										<div class="form-group">
											<label class="col-form-label" for="ZONE_CODE">Zone</label> <select
												class="js-select2 form-control" name="ZONE_CODE" id="ZONE_CODE" aria-hidden="true">
												<option value="-1" selected="selected" disabled>Choose Zone Name</option>
												<%
													int j = 1;
													List<ZoneModel> Zone = EmpGrievanceCaseViewDAO.getZone();
													if (Zone != null) {
														for (ZoneModel item : Zone) {
												%>
												<option value="<%=item.getZONE_CODE()%>"><%=item.getZONE_NAME()%></option>
												<%
													j++;
														}
													}
												%>
											</select>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="BRANCH_CODE">Branch</label>
											<select class="js-select2 form-control" name=BRANCH_CODE id="BRANCH_CODE" aria-hidden="true">
												<option value="-1" selected="selected" disabled>Choose Branch name</option>
												<%
													j = 1;
													List<BranchModel> branchList = EmpGrievanceCaseViewDAO.getBranch();
													if (branchList != null) {
														for (BranchModel item : branchList) {
												%>
												<option value="<%=item.getBRANCH_CODE()%>"><%=item.getBRANCH_NAME()%></option>
												<%
													j++;
														}
													}
												%>
											</select>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="EmployeeID">Employee ID</label>
											<input class="form-control" id="EmployeeID" name="EmployeeID" type="text" placeholder="Enter Employee ID">	
										</div>
									</div>
								</div>
								<div class="col-md-6 border-left">
									<div class="form-group">
										<label class="col-form-label" for="EMP_TYPE">Type Of Case</label>
										<div>
											<div
												class="custom-control custom-radio primary-radio custom-control-inline">
												<input type="radio" class="custom-control-input" id="actEmp" value="A" name="EMP_TYPE">
												<label class="custom-control-label" for="actEmp">Active Employee</label>
											</div>
											<div
												class="custom-control custom-radio primary-radio custom-control-inline">
												<input type="radio" class="custom-control-input" id="exEmp" name="EMP_TYPE" value="A"> 
												<label class="custom-control-label" for="exEmp">Ex-Employee</label>
											</div>
										</div>
									</div>
									<div class="searchDropdown">
										<div class="form-group">
											<label class="col-form-label" for="REGION_CODE">Region</label>
											<select class="js-select2 form-control" name="REGION_CODE" id="REGION_CODE" aria-hidden="true">
												<option value="-1" selected="selected" disabled>Choose Region Name</option>
												<%
													int i = 1;
													List<HdRegionModel> list = EmpGrievanceCaseViewDAO.getRegion();
													if (list != null) {
														for (HdRegionModel item : list) {
												%>
												<option value="<%=item.getREGION_CODE()%>"><%=item.getREGION_NAME()%></option>
												<%
													i++;
														}
													}
												%>
											</select>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="STATUSID">Status ID</label> 
											<select class="js-select2 form-control" name="STATUSID" id="STATUSID" aria-hidden="true">
												<option value="-1" selected="selected" disabled>Choose
													Status Name</option>
												<option value="64">CLOSED</option>
												<option value="62">ON-HOLD</option>
												<option value="61">WORK IN PROGRESS</option>
												<option value="65">Open</option>

											</select>
										</div>
										<div class="form-group row">
											<div class="col-sm-12 text-right">
												<button type="button" class="btn btn-inverse-secondary ml-3" id="search">
													<i class="fa fa-search"></i>
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="table-responsive datatable-primary" style="display: none" id="complaintList">
								<h4 class="card_title text-center mb-0">View Grievances Complainant's List</h4>
								<table style="width:100%;"  id="compList" class="text-center">
									<thead class="text-uppercase">
										<tr>
											<th class="sorting_none" scope="col">Sno</th>
											<th class="sorting_none">Grievance Date</th>
											<th class="sorting_none">GRVID (Header ID)</th>
											<th class="sorting_none">GRVNUMBER(TALIC & Employee Grievance Ref No)</th>
											<th class="sorting_none">Employee ID</th>
											<th class="sorting_none">Employee Name</th>
											<th class="sorting_none">Employee Type(Active-Emp or Ex-Emp)</th>
											<th class="sorting_none">Grievance Type</th>
											<th class="sorting_none">IS ACTIVE</th>
										</tr>
									</thead>
									<tbody id="Comp_List">
									</tbody>
								</table>
							</div>
							
							<div class="table-responsive datatable-primary" style="display: none" id="investigatorList">
								<h4 class="card_title text-center mb-0">View All Redressal Authority List</h4>
								<table style="width:100%;"  id="invList" class="text-center">
									<thead class="text-uppercase">
										<tr>
											<th class="sorting_none" scope="col">Sno</th>
											<th class="sorting_none">Redressal Authority ID</th>
											<th class="sorting_none">Redressal Authority Employee Name</th>
											<th class="sorting_none">Redressal Authority Employee ID</th>
											<th class="sorting_none">Redressal Authority Hierarchy Level</th>
											<th class="sorting_none">Department</th>
											<th class="sorting_none">Region</th>
											<th class="sorting_none">Zone</th>
											<th class="sorting_none">IS ACTIVE</th>
										</tr>
									</thead>
									<tbody id="Inv_List">
									</tbody>
								</table>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 text-right">
									<button type="button" id="back" style="display: none" class="btn btn-primary">Back</button>
								</div>
							</div>
							<div class="table-responsive datatable-primary" id="caseList"
								style="display: none">
								<h4 class="card_title text-center mb-0">View Employee Grievances Case List</h4>
								<table style="width:100%;" id="grvCaseList" class="text-center">
									<thead class="text-uppercase">
										<tr>
											<th class="sorting_none" scope="col">Sno</th>
											<th class="sorting_none">GRVID (HDR ID)</th>
											<th class="sorting_none">GRV Reference Number</th>
											<th class="sorting_none">Case Number (TALIC's)</th>
											<th class="sorting_none">Aggrieved Employee Category</th>
											<th class="sorting_none">Aggrieved Employee Sub-Category</th>
											<th class="sorting_none">Employee Type(Active-Emp or Ex-Emp)</th>
											<th class="sorting_none">Person resolving grievance Employee ID(Active-Emp or Ex-Emp)</th>
											<th class="sorting_none">Person resolving grievancet Name</th>
											<th class="sorting_none">Aggrieved Employee Description</th>
											<th class="sorting_none">Default Hierarchy Code</th>
											<th class="sorting_none">Start Hierarchy Code</th>
											<th class="sorting_none">Compliant Status</th>
										</tr>
									</thead>
									<tbody id="Case_List">
									</tbody>
								</table>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 text-right">
									<button type="button" id="CaseListBack" style="display: none" class="btn btn-primary">Back</button>
								</div>
							</div>
							<div class="table-responsive datatable-primary" id="finalHirarchyList" style="display: none">
								<h4 class="card_title text-center mb-0">Final Verdict</h4>
								<table style="width:100%;" id="dataTable" class="text-center">
									<thead class="text-uppercase">
										<tr>
											<th class="sorting_none" scope="col">Sno</th>
											<th class="sorting_none">GRV Reference Number</th>
											<th class="sorting_none">Case Number</th>
											<th class="sorting_none">VERDICTID</th>
											<th class="sorting_none">VERDICT_REPORT_DATE</th>
											<th class="sorting_none">VERDICT_REPORT_CONTENT</th>
										</tr>
									</thead>
									<tbody id="finalList">
									</tbody>
								</table>
								<h4 class="card_title text-center mb-0">View Hierarchy Wise CASE Details</h4>
								<table style="width:100%;"  id="dataTable2" class="text-center">
									<thead class="text-uppercase">
										<tr>
											<th class="sorting_none">Sno</th>
											<th class="sorting_none">CASE ID</th>
											<th class="sorting_none">GRV Reference Number</th>
											<th class="sorting_none">CASE NUMBER</th>
											<th class="sorting_none">MAIN CATEGORY CODE</th>
											<th class="sorting_none">SUB CATEGORY CODE</th>
											<th class="sorting_none">HIER CODE</th>
											<th class="sorting_none">HIER ORDER</th>
											<th class="sorting_none">TAT START DATE</th>
											<th class="sorting_none">TAT ACTUAL END DATE</th>
											<th class="sorting_none">TAT EXTENDED</th>
											<th class="sorting_none">TAT EXTENDED EMPLOYEE ID</th>
											<th class="sorting_none">TAT END DATE</th>
											<th class="sorting_none">REDRESSAL AUTHORITY NEEDED</th>
											<th class="sorting_none">REDRESSAL AUTHORITY ASSIGNED</th>
											<th class="sorting_none">DECISION ARRIVED</th>
											<th class="sorting_none">REASON NO DECISION</th>
											<th class="sorting_none">DECISION REPORT</th>
											<th class="sorting_none">DECISION SIGNATURE</th>
											<th class="sorting_none">EMP_ACCEPT DECISION</th>
											<th class="sorting_none">EMP NOT ACCEPT REASON</th>
											<th class="sorting_none">CURRENT ROW COMPLETED</th>
											<th class="sorting_none">CURRENT ROW ACTIVE</th>
											<th class="sorting_none">IS ACTIVE</th>
											<th class="sorting_none">REDRESSAL AUTHORITY EMPLOYEE ID</th>
											<th class="sorting_none">DECISION REPORT DATE</th>
											<th class="sorting_none">DECISION REPORT CONTENT</th>
										</tr>
									</thead>
									<tbody id="hierarchyList">
									</tbody>
								</table>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 text-right">
									<button type="button" id="HierarchyListBack" style="display: none" class="btn btn-primary">Back</button>
								</div>
							</div>
							<div class="table-responsive datatable-primary" id="daily_Dairy" style="display: none">
								<h4 class="card_title text-center mb-0">Daily Diary</h4>
								<table style="width:100%;"  id="dataTable3" class="text-center">
									<thead class="text-uppercase">
										<tr>
											<th class="sorting_none" scope="col">Sno</th>
											<th class="sorting_none">CASEID</th>
											<th class="sorting_none">Redressal Authority ID</th>
											<th class="sorting_none">Redressal Authority Name</th>
											<th class="sorting_none">Hier Code</th>
											<th class="sorting_none">Diary ID</th>
											<th class="sorting_none">Diary Date</th>
											<th class="sorting_none">Diary Details</th>
											<th class="sorting_none">Download Case Documents</th>
											<th class="sorting_none">Entry Employee ID</th>
											<th class="sorting_none">Entry Employee Name</th>
										</tr>
									</thead>
									<tbody id="daily_List">
									</tbody>
								</table>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 text-right">
									<button type="button" id="DairyListBack" style="display: none" class="btn btn-primary">Back</button>
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
<jsp:include page="footerList.jsp"></jsp:include>
</body>
<script>
	$(document).ready(function() {
		$(".js-select2").select2();
		$(".js-select2-multi").select2();
	});
	$(function() {
		$('body').addClass('slim__theme');
	});
</script>
<script>
	$(document).ready(function() {
		var compTable;
		var invTable;
		var grvTable = $('#grvCaseList').DataTable({ 
			"destroy": true,
		});
		$('#search').on('click', function() {
			var empCase = $("input[name='empCase']:checked").val();
			var ZONE_CODE = $("#ZONE_CODE").val();
			var REGION_CODE = $('#REGION_CODE').val();
			var STATUSID = $('#STATUSID').val();
			var BRANCH_CODE = $('#BRANCH_CODE').val();
			var EMP_TYPE = $("input[name='EMP_TYPE']:checked").val();
			var EmployeeID = $('#EmployeeID').val();
			console.log(empCase+ZONE_CODE+REGION_CODE+STATUSID+BRANCH_CODE+EMP_TYPE);
			$.ajax({
				type : 'post',
				url : 'EmpGrievanceCaseView',
				data : {
					'empCase' : empCase,
					'ZONE_CODE' : ZONE_CODE,
					'STATUSID' : STATUSID,
					'REGION_CODE' : REGION_CODE,
					'BRANCH_CODE' : BRANCH_CODE,
					'EMP_TYPE' : EMP_TYPE,
					'EmployeeID' : EmployeeID
				},
				dataType : 'JSON',
				success : function(result) {
					if (result.status == 200) {
						if (empCase == "E") {
							$("#Comp_List").html(result.data);
							compTable =  $("#compList").DataTable({ 
								scrollY: '50vh',
								"destroy": true,
							 });
							$("#complaintList").show();
							$("#back").show();
							$(".searchDropdown").hide();
						} else {
							$("#Inv_List").html(result.data);
							invTable = $("#invList").DataTable({
								"scrollY": '50vh',
								"destroy": true,
							});
							$("#investigatorList").show();
							$("#back").show();
							$(".searchDropdown").hide();
						}
					} else {
						$("#Inv_List").html("");
						console.log("Status Code : 412");
					}
				}
			});
		});
		$("body").on("click", ".CaseRow", function() {
			var INVESTIGATOR_EMPLOYEE_ID = $(this).data('key1');
			var GRVID = $(this).data('key2');
			$.ajax({
				type : 'post',
				url : 'GrievanceCaseList',
				data : {
					'INVESTIGATOR_EMPLOYEE_ID' : INVESTIGATOR_EMPLOYEE_ID,
					'GRVID' : GRVID
				},
				dataType : 'JSON',
				success : function(result) {
					if (result.status == 200) {
						$("#Case_List").html(result.data);
						$("#grvCaseList").DataTable();
						$("#investigatorList").hide();
						$("#complaintList").hide();
						$("#caseList").show();
						$("#back").hide();
						$("#CaseListBack").show();
					} else {
						$("#Case_List").html("");
					}
				}
			});
		});
		$('#back').on('click', function() {
			$("#complaintList").hide();
			$("#investigatorList").hide();
			$(".searchDropdown").show();
			$("#back").hide();
		});
		$('#HierarchyListBack').on('click', function() {
			$("#caseList").show();
			$("#CaseListBack").show();
			$("#finalHirarchyList").hide();
			$("#HierarchyListBack").hide();
		});
		$('#DairyListBack').on('click', function() {
			$("#finalHirarchyList").show();
			$("#HierarchyListBack").show();
			$("#daily_Dairy").hide();
			$("#DairyListBack").hide();
		});
		$('#CaseListBack').on('click', function() {
			var invCount = invTable.fnGetData().length;
			var compCount = compTable.fnGetData().length;
			if (invCount > 0) {
				$("#investigatorList").show();
				$("#caseList").hide();
				$("#CaseListBack").hide();
				$("#back").show();
			} else {
				$("#complaintList").show();
				$("#caseList").hide();
				$("#CaseListBack").hide();
				$("#back").show();
			}
		});
		$("body").on("click", ".finalRow", function() {
			var GRVDETID = $(this).data('key1');
			$.ajax({
				type : 'post',
				url : 'GetFinalAndHirarchyDetails',
				data : {
					'GRVDETID' : GRVDETID
				},
				dataType : 'JSON',
				success : function(result) {
					if (result.status == 200) {
						$("#finalList").html(result.finalList);
						$("#hierarchyList").html(result.hierarchyList);
						$("#investigatorList").hide();
						$("#complaintList").hide();
						$("#caseList").hide();
						$("#back").hide();
						$("#CaseListBack").hide();
						$("#HierarchyListBack").show();
						$("#DairyListBack").hide();
						$("#finalHirarchyList").show();
					} else {
						$("#Case_List").html("");
					}
				}
			});
		});
		$("body").on("click", ".dailyRow", function() {
			var CASEID = $(this).data('key1');
			$.ajax({
				type : 'post',
				url : 'GetDailyDairy',
				data : {
					'CASEID' : CASEID
				},
				dataType : 'JSON',
				success : function(result) {
					if (result.status == 200) {
						$("#daily_List").html(result.dairy_List);
						$("#investigatorList").hide();
						$("#complaintList").hide();
						$("#caseList").hide();
						$("#back").hide();
						$("#CaseListBack").hide();
						$("#HierarchyListBack").hide();
						$("#DairyListBack").show();
						$("#finalHirarchyList").hide();
						$("#daily_Dairy").show();
					} else {
						$("#daily_List").html("");
					}
				}
			});
		});
	});
</script>
</html>