<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gms.model.masters.GrievanceCategoryHierarchyModel" %>
<%@page import="com.gms.dao.masters.GrievanceCategoryHierarchyDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.user.Admin" %>
<%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
<!DOCTYPE html>
<html>
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
                         		<h4 class="card_title text-center text-uppercase mb-0">Category Hier Flow</h4>
                          </div>
	                         <div class="btnPosi">
	                          	<div class="rightpageBtn">
	                          		<a style="position: relative;" href="#" id="addGrievance">
									<span title="" data-toggle="popover" data-trigger="hover" data-content="Add Grievance Category Hierarchy">
										<i class="fa fa-plus-circle"></i>
									</span>
								</a>
							   </div>
							 </div>
		                          <div class="table-responsive datatable-primary">
					    			<table style="width:100%;"  id="dataTable2" class="text-center">
		                              <thead class="text-uppercase">
		                                <tr>
		                                    <th scope="col">Sno</th>
		                                    <th>FLOW ID</th>
		                                    <th>MAIN CATEGORY CODE</th>
		                                    <th>MAIN CATEGORY NAME</th>
		                                    <th>SUB CATEGORY CODE</th>
		                                    <th>SUB CATEGORY NAME</th>
		                                    <th>HIER ID</th>
		                                    <th>HIER CODE</th>
		                                    <th>CATEGORY ORDER</th>
		                                    <th>IS ACTIVE</th>
		                                    <th>Created Date</th>
		                                    <th class="sorting_none">ACTION</th>
		                                  </tr>
		                                </thead>
		                                <tbody>
									  <%
		                             	int i = 1;
		                             	List<GrievanceCategoryHierarchyModel> listOrgHierarchy =  GrievanceCategoryHierarchyDAO.getGrvCategory();
		                             	if(listOrgHierarchy != null){
		                             	for(GrievanceCategoryHierarchyModel item : listOrgHierarchy){
		                             	%>
		                                    <tr>
		                                    <td><%=i%></td>
		                                    <td><%=item.getFLOWID()%></td>
		                                    <td><%=item.getMAIN_CATEGORY_CODE()%></td>
		                                    <td><%=item.getMAIN_CATEGORY_NAME()%></td>
		                                    <td><%=item.getSUB_CATEGORY_CODE()%></td>
		                                    <td><%=item.getSUB_CATEGORY_NAME()%></td>
		                                    <td><%=item.getHIERID()%></td>
		                                    <td><%=item.getHIERCODE()%></td>
		                                    <td><%=item.getCATEGORY_ORDER()%></td>
		                                    <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                    <td><%=item.getDATE_CREATED()%></td>
			                                  <td>
			                                      <ul class="d-flex justify-content-center">
													 <li class="mr-3"><button type="button" class="btn btn-inverse-secondary edit" keys="<%=item.getFLOWID()%>"><i class="fa fa-edit"></i></button></li> 
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
<script>
document.getElementById("addGrievance").onclick = function(){
	 location.href ="GrievanceCategoryHierarchy.jsp";
	 };
	$(function() {
		$('body').addClass('slim__theme');
	});
	
	 $('.edit').click(function(){
		 var FLOWID= $(this).attr('keys');
		 location.href ="EditGrievanceCategoryHierarchy.jsp?FLOWID="+FLOWID; 
		 });
</script>
</body>
</html>
