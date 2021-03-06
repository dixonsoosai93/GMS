<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.model.masters.ManpowerModel"%>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@ page import="com.gms.model.masters.CentralCommitteeInvestigatorModel"%>
<%@page import="com.gms.dao.masters.CentralCommitteeInvestigatorDAO"%>
<%@ page import="com.gms.model.masters.ALBranch"%>
<%@ page import="com.gms.model.masters.ALDesignation"%>
<%@ page import="com.gms.model.masters.ALJobFunction"%>
<%@ page import="com.gms.model.masters.ALDepartment"%>
<%@ page import="com.gms.model.masters.ComplaintEmpSelect"%>
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
                            <h4 class="card_title text-right">Edit Central Committee Redressal Authority</h4>
                             <%
	                            int Id = Integer.parseInt(request.getParameter("CENTRALID"));
                             CentralCommitteeInvestigatorModel centralInvestigator =  CentralCommitteeInvestigatorDAO.getcentralCommittee(Id);
	                         	 %> 
                            <form id="" action="EditCentralCommitteeInvestigator" method="post">
                               <div class="form-group">
                               <label class="col-form-label" for="ECENTRALID">CENTRAL ID</label>
                               <div class="d-flex">
                                 <input type="text" name="ECENTRALID" class="form-control" value="<%=request.getParameter("CENTRALID")%>" readonly required>
                                 </div>		                      
	                            <div class="form-group">
	                                <label class="col-form-label" for="EINVESTIGATOR_EMPLOYEE_ID">Redressal Authority Employee Name</label>
	                                <div class="d-flex">
	                                <select class="js-select2 form-control" name="EINVESTIGATOR_EMPLOYEE_ID" id="EINVESTIGATOR_EMPLOYEE_ID" aria-hidden="true" value="<%=centralInvestigator.getNAME()%>">
										<option selected="selected" disabled>Choose Employee Name</option>
										<%
										int i=1;
										List<ManpowerModel> Manpower2=HrcMasterDAO.getManpower();
										   if(Manpower2 != null){
				                             	for(ManpowerModel item : Manpower2){
					        				%>
					      					<option value="<%=item.getEMPLOYEE_ID()%>" data-key1 ='<%=item.getDESIGNATION() %>' data-key2 ='<%=item.getDEPARTMENT()%>' <% if(Integer.parseInt(item.getEMPLOYEE_ID())==centralInvestigator.getINVESTIGATOR_EMPLOYEE_ID()) { %>selected<% } %>><%=item.getNAME()%></option>
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
	                                <label class="col-form-label" for="EEMPLOYEE_ID">Redressal Authority Employee ID</label>
	                                <input type="text" name="EEMPLOYEE_ID" class="form-control" id="EEMPLOYEE_ID" value="<%=centralInvestigator.getINVESTIGATOR_EMPLOYEE_ID()%>" disabled>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="EDESIGNATION">Redressal Authority Employee Designation</label>
	                                <input type="text" name="EDESIGNATION" class="form-control" id="EDESIGNATION" disabled value="<%=centralInvestigator.getDESIGNATION()%>">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="EDEPARTMENT">Redressal Authority Employee Department</label>
	                                <input type="text" name="EDEPARTMENT" class="form-control" id="EDEPARTMENT" disabled value="<%=centralInvestigator.getDEPARTMENT()%>">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="EIS_HR">Redressal Authority HR</label>
	                                <select class="custom-select" id="EIS_HR" name="EIS_HR">
	                                    <option selected="selected" disabled="">Choose Redressal Authority HR</option>
                                        <option value="Y" <% if(centralInvestigator.getIS_HR().equalsIgnoreCase("Y")){ %> Selected <% } %>>Yes</option>
                                        <option value="N" <% if(!centralInvestigator.getIS_HR().equalsIgnoreCase("Y")){ %> Selected <% } %>>No</option>
	                                </select>
	                                <span style="color: indianred; float: right;"> *</span>
	                            </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="EIS_ACTIVE">IS ACTIVE</label>
                                    <select class="custom-select" name="EIS_ACTIVE">
                                        <option value="Y" <% if(centralInvestigator.getIS_ACTIVE().equalsIgnoreCase("Y")){ %> Selected <% } %>>Yes</option>
                                        <option value="N" <% if(!centralInvestigator.getIS_ACTIVE().equalsIgnoreCase("Y")){ %> Selected <% } %>>No</option>
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
$('#EINVESTIGATOR_EMPLOYEE_ID').change(function(){
	 var EEMPLOYEE_ID =$("#EINVESTIGATOR_EMPLOYEE_ID").val();
	 $('#EEMPLOYEE_ID').val(EEMPLOYEE_ID);
	let designation = $(this).find('option:selected').data('key1');
	let department = $(this).find('option:selected').data('key2');
	$('#EDESIGNATION').val(designation);
	$('#EDEPARTMENT').val(department);
	
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
	            data : {'tbranchCode':tbranchCode,'tdesignation':tdesignation,'tJobFun':tJobFun,'tDepartment':tDepartment,'NTID':NTID, 'Name':Name},
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
	$('#EINVESTIGATOR_EMPLOYEE_ID').select2("trigger", "select", {data: { id: data[2], text: data[4] }});
	$('#EEMPLOYEE_ID').val(data[2]);
	$('#EDESIGNATION').val(data[7]);
	$('#EDEPARTMENT').val(data[9]);
	$('#tbranchCode').select2("trigger", "select", {data: { id: -1, text: "Choose Branch Name"}});
	$('#tdesignation').select2("trigger", "select", {data: { id: -1, text: "Choose Designation"}});
	$('#tJobFun').select2("trigger", "select", {data: { id: -1, text: "Choose Job Function"}});
	$('#tDepartment').select2("trigger", "select", {data: { id: -1, text: "Choose Department Name"}});
	$('#NTID').val("");
	$('#Name').val("");
	$('#dispMessage').css('display','none');
	$('#EmpSearch').dataTable().fnClearTable();
	$('#EmpSearch').dataTable().fnDestroy();
});
});
/*
$("#cancel").click(function(){
	$('#tbranchCode').select2("trigger", "select", {data: { id: -1, text: "Choose Branch Name"}});
	$('#tdesignation').select2("trigger", "select", {data: { id: -1, text: "Choose Designation"}});
	$('#tJobFun').select2("trigger", "select", {data: { id: -1, text: "Choose Job Function"}});
	$('#tDepartment').select2("trigger", "select", {data: { id: -1, text: "Choose Department Name"}});
	$('#EmpSearch').dataTable().fnClearTable();
	$('#EmpSearch').dataTable().fnDestroy();
});
*/
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