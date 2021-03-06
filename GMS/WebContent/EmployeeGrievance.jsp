<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.gms.model.masters.ALBranch"%>
<%@ page import="com.gms.model.masters.ALDesignation"%>
<%@ page import="com.gms.model.masters.ALJobFunction"%>
<%@ page import="com.gms.model.masters.ALDepartment"%>
<%@ page import="com.gms.model.masters.MainCategoryModel" %>
<%@page import="com.gms.dao.masters.MainCategoryDAO"%>
<%@ page import="com.gms.model.masters.ComplaintEmpSelect"%>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@page import="com.gms.dao.grievance.EmployeeGrievanceDAO"%>
<%@ page import="com.gms.model.masters.CaseStatusMasterModel" %>
<%@page import="com.gms.model.masters.ManpowerModel"%>
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
    <jsp:include page="headerEmployeeGrivenceAdd.jsp"></jsp:include>
    <div class="vz_main_container">
        <div class="vz_main_content">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <form id="addEmpGrievance" method="post">
								<div class="row mb-4">
									<div class="col-md-6 border-right">
										<h4 class="card_title" style="text-align: center;">Active Employee Grievance- Aggrieved Employee</h4>
										<div class="form-group">
											<label for="COMPLIANT_EMPLOYEE_ID" class="col-form-label">Active Employee ID</label> 
											<input class="form-control" type="text" id="COMPLIANT_EMPLOYEE_ID" value="<%=Manpower.getEMPLOYEE_ID()%>" name="COMPLIANT_EMPLOYEE_ID" readonly>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="COMPLIANT_EMPLOYEE_NAME">Active Employee Name</label> 
											<input class="form-control" type="text" id="COMPLIANT_EMPLOYEE_NAME" value="<%=Manpower.getNAME()%>" name="COMPLIANT_EMPLOYEE_NAME" disabled>
										</div>
										<div class="form-group">
											<label for="COMPLIANT_EMPLOYEE_TYPE" class="col-form-label">Active Employee Type</label> 
											<input type="text" name="COMPLIANT_EMPLOYEE_TYPE" class="form-control" id="COMPLIANT_EMPLOYEE_TYPE" value="Active Employee" disabled>
										</div>
										<div class="form-group">
											<label class="col-form-label" for="GROUP_COMPLAINT">Grievance Type</label>
											<div>
												<div class="custom-control custom-radio primary-radio custom-control-inline">
													<input type="radio" class="custom-control-input" id="Single" value="N" name="GROUP_COMPLAINT" checked>
													<label class="custom-control-label" for="Single">Single Employee</label>
												</div>
												<div class="custom-control custom-radio primary-radio custom-control-inline">
													<input type="radio" class="custom-control-input" id="Group" name="GROUP_COMPLAINT" value="Y"> 
													<label class="custom-control-label" for="Group">Group Of Employee</label>
													<div class="form-group" >
														<div class="d-flex align-items-start" style="padding-top: 0px; margin-left: 93px;">
															<label for="empSearch" class="col-form-label">Add Employee Group Member</label>
															<button type="button" id="empSearch" class="btn btn-inverse-secondary ml-3 empSearch" title="Check Group Of Employee" > <i class="fa fa-search"></i></button>
														</div>
													</div>
												</div>
											</div>
											<div id="grp-error" class="invalid-feedback" style="display: none">Please choose at least one employee.</div>
										</div>
										<div class="form-group">
											<label for="city" class="col-form-label">Grievance Date</label> 
											<input class="form-control datepicker" type="text" id="GRVDATE" name="GRVDATE" readonly data-date-format="dd-mm-yyyy" placeholder="dd-mm-yyyy">
										</div>
									</div>
									<div class="col-md-6 border-left">
										<div class="form-group">
											<div class="d-flex align-items-start">
												<label for="addMoreEmployeeSrch" class="col-form-label">Add More Employee Group Member</label>
												<button type="button" id="addMoreEmployeeSrch" class="btn btn-inverse-secondary ml-3 empSearch" style="display: none" title="Check Group Of Employee" ><i class="fa fa-plus-circle"></i></button>
											</div>
										</div>
										<div class="table-responsive datatable-primary empTableCount">
											<div class="list" style="max-height: 400px;">
												<table style="width:100%;"  id="EmpTable" class="text-center">
													<thead class="text-uppercase">
														<tr>
															<th>Sno</th>
															<th>Name</th>
															<th>Employee ID</th>
															<th>Designation</th>
															<th>Department</th>
															<th>Action</th>
														</tr>
													</thead>
													<tbody id="empEntry">
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-6 col-lg-4">
										<label class="col-form-label" for="MAIN_CATEGORY_CODE">Grievance Category<span style="color: indianred;"> *</span></label> 
										<select class="js-select2 form-control" id="MAIN_CATEGORY_CODE" name="MAIN_CATEGORY_CODE" aria-hidden="true">
											<option selected="selected" disabled>Choose Grievance Category</option>
											<%
											int i = 1;
											List<MainCategoryModel> MainCategory = MainCategoryDAO.getMainCategory();
											if (MainCategory != null) {
												for (MainCategoryModel item : MainCategory) {
												%>
											<option value="<%=item.getMAIN_CATEGORY_CODE()%>"><%=item.getMAIN_CATEGORY_CODE()%></option>
												<%
												i++;
											} }
											%>
										</select>
										<div id="MAIN_CATEGORY_CODE-error" class="invalid-feedback" style="display: none">Please choose grievance category</div>
									</div>
									<div class="form-group col-md-6 col-lg-4">
										<label class="col-form-label" for="SUB_CATEGORY_CODE">Grievance Sub-Category<span style="color: indianred;"> *</span></label> 
										<select class="js-select2 form-control" id="SUB_CATEGORY_CODE" name="SUB_CATEGORY_CODE" aria-hidden="true">
											<option selected="selected" disabled>Choose Grievance Sub-Category</option>
										</select>
										<div id="SUB_CATEGORY_CODE-error" class="invalid-feedback" style="display: none">Please choose grievance sub category</div>
									</div>
									<div class="form-group col-md-6 col-lg-4">
										<label class="col-form-label" for="RESPONDENT_EMPLOYEE_ID">Complainant Against (ID Of employee)</label>
										<input type="text" class="form-control" id="RESPONDENT_EMPLOYEE_ID" name="RESPONDENT_EMPLOYEE_ID" disabled>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-6 col-lg-4">
										<label class="col-form-label" for="RESPONDENT_EMPLOYEE_NAME">Complainant Against (Name Of employee)</label>
										<div class="d-flex">
											<select class="js-select2 form-control" id="RESPONDENT_EMPLOYEE_NAME" name="RESPONDENT_EMPLOYEE_NAME" aria-hidden="true">
												<option selected="selected" disabled>Choose Respondent Name</option>
												<%
													i = 1;
													List<ManpowerModel> manpower = HrcMasterDAO.getEmpGrievanceManpower();
													if (manpower != null) {
														for (ManpowerModel item : manpower) {
												%>
												<option value="<%=item.getEMPLOYEE_ID()%>" data-key31='<%=item.getNAME() %>'><%=item.getNAME()%></option>
												<%
													i++;
												} }
												%>
											</select>
											<div class="flex-fill">
												<button type="button" id="RadioEmpSearch" class="btn btn-inverse-secondary ml-3" data-toggle="modal" data-target="#exampleModalCenter"> <i class="fa fa-search"></i> </button>
											</div>
										</div>
									</div>
									<div class="form-group col-md-6 col-lg-4">
										<label class="col-form-label" for="COMPLAINT_DESC">Grievance Description<span style="color: indianred;"> *</span></label>
										<textarea class="form-control" name="COMPLAINT_DESC" id="COMPLAINT_DESC" placeholder="Enter Grievance Description"></textarea>
										<div id="COMPLAINT_DESC-error" class="invalid-feedback" style="display: none">Please enter complaint description</div>
									</div>
								</div>  
	                            <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="button" id="grievance"  class="btn btn-primary">Add Grievance</button>
	                                </div>
	                            </div>
			                     <div class="table-responsive datatable-primary ">
									<table style="width:100%;" id="AddGrievance" class="text-center">
										<thead class="text-uppercase">
											<tr>
												<th style="display: none;">Sno</th>
												<th>Grievance Category</th>
												<th>Grievance Sub-Category</th>
												<th>Respondent Employee ID</th>
												<th>Respondent Name</th>
												<th style="display: none;">Status ID</th>
												<th>Grievance Description</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody id="subGrid">
											<tr></tr>
										</tbody>
									</table>
								</div>
		                       	<div style="margin-top:20px;" class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="submit" id="Save" class="btn btn-primary">Submit</button>
	                                    <button type="button" id="CancelButton"class="btn btn-light cancel">Cancel</button>
	                                </div>
	                            </div>
		                       </form>                
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>
<div class="modal fade show" id="exampleModalCenter" style="display:none; padding-right: 17px;">       
    <div class="modal-dialog modal-xl modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">MANPOWER LIST</h5>
	            <button type="button" id="select" class="btn btn-light" style="margin-left: auto; margin-right: 10px;" data-dismiss="modal" >Select</button>
	            <button type="button" id="selectRadio" class="btn btn-light" style="margin-left: auto; margin-right: 10px;" data-dismiss="modal" >Select</button>
    	        <button type="button" id="cancel" class="btn btn-light" data-dismiss="modal" >Cancel</button>
            </div>
      		<div class="modal-body">
				<div class="row">
                <div class="col-12">
                   <div class="card">
                       <div class="card-body">
                       		<form id="scManpowerPopup" action="" method="post">
                       			<div class="row align-items-end">
				        			<div class="form-group col-lg-3"  style="margin-bottom: auto;">
				            			<label class="col-form-label" for="NTID">Employee ID</label>
				            			<input type="text" class="form-control" placeholder ="Enter Employee ID" id="NTID" name="NTID">
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
	                                        ComplaintEmpSelect filter =  HrcMasterDAO.getFilterList();
								 			int tl = 1;
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
				        			<a type="button" class="btn form-group btn-inverse-secondary ml-3" id="getRadioTable" style="margin-bottom: 32px;"><i class="fa fa-search"></i></a>
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
            <jsp:include page="footerList.jsp"></jsp:include> 
            </div>    
        </div>     
    </div>     
</div>
<script>
	$(document).ready(function() {
		/*
		var subGridList = $('#subGrid tr').length;
		console.log("subGridList : "+subGridList);
		if(subGridList === 1){
			console.log("inside ");
			$('#subGrid').append('<tr><td colspan=\"6\">No detail found</td></tr>');
		}*/
	});
</script>
<script>
    $(document).ready(function() {
      $(".js-select2").select2();
      $(".js-select2-multi").select2();
    });
    $('#CancelButton').click(function(){
		location.href ="EmployeeGLP.jsp"; 
	});
	$('.empSearch').click(function(){
    	$('#exampleModalCenter').modal('show');
	});
	$(function() {
		$('body').addClass('slim__theme');
	});
</script>
<script>
	$('input[type=radio][name=GROUP_COMPLAINT]').change(function() {
	    if (this.value == 'N') {
	    	$("#empSearch").attr("disabled", true);
	    }
	    else if (this.value == 'Y') {
	    	$("#empSearch").attr("disabled", false);
	    	$("#grp-error").css("display", "block");
	    }
	});
	
	$("#empSearch").click(function(){
		$("#getRadioTable").hide();
		$("#getTable").show();
		$("#selectRadio").hide();
		$("#select").show();
		$("#grp-error").css("display", "none");
		$("#addMoreEmployeeSrch").css("display", "block");
	});
	
	$("#RadioEmpSearch").click(function(){
		$("#getTable").hide();
		$("#getRadioTable").show();
		$("#selectRadio").show();
		$("#select").hide();
	});
	
	// selection of today's date in Grivance Date
	$("#GRVDATE").datepicker('setStartDate', 'now');
	$("#GRVDATE").datepicker('setEndDate', 'now');
	$('#GRVDATE').datepicker('setDate', 'now');
	
	// validation for lower selection form : lower part
	$('#SUB_CATEGORY_CODE').change(function(){
		$('#SUB_CATEGORY_CODE-error').css('display','none');
	});
	
	$('#COMPLAINT_DESC').focus(function(){
		$('#COMPLAINT_DESC-error').css('display','none');
	});
	
	$('#RESPONDENT_EMPLOYEE_NAME').change(function(){
		$('#RESPONDENT_EMPLOYEE_NAME-error').css('display','none');
		var RESPONDENT_EMPLOYEE_NAME =$("#RESPONDENT_EMPLOYEE_NAME").val();
		$("#RESPONDENT_EMPLOYEE_ID").val(RESPONDENT_EMPLOYEE_NAME);
	});
</script>
<script>
 	
	$(document).ready(function(){
		
		Array employees = new Array();
		var employeeId = $('#COMPLIANT_EMPLOYEE_ID').val();
		employees.push(employeeId);
		console.log("employeesArray", employees);
		/*$("#EmpTable TBODY TR").each(function () {
	    	var row = $(this);
	     	groupListData = row.find("TD").eq(2).html();
	     	groupListData.append(employeeId);
	   	});*/
		var grouplistArray = employees;
		console.log("griupListArray "+grouplistArray);

		$("#getTable").on('click', function() {
			$('#EmpSearch').dataTable().fnClearTable();
			$('#EmpSearch').dataTable().fnDestroy();
			var tbranchCode = $('#tbranchCode').val();
			var tdesignation = $('#tdesignation').val();
			var tJobFun = $('#tJobFun').val();
			var tDepartment = $('#tDepartment').val();
			var NTID = $('#NTID').val();
			var Name = $('#Name').val();
			console.log("at click event",grouplistArray);
			var data = [tbranchCode, tdesignation, tJobFun, tDepartment, NTID, Name];
				if(tbranchCode =='' ||tbranchCode == null  && tdesignation== null  && tJobFun == null && tDepartment == null && NTID == "" && Name =="" ){
					$('#dispMessage').css('display','block');
				}
				else{
					$('#dispMessage').css('display','none');
			        $.ajax({
			            type: 'post',
			            url : 'GetEmployeeSearchList',
			            data : {'tbranchCode':tbranchCode, 'tdesignation':tdesignation, 'tJobFun':tJobFun, 'tDepartment':tDepartment, 'NTID':NTID, 'Name':Name, 'grouplistArray':grouplistArray},
			            dataType : 'JSON',
			            success : function(result){
			            	if(result.status == 200){
			            		$("#manpower-list-string").html("");
			            		$("#manpower-list-string").html(result.data);
			            		$("#EmpSearch").DataTable();
			            	} else {
			            		$("#manpower-list-string").html("");
			            	}
			            }
			        }); 
				}
		});
	});
 	/*
 	$(document).ready(function(){
 		
    	var groupListData = '';
    	var employeeId = $('#COMPLIANT_EMPLOYEE_ID').val();
    	console.log("Employee Ids for Group: "+employeeId)

    	/*$("#EmpTable TBODY TR").each(function () {
        	var row = $(this);
         	groupListData = row.find("TD").eq(2).html();
         	groupListData.append(employeeId);
       	});*/
    	/*
    	var grouplistArray = employeeId;
    	console.log("griupListArray "+grouplistArray);
		$("#getTable").on('click', function() {
			$('#EmpSearch').dataTable().fnClearTable();
			$('#EmpSearch').dataTable().fnDestroy();
			var tbranchCode = $('#tbranchCode').val();
			var tdesignation = $('#tdesignation').val();
			var tJobFun = $('#tJobFun').val();
			var tDepartment = $('#tDepartment').val();
			var NTID = $('#NTID').val();
			var Name = $('#Name').val();
			console.log("at click event",grouplistArray);
			var data = [tbranchCode, tdesignation, tJobFun, tDepartment, NTID, Name];
				if(tbranchCode =='' ||tbranchCode == null  && tdesignation== null  && tJobFun == null && tDepartment == null && NTID == "" && Name =="" ){
					$('#dispMessage').css('display','block');
				}
				else{
					$('#dispMessage').css('display','none');
			        $.ajax({
			            type: 'post',
			            url : 'GetEmployeeSearchList',
			            data : {'tbranchCode':tbranchCode, 'tdesignation':tdesignation, 'tJobFun':tJobFun, 'tDepartment':tDepartment, 'NTID':NTID, 'Name':Name, 'grouplistArray':grouplistArray},
			            dataType : 'JSON',
			            success : function(result){
			            	if(result.status == 200){
			            		$("#manpower-list-string").html("");
			            		$("#manpower-list-string").html(result.data);
			            		$("#EmpSearch").DataTable();
			            	} else {
			            		$("#manpower-list-string").html("");
			            	}
			            }
			        }); 
				}
		});
	});
 	*/
 	
 	/*
 	
 	$(document).ready(function(){
		
		var groupList = new Array();
    	var groupListDataValue = {};
    	
    	groupListDataValue.EMPLOYEE_ID = $('#COMPLIANT_EMPLOYEE_ID').val();
    	console.log("Employee Ids for Group: "+groupListDataValue.EMPLOYEE_ID)
    	groupList.push(groupListDataValue);
    	console.log("groupList intiallly : ..."+groupList);
    	
    	$("#EmpTable TBODY TR").each(function () {
        	var row = $(this);
        	var groupListData = {};
        	groupListData.EMPLOYEE_ID = row.find("TD").eq(2).html();
        	groupList.push(groupListData);
        	console.log("groupList medival : .."+groupList);
    	});
    	var grouplistArray = JSON.stringify(groupList);
    	
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
				}
				else{
					$('#dispMessage').css('display','none');
			        $.ajax({
			            type:'post',
			            url : 'GetEmployeeSearchList',
			            data : {'tbranchCode':tbranchCode, 'tdesignation':tdesignation, 'tJobFun':tJobFun, 'tDepartment':tDepartment, 'NTID':NTID, 'Name':Name, 'grouplistArray':grouplistArray},
			            dataType : 'JSON',
			            success : function(result){
			            	if(result.status == 200){
			            		$("#manpower-list-string").html("");
			            		$("#manpower-list-string").html(result.data);
			            		$("#EmpSearch").DataTable();
			            	} else {
			            		$("#manpower-list-string").html("");
			            	}
			            }
			        }); 
				}
		});
	});
 	
 	*/
	
</script>

<script>
	/*
	$(document).ready(function(){
		var groupList = new Array();
    	var groupListDataValue = {};
    	var groupObject = {};
		var values; 
		
    	groupListDataValue.EMPLOYEE_ID = $('#COMPLIANT_EMPLOYEE_ID').val();
    	groupList.push(groupListDataValue);
    	$("#EmpTable TBODY TR").each(function () {
        	var row = $(this);
        	var groupListData = {};
        	groupListData.EMPLOYEE_ID = row.find("TD").eq(2).html();
        	groupList.push(groupListData);
    	});
    	
		$("#getTable").on('click', function() {
			groupObject.tbranchCode = $('#tbranchCode').val() != null?$('#tbranchCode').val():null;
			groupObject.tdesignation = $('#tdesignation').val() != null?$('#tdesignation').val():null;
			groupObject.tJobFun = $('#tJobFun').val() != null? $('#tJobFun').val():null;
			groupObject.tDepartment = $('#tDepartment').val() != null?$('#tDepartment').val():null;
			groupObject.NTID = $('#NTID').val() != null? $('#NTID').val():0;
			groupObject.Name = $('#Name').val() != null? $('#Name').val():"";
			
				if(groupObject.tbranchCode  == null && groupObject.tdesignation == null  && groupObject.tJobFun== null  && groupObject.tDepartment == null && groupObject.NTID == "" && groupObject.Name =="" ){
					$('#dispMessage').css('display','block');
				} else {
					$('#dispMessage').css('display','none');
					groupObject.groupListArr = groupList;
					values = JSON.stringify(groupObject);
					console.log(" values "+values);
					$.ajax({
			            type:'post',
			            url : 'GetEmployeeList',
			            data: {'data': values},
			            dataType : 'JSON',
			            success : function(result){
			            	if(result.status == 200){
			            		$("#manpower-list-string").html("");
			            		$("#manpower-list-string").html(result.data);
			            		$("#EmpSearch").DataTable();
			            	} else {
			            		$("#manpower-list-string").html("");
			            	}
			            }
			        }); 
				} 
		});
	});
	*/
</script>

<script type="text/javascript">
	var employeeData = "";
	var employeeDataAppend = "";
	$("body").on("click", "#empCheck", function () {
		if($(this).prop("checked") == true){
			var row = $(this).closest("tr")[0];
	        employeeData += "<tr>";
		        employeeData += "<td class=\"order\">"+"</td>";
		        employeeData += "<td>"+row.cells[4].innerHTML+"</td>";
		        employeeData += "<td>"+row.cells[2].innerHTML+"</td>";
		        employeeData += "<td>"+row.cells[7].innerHTML+"</td>";
		        employeeData += "<td>"+row.cells[9].innerHTML+"</td>";
		        employeeData += "<td>\r\n" + 
				"<ul class=\"d-flex justify-content-center\">\r\n" + 
				" <li class=\"mr-3\"><button type=\"button\" class=\"btn btn-inverse-danger delete\" ><i class=\"ti-trash\"></i></button></li> \r\n" +
				"</ul>\r\n" + 
				"</td>";
			employeeData += "</tr>";
		}	
	});
	
	$("#select").click(function () {
		if(employeeDataAppend != null && employeeDataAppend != " "){
    		employeeData = employeeDataAppend + employeeData;
    	}
		$("#empEntry").html(employeeData);
	    employeeDataAppend = employeeData;
	    employeeData = " ";
	});
	
	$("body").on("click", ".delete", function () {
		if($('#EmpTable tr').length > 1){
			$tr=$(this).closest('tr');
			var row =$(this).closest('tr');
			var table = $("#EmpTable")[0];
	    	table.deleteRow(row[0].rowIndex);
	    	employeeDataAppend = $("#empEntry").get(0).innerHTML;
		}
	}); 
</script>
<script type="text/javascript">
	$("#subGrid").on("click", ".deleteGrv", function() {
		$(this).closest("tr").remove();
	});
	
	$("body").on("click", ".editGrv", function () {
		$tr=$(this).closest('tr');
		var row =$(this).closest('tr');
		var data=$tr.children('td').map(function(){
			return $(this).text();
		}).get();
		$('#RESPONDENT_EMPLOYEE_NAME').select2("trigger", "select", {data: { id: data[3], text: data[4]}});
		$('#MAIN_CATEGORY_CODE').select2("trigger", "select", {data: { id: data[1], text: data[1]}});
		$('#RESPONDENT_EMPLOYEE_ID').val(data[3]);
		$('#COMPLAINT_DESC').val(data[6]);
		var mainCategoryCode = data[1];
		var subCategoryCode = data[2]
		$.ajax({
		    type:'post',
		    url : 'GetSubCategoryCodeEdit',
		    data : {mainCategoryCode:mainCategoryCode, subCategoryCode:subCategoryCode},
		    dataType : 'JSON',
		    success : function(result)
		    {
		    	if(result.status == 200){
		    		$("#SUB_CATEGORY_CODE").html("");
		    		$("#SUB_CATEGORY_CODE").html(result.data);
		    	} else {
		    		$("#SUB_CATEGORY_CODE").html("");
		    	}
		    }
		}); 	
		$(this).closest("tr").remove();
	});
</script>
<script>
	$("#reset").click(function(){
		$('#tbranchCode').val($('#tbranchCode option:first-child').val()).trigger('change');
		$('#tdesignation').val($('#tdesignation option:first-child').val()).trigger('change');
		$('#tJobFun').val($('#tJobFun option:first-child').val()).trigger('change');
		$('#tDepartment').val($('#tDepartment option:first-child').val()).trigger('change');
	    $('#NTID').val("");
		$('#Name').val("");
		var dataTable = $('#EmpSearch').DataTable();
		dataTable.rows().remove().draw();
	});

	$('.modal').on('hidden.bs.modal', function(){
		$('#tbranchCode').val($('#tbranchCode option:first-child').val()).trigger('change');
		$('#tdesignation').val($('#tdesignation option:first-child').val()).trigger('change');
		$('#tJobFun').val($('#tJobFun option:first-child').val()).trigger('change');
		$('#tDepartment').val($('#tDepartment option:first-child').val()).trigger('change');
	    $('#NTID').val("");
		$('#Name').val("");
		var dataTable = $('#EmpSearch').DataTable();
		dataTable.rows().remove().draw();
	});
</script>
<script>
	// Get Data in Dependent DropDown : on Basis of Main Category getting Sub Category Data
	$('#MAIN_CATEGORY_CODE').change(function(){
		$('#MAIN_CATEGORY_CODE-error').css('display','none');
		var MAIN_CATEGORY_CODE =$("#MAIN_CATEGORY_CODE").val();
		$.ajax({
		    type:'post',
		    url : 'GetSubCategoryCode',
		    data : {MAIN_CATEGORY_CODE:MAIN_CATEGORY_CODE},
		    dataType : 'JSON',
		    success : function(result)
		    {
		    	if(result.status == 200){
		    		$("#SUB_CATEGORY_CODE").html("");
		    		$("#SUB_CATEGORY_CODE").html(result.data);
		    	} else {
		    		$("#SUB_CATEGORY_CODE").html("");
		    	}
		    }
		}); 	
	});
</script>
<script>
	$('#grievance').on('click', function(){
		add();
	});

	function  add(){
	    var MAIN_CATEGORY_CODE = document.getElementById("MAIN_CATEGORY_CODE").value;
	    var SUB_CATEGORY_CODE = document.getElementById("SUB_CATEGORY_CODE").value;
	    var subCategoryCode = $('#SUB_CATEGORY_CODE').find(':selected').attr('data-key2');
	    var COMPLAINT_DESC = document.getElementById("COMPLAINT_DESC").value;
	    var RESPONDENT_EMPLOYEE_ID = $("#RESPONDENT_EMPLOYEE_NAME").val() != null?$("#RESPONDENT_EMPLOYEE_NAME").val():"0";
	    var RESPONDENT_EMPLOYEE_NAME = document.getElementById("RESPONDENT_EMPLOYEE_NAME");
	    var optRESPONDENT_EMPLOYEE_NAME = RESPONDENT_EMPLOYEE_NAME.options[RESPONDENT_EMPLOYEE_NAME.selectedIndex].text != "Choose Respondent Name"?RESPONDENT_EMPLOYEE_NAME.options[RESPONDENT_EMPLOYEE_NAME.selectedIndex].text:"Organization";
	    if (MAIN_CATEGORY_CODE == "Choose Grievance Category"){
 			$('#MAIN_CATEGORY_CODE-error').css('display','block');
			return false;
		}
		if(SUB_CATEGORY_CODE == "Choose Grievance Sub-Category"){
			$('#SUB_CATEGORY_CODE-error').css('display','block');
			return false;
		}
		if(COMPLAINT_DESC ==""){
			$('#COMPLAINT_DESC-error').css('display','block');
			return false;
		}
		var row_countMessage = $('#empEntry tr').length;
		var GROUP_COMPLAINT_Message = document.getElementById("Group").checked;
		if(row_countMessage == 0 && GROUP_COMPLAINT_Message == true){
			alert("Please Add Employee Group Member");
			return false;
		}
		if(MAIN_CATEGORY_CODE != "Choose Grievance Category" || SUB_CATEGORY_CODE != "Choose Grievance Sub-Category" || COMPLAINT_DESC != ""){
 			alert("You have added grievance click on submit button");		  
		} 
		var DEFAULT_HIERCODE = $('#SUB_CATEGORY_CODE').find(':selected').attr('data-key1');
		var row_count = $('#subGrid tr').length;
		var i = (row_count);
		var Sno = i;
	    var STATUSID = "65";
	    var STATUSNAME = "OPEN";
	    var table = document.getElementById("AddGrievance");
	    var row = table.insertRow(-1);
	    var cell1 = row.insertCell(0);
	    var cell2 = row.insertCell(1);
	    var cell3 = row.insertCell(2);
	    var cell4 = row.insertCell(3);
	    var cell5 = row.insertCell(4);
	    var cell6 = row.insertCell(5);
	    var cell7 = row.insertCell(6);
	    var cell8 = row.insertCell(7);
	    var cell9 = row.insertCell(8);
	    var cell10 = row.insertCell(9);
	    var cell11 = row.insertCell(10);
	    cell1.innerHTML = Sno;
	    cell2.innerHTML = MAIN_CATEGORY_CODE;
	    cell3.innerHTML = SUB_CATEGORY_CODE;
	    cell4.innerHTML = RESPONDENT_EMPLOYEE_ID;        
	    cell5.innerHTML = optRESPONDENT_EMPLOYEE_NAME;
	    cell6.innerHTML = STATUSNAME;
	    cell7.innerHTML = COMPLAINT_DESC;
	    cell8.innerHTML = DEFAULT_HIERCODE;
	    cell9.innerHTML = STATUSID;
	    cell10.innerHTML = "<td>\r\n" + 
		"<ul class=\"d-flex justify-content-center\">\r\n"+ 
			"<li class=\"mr-3\"><button type=\"button\" class=\"btn btn-inverse-edit editGrv\"><i class=\"fa fa-edit\"></i></button></li> \r\n"+
			"<li class=\"mr-3\"><button type=\"button\" class=\"btn btn-inverse-danger deleteGrv\"><i class=\"ti-trash\"></i></button></li> \r\n"+
			"</ul>\r\n"+ 
		"</td>";
		cell11.innerHTML = subCategoryCode;
	    cell1.style.display = "none";
	    cell8.style.display = "none";
	    cell9.style.display = "none";
	    cell6.style.display = "none";
	    cell11.style.display = "none";
		$('#MAIN_CATEGORY_CODE').val($('#MAIN_CATEGORY_CODE option:first-child').val()).trigger('change');
		$('#RESPONDENT_EMPLOYEE_NAME').val($('#RESPONDENT_EMPLOYEE_NAME option:first-child').val()).trigger('change');
		$('#SUB_CATEGORY_CODE').val($('#SUB_CATEGORY_CODE option:first-child').val()).trigger('change');
		$('#RESPONDENT_EMPLOYEE_ID').val("");
		$('#COMPLAINT_DESC').val("");
	}
</script>
<script>
	$( "#Save" ).click(function() {
		var row_count = $('#empEntry tr').length;
		var grv_row_count = $('#subGrid tr').length;
		var GROUP_COMPLAINT=document.getElementById("Group").checked;
	 	if(grv_row_count == 1){
			alert("Please Add Grievance");
			return false;
		} else{
			$("#Save").attr("disabled", true);
	    	var grievancelist = new Array();
	    	$("#AddGrievance TBODY TR").each(function () {
	        	var row = $(this);
	        	var grievanceData = {};
	        	grievanceData.MAIN_CATEGORY_CODE = row.find("TD").eq(1).html();
	        	grievanceData.SUB_CATEGORY_CODE = row.find("TD").eq(10).html();
	        	grievanceData.RESPONDENT_EMPLOYEE_ID = row.find("TD").eq(3).html();
	        	grievanceData.RESPONDENT_EMPLOYEE_NAME = row.find("TD").eq(4).html();
	        	grievanceData.COMPLAINT_DESC = row.find("TD").eq(6).html();
	        	grievanceData.DEFAULT_HIERCODE = row.find("TD").eq(7).html();
	        	grievanceData.STATUSID = row.find("TD").eq(8).html();
	        	grievancelist.push(grievanceData);
	    	});
	    	var groupList = new Array();
	    	var groupListDataValue = {};
	    	groupListDataValue.EMPLOYEE_ID = $('#COMPLIANT_EMPLOYEE_ID').val();
	    	groupList.push(groupListDataValue);
	    	$("#EmpTable TBODY TR").each(function () {
	        	var row = $(this);
	        	var groupListData = {};
	        	groupListData.EMPLOYEE_ID = row.find("TD").eq(2).html();
	        	groupList.push(groupListData);
	        });
	    	var data = JSON.stringify(grievancelist);
        	var grouplist = JSON.stringify(groupList);
        	var COMPLIANT_EMPLOYEE_ID = <%=Manpower.getEMPLOYEE_ID()%>
        	console.log("COMPLIANT_EMPLOYEE_ID :"+COMPLIANT_EMPLOYEE_ID);
        	var GRVDATE = $("#GRVDATE").val();
	    	$.ajax({
				type : 'post',
				url : 'CreateEmployeeGrievance',
				data : {'data':data, 'grouplist':grouplist, 'COMPLIANT_EMPLOYEE_ID':COMPLIANT_EMPLOYEE_ID, 'GRVDATE':GRVDATE, 'GROUP_COMPLAINT':GROUP_COMPLAINT},
				dataType : 'JSON',
				success : function(result) {
					if (result.status == 200) {
	        			window.location = "EmployeeGrievanceList.jsp";
					} else{
						window.location = "EmployeeGrievanceList.jsp";
					}
				}
			});
	    	return false;
		}
	});
</script>
</body>
</html>