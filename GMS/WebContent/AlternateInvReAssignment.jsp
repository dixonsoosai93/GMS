<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.gms.model.masters.ComplaintEmpSelect"%>
<%@ page import="com.gms.model.masters.ManpowerModel"%>
<%@ page import="com.gms.model.masters.ALBranch"%>
<%@ page import="com.gms.model.masters.ALDesignation"%>
<%@ page import="com.gms.model.masters.ALJobFunction"%>
<%@ page import="com.gms.model.masters.ALDepartment"%>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@ page import="java.util.List" %>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 	if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }
%>
<%
    String GRVDETID2 = request.getParameter("GRVDETID") != null?request.getParameter("GRVDETID"):"0";
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
	                           			<h4 class="card_title text-center mb-0">ALTERNATE REDRESSAL AUTHORITY REASSIGNMENT</h4>
                                    </div>
                                    <jsp:include page="GrievanceDetails.jsp"></jsp:include>
								<div class="table-responsive datatable-primary">
									<table style="width:100%;"  id="alternateInv" class="text-center">
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
												<th>Re-Assigned</th>
												<th>Redressal Authority Employee ID</th>
												<th>Redressal Authority Name</th>
												<th>Remarks</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody id="grid_case">

										</tbody>
									</table>
								</div>
								<div class="form-group col-md-12 col-lg-12 text-right" style="margin-top:20px;">
                                	<!--<button type="button" class="btn btn-primary select2" id="Submit">Submit</button>-->
                                	<button type="button" class="btn btn-light" id="cancel">Cancel</button>
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
<jsp:include page="HierarchyModal.jsp"></jsp:include>
<div class="modal fade show" id="exampleModalCenter" style="display:none; padding-right: 17px;">       
    <div class="modal-dialog modal-xl modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">MANPOWER LIST</h5>
	                <button type="button" class="btn btn-primary select" style="margin-left: auto; margin-right: 10px;">Submit</button>
    	            <button type="button" class="btn btn-light" id="cancel" data-dismiss="modal" >Cancel</button>
            </div>
      		<div class="modal-body">
				<div class="row">
                <div class="col-12">
                   <div class="card">
                       <div class="card-body">
                       		<form id="scManpowerPopup" action="" method="post">
                       			<div class="row align-items-end">
				                     <div class="form-group col-lg-3"  style="margin-bottom: auto;">
				            			<label class="col-form-label" for="NTID">NT ID</label>
				            			<input type="text" class="form-control" placeholder ="Enter NT ID" id="NTID" name="NTID">
				        			</div>
				        			<div class="form-group col-lg-3"  style="margin-bottom: auto;">
				            			<label class="col-form-label" for="Name">Name</label>
				            			<input type="text" class="form-control" placeholder ="Enter Name" id="Name" name="Name">
				        			</div>
				        			<div class="form-group col-lg-3">
	                                    <label class="col-form-label" for="tdesignation">Select Designation</label>
	                                    <select class="js-select2 res" id="tdesignation" name="tdesignation">
	                                        <option selected="selected" value="-1" disabled>Choose Designation</option>
	                                        <%
								 			int tl = 1;
	                                    	ComplaintEmpSelect filter =  HrcMasterDAO.getFilterList();
	                                    	List<ALDesignation> tDesignation =  filter.gettDesignation();
					     					if(tDesignation != null){
					          				for(ALDesignation item : tDesignation) { 
					        				%>
					        				<option value="<%=item.getDesignationCode()%>"><%=item.getDesignationName() %></option>
											<%
								             tl++;
								         	} }
								 			%>
	                                    </select>
	                                </div>
				        			<div class="form-group col-lg-3">
				            			<label class="col-form-label" for="tDepartment">Select Department</label>
				            			<select class="js-select2 res" id="tDepartment" name="tDepartment">
				             				<option selected="selected" value="-1" disabled>Choose Department Name</option>
					         		  		<%
					           				int td = 1;
					          				List<ALDepartment> tDepartment =  filter.gettDepartment();
					     					if(tDepartment != null){
					          				for(ALDepartment item : tDepartment) { 
					        				%>
					      					<option value="<%=item.getDepartmentCode() %>"><%=item.getDepartment() %></option>
											<%
								             td++;
								         	} }
								 			%>
				       					</select>
				        			</div>
				        			<div class="form-group col-lg-3">
				            			<label class="col-form-label" for="tJobFun">Select Job Function</label>
				            			<select class="js-select2 res" id="tJobFun" name="tJobFun">
				             				<option selected="selected" value="-1" disabled>Choose Job Function</option>
					         		  		<%
											int tj = 1;
								 			List<ALJobFunction> tJobFunction =  filter.gettJobFUnction();
					     					if(tJobFunction != null){
					          				for(ALJobFunction item : tJobFunction) { 
					        				%>
					      					<option value="<%=item.getJobFunctionCode()%>"><%=item.getJobFunction() %></option>
											<%
								             tj++;
								         	} }
								 			%>
				       					</select>
				        			</div>
				        			<div class="form-group col-lg-3">
				            			<label class="col-form-label" for="tbranchCode">Select Branch</label>
				            			<select class="js-select2 res" id="tbranchCode" name="tbranchCode">
				             				<option selected="selected" value="-1" disabled>Choose Branch Name</option>
								 			<%
								 			int ti = 1;
								 			List<ALBranch> tbranch =  filter.gettBranch();
					     					if(tbranch != null){
					          				for(ALBranch item : tbranch) { 
					        				%>
					      					<option value="<%=item.getBranchCode()%>"><%=item.getBranchName() %></option>
											<%
								             ti++;
								         	} }
								 			%>
				       					</select>
				        			</div>
				        			<a type="button" class="btn form-group btn-inverse-secondary ml-3" id="getTable" style="margin-bottom: 32px;"><i class="fa fa-search"></i></a>
                       				<button type="button" class="btn form-group btn-inverse-secondary ml-3" id="reset" style="margin-bottom: 32px;"><i class="fa fa-refresh"></i></button>
                       				<div id='dispMessage' class="invalid-feedback" style="display:none">Please Choose any of the above dropdown / Enter NTID or Name.</div>
                       			</div>
                       		</form>	
                           <div class="table-responsive datatable-primary">
								<table style="width:100%;"  id="EmpSearch" class="text-center">
                                     <thead class="text-uppercase">
                                        <tr>
                                        	<th scope="col">Choose Employee</th>
                                         	<th scope="col">S.No.</th>
                                         	<th scope="col">MANPOWER ID</th>
                                         	<th scope="col">TITLE</th>
                    						<th scope="col">NAME</th>
                                            <th scope="col">DOB</th>
                                            <th scope="col">GENDER</th>
                                            <th scope="col">DESIGNATION</th>
                                            <th scope="col">JOB FUNCTION</th>
                                            <th scope="col">DEPARTMENT</th>
                                            <th scope="col">BRANCH</th>
                                            <th scope="col">SUPERVISOR ID</th>
                                            <th scope="col">STATUS</th>
                                            <th scope="col">DATE</th>
                                        </tr>
                                     </thead>
                                     <tbody id="manpower-list-string">
                                     </tbody> 
                               </table>
                           </div>    
                       </div>
                   </div>
                </div>    
            </div>
            </div>    
        </div>     
    </div>     
</div>
<style>
.ui-dialog 
	{
	position:fixed;
	}
</style>
<script>
	 $(function() {
		 $('body').addClass('slim__theme');
		 });
	 $(document).ready(function() {
	     $(".js-select2").select2();
	     $(".js-select2-multi").select2();
	   });
</script>
<script>
	$(document).ready(function(){
		$("#getTable").on('click', function() {
			$('#EmpSearch').dataTable().fnClearTable();
			$('#EmpSearch').dataTable().fnDestroy();
			var tbranchCode = $('#tbranchCode').val();
			var tdesignation = $('#tdesignation').val();
			var tJobFun = $('#tJobFun').val();
			var tDepartment = $('#tDepartment').val();
			var NTID = $('#NTID').val();
			var Name = $('#Name').val();
			var data = [tbranchCode, tdesignation, tJobFun, tDepartment, NTID, Name];
			if(tbranchCode =='' ||tbranchCode == null  && tdesignation== null  && tJobFun == null && tDepartment == null && NTID == "" && Name =="" ){
				$('#dispMessage').css('display','block');
			} else{
				$('#dispMessage').css('display','none');
		        $.ajax({
		            type:'post',
		            url : 'GetEmpSelectList',
		            data : {'tbranchCode':tbranchCode,'tdesignation':tdesignation,'tJobFun':tJobFun,'tDepartment':tDepartment,'NTID':NTID,'Name':Name},
		            dataType : 'JSON',
		            success : function(result){
		            	if(result.status == 200){
		            		$("#manpower-list-string").html("");
		            		$("#manpower-list-string").html(result.data);
		            		$("#EmpSearch").dataTable();
		            	} else {
		            		$("#manpower-list-string").html("");
		            	}
		            }
		        }); 
			}
		});
	});
</script>
<script>
	var REGION_CODE;
	var ZONE_CODE;
	var CASEID;
	$("#search").click(function() {
		var GRVDETID = $("#GRVDETID").val();
		if (GRVDETID == "") {
			alert("Please enter GRVDETID");
			return false;
		}
		$.ajax({
			type : 'post',
			url : 'AlternateInvReAssign',
			data : { GRVDETID : GRVDETID},
			dataType : 'JSON',
			success : function(result) {
				if (result.status == 200) {
					$("#grid_case").html(result.data);
					$("#alternateInv").DataTable();
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
					REGION_CODE = result.REGION_CODE;
					ZONE_CODE = result.ZONE_CODE;
				} else {
					$("#grid_case").html("");
				}
			}
		});
	});
	
	$(document).ready(function(){
		<% 
		String GRVDETID = "";
			String GRVDETID1 = (String)session.getAttribute("GRVDETID");
			if(GRVDETID1 != null && GRVDETID1 != ""){
				GRVDETID = GRVDETID1;
			} else{
				GRVDETID = GRVDETID2;
			}
		%>
		var GRVDETID = <%=GRVDETID%>
		if (GRVDETID == "" || GRVDETID == null) {
			return false;
		}
		$.ajax({
			type : 'post',
			url : 'AlternateInvReAssign',
			data : { GRVDETID : GRVDETID},
			dataType : 'JSON',
			success : function(result) {
				if (result.status == 200) {
					$("#grid_case").html(result.data);
					$("#alternateInv").DataTable();
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
					REGION_CODE = result.REGION_CODE;
					ZONE_CODE = result.ZONE_CODE;
				} else {
					$("#grid_case").html("");
				}
			}
		});
	});
	
	$("body").on("click", ".changeInv", function() {
		var HIREORDER = $(this).data('key1');
		CASEID = $(this).data('key2');
		console.log("HIREORDER : "+HIREORDER+" CASEID :"+CASEID);
		$.ajax({
			type : 'post',
			url : 'HierarchySelectList',
			data : {
				'HIREORDER' : HIREORDER,
				'REGION_CODE' : REGION_CODE,
				'ZONE_CODE' : ZONE_CODE
			},
			dataType : 'JSON',
			success : function(result) {
				if (result.status == 200) {
					if (HIREORDER == 2) {
						$('#hierarchyModal').modal('show');
						$("#rhrDataTable").DataTable();
						$('#RHR').show();
						$('#rhr').show();
						$('#CENTCOM').hide();
						$('#centCom').hide();
						$('#ZLGC').hide();
						$('#zlgc').hide();
						$("#rhr-list").html(result.data);
					} else if (HIREORDER == 4) {
						$('#hierarchyModal').modal('show');
						$("#centcom-list").html(result.data);
						$("#centcomDataTable").DataTable();
						$('#CENTCOM').show();
						$('#centCom').show();
						$('#ZLGC').hide();
						$('#zlgc').hide();
						$('#RHR').hide();
						$('#rhr').hide();
					} else if (HIREORDER == 3) {
						$('#hierarchyModal').modal('show');
						$("#zlgc-list").html(result.data);
						$("#zlgcDataTable").DataTable();
						$('#ZLGC').show();
						$('#zlgc').show();
						$('#RHR').hide();
						$('#rhr').hide();
						$('#CENTCOM').hide();
						$('#centCom').hide();
					} else {
						$('#exampleModalCenter').modal('show');
					}
				} else {
					$("#rhr-list").html("");
				}
			}
		});
	});

	$("body").on("click", ".selectRow", function() {
		var INVESTIGATOR_EMPLOYEE_ID = $(this).data('key1');
		var GRVDETID = $("#GRVDETID").val();
		var Remark= $("#Remark").val();
		console.log("INVESTIGATOR_EMPLOYEE_ID : "+INVESTIGATOR_EMPLOYEE_ID+"Remark :"+Remark);
		$(".select").click(function(){
			var remarkError = $("#Remark").val();
			if(remarkError  == null || remarkError == ""){
				alert("Please click on cancel button and enter remark to submit");
				$("#Remark-error").css('display','block');
				return false;
			}
			else{
				if(confirm("Are you sure want to change Redressal Authority")){
					$.ajax({
						type : 'post',
						url : 'CaseInvReAssign',
						data : {
							'CASEID' : CASEID,
							'GRVDETID': GRVDETID,
							'INVESTIGATOR_EMPLOYEE_ID' : INVESTIGATOR_EMPLOYEE_ID,
							'Remark' : Remark
						},
						dataType : 'JSON',
						success : function(result) {
							if (result.status == 200) {
								window.location = "AlternateInvReAssignment.jsp";
							} else {
								window.location = "AlternateInvReAssignment.jsp";
							}
						}
					});
				}else{
					return false;
				}
			}
		});
	});
</script>
<script type="text/javascript">
	$('.modal').on('hidden.bs.modal', function(){
		$('#tbranchCode').val($('#tbranchCode option:first-child').val()).trigger('change');
		$('#tdesignation').val($('#tdesignation option:first-child').val()).trigger('change');
		$('#tJobFun').val($('#tJobFun option:first-child').val()).trigger('change');
		$('#tDepartment').val($('#tDepartment option:first-child').val()).trigger('change');
	    $('#NTID').val("");
		$('#Name').val("");
		$('#dispMessage').css('display','none');
		var dataTable = $('#EmpSearch').DataTable();
		dataTable.rows().remove().draw();
	});
	$("#reset").click(function(){
		$('#tbranchCode').select2("trigger", "select", {data: { id: -1, text: "Choose Branch Name"}});
		$('#tdesignation').select2("trigger", "select", {data: { id: -1, text: "Choose Designation"}});
		$('#tJobFun').select2("trigger", "select", {data: { id: -1, text: "Choose Job Function"}});
		$('#tDepartment').select2("trigger", "select", {data: { id: -1, text: "Choose Department Name"}});
		$('#NTID').val("");
		$('#Name').val("");
		$('#EmpSearch').dataTable().fnClearTable();
	});
</script>
<script>
	$('#cancel').click(function(){
 		location.href ="index.jsp"; 
 	}); 
</script>
</body>
</html>