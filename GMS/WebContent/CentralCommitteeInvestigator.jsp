<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.model.masters.ZoneModel"%>
<%@ page import="com.gms.model.masters.ManpowerModel"%>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@ page import="com.gms.model.masters.ALBranch"%>
<%@ page import="com.gms.model.masters.ALDesignation"%>
<%@ page import="com.gms.model.masters.ALJobFunction"%>
<%@ page import="com.gms.model.masters.ALDepartment"%>
<%@ page import="com.gms.model.masters.ComplaintEmpSelect"%>
<%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
<head>
	<title>TATA AIA GMS</title>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body class="slim__theme">
<div class="vz_main_sec">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Text-->
    <div class="vz_main_container">
        <div class="vz_main_content">
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card_title text-right">ADD Central Committee Redressal Authority</h4>
                            <form id="addCentralInv" action="CreateCentralCommitteeInvestigatorMaster" method="post">			                      
	                            <div class="form-group">
	                                <label class="col-form-label" for="INVESTIGATOR_EMPLOYEE_ID">Redressal Authority Employee Name</label>
	                                <div class="d-flex">
	                                <select class="js-select2 form-control" name="INVESTIGATOR_EMPLOYEE_ID" id="INVESTIGATOR_EMPLOYEE_ID" aria-hidden="true">
										<option selected="selected" disabled>Choose Employee Name</option>
										<%
										int i=1;
										List<ManpowerModel> Manpower2=HrcMasterDAO.getCentralManpower();
										   if(Manpower2 != null){
				                             	for(ManpowerModel item : Manpower2){
					        				%>
					      					<option value="<%=item.getEMPLOYEE_ID()%>" data-key1 ='<%=item.getDESIGNATION() %>' data-key2 ='<%=item.getDEPARTMENT()%>'><%=item.getNAME()%></option>
											<%
								             i++;
								         	} 
				                            }
								 			%>
			  						</select>
			  						<span style="color: indianred; float: right;"> *</span>
			  						<div class="flex-fill">
				  					<button type="button" class="btn btn-inverse-secondary ml-3" data-toggle="modal" data-target="#exampleModalCenter"><i class="fa fa-search"></i></button>
				  					</div>
	                            </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="EMPLOYEE_ID">Redressal Authority Employee ID</label>
	                                <input type="text" name="EMPLOYEE_ID" class="form-control" id="EMPLOYEE_ID" disabled>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="DESIGNATION">Redressal Authority Employee Designation</label>
	                                <input type="text" name="DESIGNATION" class="form-control" id="DESIGNATION" disabled>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for=DEPARTMENT>Redressal Authority Employee Department</label>
	                                <input type="text" name="DEPARTMENT" class="form-control" id="DEPARTMENT" disabled>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="IS_HR">Redressal Authority HR</label>
	                                <select class="custom-select" id="IS_HR" name="IS_HR">
	                                    <option selected="selected" disabled="">Choose Redressal Authority HR</option>
	                                    <option value="Y">Yes</option>
	                                    <option value="N">No</option>
	                                </select>
	                                <span style="color: indianred; float: right;"> *</span>
	                            </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
                                    <select class="custom-select" name="IS_ACTIVE">
                                        <option value="Y">Yes</option>
                                        <option value="N">No</option>
                                    </select>
                                </div>   
	                            <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="submit" class="btn btn-primary">Submit</button>
	                                    <button type="button" class="btn btn-light cancel">Cancel</button>
	                                </div>
	                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-6 stretched_card" style="display:none">
     <button type="button" class="btn btn-success mt-2 sweet_success_btn">Success Message</button>
</div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<jsp:include page="ManpowerList.jsp"></jsp:include>
<script>
$("#ZONE_CODE").change(function(){
	 var ZONE_ID =$("#ZONE_CODE").val();
	 $('#ZONE_ID').val(ZONE_ID);
});
$('#INVESTIGATOR_EMPLOYEE_ID').change(function(){
	 var EMPLOYEE_ID =$("#INVESTIGATOR_EMPLOYEE_ID").val();
	 $('#EMPLOYEE_ID').val(EMPLOYEE_ID);
	let designation = $(this).find('option:selected').data('key1');
	let department = $(this).find('option:selected').data('key2');
	$('#DESIGNATION').val(designation);
	$('#DEPARTMENT').val(department);
	
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
		if(tbranchCode == null  && tdesignation== null  && tJobFun == null && tDepartment == null && NTID == "" && Name =="" ){
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
	            		$("#EmpSearch").DataTable();
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
	$("body").on("click", "#emp", function () {
		$tr=$(this).closest('tr');
		var row =$(this).closest('tr');
		var data=$tr.children('td').map(function(){
			return $(this).text();
		}).get();
			$("#select").click(function(){
			$('#INVESTIGATOR_EMPLOYEE_ID').select2("trigger", "select", {data: { id: data[2], text: data[4] }});
			$('#EMPLOYEE_ID').val(data[2]);
			$('#DESIGNATION').val(data[7]);
			$('#DEPARTMENT').val(data[9]);
			$('#tbranchCode').select2("trigger", "select", {data: { id: -1, text: "Choose Branch Name"}});
			$('#tdesignation').select2("trigger", "select", {data: { id: -1, text: "Choose Designation"}});
			$('#tJobFun').select2("trigger", "select", {data: { id: -1, text: "Choose Job Function"}});
			$('#tDepartment').select2("trigger", "select", {data: { id: -1, text: "Choose Department Name"}});
			$('#NTID').val("");
			$('#Name').val("");
			$('#EmpSearch').dataTable().fnClearTable();
			$('#EmpSearch').dataTable().fnDestroy();
		});
	});
	/*$("#cancel").click(function(){
		$('#tbranchCode').select2("trigger", "select", {data: { id: -1, text: "Choose Branch Name"}});
		$('#tdesignation').select2("trigger", "select", {data: { id: -1, text: "Choose Designation"}});
		$('#tJobFun').select2("trigger", "select", {data: { id: -1, text: "Choose Job Function"}});
		$('#tDepartment').select2("trigger", "select", {data: { id: -1, text: "Choose Department Name"}});
		$('#NTID').val("");
		$('#Name').val("");
		$('#EmpSearch').dataTable().fnClearTable();
		$('#EmpSearch').dataTable().fnDestroy();
	}); */
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
</script>
<script>
	$(function() {
		$('body').addClass('slim__theme');
	});
    $(document).ready(function() {
      $(".js-select2").select2();
      $(".js-select2-multi").select2();
    });
    $('.cancel').click(function(){
   	 location.href ="CentralCommitteeInvestigatorList.jsp"; 
   	 }); 
</script>
</body>
</html>