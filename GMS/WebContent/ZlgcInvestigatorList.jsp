<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gms.model.masters.ZlgcInvestigatorMasterModel" %>
<%@page import="com.gms.dao.masters.ZlgcInvestigatorDAO"%>
  <%@page import="com.gms.model.masters.ManpowerModel"%>
<% ManpowerModel Manpower = (ManpowerModel)session.getAttribute("manpower"); 
 if (Manpower == null) {
        Manpower = new ManpowerModel();
        response.sendRedirect("login.jsp");
    }%>
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
                           		<h4 class="card_title text-center text-uppercase mb-0">ZLGC Redressal Authority</h4>
                            </div>
	                       <div class="btnPosi">
                            	<div class="rightpageBtn">
                            		<a style="position: relative;" href="#" id="addZlgcInvestigator">
										<span title="" data-toggle="popover" data-trigger="hover" data-content="Add ZLGC Investigator">
											<i class="fa fa-plus-circle"></i>
										</span>
									</a>
								</div>
							</div>     
                           <div class="table-responsive datatable-primary">
								<table style="width:100%;"  id="dataTable2" class="text-center">
                                      <thead class="text-uppercase">
                                        <tr>
                                           	<th>S.No.</th>
                                            <th>ZLGC Redressal Authority ID</th>
                                            <th>Zone ID</th>
                                            <th>Zone Name</th>
                                            <th>Redressal Authority Employee Name</th>
                                            <th>Redressal Authority Employee ID</th>
                                            <th>Redressal Authority Employee Designation</th>
                                            <th>Redressal Authority Employee Department</th>
                                            <th>Redressal Authority HR</th>
                                            <th>Is Active</th>
                                            <th>Created Date</th>
                                            <th>Action</th>
                                          </tr>  
                                      </thead>     
                                      <tbody>
                                      <%
                                        int i=1;
                                        List<ZlgcInvestigatorMasterModel> list= ZlgcInvestigatorDAO.ZlgcInvestigatorMaster();
                                        if(list !=null){
                                        	for(ZlgcInvestigatorMasterModel item :list){
                                        %>
		                                <tr>
		                                  <td><%=i%></td>
		                                  <td><%=item.getZLGCID()%></td>
		                                  <td><%=item.getZONE_CODE()%></td>
		                                  <td><%=item.getZONE_NAME()%></td>
		                                  <td><%=item.getNAME()%></td>
		                                  <td><%=item.getINVESTIGATOR_EMPLOYEE_ID()%></td>
		                                  <td><%=item.getDESIGNATION()%></td>
		                                  <td><%=item.getDEPARTMENT()%></td>
		                                  <td><% if(item.getIS_HR().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td><%=item.getDATE_CREATED()%></td>
		                                  <td>
		                                      <ul class="d-flex justify-content-center">
												 <li class="mr-3"><button type="button" class="btn btn-inverse-secondary edit" keys="<%=item.getZLGCID()%>"><i class="fa fa-edit"></i></button></li> 
		                                      </ul>
		                                  </td>
										</tr>
										<%
										i++;
                                        	}}
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
 document.getElementById("addZlgcInvestigator").onclick = function(){
 location.href ="ZlgcInvestigator.jsp";
 };
 $(function() {
 $('body').addClass('slim__theme');
 });
</script>
<script>
 $('.edit').click(function(){
 var ZLGC= $(this).attr('keys');
 location.href ="EditZlgcInvestigator.jsp?ZLGC="+ZLGC; 
 });
</script>
</body>
</html>
