<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.model.masters.ManpowerModel" %>
<%@page import="com.gms.dao.masters.OrganisationHierarchyMasterDAO"%>
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
                            <h4 class="card_title text-right">ADD Organisation Hierarchy</h4>
                            <form id="addOrgHierarchy" action="CreateOrganisationHierarchyMaster" method="post">
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERCODE">HIER CODE</label>
	                                <input type="text" name="HIERCODE" class="form-control" id="HIERCODE"  placeholder="Enter Hier Code">
	                                <span style="color: indianred; float: right;"> *</span>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="CLIENTCAPTION">CLIENT CAPTION</label>
	                                <input type="text" name="CLIENTCAPTION" class="form-control" id="CLIENTCAPTION" placeholder="Enter Client Caption">
	                            	<span style="color: indianred; float: right;"> *</span>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERNAME">HIER NAME</label>
	                                <input type="text" name="HIERNAME" class="form-control" id="HIERNAME" placeholder="Enter Hier Name">
	                            	<span style="color: indianred; float: right;"> *</span>
	                            </div>
	                            <div class="form-group">
								   <label class="col-form-label" for="HIERDESIGNATIONID">HIER DESIGNATION NAME</label>
									<select class="js-select2 form-control" name="HIERDESIGNATIONID" id="HIERDESIGNATIONID" aria-hidden="true">
										<option selected="selected" disabled>Choose Hier Designation Name</option>
										<%
										int j=1;
										List<ManpowerModel> Manpower2=OrganisationHierarchyMasterDAO.getOrganisationDesignation();
										   if(Manpower2 != null){
				                             	for(ManpowerModel item : Manpower2){
					        				%>
					      					<option value="<%=item.getDESIGNATION_CODE()%>"><%=item.getDESIGNATION()%></option>
											<%
								             j++;
								         	} 
				                            }
								 			%>
			  						</select>
			  						<span style="color: indianred; float: right;"> *</span>
			                     </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERDESIGNATION">HIER DESIGNATION ID</label>
	                                <input type="text" name="HIERDESIGNATION" class="form-control" id="HIERDESIGNATION" disabled>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERORDER">HIER ORDER</label>
	                                <input type="text" name="HIERORDER" class="form-control" id="HIERORDER"  placeholder="Enter Hier Order">
	                                <span style="color: indianred; float: right;"> *</span>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERCAP">HIER CAP</label>
	                                <input type="text" name="HIERCAP" class="form-control" id="HIERCAP" placeholder="Enter Hier Cap">
	                                <span style="color: indianred; float: right;"> *</span>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="INVESTIGATOR_NEEDED">REDRESSAL AUTHORITY NEEDED</label>
	                                <select class="custom-select" id="INVESTIGATOR_NEEDED" name="INVESTIGATOR_NEEDED">
	                                    <option selected="selected" id="INVESTIGATOR_NEEDED" disabled="">REDRESSAL AUTHORITY Needed</option>
	                                    <option value="Y">Yes</option>
	                                    <option value="N">No</option>
	                                </select>
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
<script>
$("#HIERDESIGNATIONID").change(function(){
	 var HIERDESIGNATIONID =$("#HIERDESIGNATIONID").val();
	 $('#HIERDESIGNATION').val(HIERDESIGNATIONID);
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
   	 location.href ="OrganisationHierarchyList.jsp"; 
   	 }); 
</script>
</body>
</html>