<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="com.gms.dao.admin.IdleCaseMonitorDAO"%>
<%@ page import="com.gms.model.admin.IdleCaseMonitor" %>
<%@ page import="com.gms.model.masters.ManpowerModel"%>
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
                           		<h4 class="card_title text-center mb-0">DETAIL CASE MONITOR</h4>
                            </div>   
                           <div class="table-responsive datatable-primary">
								<table style="width:100%;"  id="dataTable2" class="text-center">
                                      <thead class="text-uppercase">
                                        <tr>
                                           	<th>S.No.</th>
                                            <th>Case ID</th>
                                            <th>GRV Reference Number</th>
                                            <th>TALIC Case Number</th>
                                            <th>Main Category Code</th>
                                            <th>Sub Category Code</th>
                                            <th>Hierarchy Code</th>
                                            <th>Hierarchy Order</th>
                                            <th>TAT Start Date</th>
                                            <th>TAT Actual End Date</th>
                                            <th>No of days from Start date</th>
                                            <th>No of Daily Dairy Records</th>
                                            <th>Redressal Authority Completed Status</th>
                                            <th>Current Active Hierarchy</th>
                                            <th>Status</th>
                                            <th>Redressal Authority Employee ID</th>
                                            <th>Redressal Authority Name</th>
                                            <th>Redressal Authority Designation</th>
                                        </tr>  
                                      </thead>     
                                      <tbody>
                                      <%
                                        int i=1;
                                        List<IdleCaseMonitor> list= IdleCaseMonitorDAO.getIdleCase();
                                        if(list !=null){
                                        	for(IdleCaseMonitor item :list){
                                        %>
		                                <tr>
		                                  <td><%=i%></td>
		                                  <td><%=item.getCASEID()%></td>
		                                  <td><%=item.getGRVDETID()%></td>
		                                  <td><%=item.getCASENUMBER()%></td>
		                                  <td><%=item.getMAIN_CATEGORY_CODE()%></td>
		                                  <td><%=item.getSUB_CATEGORY_CODE()%></td>
		                                  <td><%=item.getHIERCODE()%></td>
		                                  <td><%=item.getHIERORDER()%></td>
		                                  <td><%=item.getTAT_START_DATE()%></td>
		                                  <td><%=item.getTAT_ACTUAL_END_DATE()%></td>
		                                  <td><%=item.getNoOfDaysFromDtartDate()%></td>
		                                  <td><%=item.getNoOfDailyDairyRecords()%></td>
		                                  <td><%if(item.getCURRENT_ROW_COMPLETED().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% }%></td>
		                                  <td><%if(item.getCURRENT_ROW_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td><% if(item.getIS_ACTIVE().equalsIgnoreCase("Y")){ %>Yes<% } else { %>No <% } %></td>
		                                  <td><%=item.getINVESTIGATOR_EMPLOYEE_ID() %></td>
		                                  <td><%=item.getNAME() != null?item.getNAME():"" %></td>
		                                  <td><%=item.getDESIGNATION() != null?item.getDESIGNATION():""%></td>
										</tr>
										<%
										i++;
                                        	}}
										%>
										</tbody>
                                  </table>
                                   <div class="form-group row">
	                                <div class="col-sm-12 text-right">
	                                    <button type="button" id="cancel" class="btn btn-light cancel">Back</button>
	                                </div>
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
<script type="text/javascript">
 	$(function() {
 		$('body').addClass('slim__theme');
 	});
</script>
<script>
	$('#cancel').click(function(){
 	 	location.href ="index.jsp"; 
 	}); 
</script>
</body>
</html>
