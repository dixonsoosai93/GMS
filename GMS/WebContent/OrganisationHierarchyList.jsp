<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gms.model.masters.OrganisationHierarchyMasterModel" %>
<%@page import="com.gms.dao.masters.OrganisationHierarchyMasterDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }
    %>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
<head>
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
                           		<h4 class="card_title text-center text-uppercase mb-0">Organisation Hierarchy</h4>
                            </div>
	                       <div class="btnPosi">
                            	<div class="rightpageBtn">
                            		<a style="position: relative;" href="#" id="addOrgHierarchy">
										<span title="" data-toggle="popover" data-trigger="hover" data-content="Add Organisation Hierarchy">
											<i class="fa fa-plus-circle"></i>
										</span>
									</a>
								</div>
							</div>     
                           <div class="table-responsive datatable-primary">
								<table style="width:100%;"  id="dataTable2" class="text-center">
                                      <thead class="text-capitalize">
                                        <tr>
                                           	<th>S.No.</th>
                                            <th>HIER ID</th>
                                            <th>HIER CODE</th>
                                            <th>CLIENT CAPTION</th>
                                            <th>HIER NAME</th>
                                            <th>HIER DESIGNATION NAME</th>
                                            <th>HIER DESIGNATION ID(TALIC Designation ID)</th>
                                            <th>HIER ORDER</th>
                                            <th>HIER CAP</th>
                                            <th>REDRESSAL AUTHORITY NEEDED</th>
                                            <th>IS ACTIVE</th>
                                            <th>CREATED DATE</th>
                                            <th>ACTION</th>
                                          </tr>  
                                      </thead>     
                                      <tbody>
										<%
		                             	int i = 1;
		                             	List<OrganisationHierarchyMasterModel> listOrgHierarchy =  OrganisationHierarchyMasterDAO.getOrgHierarchy();
		                             	if(listOrgHierarchy != null){
		                             	for(OrganisationHierarchyMasterModel item : listOrgHierarchy){
		                             	%>
		                                <tr>
		                                  <td><%=i%></td>
		                                  <td><%=item.getHIERID()%></td>
		                                  <td><%=item.getHIERCODE()%></td>
		                                  <td><%=item.getCLIENTCAPTION()%></td>
		                                  <td><%=item.getHIERNAME()%></td>
		                                  <td><%=item.getHIERDESIGNATIONNAME()%></td>
		                                  <td><%=item.getHIERDESIGNATIONID()%></td>
		                                  <td><%=item.getHIERORDER()%></td>
		                                  <td><%=item.getHIERCAP()%></td>
		                                  <td><% if(item.getINVESTIGATOR_NEEDED().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td><%=item.getDATE_CREATED() %></td> 
		                                  <td>
		                                      <ul class="d-flex justify-content-center">
												 <li class="mr-3"><button type="button" class="btn btn-inverse-secondary edit"  keys="<%=item.getHIERID()%>" ><i class="fa fa-edit"></i></button></li> 
		                                      </ul>
		                                  </td>
										</tr>
		                              	<%
		                                i++;
			                          	} }
		                      			%>
										</tbody>
                                  </table>
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
 document.getElementById("addOrgHierarchy").onclick = function(){
 location.href ="OrganisationHierarchy.jsp";
 };
 $(function() {
 $('body').addClass('slim__theme');
 });
</script>
<script>
 $('.edit').click(function(){
 var HIERID= $(this).attr('keys');
 location.href ="EditOraganisationHierarchy.jsp?HIERID="+HIERID; 
 });
 var HIERID = null;
 var confirmBox = $("#confirm");
 function functionConfirm(e){
 HIERID = $(e).data('key');
 if(confirm("Are you sure to delete "+HIERID+"?")){
 location.href ="DeleteOrganisationHierarchyMaster?HIERID="+HIERID; 
 } else{
 return false;
 }
 }
</script>
</body>
</html>
