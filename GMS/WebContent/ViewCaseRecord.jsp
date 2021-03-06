<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="com.gms.model.investigator.CaseView"%>
<%@page import="com.gms.dao.masters.HrcMasterDAO"%>
<%@page import="com.gms.dao.investigator.DailyProofUploadDAO"%>
<%@page import="com.gms.dao.investigator.DailyDairyDAO"%>
<%@page import="com.gms.model.investigator.DtDailyDairy"%>
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
    <jsp:include page="InvSidebar.jsp"></jsp:include>
    <jsp:include page="headerRedressalAuthority.jsp"></jsp:include>
 <div class="vz_main_container">
      <div class="vz_main_content">
          <div class="row">
              <div class="col-12">
                  <div class="card">
                      <div class="card-body">
                       <h4 class="card_title text-right">View Case Record</h4>
                             <%
                                 int CASEID=Integer.parseInt(request.getParameter("CASEID"));
                                 int GRVID=Integer.parseInt(request.getParameter("GRVID"));
                                 int GRVDETID=Integer.parseInt(request.getParameter("GRVDETID"));
                                 String Report_Type = request.getParameter("Report_Type");
                                   CaseView caseview =DailyProofUploadDAO.getViewCaseRecord(CASEID, GRVDETID, GRVID);
	                         	 %> 
                       <form id="addGrievanceCategory"  method="post">
                             <div class="row">
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="GRVID">Grievance HD ID</label>
	                                <input type="text"  class="form-control" id="GRVID" value="<%=caseview.getGRVID() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label " for="COMPLIANT_EMPLOYEE_ID">Aggrieved employee ID</label>
	                                <input type="text"  class="form-control" id="COMPLIANT_EMPLOYEE_ID" value="<%=caseview.getCOMPLIANT_EMPLOYEE_ID() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="INVESTIGATOR_EMPLOYEE_ID">Redressal Authority Emp ID</label>
	                                <input type="text"  class="form-control" id="INVESTIGATOR_EMPLOYEE_ID" value="<%=caseview.getINVESTIGATOR_EMPLOYEE_ID() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="GRVDETID">Grievance Reference Number</label>
	                                <input type="text"  class="form-control" id="GRVDETID" value="<%=caseview.getGRVDETID() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="NAME">Aggrieved employee Name</label>
	                                <input type="text"  class="form-control" id="NAME" value="<%=caseview.getNAME() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="INV_NAME">Redressal Authority Name</label>
	                                <input type="text"   class="form-control" id="" value="<%=Manpower.getNAME()%>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="CASEID">Case ID</label>
	                                <input type="text"  class="form-control" id="CASEID" value="<%=caseview.getCASEID() %>" disabled>
	                            </div>
	                            <div class=" form-group col-md-6 col-lg-4">
									<label class="col-form-label" for="name">Aggrieved employee Group Members</label>
									<div class="input-group">
										<label class="form-control col-md-11" for="name"> ID</label>
										<label class="form-control" for="name"> Name</label>
									</div>
									<%
		                             	List<CaseView> list =  DailyProofUploadDAO.getComplainantName(CASEID, GRVDETID, GRVID);
		                             	if(list != null){
		                             	for(CaseView item : list){
		                             %>
		                             <div class="input-group">
										<input type="text" class="form-control col-md-11" value="<%=item.getEMPLOYEE_ID()%>" disabled>
										<input type="text" class="form-control"  value="<%=item.getEMPLOYEE_NAME()%>" disabled>
									</div>
									 <%} }%>
								</div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="INV_TYPE">Redressal Authority Type</label>
	                                <input type="text" name="INV_TYPE" class="form-control" id="INV_TYPE" value="<%=caseview.getINVESTIGATOR_TYPE()%>" disabled >
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="CASENUMBER">TALIC Case No</label>
	                                <input type="text"  class="form-control" id="CASENUMBER" value="<%=caseview.getCASENUMBER() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="HIERCODE">Hierarchy Code</label>
	                                <input type="text" class="form-control" id="HIERCODE" value="<%=caseview.getHIERCODE() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="HIERORDER">Hierarchy Order</label>
	                                <input type="text"  class="form-control" id="HIERORDER" value="<%=caseview.getHIERORDER() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="MAIN_CATEGORY_CODE">Main Category Code</label>
	                                <input type="text" class="form-control" id="MAIN_CATEGORY_CODE" value="<%=caseview.getMAIN_CATEGORY_CODE() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="MAIN_CATEGORY_NAME">Main Category Name</label>
	                                <input type="text" name="MAIN_CATEGORY_NAME" class="form-control" id="MAIN_CATEGORY_NAME" value="<%=caseview.getMAIN_CATEGORY_NAME()%>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="SUB_CATEGORY_CODE">Sub Category Code</label>
	                                <input type="text"  class="form-control" id="SUB_CATEGORY_CODE" value="<%=caseview.getSUB_CATEGORY_CODE() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="MAIN_CATEGORY_NAME">Sub Category Name</label>
	                                <input type="text" name="MAIN_CATEGORY_NAME" class="form-control" id="SUB_CATEGORY_NAME" value="<%=caseview.getSUB_CATEGORY_NAME() %>"  disabled >
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="RESPONDENT_EMPLOYEE_ID">Respondent ID</label>
	                                <input type="text"  class="form-control" id="RESPONDENT_EMPLOYEE_ID" value="<%=caseview.getRESPONDENT_EMPLOYEE_ID() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="RESPONDENT_EMPLOYEE_NAME">Respondent Name</label>
	                                <input type="text"  class="form-control" id="RESPONDENT_EMPLOYEE_NAME" value="<%=caseview.getRESPONDENT_EMPLOYEE_NAME() %>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="TAT_START_DATE">TAT Start Date</label>
	                                <input type="text" class="form-control" id="TAT_START_DATE" value="<%=caseview.getTAT_START_DATE()%>" disabled>
	                            </div>
	                            <div class="form-group col-md-6 col-lg-4">
	                                <label class="col-form-label" for="TAT_END_DATE">TAT End Date</label>
	                                <input type="text"  class="form-control" id="TAT_END_DATE" value="<%=caseview.getTAT_END_DATE() %>"  disabled>
	                            </div>
	                            <input type="hidden" id="IS_ACTIVE" name="IS_ACTIVE" value="Y">
							</div>
                             <div class="form-group">
								<label class="col-form-label" for="COMPLAINT_DESC">Grievance Description</label>
								<textarea class="form-control" id="COMPLAINT_DESC" disabled><%=caseview.getCOMPLAINT_DESC() %></textarea>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 text-right">
									<button type="button" id="addNew" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">ADD DAILY DAIRY</button>
								</div>
							</div>
						</form>
						<div class="table-responsive datatable-primary">
					    	<table style="width:100%;"  id="dataTable" class="text-center">
								<thead class="text-uppercase">
		                           <tr>
	                                   <th>Sno</th>
	                                   <th>Redressal Authority ID</th>
	                                   <th>Redressal Authority Name</th>
	                                   <th>Hier Code</th>
	                                   <th>Diary ID</th>
	                                   <th>Diary Date</th>
	                                   <th>Diary Details</th>
	                                   <th>Upload Case Documents</th>
	                                   <th>Download Case Documents</th>
	                                   <th>Status</th>
	                                   <th>ACTION</th>
                                   </tr>
								</thead>
								<tbody>
                                <% List<DtDailyDairy> listDiary =DailyDairyDAO.getDailyDairy(CASEID, GRVDETID, GRVID);
                                  int i=1;
                                  if(listDiary != null){
      		                            for(DtDailyDairy item : listDiary){
                                  %>
                                  <tr>
                                  	<td><%=i%></td>
	                                  <td><%=item.getEMPLOYEE_ID() %></td>
	                                  <td><%=item.getNAME()%></td>
	                                  <td><%=item.getHIRECODE() %></td>
	                                  <td><%=item.getDAIRYID() %></td>
	                                  <td><%=item.getDAIRY_DATE() %></td>
	                                  <td><%=item.getDAIRY_DETAILS() %></td>
	                                  <td><button type="button" class="btn btn-inverse-secondary attach " keys="<%=item.getDAIRYID()%>"><i class="fa fa-folder-open-o"></i></button></td>
	                                  <td><button type="button" class="btn btn-inverse-secondary download" keys="<%=item.getDAIRYID()%>"><i class="fa fa-download"></i></button></td>
	                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
	                                  <td>
			                          <ul class="d-flex justify-content-center">
											<li class="mr-3"><button type="button" class="btn btn-inverse-secondary edit" data-toggle="modal" data-target="#exampleModalCenter2"><i class="fa fa-edit"></i></button></li> 
			                                 </ul>
			                           </td>
                                  </tr>
                                    <% i++;
                                   }} %>
								</tbody>
								</table>
		                       </div>
		                       	<div class="form-group row" style="margin-top:20px;">
	                                <div class="col-sm-12 text-right">
	                                    <button type="button" id="back" class="btn btn-light">Back</button>
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
</div>
<div class="modal fade show" id="exampleModalCenter" style="display: none; padding-right: 17px;">                        
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
          	<form id="DtDailyDairy" action="CreateDtDailyDairy" method="post">
					<div class="modal-header">
	                   <h5 class="modal-title text-right">Casewise-Daily Diary with Proof Upload</h5>
	              	</div>
					<div class="modal-body">
						<input type="hidden" name="GRVID"
							value="<%=caseview.getGRVID()%>" readonly> <input
							type="hidden" name="GRVDETID"
							value="<%=caseview.getGRVDETID()%>" readonly>
						<div class="form-group">
							<label class="col-form-label" for="Emp_Ref_No">Employee
								Grievance Ref No</label> <input type="text" name="Emp_Ref_No"
								class="form-control" id="Emp_Ref_No"
								value="<%=caseview.getGRVDETID()%>" disabled>
						</div>
						<div class="form-group">
							<label class="col-form-label" for="CASEID">Case No</label> <input
								type="text" name="CASEID" class="form-control" id="CASEID"
								value="<%=caseview.getCASEID()%>" readonly>
						</div>
						<div class="form-group">
							<label class="col-form-label" for="EMPLOYEE_id">Employee
								ID</label> <input type="text" name="EMPLOYEE_ID" class="form-control"
								id="EMPLOYEE_ID"
								value="<%=caseview.getINVESTIGATOR_EMPLOYEE_ID()%>" readonly>
						</div>
						<div class="form-group">
							<label class="col-form-label" for="EMPLOYEE_NAME">Employee
								Name</label> <input type="text" name="EMPLOYEE_NAME"
								class="form-control" id="EMPLOYEE_NAME"
								value="<%=Manpower.getNAME()%>" disabled>
						</div>
						<div class="form-group">
							<label class="col-form-label" for=DEPARTMENT>Daily Dairy
								Date</label> <input type="text" name="DAIRY_DATE" class="form-control"
								id="DAIRY_DATE" data-date-format="dd-mm-yyyy" readonly>
						</div>
						<div class="form-group">
							<label class="col-form-label">Daily Dairy Details</label>
							<textarea class="form-control" name="DAIRY_DETAILS"
								id="DAIRY_DETAILS" placeholder="Dairy Details" required></textarea>
							<span style="color: indianred; float: right;"> *</span>
						</div>
						<div class="form-group">
							<label class="col-form-label" for="IS_ACTIVE">STATUS</label> <select
								class="custom-select" name="IS_ACTIVE">
								<option value="Y">Yes</option>
								<option value="N">No</option>
							</select>
						</div>
						<div class="modal-footer">
							<button type="submit" id="createSubmit" class="btn btn-primary">SUBMIT</button>
							<button type="button" id="cancel" class="btn btn-light"
								data-dismiss="modal">CANCEL</button>
						</div>
					</div>
				</form>    
			</div>
		</div>
	</div>
	
<div class="modal fade show" id="exampleModalCenter2" style="display: none; padding-right: 17px;">                        
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
          	<form id="EditDtDailyDairy" action="EditDtDailyDairy" method="post">
					<div class="modal-header">
	                   <h5 class="modal-title text-right">Edit Casewise-Daily Diary</h5>
	              	</div>
				    <div class="modal-body">
				              <input type="hidden" name="GRVID"  value="<%=caseview.getGRVID()%>" readonly>
				             <input type="hidden" name="GRVDETID"  value="<%=caseview.getGRVDETID() %>" readonly>
				            <div class="form-group">
                                <label class="col-form-label" for="DIARYID">DIARY ID</label>
                                <input type="text" name="DIARYID" class="form-control" id="DIARYID" readonly>
                            </div>
                  	         <div class="form-group">
							   <label class="col-form-label" for="Emp_Ref_No">Employee Grievance Ref No</label>
									<input type="text" name="Emp_Ref_No" class="form-control" id="Edit_Emp_Ref_No" value="<%=caseview.getGRVDETID() %>" disabled>	
		                      </div>
                            <div class="form-group">
                                <label class="col-form-label" for="CASEID">Case No</label>
                                <input type="text" name="CASEID" class="form-control" id="Edit_CASEID" value="<%=caseview.getCASEID() %>" readonly>
                            </div>			                      
                            
                            <div class="form-group">
                                <label class="col-form-label" for="EMPLOYEE_id">Employee ID</label>
                                <input type="text" name="EMPLOYEE_ID" class="form-control" id="Edit_EMPLOYEE_ID" readonly>
                            </div>
                            <div class="form-group">
                                <label class="col-form-label" for="EMPLOYEE_NAME">Employee Name</label>
                                <input type="text" name="EMPLOYEE_NAME" class="form-control" id="Edit_EMPLOYEE_NAME"   disabled>
                            </div>
                            <div class="form-group">
                                <label class="col-form-label" for=DEPARTMENT>Daily Dairy Date</label>
                                <input type="text" name="DAIRY_DATE" class="form-control" readonly data-date-format="dd-mm-yyyy" id="Edit_DAIRY_DATE" readonly>
                            </div>
                            <div class="form-group">
                                <label class="col-form-label" >Daily Dairy Details</label>
                                 <textarea class="form-control" name="DAIRY_DETAILS" id="Edit_DAIRY_DETAILS" placeholder="Dairy Details" required></textarea>
                            	<span style="color: indianred; float: right;"> *</span>
                            </div>
                            
                               <div class="form-group">
                                   <label class="col-form-label" for="IS_ACTIVE">STATUS</label>
                                   <select class="custom-select" name="IS_ACTIVE" id="Edit_IS_ACTIVE">
                                       <option value="Y">Yes</option>
                                       <option value="N">No</option>
                                   </select>
                               </div>   
			               <div class="modal-footer">
			                   <button type="submit" class="btn btn-primary">SUBMIT</button>
			                   <button type="button" id="cancel" class="btn btn-light" data-dismiss="modal">CANCEL</button>
			               </div>
		              </div>
				</form>    
			</div>
		</div>
	</div>
<script>
	$('.edit').on('click',function(){
		$tr=$(this).closest('tr');
		var data=$tr.children('td').map(function(){
			return $(this).text();
		}).get();
		$('#DIARYID').val(data[4]);
		$('#Edit_EMPLOYEE_ID').val(data[1]);
		$('#Edit_EMPLOYEE_NAME').val(data[2]);
		$('#Edit_DAIRY_DATE').val(data[5]);
		$('#Edit_DAIRY_DETAILS').val(data[6]);
		var status = data[9];
		if(status=="Yes"){
			$('#Edit_IS_ACTIVE').val("Y");
		}else{
			$('#Edit_IS_ACTIVE').val("N");
		}
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
    
    $('.attach').click(function(){
    	var DAIRYID= $(this).attr('keys');
    	var CASEID=$("#CASEID").val();
    	var GRVID=$("#GRVID").val();
    	var GRVDETID=$("#GRVDETID").val();
      	 location.href ="DailyDairyAttachment.jsp?CASEID="+CASEID+"&DAIRYID="+DAIRYID+"&GRVID="+GRVID+"&GRVDETID="+GRVDETID; 
      	 });
    $('.download').click(function(){
    	 var DAIRYID= $(this).attr('keys');
 	  	 location.href ="DownloadCaseAttach.jsp?DAIRYID="+DAIRYID; 
     	 });
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#back').click(function(){
		 	let reportType = "<%=Report_Type%>";
		 	console.log(reportType);
			location.href ="DailyDairyUpdationList.jsp?Report_Type="+reportType;			
	 	});
	});
</script>
<script type="text/javascript">
	$('#DAIRY_DATE').datepicker('setDate', 'now');
	$('#Edit_DAIRY_DATE').datepicker('setDate', 'now');
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#createSubmit').click(function(){
		 	if(confirm("Do you want to add Daily Dairy")){
		 	}	else{
		 		return false;
		 	}		
	 	});
	});
</script>
<style>
	.modal-dialog{
	    overflow-y: initial !important
	}
	.modal-body{
	    height: 80vh;
	    overflow-y: auto;
	}
</style>
</body>
</html>