<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@ page import="com.gms.model.masters.OrganisationHierarchyMasterModel" %>
<%@page import="com.gms.dao.masters.OrganisationHierarchyMasterDAO"%>
<%@ page import="com.gms.model.masters.ManpowerModel" %>
<%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
<head>
	<title>Organisation Hierarchy</title>
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
                            <h4 class="card_title text-right">Edit Organisation Hierarchy</h4>
                            <%
	                            int Id = Integer.parseInt(request.getParameter("HIERID"));
                                OrganisationHierarchyMasterModel orgHierarchy =  OrganisationHierarchyMasterDAO.getOrganisationHierarchy(Id);
	                           	if(orgHierarchy != null){
	                         	 %> 
                            <form id="editOrgHierarchy" action="EditOrganisationHierarchyMaster" method="post">
                            	<div class="form-group">
	                             <label class="col-form-label" for="HIERNAME">HIER ID</label>
                                <input type="text" name="HIERID" class="form-control" value="<%=request.getParameter("HIERID") %>" readonly required>
                                </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERCODE">HIER CODE</label>
	                                <input type="text" name="HIERCODE" class="form-control" id="HIERCODE" value="<%=orgHierarchy.getHIERCODE()%>" placeholder="Enter Hier Code">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="CLIENTCAPTION">CLIENT CAPTION</label>
	                                <input type="text" name="CLIENTCAPTION" class="form-control" id="CLIENTCAPTION" value="<%=orgHierarchy.getCLIENTCAPTION()%>" placeholder="Enter Client Caption">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERNAME">HIER NAME</label>
	                                <input type="text" name="HIERNAME" class="form-control" id="HIERNAME" value="<%=orgHierarchy.getHIERNAME()%>" placeholder="Enter Hier Name">
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
					      					<option value="<%=item.getDESIGNATION_CODE()%>" <% if(item.getDESIGNATION_CODE().equalsIgnoreCase(orgHierarchy.getHIERDESIGNATIONID())) { %>selected<% } %>><%=item.getDESIGNATION()%></option>
											<%
								             j++;
								         	} 
				                            }
								 			%>
			  						</select>
			                     </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERDESIGNATIONID">HIER DESIGNATION ID(TALIC Designation ID)</label>
	                                <input type="text" name="HIERDESIGNATIONID" class="form-control" id="HIERDESIGNATIONID" value="<%=orgHierarchy.getHIERDESIGNATIONID()%>" placeholder="Enter Hier Designation Id">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERORDER">HIER ORDER</label>
	                                <input type="text" name="HIERORDER" class="form-control" id="HIERORDER"  value="<%=orgHierarchy.getHIERORDER()%>" placeholder="Enter Hier Order">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="HIERCAP">HIER CAP</label>
	                                <input type="text" name="HIERCAP" class="form-control" id="HIERCAP" value="<%=orgHierarchy.getHIERCAP()%>" placeholder="Enter Hier Cap">
	                            </div>
	                            <div class="form-group">
	                                <label class="col-form-label" for="INVESTIGATOR_NEEDED">REDRESSAL AUTHORITY NEEDED</label>
	                                <select class="custom-select" id="INVESTIGATOR_NEEDED" name="INVESTIGATOR_NEEDED">
	                                    <option selected="selected" id="INVESTIGATOR_NEEDED" disabled="">Redressal Authority Needed</option>
	                                    <option value="Y" <% if(orgHierarchy.getINVESTIGATOR_NEEDED().equalsIgnoreCase("Y")){ %> Selected <% } %>>Yes</option>
	                                    <option value="N" <% if(!orgHierarchy.getINVESTIGATOR_NEEDED().equalsIgnoreCase("Y")){ %> Selected <% } %>>No</option>
	                                </select>
	                            </div>
                                <div class="form-group">
                                    <label class="col-form-label" for="IS_ACTIVE">IS ACTIVE</label>
                                    <select class="custom-select" name="IS_ACTIVE">
                                        <option value="Y" <% if(orgHierarchy.getIS_ACTIVE().equalsIgnoreCase("Y")){ %> Selected <% } %>>Yes</option>
                                        <option value="N" <% if(!orgHierarchy.getIS_ACTIVE().equalsIgnoreCase("Y")){ %> Selected <% } %>>No</option>
                                    </select>
                                </div>   
	                            <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="submit" class="btn btn-primary">Submit</button>
	                                    <button type="button" class="btn btn-light cancel">Cancel</button>
	                                </div>
	                            </div>
                            </form>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
<div class="col-lg-6 stretched_card" style="display:none">
     <button type="button" class="btn btn-success mt-2 sweet_success_btn">Success Message</button>
</div>
<script>
$('.cancel').click(function(){
	 location.href ="OrganisationHierarchyList.jsp"; 
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
</script>
</body>
</html>